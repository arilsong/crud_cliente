package org.gestao_reserva.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/empresa";

    private static Connection conn;

    static {
        //procura a dependencia se existe no projeto
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){

        try{
            if(conn == null){
                //inicia a conexao
                conn = DriverManager.getConnection(url, user, password);
            }
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
