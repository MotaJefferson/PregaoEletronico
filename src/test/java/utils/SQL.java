package utils;

import java.sql.*;

public class SQL {

    public static void main(String[] args){
        String conectarSQL =
                "jdbc:sqlserver://192.168.0.90:1437;"
                + "database=SmarAM_SCS;"
                + "user=mat;"
                + "password=mpk3530;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;"
                ;

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(conectarSQL);
             Statement statement = connection.createStatement();){

                 String selectSQL = "SELECT TOP 10 idEdital FROM MCT01200";
                 resultSet = statement.executeQuery(selectSQL);

                 while (resultSet.next()){
                     System.out.println(resultSet.getString(1));
                                      }
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

}
