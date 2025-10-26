package Models;

import DataBase.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WandDAO {

    private Connection conn;

    public WandDAO() {
        conn = DBConnection.getConnection();
    }

    public void create(Wand wand) {
        try {
            String sql = "INSERT INTO wand (wood, core, length) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, wand.getWood());
            ps.setString(2, wand.getCore());
            ps.setDouble(3, wand.getLength());
            ps.executeUpdate();

            //Esto se hace para guardar el id generado
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                wand.setId(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("❌ERROR❌" + e.getMessage());
        }
    }

    public List<Wand> getALL() {
        List<Wand> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM wand";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(
                        new Wand(rs.getInt("id"), rs.getString("wood"), rs.getString("core"), rs.getDouble("length")));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("❌ERROR❌" + e.getMessage());
        }
        return list;
    }

    //Metodo para verificar si existen magos asociados a una varita
    public boolean hasWizard(int wandId){
        try{
            String sql = "SELECT COUNT(*) FROM wizard WHERE wand_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, wandId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1) > 0;
            }
            ps.close();
        }catch (SQLException e){
            System.out.println("❌ERROR al verificar magos asociados: " + e.getMessage());
        }
        return false;
    }

    //Metodo para eliminar un ID
    public  void delete(int id){
        //Utilizando el metodo de verificacion antes para no permitir borrar si tiene mago asociado.
        if(hasWizard(id)){
            System.out.println("⚠️ No puedes eliminar esta varita porque tiene magos asociados.");
            return;
        }
        try{
            String sql = "DELETE FROM wand WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0){
                System.out.println("☑️ Varita eliminada correctamente.");
            }else {
                System.out.println("⚠️ No se encontro la Varita con ese ID.");
            }
            ps.close();
        }catch (SQLException e){
            System.out.println("❌ERROR al eliminar la Varita: " + e.getMessage());
        }
    }

    //Metodo para actualizar datos
    public void update(Wand wand){
        try{
            String sql = "UPDATE wand SET wood = ?, core = ?, length = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wand.getWood());
            ps.setString(2, wand.getCore());
            ps.setDouble(3, wand.getLength());
            ps.setInt(4, wand.getId());
            int rows = ps.executeUpdate();
            if (rows > 0){
                System.out.println("☑️ Varita actualizada correctamente.");
            }else {
                System.out.println("⚠️ No se encontro la varita con ese ID.");
            }
            ps.close();
        }catch (SQLException e){
            System.out.println("❌ERROR al actualizar la varita: " + e.getMessage());
        }
    }

}
