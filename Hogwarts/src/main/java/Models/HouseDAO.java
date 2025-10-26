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


}//HouseDAO
