/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cps510_ecommerce;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marvi
 */
public class CreateAccountScreenController implements Initializable {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField postalcodeField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    // Works
    public boolean isUsernameUnique(String usernameToCheck){
        Connection conn1 = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
 
            String dbURL1 = "jdbc:oracle:thin:mjuy/01316222@oracle.scs.ryerson.ca:1521:orcl";  // that is school Oracle database and you can only use it in the labs
            conn1 = DriverManager.getConnection(dbURL1);
            if(conn1 != null){
                System.out.println("Connected with connection #1");
            }
            try(Statement stmt = conn1.createStatement()){
                String query = "SELECT COUNT(username) FROM productuser WHERE username = '" + usernameToCheck + "'";
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()) {
                    int count = rs.getInt(1);
//                    System.out.println(count);
                    return count == 0;
                }
            }catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }   
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
     
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    // Format: letter|number|letter number|letter|number
    public boolean isValidPostalCode(String postalCodeToCheck) {
        // checks length of the postal code
        if (postalCodeToCheck.length() != 7) {
            return false;
        }

        // checks each character's validity
        return isLetter(postalCodeToCheck.charAt(0)) &&
               isDigit(postalCodeToCheck.charAt(1)) &&
               isLetter(postalCodeToCheck.charAt(2)) &&
               postalCodeToCheck.charAt(3) == ' ' &&
               isDigit(postalCodeToCheck.charAt(4)) &&
               isLetter(postalCodeToCheck.charAt(5)) &&
               isDigit(postalCodeToCheck.charAt(6));
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    // Change format of postal code string to M4M 7G7
    @FXML
    private void createAccountButton(ActionEvent event) throws IOException, SQLException {
        Connection conn1 = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
 
            String dbURL1 = "jdbc:oracle:thin:mjuy/01316222@oracle.scs.ryerson.ca:1521:orcl";  // that is school Oracle database and you can only use it in the labs
            conn1 = DriverManager.getConnection(dbURL1);
            if(conn1 != null){
                System.out.println("Connected with connection #1");
            }
            
            String username = usernameField.getText();
            String password = passwordField.getText();
            String firstname = firstnameField.getText();
            String lastname = lastnameField.getText();
            String address = addressField.getText();
            String city = cityField.getText();
            String postalcode = postalcodeField.getText();
            System.out.println(username + ", " + password + ", " + firstname + ", " + lastname + ", " + address + ", " + city + ", " + postalcode);
            if(username != null && password != null && firstname != null && lastname != null && address != null && city != null && (postalcode.replaceAll("\\s","").length() == 6)){
                if(isUsernameUnique(username) == true && isValidPostalCode(postalcode)){
//                  System.out.println(isUsernameUnique(username));
                    postalcode = postalcode.toUpperCase();
                    try(Statement stmt = conn1.createStatement()){
                    
                    String query = "INSERT INTO productuser (username, userpassword, firstname, lastname, address, city, postalcode, totalitemsavailable, totalitemssold, totalearnings)"
                            + " VALUES ('" + username + "', '" + password + "', '" + firstname + "', '" + lastname + "', '" + address + "', '" + city + "', '" + postalcode + "', 0, 0, 0)";
                    stmt.executeQuery(query);
                    System.out.println("User successfully added!");
                    root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    
                    }catch (SQLException e) {
                        System.out.println(e.getErrorCode());
                    }  
                }
                else
                    System.out.println("Username taken or Postal Code invalid.");
            }
            else{
                System.out.println("Please fill in all information boxes.");
            }
           
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
     
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        

    }
    
    @FXML
    private void backButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
