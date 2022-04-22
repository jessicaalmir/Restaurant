package com.example.restaurant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class menu {
    PreparedStatement pst= null;
    ResultSet rs = null;
    String item;

    public  menu(String item){
        this.item=item;
    }
    public menu(){

    }
    public String getMenu() {
        return item;
    }
    public void setMenu(String item){
        this.item = item;
    }

    public ObservableList<menu> getOptions() {
        ObservableList<menu> obs = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?autoReconnect=true&useSSL=false", "root", "root");
            String query = "Select name from menu";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()){

                String item = rs.getString("name");

                menu m = new menu(item);
                obs.add(m);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obs;
    }

}
