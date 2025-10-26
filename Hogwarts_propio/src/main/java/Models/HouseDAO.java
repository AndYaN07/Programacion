package Models;

//DAO SIGNIFICA Data Access Object

import DataBase.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseDAO {

    private Connection conn;

    public HouseDAO() {
        conn = DBConnection.getConnection();
    }

    //Metodo de creacion
    public void create(House house) {
        try {
            String sql = "INSERT INTO house (name, founder) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, house.getName());
            ps.setString(2, house.getFounder());
            ps.executeUpdate();

            //Esto se hace para guardar el id generado
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                house.setId(rs.getInt(1));
            }

            ps.close();
        } catch (SQLException e) {
            System.out.println("❌ERROR❌" + e.getMessage());
        }
    }

    //Metodo para listar toda la tabla
    public List<House> getALL() {
        List<House> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM house";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(
                        new House(rs.getInt("id"), rs.getString("name"), rs.getString("founder")));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("❌ERROR❌" + e.getMessage());
        }
        return list;
    }

    //Metodo para verificar si existen magos asociados a una casa
    public boolean hasWizard(int houseId) {
        try {
            String sql = "SELECT COUNT(*) FROM wizard WHERE house_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, houseId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("❌ERROR al verificar magos asociados: " + e.getMessage());
        }
        return false;
    }

    //Metodo para eliminar un ID
    public  void delete(int id){
        //Utilizando el metodo de verificacion antes para no permitir borrar si tiene mago asociado.
        if(hasWizard(id)){
            System.out.println("⚠️ No puedes eliminar esta casa porque tiene magos asociados.");
            return;
        }
        try{
            String sql = "DELETE FROM house WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0){
                System.out.println("☑️ Casa eliminada correctamente.");
            }else {
                System.out.println("⚠️ No se encontro la casa con ese ID.");
            }
            ps.close();
        }catch (SQLException e){
            System.out.println("❌ERROR al eliminar la casa: " + e.getMessage());
        }
    }

    //Metodo para actualizar datos
    public void update (House house){
        try{
            String sql = "UPDATE house SET name = ?, founder = ?, WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, house.getName());
            ps.setString(2, house.getFounder());
            ps.setInt(3, house.getId());
            int rows = ps.executeUpdate();
            if (rows > 0){
                System.out.println("☑️ Casa actualizada correctamente.");
            }else {
                System.out.println("⚠️ No se encontro la casa con ese ID.");
            }
            ps.close();
        }catch (SQLException e){
            System.out.println("❌ERROR al actualizar la casa: " + e.getMessage());
        }
    }


}//HouseDAO
