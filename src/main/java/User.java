
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author james
 */

import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class User {
    private String firstname;
    private String username;
    private ArrayList<ShoppingList> basket;
    
    public User() {
    }
    
    public User(String firstname, String username) {
        this.firstname = firstname;
        this.username = username;
        // this.basket = retrieveBasket();
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public String getUsername() {
        return username;
    }
    
    private ArrayList<ShoppingList> retrieveBasket() {
        ArrayList<ShoppingList> basket = new ArrayList<>();
        
        File directory = new File(System.getProperty("user.dir") + "csv\\" + username);
        File[] files = directory.listFiles(File::isFile);  
        for (File file : files) {
            basket.add(retrieveList(file));
        }
        
        return basket;
    }
    
    private ShoppingList retrieveList(File file) {
        ArrayList<Item> list = new ArrayList<>();
        String[] fileName = file.getName().split("[-.]");
        String listName = fileName[0];
        String listDateUnf = fileName[1];
        
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd")
                                                .withResolverStyle(ResolverStyle.STRICT); 
        LocalDate listDate = LocalDate.parse(listDateUnf, df);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while ((str = br.readLine()) != null) {
                String[] itemStr = str.split(",");
                
                String name = itemStr[0];
                int quantity = Integer.parseInt(itemStr[1]);
                double price = Double.parseDouble(itemStr[2]);
                
                list.add(new Item(name, quantity, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return new ShoppingList(listName ,listDate ,list);
    }
    
}
