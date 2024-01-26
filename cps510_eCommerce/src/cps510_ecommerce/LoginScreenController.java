package cps510_ecommerce;
//import static cps510_ecommerce.Main.conn1; // imported Connection conn1 from Main
import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
public class LoginScreenController implements Initializable {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private void createAccountButton(ActionEvent event) throws IOException, SQLException {
        System.out.println("Switching to Create Account Screen");
        root = FXMLLoader.load(getClass().getResource("CreateAccountScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loginButton(ActionEvent event) throws IOException, SQLException {
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
            System.out.println(username + ", " + password);
            String usernameSQL = "";
            String passwordSQL = "";
            try(Statement stmt = conn1.createStatement()){
                ResultSet rs = stmt.executeQuery("SELECT username, userpassword FROM productuser" +
                    " WHERE username = '" + username + "' AND userpassword = '" + password + "'");

                while (rs.next()) {
                    usernameSQL = rs.getString("username"); // Position of the column
                    passwordSQL = rs.getString("userpassword");
                    System.out.println(usernameSQL + ", " + passwordSQL);
                }
            }catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }
            if(username.equals(usernameSQL) && password.equals(passwordSQL)){
                User login = new User(username, password); // Create new User with the current Username and Password
                System.out.println("Success");
                
                Main.setCurrentAccount(login); // Sets the current account as the login credentials
                System.out.println("Current account is " + Main.getCurrentAccount().usernameProperty().get()); // Access username by usernameProperty().get(); Because that is the StringProperty in the User.java file
                root = FXMLLoader.load(getClass().getResource("UserStartScreen.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
            }
            else{
                System.out.println("Invalid Credentials");
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
    private void createTablesButton(ActionEvent event) throws IOException, SQLException {
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
            System.out.println(username + ", " + password);
            String usernameSQL = "";
            String passwordSQL = "";
            try(Statement stmt = conn1.createStatement()){
                ResultSet rs = stmt.executeQuery("SELECT username, userpassword FROM productuser" +
                    " WHERE username = '" + username + "' AND userpassword = '" + password + "'");

                while (rs.next()) {
                    usernameSQL = rs.getString("username"); // Position of the column
                    passwordSQL = rs.getString("userpassword");
                    System.out.println(usernameSQL + ", " + passwordSQL);
                }
            }catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }
            if(username.equals(usernameSQL) && password.equals(passwordSQL)){
                User login = new User(username, password); // Create new User with the current Username and Password
                System.out.println("Success");
                
                Main.setCurrentAccount(login); // Sets the current account as the login credentials
                System.out.println("Current account is " + Main.getCurrentAccount().usernameProperty().get()); // Access username by usernameProperty().get(); Because that is the StringProperty in the User.java file
                root = FXMLLoader.load(getClass().getResource("UserStartScreen.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
            }
            else{
                System.out.println("Invalid Credentials");
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        if(check.isDbConnected()){
////            isConnected.setText("");
//        }
    }    
    
}
