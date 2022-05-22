/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author james
 */

import java.io.*;
import java.time.*;
import java.util.*;

public class ShoppingList {
    private String name;
    private LocalDate date;
    private ArrayList<Item> list;
    private double total;
    
    public ShoppingList() {
        
    }
    
    public ShoppingList(String name, LocalDate date, ArrayList<Item> list) {
        this.name = name;
        this.date = date;
        this.list = list;
        
        System.out.println(name);
        System.out.println(date);
        System.out.println(list);
        
        for (Item item : list) {
            this.total += item.getTotal();
        }
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void setList(ArrayList<Item> list) {
        this.list = list;
    }
    
    public String getName() {
        return name;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public ArrayList<Item> getList() {
        return list;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void addItem (Item item) {
        list.add(item);
        total += item.getTotal();
    }
    
    @Override
    public String toString() {
        return name + "-" + date.toString().replaceAll("-", "");
    }
            
}
