
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author james
 */
public class Item {
    private String name;
    private int quantity;
    private double price;
    
    public Item() {
        
    }
    
    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setQuantity(int Quantity) {
        this.quantity = quantity;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getTotal() {
        return quantity * price;
    }
    
    public String toString(){
        return name + "-X-" + quantity + "(PHP " + price + ")-" + "PHP " + getTotal(); 
    }
}


// Comparator implementations for Collection Sort
class SortByNameA implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return a.getName().compareTo(b.getName());
    }
}

class SortByNameD implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return b.getName().compareTo(a.getName());
    }
}

class SortByQuantityA implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return a.getQuantity() - b.getQuantity();
    }
}

class SortByQuantityD implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return b.getQuantity() - a.getQuantity();
    }
}

class SortByPriceA implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return (int) Math.round(a.getPrice() - b.getPrice());
    }
}
class SortByPriceD implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return (int) Math.round(b.getPrice() - a.getPrice());
    }
} 