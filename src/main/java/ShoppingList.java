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
    
    public ShoppingList() {
        
    }
    
    public ShoppingList(String name, LocalDate date, ArrayList<Item> list) {
        this.name = name;
        this.date = date;
        this.list = list;
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
            
}
