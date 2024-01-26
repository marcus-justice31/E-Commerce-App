/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cps510_ecommerce;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marvi
 */
public class UserStartScreenController implements Initializable {
 
//    @FXML
//    private TableView<Customer> customerTable;
//    @FXML
//    private TableColumn<Customer, String> usernameColumn;
//    @FXML
//    private TableColumn<Customer, String> passwordColumn;
//    @FXML
//    private TableColumn<Customer, Integer> pointsColumn;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label WelcomeMessage;

    @FXML
    private void enterButton(ActionEvent event) throws IOException {
//        Customer c = new Customer(username, password);
//        if (!Main.getCustomerList().contains(c)) {
//            Main.getCustomerList().add(c);
//        }
    }

    @FXML
    private void deleteButton(ActionEvent event) throws IOException {
//        Customer selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
//        Main.getCustomerList().remove(selectedCustomer);
    }
    
//    @FXML
//    private void backButton(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("LoginSc.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    @FXML
    private void buyButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UserBuyScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void sellButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UserSellScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void shoppingCartButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UserShoppingCartScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void logoutButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WelcomeMessage.setText("Welcome " + Main.getCurrentAccount().usernameProperty().get() + "! \n What would you like to do today?");
        
    }
    
}

