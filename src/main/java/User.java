import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class User {
    private String firstname;
    private String username;
    private ArrayList<ShoppingList> history;
    private ShoppingList unfinishedList;
    
    public User() {
    }
    
    public User(String firstname, String username) {
        this.firstname = firstname;
        this.username = username;
        if (hasUnfinishedList()) {
            this.unfinishedList = retrieveUnfinishedList();
        }
        this.history = retrieveHistory();
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public String getUsername() {
        return username;
    }
    
    public ArrayList<ShoppingList> getHistory() {
        return history;
    }
    
    public ShoppingList getUnfinishedList() {
        return unfinishedList;
    }
    
    public void addItemToUnfinishedList(Item item) {
        unfinishedList.addItem(item);
        
        // Save to file
        String userDataDr = System.getProperty("user.dir") + "\\csv\\" + username;
        File[] files = (new File(userDataDr)).listFiles(File::isFile);  
        
        for (File file : files) {
            String name = file.getName();

            if (name.substring(name.length()-4).equals(".csv")) {
                try {
                    FileWriter fw = new FileWriter(file, true);
                    
                    String itemName = item.getName();
                    int quantity = item.getQuantity();
                    double price = item.getPrice();
                    
                    fw.append(itemName + "," + quantity + "," + price + "\n");
                    
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }   
    
    public void addList(ShoppingList list) {
        history.add(list);
    }
    
    public void refreshHistory() {
        history = retrieveHistory();
    }
    
    public boolean hasUnfinishedList() {
        boolean hasUnfinished = false;
        
        String userDataDr = System.getProperty("user.dir") + "\\csv\\" + username;
        File[] files = (new File(userDataDr)).listFiles(File::isFile);
        if (files.length == 1) {
            hasUnfinished = true;
        }
        
        return hasUnfinished;
    }
    
    private ShoppingList getListInfo(File file) {
        ArrayList<Item> list = new ArrayList<>();
        String[] fileName = file.getName().split("[-.]");
        String listName = fileName[0];
        String listDateUnf = fileName[1];
        
        DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuuMMdd")
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
    
    private ShoppingList retrieveUnfinishedList() {
        String userDataDr = System.getProperty("user.dir") + "\\csv\\" + username;
        File[] files = (new File(userDataDr)).listFiles(File::isFile);  
        
        for (File file : files) {
            String name = file.getName();

            if (name.substring(name.length()-4).equals(".csv")) {
                return getListInfo(file);
            }
        }
        
        return null;
    }
    
    private ArrayList<ShoppingList> retrieveHistory() {
        ArrayList<ShoppingList> list = new ArrayList<>();
        
        String userDataDr = System.getProperty("user.dir") + "\\csv\\" + username + "\\history";
        File[] files = (new File(userDataDr)).listFiles(File::isFile);  
        for (File file : files) {
            list.add(getListInfo(file));
        }
        
        return list;
    }
    
    
}
