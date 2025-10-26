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

}
