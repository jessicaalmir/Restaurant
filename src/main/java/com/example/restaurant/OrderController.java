package com.example.restaurant;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.sql.*;

public class OrderController {
    @FXML
    private Label welcomeText;

    Connection con;
    PreparedStatement pst= null;
    ResultSet rs = null;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onCreateOrderClick()
    {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/restaurant","root","root");
            String query = "Insert into orderdetail(IdOrder,IdMenu) values (1,1)";
            pst = con.prepareStatement(query);
            int status  = pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Created");
            alert.setHeaderText(null);
            alert.setContentText("Order Created Successfully");
            alert.showAndWait();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
}