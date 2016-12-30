package org.kolokolov.databases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.sql.PreparedStatement;

public class MySQLdemo {

    public static void main(String[] args) {
        Properties connectionProperties = new Properties();
        try (InputStream input = new FileInputStream("test/connection.properties")) {
            connectionProperties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = connectionProperties.getProperty("url");
        String user = connectionProperties.getProperty("user");
        String password = connectionProperties.getProperty("password");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT g.name Product, g.price Price, c.name Category "
                    + "FROM good g LEFT JOIN category_has_good cg ON g.id = cg.good_id "
                    + "LEFT JOIN category c ON cg.category_id = c.id "
                    + "WHERE c.name = 'Dental care' ORDER BY g.price");
            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getString(1) + ",\t" + resultSet.getBigDecimal(2) + ",\t" + resultSet.getString(3));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            PreparedStatement statement = connection
                    .prepareStatement("SELECT g.name Product, g.price Price, c.name Category FROM good g "
                            + "LEFT JOIN category_has_good cg ON g.id = cg.good_id "
                            + "LEFT JOIN category c ON cg.category_id = c.id WHERE c.name = ? ORDER BY g.price");
            statement.setString(1, "Cigarettes");
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + ",\t" 
                + resultSet.getBigDecimal(2) + ",\t" 
                + resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.forEach(t -> t.printStackTrace());
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++");
        
        CachedRowSet crs = null;
        
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            
            PreparedStatement statement = connection
                    .prepareStatement("SELECT g.name Product, g.price Price, c.name Category FROM good g "
                            + "LEFT JOIN category_has_good cg ON g.id = cg.good_id "
                            + "LEFT JOIN category c ON cg.category_id = c.id WHERE c.name = ? ORDER BY g.price");
            statement.setString(1, "Chemicals");
            ResultSet resultSet =statement.executeQuery();
            
            RowSetFactory factory = RowSetProvider.newFactory();
            crs = factory.createCachedRowSet();
            
            crs.populate(resultSet);

        } catch (SQLException e) {
            e.forEach(t -> t.printStackTrace());
        }
        
        try {
            while (crs.next()) {
                System.out.println(crs.getString(1) + ",\t" 
                + crs.getBigDecimal(2) + ",\t" 
                + crs.getString(3));
            }
        } catch (SQLException e) {
            e.forEach(t -> t.printStackTrace());
        }
        
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        
        CachedRowSet crs2 = null;
        
        try {
            RowSetFactory factory2 = RowSetProvider.newFactory();
            crs2 = factory2.createCachedRowSet();
            
            crs2.setUrl(url);
            crs2.setUsername(user);
            crs2.setPassword(password);
            crs2.setPageSize(5);
            
            crs2.setCommand("SELECT g.name Product, g.price Price, c.name Category FROM good g "
                            + "LEFT JOIN category_has_good cg ON g.id = cg.good_id "
                            + "LEFT JOIN category c ON cg.category_id = c.id WHERE c.name = ? ORDER BY g.price");
            crs2.setString(1, "Doors");
            crs2.execute();
            

        } catch (SQLException e) {
            e.forEach(t -> t.printStackTrace());
        }
        
        try {
            int pageCounter = 0;
            do {
                System.out.println("<<< page " + ++pageCounter + " >>>");
                while (crs2.next()) {
                    System.out.println(crs2.getString(1) + ",\t" 
                    + crs2.getBigDecimal(2) + ",\t" 
                    + crs2.getString(3));
                }
            } while (crs2.nextPage());
        } catch (SQLException e) {
            e.forEach(t -> t.printStackTrace());
        }
    }

}
