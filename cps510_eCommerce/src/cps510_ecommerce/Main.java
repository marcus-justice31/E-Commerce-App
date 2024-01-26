/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cps510_ecommerce;

import java.sql.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
/**
 *
 * @author marvi
 */
public class Main extends Application{
//    public static Connection conn1 = null;
    private static User currentAccount;
    
    
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        
        
        
        launch(args); // starts the FXML 
        
        
        
    }
    public static User getCurrentAccount() {
        return currentAccount;
    }

    public static void setCurrentAccount(User acc) {
        currentAccount = acc;
    }
    
    public static ObservableList<Item> fetchItems() throws FileNotFoundException {

        ObservableList<Item> tempList = FXCollections.observableArrayList();
//        Scanner input = new Scanner(new File("customers.txt"));
//
//        while (input.hasNextLine()) {
//            try {
//                tempList.add(new Customer(input.nextLine(), input.nextLine(), Integer.parseInt(input.nextLine())));
//            } catch (NoSuchElementException e) {
//                System.out.println("customers.txt error");
//            }
//        }
        return tempList;
    }
    
}

