package Models;

import DataBase.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WizardDAO {

    private Connection conn;

    public WizardDAO() {
        conn = DBConnection.getConnection();
    }

    public void create(Wizard wizard) {

        try {
            String sql = "INSERT INTO wizard (name, age, house_id, wand_id) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wizard.getName());
            ps.setInt(2, wizard.getAge());
            ps.setInt(3, wizard.getHouseId());
            ps.setInt(4, wizard.getWandId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.printf("❌❌ERROR!!:❌❌" + e.getMessage());
        }
    }

    public List<Wizard> getAll() {
        List<Wizard> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM wizard";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(
                        new Wizard(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getInt("house_id"), rs.getInt("wand_id")));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("❌ERROR❌" + e.getMessage());
        }
        return list;
    }

    //Metodo para eliminar un ID
    public  void delete(int id){
        try{
            String sql = "DELETE FROM wizard WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0){
                System.out.println("☑️ Mago eliminado correctamente.");
            }else {
                System.out.println("⚠️ No se encontro el mago con ese ID.");
            }
            ps.close();
        }catch (SQLException e){
            System.out.println("❌ERROR al eliminar el mago: " + e.getMessage());
        }
    }

    //Metodo para actualizar datos
    public void update (Wizard wizard){
        try{
            String sql = "UPDATE wizard SET name = ?, age = ?, house_id = ?, wand_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wizard.getName());
            ps.setInt(2, wizard.getAge());
            ps.setInt(3, wizard.getHouseId());
            ps.setInt(4, wizard.getWandId());
            ps.setInt(5, wizard.getId());
            int rows = ps.executeUpdate();
            if (rows > 0){
                System.out.println("☑️ Mago actualizado correctamente.");
            }else {
                System.out.println("⚠️ No se encontro ningun mago con ese ID.");
            }
            ps.close();
        }catch (SQLException e){
            System.out.println("❌ERROR al actualizar el mago: " + e.getMessage());
        }
    }


}//Wizard DAO
