/* TODO:
        Make a textbox generator
        

*/
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;
import javax.swing.border.*;

public class appGUI extends JFrame{
    // <editor-fold defaultstate="collapsed" desc="Private declarations">
    // Constants
    private static final Color MAIN_GREEN = new Color(25, 171, 103);
    private static final Color MAIN_BLUE = new Color(3, 44, 103);
    private static final Color MAIN_BLACK = new Color(35, 40, 50);
    
    // Data Management
    HashMap<String, String> credentialsMap;
    User curUser;
    
    // Pages
    // <editor-fold defaultstate="collapsed" desc="Start Page">
    private JPanel pLogo;
    private JPanel pStart;
    private JPanel pStartButtons; 
    
    private JButton bStartLogin;
    private JButton bStartRegister;
    
    private JLabel logo;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Register Page">
    private JPanel pRegister;
    private JPanel pRegisterFName;
    private JPanel pRegisterFNameText;
    private JPanel pRegisterUName;
    private JPanel pRegisterUNameText;
    private JPanel pRegisterPassword;
    private JPanel pRegisterPasswordText;
    private JPanel pRegisterConfirmPassword;
    private JPanel pRegisterCreateAccount;
    private JPanel pRegisterGoBack;
    
    private JButton bRegisterCreateAccount;
    private JButton bRegisterGoBack;
    
    private JTextField tfRegisterFName;
    private JTextField tfRegisterUName;
    private JPasswordField pfRegisterPassword;
    private JPasswordField pfRegisterConfirmPassword;
    
    private JLabel lRegisterTitle;
    private JLabel lRegisterFName;
    private JLabel lRegisterUName;
    private JLabel lRegisterPassword;
    private JLabel lRegisterConfirmPassword;
    private JLabel lRegisterFNameParam;
    private JLabel lRegisterUNameParam;
    private JLabel lRegisterPasswordParam;
    
    private JPanel pSuccessRegister;
    private JPanel pSuccessRegisterDesc;
    private JPanel pSuccessRegisterLogin;
    
    private JButton bSuccessRegisterLogin;
    
    private JLabel lSuccessRegisterCongrats; 
    private JLabel lSuccessRegisterDesc;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Login Page">
    private JPanel pLogin;
    private JPanel pLoginUName;
    private JPanel pLoginPassword;
    private JPanel pLoginLogin;
    private JPanel pLoginGoBack;
            
    private JButton bLoginLogin;
    private JButton bLoginGoBack;
    
    private JTextField tfLoginUName;
    private JPasswordField pfLoginPassword;
    
    private JLabel lLoginTitle;
    private JLabel lLoginUName;
    private JLabel lLoginPassword;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Welcome Page">
    private JPanel pWelcome;
    private JPanel pWelcomeStart;
    private JPanel pWelcomeSeeHistory;
    
    private JButton bWelcomeStart;
    private JButton bWelcomeSeeHistory;
    
    private JLabel lWelcomeUser;
    private JLabel lWelcomeDesc;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Create Page">
    private JPanel pCreateList;
    private JPanel pCreateListName;
    private JPanel pCreateListDate;
    private JPanel pCreateListDateBoxes;
    private JPanel pCreateListButtons;
    
    private JButton bCreateListCreate;
    private JButton bCreateListGoBack;
    
    private JTextField tfCreateListName;
    
    private JComboBox<String> cbCreateListMM;
    private JComboBox<String> cbCreateListDD;
    private JComboBox<String> cbCreateListYYYY;
    
    private JLabel lCreateListName; 
    private JLabel lCreateListNameParam;
    private JLabel lCreateListDate;
    private JLabel lCreateListDateMM;
    private JLabel lCreateListDateDD;
    private JLabel lCreateListDateYYYY;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="History Page">
    private JPanel pHistory;
    private JPanel pHistoryTop;
    private JPanel pHistoryScroll;
    private JPanel pHistoryGoBack;
    
    private JButton bHistoryGoBack;
    
    private JScrollPane spHistoryScroll;
    // </editor-fold>
    
    // </editor-fold>
    
    public appGUI() {
        curUser = new User();
        
        // <editor-fold defaultstate="collapsed" desc="Start page">
        
        
        pLogo = new JPanel();
        pStart = new JPanel();
        pStartButtons = new JPanel();
        
        bStartLogin = makeButton("LOGIN", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));
        bStartRegister = makeButton("CREATE ACCOUNT", Color.WHITE, MAIN_GREEN, new Font("Open Sans", Font.BOLD, 20));
        
        logo = new JLabel();
        
        ImageIcon icon = new ImageIcon("ico\\logo.png");
        Image image = icon.getImage();
        Image scaledImg = image.getScaledInstance(225, 225,  java.awt.Image.SCALE_SMOOTH);
        
        logo.setIcon(new ImageIcon(scaledImg));
        pLogo.setLayout(new GridBagLayout());
        pLogo.setBackground(Color.WHITE);
        pLogo.add(logo);
        
        
        bStartLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                appGUI.this.remove(pStart);
                appGUI.this.add(pLogin);
                appGUI.this.revalidate();
                appGUI.this.repaint();
            }
        });
        
        bStartRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                appGUI.this.remove(pStart);
                appGUI.this.add(pRegister);
                appGUI.this.revalidate();
                appGUI.this.repaint();
            }
        });
        
        pStartButtons.setBackground(Color.WHITE);
        pStartButtons.setLayout(new GridLayout(2, 1, 15, 15));
        pStartButtons.setBorder(BorderFactory.createEmptyBorder(75, 100, 150, 100));
        pStartButtons.add(bStartLogin);
        pStartButtons.add(bStartRegister);
        
        pStart.setBackground(Color.WHITE);
        pStart.setLayout(new GridLayout(2, 1));
        pStart.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        pStart.add(pLogo);
        pStart.add(pStartButtons);
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Register page">
        pRegister = new JPanel();
        pRegisterFName = new JPanel();
        pRegisterFNameText = new JPanel();
        pRegisterUName = new JPanel();
        pRegisterUNameText = new JPanel();
        pRegisterPassword = new JPanel();
        pRegisterPasswordText = new JPanel();
        pRegisterConfirmPassword = new JPanel();
        pRegisterCreateAccount = new JPanel();
        pRegisterGoBack = new JPanel();
        
        bRegisterCreateAccount = makeButton("CREATE ACCOUNT", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));
        bRegisterGoBack = makeButton("GO BACK", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));
        
        tfRegisterFName = makeTextField();
        tfRegisterUName = makeTextField();
        pfRegisterPassword = makePasswordField();
        pfRegisterConfirmPassword = makePasswordField();

        lRegisterTitle = makeLabel("CREATE ACCOUNT", MAIN_BLUE, new Font("League Spartan", Font.BOLD, 30));
        lRegisterFName = makeLabel("First Name", MAIN_BLUE, new Font("Open Sans", Font.BOLD, 18));
        lRegisterUName = makeLabel("Username", MAIN_BLUE, new Font("Open Sans", Font.BOLD, 18));
        lRegisterPassword = makeLabel("Password", MAIN_BLUE, new Font("Open Sans", Font.BOLD, 18));
        lRegisterConfirmPassword = makeLabel("Confirm Password", MAIN_BLUE, new Font("Open Sans", Font.BOLD, 18));
        lRegisterFNameParam = makeLabel("(max. 12 Characters)", MAIN_BLUE, new Font("Open Sans", Font.PLAIN, 10));
        lRegisterUNameParam = makeLabel("(max. 20 Characters)", MAIN_BLUE, new Font("Open Sans", Font.PLAIN, 10));
        lRegisterPasswordParam = makeLabel("(max. 20 Characters)", MAIN_BLUE, new Font("Open Sans", Font.PLAIN, 10));
        
        lRegisterTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        pRegisterFNameText.setLayout(new GridLayout(1, 2)); 
        pRegisterFNameText.setBackground(Color.WHITE);
        pRegisterFNameText.add(lRegisterFName);
        pRegisterFNameText.add(lRegisterFNameParam);
        
        pRegisterUNameText.setLayout(new GridLayout(1, 2));
        pRegisterUNameText.setBackground(Color.WHITE);
        pRegisterUNameText.add(lRegisterUName);
        pRegisterUNameText.add(lRegisterUNameParam);
        
        pRegisterPasswordText.setLayout(new GridLayout(1, 2));
        pRegisterPasswordText.setBackground(Color.WHITE);
        pRegisterPasswordText.add(lRegisterPassword);
        pRegisterPasswordText.add(lRegisterPasswordParam);
        
        pRegisterFName.setLayout(new GridLayout(2, 1));
        pRegisterFName.add(pRegisterFNameText);
        pRegisterFName.add(tfRegisterFName);
        
        pRegisterUName.setLayout(new GridLayout(2, 1));
        pRegisterUName.add(pRegisterUNameText);
        pRegisterUName.add(tfRegisterUName);
        
        pRegisterPassword.setLayout(new GridLayout(2, 1));
        pRegisterPassword.add(pRegisterPasswordText);
        pRegisterPassword.add(pfRegisterPassword);
        
        pRegisterConfirmPassword.setLayout(new GridLayout(2, 1));
        pRegisterConfirmPassword.setBackground(Color.WHITE);
        pRegisterConfirmPassword.add(lRegisterConfirmPassword);
        pRegisterConfirmPassword.add(pfRegisterConfirmPassword);
        
        pRegister.setBackground(Color.WHITE);
        pRegister.setLayout(new GridLayout(7, 1, 20, 20));
        pRegister.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        bRegisterCreateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean registerSuccessful = false;
                
                try {
                    registerUser();
                    registerSuccessful = true;
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "An IllegalArgumentExceptionCaught: " + e.getMessage() + ". Please Try again.", 
                                              "Error Screen", JOptionPane.ERROR_MESSAGE);
                }
                
                if (registerSuccessful) {
                    appGUI.this.remove(pRegister);
                    appGUI.this.add(pSuccessRegister);
                    appGUI.this.revalidate();
                    appGUI.this.repaint();
                }
            }
        });
        
        bRegisterCreateAccount.setPreferredSize(new Dimension(300, 50));
      
        pRegisterCreateAccount.setBackground(Color.WHITE);
        pRegisterCreateAccount.add(bRegisterCreateAccount);
        
        bRegisterGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                appGUI.this.remove(pRegister);
                appGUI.this.add(pStart);
                appGUI.this.revalidate();
                appGUI.this.repaint();
            }
        });
        bRegisterGoBack.setPreferredSize(new Dimension(300, 50));
        
        pRegisterGoBack.setBackground(Color.WHITE);
        pRegisterGoBack.add(bRegisterGoBack);
        
        pRegister.add(lRegisterTitle);
        pRegister.add(pRegisterFName);
        pRegister.add(pRegisterUName);
        pRegister.add(pRegisterPassword);
        pRegister.add(pRegisterConfirmPassword);
        pRegister.add(pRegisterCreateAccount);
        pRegister.add(pRegisterGoBack);
        
        
        // Successful Register Page
        pSuccessRegister = new JPanel();
        pSuccessRegisterDesc = new JPanel();
        pSuccessRegisterLogin = new JPanel();
        
        bSuccessRegisterLogin = makeButton("LOG IN", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));
        
        lSuccessRegisterCongrats = makeLabel("Congratulations!", MAIN_BLUE, new Font("Open Sans", Font.BOLD, 30));
        lSuccessRegisterDesc = makeLabel("""
                                         <html><body style='text-align: center'>
                                         You have successfully registered your 
                                         <br/>
                                         account. Please log in to continue.
                                         </html>
                                         """, MAIN_BLUE, new Font("Open Sans", Font.PLAIN, 20));
        
        lSuccessRegisterCongrats.setHorizontalAlignment(SwingConstants.CENTER);
        lSuccessRegisterDesc.setHorizontalAlignment(SwingConstants.CENTER);
        pSuccessRegisterDesc.setBackground(Color.WHITE);
        pSuccessRegisterDesc.add(lSuccessRegisterDesc);
        
        bSuccessRegisterLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                appGUI.this.remove(pSuccessRegister);
                appGUI.this.add(pLogin);
                appGUI.this.revalidate();
                appGUI.this.repaint();
            }
        });
        bSuccessRegisterLogin.setPreferredSize(new Dimension(300, 50));
        pSuccessRegisterLogin.setBackground(Color.WHITE);
        pSuccessRegisterLogin.add(bSuccessRegisterLogin);
        
        pSuccessRegister.setLayout(new GridLayout(3, 1, 10, 10));
        pSuccessRegister.setBorder(BorderFactory.createEmptyBorder(225, 50, 225, 50));
        pSuccessRegister.setBackground(Color.WHITE);
        
        pSuccessRegister.add(lSuccessRegisterCongrats);
        pSuccessRegister.add(pSuccessRegisterDesc);
        pSuccessRegister.add(pSuccessRegisterLogin);
        
        
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Login page">
        pLogin = new JPanel();
        pLoginUName = new JPanel();
        pLoginPassword = new JPanel();
        pLoginLogin = new JPanel();
        pLoginGoBack = new JPanel();
        
        bLoginLogin = makeButton("LOG IN", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));
        bLoginGoBack = makeButton("GO BACK", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));
        
        tfLoginUName = new JTextField();
        pfLoginPassword = new JPasswordField();

        lLoginTitle = makeLabel("LOG IN", MAIN_BLUE, new Font("League Spartan", Font.BOLD, 40));;
        lLoginUName = makeLabel("Username", MAIN_BLUE, new Font("Open Sans", Font.BOLD, 18));
        lLoginPassword = makeLabel("Password", MAIN_BLUE, new Font("Open Sans", Font.BOLD, 18));
        
        lLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        tfLoginUName.setBorder(BorderFactory.createLineBorder(MAIN_BLACK, 3));
        pfLoginPassword.setBorder(BorderFactory.createLineBorder(MAIN_BLACK, 3));
        
        pLoginUName.setLayout(new GridLayout(2, 1));
        pLoginUName.setBackground(Color.WHITE);
        pLoginUName.add(lLoginUName);
        pLoginUName.add(tfLoginUName);
        
        pLoginPassword.setLayout(new GridLayout(2, 1));
        pLoginPassword.setBackground(Color.WHITE);
        pLoginPassword.add(lLoginPassword);
        pLoginPassword.add(pfLoginPassword);
        
        bLoginLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    login();
                    
                    lWelcomeUser.setText("Welcome, " + curUser.getFirstname());
                    appGUI.this.remove(pLogin);
                    appGUI.this.add(pWelcome);
                    appGUI.this.revalidate();
                    appGUI.this.repaint();
                } catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, e.getMessage() + ". Please Try again.", 
                                              "Error Screen", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        bLoginLogin.setPreferredSize(new Dimension(300, 50));
        pLoginLogin.setBackground(Color.WHITE);
        pLoginLogin.add(bLoginLogin);
        
        bLoginGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                appGUI.this.remove(pLogin);
                appGUI.this.add(pStart);
                appGUI.this.revalidate();
                appGUI.this.repaint();
            }
        });
        bLoginGoBack.setPreferredSize(new Dimension(300, 50));
        pLoginGoBack.setBackground(Color.WHITE);
        pLoginGoBack.add(bLoginGoBack);
        
        pLogin.setLayout(new GridLayout(5, 1, 25, 25));
        pLogin.setBorder(BorderFactory.createEmptyBorder(125, 50, 125, 50));
        pLogin.setBackground(Color.WHITE); 
        pLogin.add(lLoginTitle);
        pLogin.add(pLoginUName);
        pLogin.add(pLoginPassword);
        pLogin.add(pLoginLogin);
        pLogin.add(pLoginGoBack);
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Welcome Page">
        pWelcome = new JPanel();
        pWelcomeStart = new JPanel();
        pWelcomeSeeHistory = new JPanel();

        bWelcomeStart = makeButton("START", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));
        bWelcomeSeeHistory = makeButton("SEE HISTORY", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));
        
        lWelcomeUser = makeLabel("Welcome, missingName" + curUser.getFirstname(), MAIN_BLUE, new Font("Open Sans", Font.BOLD, 30));
        lWelcomeDesc = makeLabel("Shall we start shopping?", MAIN_BLUE, new Font("Open Sans", Font.PLAIN, 20));
        
        lWelcomeUser.setHorizontalAlignment(SwingConstants.CENTER);
        lWelcomeDesc.setHorizontalAlignment(SwingConstants.CENTER);
        
        bWelcomeStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
            }
        });
        bWelcomeStart.setPreferredSize(new Dimension(300, 50));
        pWelcomeStart.setBackground(Color.WHITE);
        pWelcomeStart.add(bWelcomeStart);
        
        bWelcomeSeeHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            }
        });
        bWelcomeSeeHistory.setPreferredSize(new Dimension(300, 50));
        pWelcomeSeeHistory.setBackground(Color.WHITE);
        pWelcomeSeeHistory.add(bWelcomeSeeHistory);
        
        pWelcome.setLayout(new GridLayout(4, 1, 10, 10));
        pWelcome.setBackground(Color.WHITE);
        pWelcome.setBorder(BorderFactory.createEmptyBorder(225, 50, 225, 50));
        
        pWelcome.add(lWelcomeUser);
        pWelcome.add(lWelcomeDesc);
        pWelcome.add(pWelcomeStart);
        pWelcome.add(pWelcomeSeeHistory);
        
        
        // </editor-fold> 
        
        // <editor-fold defaultstate="collapsed" desc="Create Page">
        
        pCreateList = new JPanel();
        pCreateListName = new JPanel();
        pCreateListDate = new JPanel();
        pCreateListDateBoxes = new JPanel();
        pCreateListButtons = new JPanel();

        bCreateListCreate = makeButton("CREATE", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));
        bCreateListGoBack = makeButton("GO BACK", MAIN_GREEN, Color.WHITE, new Font("Open Sans", Font.BOLD, 20));

        tfCreateListName = new JTextField();

        cbCreateListMM = new JComboBox<>();
        cbCreateListDD = new JComboBox<>();
        cbCreateListYYYY = new JComboBox<>();

        lCreateListName = makeLabel("LIST NAME" + curUser.getFirstname(), MAIN_BLUE, new Font("League Spartan", Font.BOLD, 30));
        lCreateListNameParam = makeLabel("(Max. 20 Characters)", MAIN_BLUE, new Font("Open Sans", Font.PLAIN, 12));
        lCreateListDate = makeLabel("DATE TODAY" + curUser.getFirstname(), MAIN_BLUE, new Font("League Spartan", Font.BOLD, 30));
        lCreateListDateMM = makeLabel("MM", MAIN_BLUE, new Font("Open Sans", Font.PLAIN, 14));
        lCreateListDateDD = makeLabel("/ DD", MAIN_BLUE, new Font("Open Sans", Font.PLAIN, 14));
        lCreateListDateYYYY = makeLabel("/ YYYY", MAIN_BLUE, new Font("Open Sans", Font.PLAIN, 14));
        
        lCreateListName.setHorizontalAlignment(SwingConstants.CENTER);
        lCreateListNameParam.setHorizontalAlignment(SwingConstants.CENTER);
        
        pCreateListName.setLayout(new GridLayout(3, 1));
        pCreateListName.add(lCreateListName);
        pCreateListName.add(lCreateListNameParam);
        pCreateListName.add(tfCreateListName);
        
        pCreateListDateBoxes.setLayout(new SpringLayout());
        
        
        String[] mm = new String[12];
        String[] dd = new String[31];
        String[] yyyy = new String[(LocalDate.now().getYear()-1900)];
        
        for (int i = 0; i < mm.length; i++) {
            mm[i] = String.format("%02d", i+1);
        }
        
        for (int i = 0; i < dd.length; i++) {
            dd[i] = String.format("%02d", i+1);
        }
        
        for (int i = 0; i < yyyy.length; i++) {
            yyyy[i] = String.format("%04d", i+1901);
        }
        
        cbCreateListMM.setModel(new DefaultComboBoxModel<>(mm));
        cbCreateListDD.setModel(new DefaultComboBoxModel<>(dd));
        cbCreateListYYYY.setModel(new DefaultComboBoxModel<>(yyyy));
        
   
        
        pCreateList.setLayout(new GridLayout(3, 1));
        
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Add Item Page">
        
        
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Preview List Page">
        
        
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Finish List Page">
        
        
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="History Page">
        
        
        
        // </editor-fold>
        
        // Main Frame Build
        setSize(450, 750);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().add(pStart);
        
        // File I/O
        
        credentialsMap = retrieveCredentials();
    }
    
    
    public void run() {
        setVisible(true);
    }
    
    // Helper functions
    private void login() throws IllegalArgumentException {
        String username = tfLoginUName.getText();
        String password = new String(pfLoginPassword.getPassword());

        try {
            if (credentialsMap.get(username).equals(password)) {
                curUser = retrieveUserInfo(username);
            } else {
                throw new IllegalArgumentException("Invalid Credentials");
            }   
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        
    }
    
    private void registerUser() throws IllegalArgumentException{
        String firstname = "";
        String username = "";
        String password = "";
        String confirmPassword = "";
        
        // <editor-fold defaultstate="collapsed" desc="Info Checking">
        // Check if name field is empty
        try {
            firstname = tfRegisterFName.getText();
            if (firstname.length() == 0) {
                throw new IllegalArgumentException("First Name Field is Empty");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("First Name Field is Empty");
        }
        
        try {
            username = tfRegisterUName.getText();
            if (username.length() == 0) {
                throw new IllegalArgumentException("Username Name Field is Empty");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Username Field is Empty");
        }
        
        try {
            password = new String(pfRegisterPassword.getPassword());
            if (password.length() == 0) {
                throw new IllegalArgumentException("Pasword Field is Empty");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Password Field is Empty");
        }
         
        try {
            confirmPassword = new String(pfRegisterConfirmPassword.getPassword());
            if (password.length() == 0) {
                throw new IllegalArgumentException("Confirm Password Field is Empty");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Confirm Password Field is Empty");
        }
        
        
        // Check if input exceeds character limit
        if (firstname.length() > 12) {
            throw new IllegalArgumentException("First Name exceeds character limit");
        } 
        
        if (username.length() > 20){
            throw new IllegalArgumentException("Username exceeds character limit");
        } 
        
        if (password.length() > 20) {
            throw new IllegalArgumentException("Password exceeds character limit");
        }
        
        // Check for invalid folder names in windows and mac
        String[] invalidNames = {"CON", "PRN", "AUX", "NUL", 
                                 "COM1", "COM2", "COM3", 
                                 "COM4", "COM5", "COM6", 
                                 "COM7", "COM8", "COM9", 
                                 "LPT1", "LPT2", "LPT3", 
                                 "LPT4", "LPT5", "LPT6", 
                                 "LPT7", "LPT8", "LPT9"};
        
        for (String name : invalidNames) {
            if (name.equals(username.toUpperCase())) {
                throw new IllegalArgumentException("Invalid Username, please try to enter a different one");
            }
        }
        
        // Check if username is already registered
        if (credentialsMap.containsKey(username)) {
            throw new IllegalArgumentException("User already exists in the system");
        }
        
        
        // Check if Password is confirmed
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        
        // </editor-fold>
        
        // Register the user
        
        // Get the path for the list of login credentials
        String logCred = System.getProperty("user.dir") + "\\csv\\loginCredentials.csv";
        // Create a directory for the user data
        String userDataDr = System.getProperty("user.dir") + "\\csv\\" + username;
        try {
            File userDr = new File(userDataDr);
            userDr.mkdir();
            
            credentialsMap.put(username, password);
            FileWriter fw = new FileWriter(logCred, true);
            fw.write(username + "," + password + "," + firstname + "\n");
            
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private HashMap<String, String> retrieveCredentials() {
        HashMap<String, String> loginCredentials = new HashMap<>();
        File credentialsFile = new File("csv\\loginCredentials.csv");
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(credentialsFile));
            String str;
            while ((str = br.readLine()) != null) {
                String[] credential = str.split(",");
                
                loginCredentials.put(credential[0], credential[1]);
            }
            
            br.close();
        } catch (FileNotFoundException e) {
            try {
                credentialsFile.createNewFile();
                return retrieveCredentials();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return loginCredentials;
    }
    
    private User retrieveUserInfo(String username) {
        String firstname = "";
        File credentialsFile = new File("csv\\loginCredentials.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(credentialsFile));
            String str;
            while ((str = br.readLine()) != null) {
                String[] credential = str.split(",");
                if (credential[0].equals(username)) {
                    firstname = credential[2];
                }
            }
            
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return new User(firstname, username);
    }
    
    // GUI Builder Functions
    private static JButton makeButton(String text, Color bg, Color fg, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(fg);
        button.setBackground(bg);
        Border line = new LineBorder(fg);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        
        
        button.setFocusPainted(false);
        
        return button;
    }
    
    private static JLabel makeLabel(String text, Color fg, Font font) {
        JLabel label = new JLabel(text);
        label.setForeground(fg);
        label.setFont(font); 
        
        return label;
    }
    
    private static JTextField makeTextField() {
        JTextField tf = new JTextField();
        
        Border line = new LineBorder(MAIN_BLACK, 3);
        Border empty = new EmptyBorder(0, 5, 0, 0);
        tf.setBorder(new CompoundBorder(line, empty));
        tf.setMargin(new Insets(0, 5, 0, 10));
        tf.setFont(new Font("Open Sans", Font.PLAIN, 14));
        
        return tf;
    }
    
    private static JPasswordField makePasswordField() {
        JPasswordField pf = new JPasswordField();
        
        Border line = new LineBorder(MAIN_BLACK, 3);
        Border empty = new EmptyBorder(0, 5, 0, 0);
        pf.setBorder(new CompoundBorder(line, empty));
        pf.setMargin(new Insets(0, 5, 0, 10));
        
        pf.setFont(new Font("Open Sans", Font.PLAIN, 14));
        
        return pf;
    }
    
    private static JComboBox makeDropDown() {
        JComboBox dropDown = new JComboBox();
        dropDown.setBorder(BorderFactory.createLineBorder(MAIN_BLACK, 2));
        dropDown.setFont(new Font("Open Sans", Font.PLAIN, 10));
        
        return dropDown;
    }
}
