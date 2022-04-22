package com.example.restaurant;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class OrderApplication extends Application {

    Connection conn;
    ComboBox combo = new ComboBox();

    public void connect(){
        try {
             conn = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/restaurant?autoReconnect=true&useSSL=false", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void initCombo(){
        menu m =new menu();

        ObservableList<menu> obsmenu = m.getOptions();
         combo.setItems(obsmenu);
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OrderApplication.class.getResource("order-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        connect();
        initCombo();
        stage.setTitle("Create Order");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}