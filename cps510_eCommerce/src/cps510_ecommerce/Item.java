/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cps510_ecommerce;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.*;
import javafx.scene.control.CheckBox;

/**
 *
 * @author marvi
 */
public class Item {
    private IntegerProperty productID;
    private StringProperty productName;
    private StringProperty productSeller;
    private DoubleProperty price;
    private StringProperty productDescription;
    private StringProperty productTag;
    private CheckBox select;

    public Item(String name, double price, String seller, String description, String tag) {
        productNameProperty().set(name);
        price = ((int) (price * 100)) / 100.0;
        priceProperty().set(price);
        select = new CheckBox();
    }

    public final StringProperty productNameProperty() {
        if (productName == null) {
            productName = new SimpleStringProperty(this, "productName");
        }
        return productName;
    }
    
    public final StringProperty itemSellerProperty() {
        if (productSeller == null) {
            productSeller = new SimpleStringProperty(this, "productSeller");
        }
        return productSeller;
    }
    
    public final StringProperty itemDescriptionProperty() {
        if (productDescription == null) {
            productDescription = new SimpleStringProperty(this, "productDescription");
        }
        return productDescription;
    }
    
    public final StringProperty itemTagProperty() {
        if (productTag == null) {
            productTag = new SimpleStringProperty(this, "productTag");
        }
        return productTag;
    }
    
    public final DoubleProperty priceProperty() {
        if (price == null) {
            price = new SimpleDoubleProperty(this, "price");
        }
        return price;
    }
    
    public CheckBox getSelect() {
        return select;
    }
    
    public void setSelect(CheckBox select) {
        this.select = select;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item i = (Item) o;
        return productNameProperty().get().equals(i.productNameProperty().get()) && priceProperty().get() == i.priceProperty().get() 
                && itemSellerProperty().get().equals(i.itemSellerProperty().get())
                && itemDescriptionProperty().get().equals(i.itemDescriptionProperty().get())
                && itemTagProperty().get().equals(i.itemTagProperty().get());
    }
}
