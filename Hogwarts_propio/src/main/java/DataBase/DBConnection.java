package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3307/hp";
    private static final String USER = "root";
    private static final String PASSWORD = "andy";

    //Esta variable se agrega para evitar que el saludo se imprima varias veces.
    private static boolean welcomeMostrar = false;


    public static Connection getConnection(){

        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //Agregamos la variable creada anteriormente para controlar que se muestre la bienvenida una sola vez.
            if(!welcomeMostrar){
            System.out.println("☑️Welcome Hogwarts️🏰");
            welcomeMostrar = true;}
        }catch (SQLException e){
            if(!welcomeMostrar) {
                System.out.println("❌❌❌ERROR DE CONEXION: " + e.getMessage());
                welcomeMostrar = true;
            }
        }
        return conn;
    }




}
