
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;


public class AppGUI extends JFrame{
    // <editor-fold defaultstate="collapsed" desc="Private declarations">
    // Constants
    private static final Color MAIN_GREEN = new Color(25, 171, 103);
    private static final Color MAIN_BLUE = new Color(3, 44, 103);
    private static final Color MAIN_BLACK = new Color(35, 40, 50);
    
    private static final File OPEN_SANS = new File("fonts\\OpenSans.ttf");
    private static final File LEAGUE_SPARTAN = new File("fonts\\LeagueSpartan.ttf");
    
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
    private JPanel pCreateListDateMM;
    private JPanel pCreateListDateDD;
    private JPanel pCreateListDateYYYY;
    private JPanel pCreateListDateBoxes;
    private JPanel pCreateListCreate;
    private JPanel pCreateListGoBack;
    private JPanel pCreateListButtons;
    
    private JButton bCreateListCreate;
    private JButton bCreateListGoBack;
    
    private JTextField tfCreateListName;
    
    private JComboBox<String> cbCreateListDateMM;
    private JComboBox<String> cbCreateListDateDD;
    private JComboBox<String> cbCreateListDateYYYY;
    
    private JLabel lCreateListName; 
    private JLabel lCreateListNameParam;
    private JLabel lCreateListDate;
    private JLabel lCreateListDateMM;
    private JLabel lCreateListDateDD;
    private JLabel lCreateListDateYYYY;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Add Item Page">
    private JPanel pAddItem;
    private JPanel pAddItemBottom;
    private JPanel pAddItemListDetails;
    private JPanel pAddItemName;
    private JPanel pAddItemQuantity;
    private JPanel pAddItemPrice;
    private JPanel pAddItemButtons;
    private JPanel pAddItemAdd;
    private JPanel pAddItemSeeList;
    
    private JButton bAddItemAdd;
    private JButton bAddItemSeeList;
    
    private JTextField tfAddItemName;
    private JTextField tfAddItemQuantity;
    private JTextField tfAddItemPrice;
    
    private JLabel lAddItemListName;
    private JLabel lAddItemListDate;
    private JLabel lAddItemName;
    private JLabel lAddItemNameParam;
    private JLabel lAddItemQuantity;
    private JLabel lAddItemQuantityParam;
    private JLabel lAddItemPrice;
    private JLabel lAddItemPriceParam;
    
    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Preview Page">
    private JPanel pPreviewList;
    private JPanel pPreviewListBottom;
    private JPanel pPreviewListDetails;
    private JPanel pPreviewListDisplay;
    private JPanel pPreviewListTotal;
    private JPanel pPreviewListButtons;
    private JPanel pPreviewListFinish;
    private JPanel pPreviewListAddMore;
    private JPanel pPreviewListTotalButtons;
    
    private JButton bPreviewListFinish;
    private JButton bPreviewListAddMore;
    
    private JScrollPane spPreviewListDisplay;
    private DefaultTableModel dtmPreviewListDisplay;
    private JTable tPreviewListDisplay;
    
    private JLabel lPreviewListName;
    private JLabel lPreviewListDate;
    private JLabel lPreviewListTotal;
    private JLabel lPreviewListTotalPrice;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Finish List Page">

    private JPanel pFinishedList;
    private JPanel pFinishedListDetails;
    private JPanel pFinishedListDisplay;
    private JPanel pFinishedListTotal;
    private JPanel pFinishedListButtons;
    private JPanel pFinishedListCreateNew;
    private JPanel pFinishedListHome;
    
    private JButton bFinishedListCreateNew;
    private JButton bFinishedListHome;
    
    private JScrollPane spFinishedListDisplay;
    private DefaultTableModel dtmFinishedListDisplay;
    private JTable tFinishedListDisplay;
    
    private JLabel lFinishedListLogo;
    private JLabel lFinishedListName;
    private JLabel lFinishedListDate;
    private JLabel lFinishedListTotal;
    private JLabel lFinishedListTotalPrice;
        
        
        // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Finished History List Page">

    private JPanel pFinishedHistoryList;
    private JPanel pFinishedHistoryListDetails;
    private JPanel pFinishedHistoryListDisplay;
    private JPanel pFinishedHistoryListTotal;
    private JPanel pFinishedHistoryListButtons;
    private JPanel pFinishedHistoryListRemove;
    private JPanel pFinishedHistoryListHome;
    
    private JButton bFinishedHistoryListRemove;
    private JButton bFinishedHistoryListGoBack;
    
    private JScrollPane spFinishedHistoryListDisplay;
    private DefaultTableModel dtmFinishedHistoryListDisplay;
    private JTable tFinishedHistoryListDisplay;
    
    private JLabel lFinishedHistoryListLogo;
    private JLabel lFinishedHistoryListName;
    private JLabel lFinishedHistoryListDate;
    private JLabel lFinishedHistoryListTotal;
    private JLabel lFinishedHistoryListTotalPrice;
        
        
        // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="History Page">

    private JPanel pHistory;
    private JPanel pHistoryLabel;
    private JPanel pHistoryDisplay;
    private JPanel pHistoryGoBack;
    
    private JButton bHistoryGoBack;
    
    private JTextField tfHistorySearch;
    private JScrollPane spHistoryDisplay;
    
    private JLabel lHistoryLabel;
    
    // </editor-fold>
    
    // </editor-fold>
    
    public AppGUI() {
        curUser = new User();
        
        // <editor-fold defaultstate="collapsed" desc="Start page">
        
        
        pLogo = new JPanel();
        pStart = new JPanel();
        pStartButtons = new JPanel();
        
        bStartLogin = makeButton("LOGIN", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        bStartRegister = makeButton("CREATE ACCOUNT", Color.WHITE, MAIN_GREEN, makeFont(OPEN_SANS, Font.BOLD, 20));
        
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
                AppGUI.this.remove(pStart);
                AppGUI.this.add(pLogin);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        
        bStartRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pStart);
                AppGUI.this.add(pRegister);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
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
        
        bRegisterCreateAccount = makeButton("CREATE ACCOUNT", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        bRegisterGoBack = makeButton("GO BACK", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        
        tfRegisterFName = makeTextField();
        tfRegisterUName = makeTextField();
        pfRegisterPassword = makePasswordField();
        pfRegisterConfirmPassword = makePasswordField();

        lRegisterTitle = makeLabel("CREATE ACCOUNT", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lRegisterFName = makeLabel("First Name", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 18));
        lRegisterUName = makeLabel("Username", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 18));
        lRegisterPassword = makeLabel("Password", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 18));
        lRegisterConfirmPassword = makeLabel("Confirm Password", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 18));
        lRegisterFNameParam = makeLabel("(max. 12 Characters)", MAIN_BLUE, makeFont(OPEN_SANS, Font.PLAIN, 10));
        lRegisterUNameParam = makeLabel("(max. 20 Characters)", MAIN_BLUE, makeFont(OPEN_SANS, Font.PLAIN, 10));
        lRegisterPasswordParam = makeLabel("(max. 20 Characters)", MAIN_BLUE, makeFont(OPEN_SANS, Font.PLAIN, 10));
        
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
                    handleError(e);
                }
                
                if (registerSuccessful) {
                    AppGUI.this.remove(pRegister);
                    AppGUI.this.add(pSuccessRegister);
                    AppGUI.this.revalidate();
                    AppGUI.this.repaint();
                }
            }
        });
        pRegisterCreateAccount.setBackground(Color.WHITE);
        pRegisterCreateAccount.add(bRegisterCreateAccount);
        
        bRegisterGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pRegister);
                AppGUI.this.add(pStart);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
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
        
        bSuccessRegisterLogin = makeButton("LOG IN", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        
        lSuccessRegisterCongrats = makeLabel("Congratulations!", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 30));
        lSuccessRegisterDesc = makeLabel("""
                                         <html><body style='text-align: center'>
                                         You have successfully registered your 
                                         <br/>
                                         account. Please log in to continue.
                                         </html>
                                         """, MAIN_BLUE, makeFont(OPEN_SANS, Font.PLAIN, 20));
        
        lSuccessRegisterCongrats.setHorizontalAlignment(SwingConstants.CENTER);
        lSuccessRegisterDesc.setHorizontalAlignment(SwingConstants.CENTER);
        pSuccessRegisterDesc.setBackground(Color.WHITE);
        pSuccessRegisterDesc.add(lSuccessRegisterDesc);
        
        bSuccessRegisterLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pSuccessRegister);
                AppGUI.this.add(pLogin);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
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
        
        bLoginLogin = makeButton("LOG IN", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        bLoginGoBack = makeButton("GO BACK", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        
        tfLoginUName = makeTextField();
        pfLoginPassword = makePasswordField();

        lLoginTitle = makeLabel("LOG IN", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 40));;
        lLoginUName = makeLabel("Username", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 18));
        lLoginPassword = makeLabel("Password", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 18));
        
        lLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
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
                    AppGUI.this.remove(pLogin);
                    AppGUI.this.add(pWelcome);
                    AppGUI.this.revalidate();
                    AppGUI.this.repaint();
                } catch (IllegalArgumentException e){
                    handleError(e);
                }
            }
        });
        pLoginLogin.setBackground(Color.WHITE);
        pLoginLogin.add(bLoginLogin);
        
        bLoginGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pLogin);
                AppGUI.this.add(pStart);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
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

        bWelcomeStart = makeButton("START", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        bWelcomeSeeHistory = makeButton("SEE HISTORY", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        
        lWelcomeUser = makeLabel("Welcome, missingName" + curUser.getFirstname(), MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 30));
        lWelcomeDesc = makeLabel("Shall we start shopping?", MAIN_BLUE, makeFont(OPEN_SANS, Font.PLAIN, 20));
        
        lWelcomeUser.setHorizontalAlignment(SwingConstants.CENTER);
        lWelcomeDesc.setHorizontalAlignment(SwingConstants.CENTER);
        
        bWelcomeStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pWelcome);
                
                if (curUser.hasUnfinishedList()) {
                    displayShoppingList(dtmPreviewListDisplay, curUser.getUnfinishedList(), lPreviewListTotalPrice); 
                
                    AppGUI.this.remove(pWelcome);
                    AppGUI.this.add(pPreviewList);
                    AppGUI.this.revalidate();
                    AppGUI.this.repaint();
                } else {
                    AppGUI.this.add(pCreateList);
                }
                
                
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
                
            }
        });
        pWelcomeStart.setBackground(Color.WHITE);
        pWelcomeStart.add(bWelcomeStart);
        
        bWelcomeSeeHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pWelcome);
                AppGUI.this.add(pHistory);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
                
                updateHistory(spHistoryDisplay, curUser.getHistory());
            }
        });
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
        
        // <editor-fold defaultstate="collapsed" desc="Create List Page">
        
        pCreateList = new JPanel();
        pCreateListName = new JPanel();
        pCreateListDate = new JPanel();
        pCreateListDateMM = new JPanel();
        pCreateListDateDD = new JPanel();
        pCreateListDateYYYY = new JPanel();
        pCreateListDateBoxes = new JPanel();
        pCreateListCreate = new JPanel();
        pCreateListGoBack = new JPanel();
        pCreateListButtons = new JPanel();

        bCreateListCreate = makeButton("CREATE", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        bCreateListGoBack = makeButton("GO BACK", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));

        tfCreateListName = makeTextField();

        cbCreateListDateMM = makeDropDown();
        cbCreateListDateDD = makeDropDown();
        cbCreateListDateYYYY = makeDropDown();

        lCreateListName = makeLabel("LIST NAME", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lCreateListNameParam = makeLabel("(Max. 20 Characters)", MAIN_BLUE, makeFont(OPEN_SANS, Font.PLAIN, 18));
        lCreateListDate = makeLabel("DATE TODAY", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lCreateListDateMM = makeLabel("M  M", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 12));
        lCreateListDateDD = makeLabel("/ D  D", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 12));
        lCreateListDateYYYY = makeLabel("/ Y  Y  Y  Y", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 12));
        
        lCreateListName.setHorizontalAlignment(SwingConstants.CENTER);
        lCreateListNameParam.setHorizontalAlignment(SwingConstants.CENTER);
        lCreateListDate.setHorizontalAlignment(SwingConstants.CENTER);
        
        pCreateListName.setLayout(new GridLayout(3, 1));
        pCreateListName.setBackground(Color.WHITE);
        pCreateListName.add(lCreateListName);
        pCreateListName.add(lCreateListNameParam);
        pCreateListName.add(tfCreateListName);
        
        
        
        LocalDate today = LocalDate.now();
        
        String[] mm = new String[12];
        String[] dd = new String[31];
        String[] yyyy = new String[(today.getYear()-1900)];
        
        for (int i = 0; i < mm.length; i++) {
            mm[i] = String.format("%02d", i+1).replace("", "  ").trim();
        }
        
        for (int i = 0; i < dd.length; i++) {
            dd[i] = String.format("%02d", i+1).replace("", "  ").trim();
        }
        
        for (int i = 0; i < yyyy.length; i++) {
            yyyy[i] = String.format("%04d", i+1901).replace("", "  ").trim();
        }
        
        cbCreateListDateMM.setModel(new DefaultComboBoxModel<>(mm));
        cbCreateListDateDD.setModel(new DefaultComboBoxModel<>(dd));
        cbCreateListDateYYYY.setModel(new DefaultComboBoxModel<>(yyyy));
        
        cbCreateListDateMM.setSelectedItem(mm[today.getMonthValue()-1]);
        cbCreateListDateDD.setSelectedItem(dd[today.getDayOfMonth()-1]);
        cbCreateListDateYYYY.setSelectedItem(yyyy[today.getYear()-1901]);
                
        pCreateListDateMM.setLayout(new GridLayout(2, 1));
        pCreateListDateDD.setLayout(new GridLayout(2, 1));
        pCreateListDateYYYY.setLayout(new GridLayout(2, 1));
        
        pCreateListDateMM.setBackground(Color.WHITE);
        pCreateListDateDD.setBackground(Color.WHITE);
        pCreateListDateYYYY.setBackground(Color.WHITE);
        
        pCreateListDateMM.add(lCreateListDateMM);
        pCreateListDateMM.add(cbCreateListDateMM);
        pCreateListDateDD.add(lCreateListDateDD);
        pCreateListDateDD.add(cbCreateListDateDD);
        pCreateListDateYYYY.add(lCreateListDateYYYY);
        pCreateListDateYYYY.add(cbCreateListDateYYYY);
        
        pCreateListDateBoxes.setLayout(new FlowLayout(FlowLayout.CENTER ,10, 0));
        pCreateListDateBoxes.setBackground(Color.WHITE);
        pCreateListDateBoxes.add(pCreateListDateMM);
        pCreateListDateBoxes.add(pCreateListDateDD);
        pCreateListDateBoxes.add(pCreateListDateYYYY);
        
        pCreateListDate.setLayout(new GridLayout(2, 1));
        pCreateListDate.setBackground(Color.WHITE);
        pCreateListDate.add(lCreateListDate);
        pCreateListDate.add(pCreateListDateBoxes);
        
        
        bCreateListCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    createList();
                    
                    lAddItemListName.setText(curUser.getUnfinishedList().getName());
                    lAddItemListDate.setText(curUser.getUnfinishedList().getDate()
                                                                        .format(DateTimeFormatter
                                                                        .ofPattern("MM/dd/uuuu")));
                    
                    AppGUI.this.remove(pCreateList);
                    AppGUI.this.add(pAddItem);
                    AppGUI.this.revalidate();
                    AppGUI.this.repaint();
                } catch (IllegalArgumentException e) {
                    handleError(e);
                }
            }
        });
        pCreateListCreate.setBackground(Color.WHITE);
        pCreateListCreate.add(bCreateListCreate);
        
        bCreateListGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pCreateList);
                AppGUI.this.add(pWelcome);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pCreateListGoBack.setBackground(Color.WHITE);
        pCreateListGoBack.add(bCreateListGoBack);

        pCreateListButtons.setLayout(new GridLayout(2, 1));
        pCreateListButtons.setBackground(Color.WHITE);
        pCreateListButtons.add(pCreateListCreate);
        pCreateListButtons.add(pCreateListGoBack);
        
        pCreateList.setLayout(new GridLayout(3, 1, 15, 35));
        pCreateList.setBorder(BorderFactory.createEmptyBorder(125, 50, 125, 50));
        pCreateList.setBackground(Color.WHITE);
        pCreateList.add(pCreateListName);
        pCreateList.add(pCreateListDate);
        pCreateList.add(pCreateListButtons);
        
        
        
        
        // </editor-fold> 
        
        // <editor-fold defaultstate="collapsed" desc="Add Item Page">
        
        pAddItem = new JPanel();
        pAddItemBottom = new JPanel();
        pAddItemListDetails = new JPanel();
        pAddItemName = new JPanel();
        pAddItemQuantity = new JPanel();
        pAddItemPrice = new JPanel();
        pAddItemButtons = new JPanel();
        pAddItemAdd = new JPanel();
        pAddItemSeeList = new JPanel();

        bAddItemAdd = makeButton("ADD", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        bAddItemSeeList = makeButton("SEE LIST", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));

        tfAddItemName = makeTextField();
        tfAddItemQuantity = makeTextField();
        tfAddItemPrice = makeTextField();

        lAddItemListName = makeLabel("NULL NAME", Color.WHITE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lAddItemListDate = makeLabel("NULL DATE", Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 12));
        lAddItemName = makeLabel("PRODUCT NAME", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lAddItemNameParam = makeLabel("( M a x .   2 0   c h a r a c t e r s )", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 12));
        lAddItemQuantity = makeLabel("QUANTITY", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lAddItemQuantityParam = makeLabel("E x .  1 0", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 12));
        lAddItemPrice = makeLabel("PRICE", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lAddItemPriceParam = makeLabel("E x .  1 2 3 4 . 5 6", MAIN_BLUE, makeFont(OPEN_SANS, Font.BOLD, 12));
        
        lAddItemListName.setHorizontalAlignment(SwingConstants.CENTER);
        lAddItemListDate.setHorizontalAlignment(SwingConstants.CENTER);
        lAddItemName.setHorizontalAlignment(SwingConstants.CENTER);
        lAddItemNameParam.setHorizontalAlignment(SwingConstants.CENTER);
        lAddItemQuantity.setHorizontalAlignment(SwingConstants.CENTER);
        lAddItemQuantityParam.setHorizontalAlignment(SwingConstants.CENTER);
        lAddItemPrice.setHorizontalAlignment(SwingConstants.CENTER);
        lAddItemPriceParam.setHorizontalAlignment(SwingConstants.CENTER);
        
        pAddItemListDetails.setLayout(new GridLayout(2, 1));
        pAddItemListDetails.setBorder(BorderFactory.createEmptyBorder(35, 50, 0, 50));
        pAddItemListDetails.setPreferredSize(new Dimension(350, 110));
        pAddItemListDetails.setBackground(MAIN_GREEN);
        pAddItemListDetails.add(lAddItemListName);
        pAddItemListDetails.add(lAddItemListDate);
        
        pAddItemName.setLayout(new GridLayout(3, 1));
        pAddItemName.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        pAddItemName.setBackground(Color.WHITE);
        pAddItemName.add(lAddItemName);
        pAddItemName.add(lAddItemNameParam);
        pAddItemName.add(tfAddItemName);
        
        pAddItemQuantity.setLayout(new GridLayout(3, 1));
        pAddItemQuantity.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        pAddItemQuantity.setBackground(Color.WHITE);
        pAddItemQuantity.add(lAddItemQuantity);
        pAddItemQuantity.add(lAddItemQuantityParam);
        pAddItemQuantity.add(tfAddItemQuantity);
        
        pAddItemPrice.setLayout(new GridLayout(3, 1));
        pAddItemPrice.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        pAddItemPrice.setBackground(Color.WHITE);
        pAddItemPrice.add(lAddItemPrice);
        pAddItemPrice.add(lAddItemPriceParam);
        pAddItemPrice.add(tfAddItemPrice);
        
        bAddItemAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    addItemToUnfinishedList();
                    
                    displayShoppingList(dtmPreviewListDisplay, curUser.getUnfinishedList(), lPreviewListTotalPrice);

                    AppGUI.this.remove(pAddItem);
                    AppGUI.this.add(pPreviewList);
                    AppGUI.this.revalidate();
                    AppGUI.this.repaint();
                } catch (IllegalArgumentException e) {
                    handleError(e);
                }
            }
        });
        pAddItemAdd.setBackground(Color.WHITE);
        pAddItemAdd.add(bAddItemAdd);
        
        
        bAddItemSeeList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displayShoppingList(dtmPreviewListDisplay, curUser.getUnfinishedList(), lPreviewListTotalPrice); 
                
                AppGUI.this.remove(pAddItem);
                AppGUI.this.add(pPreviewList);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pAddItemSeeList.setBackground(Color.WHITE);
        pAddItemSeeList.add(bAddItemSeeList);
        
        pAddItemButtons.setLayout(new GridLayout(2, 1, 15, 15));
        pAddItemButtons.setBackground(Color.WHITE);
        pAddItemButtons.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        pAddItemButtons.add(bAddItemAdd);
        pAddItemButtons.add(bAddItemSeeList);
        
        pAddItemBottom.setLayout(new GridLayout(4, 1, 20, 20));
        pAddItemBottom.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0));
        pAddItemBottom.setBackground(Color.WHITE);
        pAddItemBottom.add(pAddItemName);
        pAddItemBottom.add(pAddItemQuantity);
        pAddItemBottom.add(pAddItemPrice);
        pAddItemBottom.add(pAddItemButtons);
        
        pAddItem.setLayout(new BoxLayout(pAddItem, BoxLayout.Y_AXIS));
        pAddItem.setBackground(Color.WHITE);
        pAddItem.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        pAddItem.add(pAddItemListDetails);
        pAddItem.add(pAddItemBottom);
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Preview List Page">
        pPreviewList = new JPanel();
        pPreviewListBottom = new JPanel();
        pPreviewListDetails = new JPanel();
        pPreviewListDisplay = new JPanel();
        pPreviewListTotal = new JPanel();
        pPreviewListButtons = new JPanel();
        pPreviewListFinish = new JPanel();
        pPreviewListAddMore = new JPanel();
        pPreviewListTotalButtons = new JPanel();

        bPreviewListFinish = makeButton("FINISH", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        bPreviewListAddMore = makeButton("ADD MORE", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        
        String[] header = {"PRODUCT", "X" , "Q", "PRICE"};
        dtmPreviewListDisplay = new DefaultTableModel(header, 0);
        tPreviewListDisplay = makeTable(dtmPreviewListDisplay);
        spPreviewListDisplay = new JScrollPane(tPreviewListDisplay);
        spPreviewListDisplay.setBackground(Color.WHITE);

        lPreviewListName = makeLabel("NULL NAME", Color.WHITE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lPreviewListDate = makeLabel("NULL DATE ", Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 12));
        lPreviewListTotal = makeLabel("TOTAL PRICE:", MAIN_BLACK, makeFont(LEAGUE_SPARTAN, Font.BOLD, 18));
        lPreviewListTotalPrice = makeLabel("PHP NULL", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 40));
        
        lPreviewListName.setHorizontalAlignment(SwingConstants.CENTER);
        lPreviewListDate.setHorizontalAlignment(SwingConstants.CENTER);
        lPreviewListTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lPreviewListTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
        
        pPreviewListDetails.setLayout(new GridLayout(2, 1));
        pPreviewListDetails.setBorder(BorderFactory.createEmptyBorder(35, 50, 0, 50));
        pPreviewListDetails.setPreferredSize(new Dimension(350, 110));
        pPreviewListDetails.setBackground(MAIN_GREEN);
        pPreviewListDetails.add(lPreviewListName);
        pPreviewListDetails.add(lPreviewListDate);
        
        pPreviewListDisplay.setLayout(new GridLayout(1, 1));
        pPreviewListDisplay.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 50));
        pPreviewListDisplay.setBackground(Color.WHITE);
        pPreviewListDisplay.add(spPreviewListDisplay);
        
        pPreviewListTotal.setLayout(new GridLayout(2, 1, 15, 15));
        pPreviewListTotal.setBackground(Color.WHITE);
        pPreviewListTotal.add(lPreviewListTotal);
        pPreviewListTotal.add(lPreviewListTotalPrice);
        
        bPreviewListFinish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                double total = Double.parseDouble(lPreviewListTotalPrice.getText().substring(4));
                String finishedListName = curUser.getUnfinishedList().toString()+ "-" + curUser.getUnfinishedList().getTotal() + ".csv";
                finishList(total);
                curUser.refreshUser();
               
                displayFinishedList(dtmFinishedListDisplay, finishedListName, lFinishedListTotalPrice);
                
                AppGUI.this.remove(pPreviewList);
                AppGUI.this.add(pFinishedList);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pPreviewListFinish.setBackground(Color.WHITE);
        pPreviewListFinish.add(bPreviewListFinish);
        
        bPreviewListAddMore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                lAddItemListName.setText(curUser.getUnfinishedList().getName());
                lAddItemListDate.setText(curUser.getUnfinishedList().getDate()
                                                                    .format(DateTimeFormatter
                                                                    .ofPattern("MM/dd/uuuu")));
                
                AppGUI.this.remove(pPreviewList);
                AppGUI.this.add(pAddItem);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pPreviewListAddMore.setBackground(Color.WHITE);
        pPreviewListAddMore.add(bPreviewListAddMore);
        
        pPreviewListButtons.setLayout(new GridLayout(2, 1, 15, 15));
        pPreviewListButtons.setBackground(Color.WHITE);
        pPreviewListButtons.add(pPreviewListFinish);
        pPreviewListButtons.add(pPreviewListAddMore);

        pPreviewListTotalButtons.setLayout(new GridLayout(2, 1, 15, 15));
        pPreviewListTotalButtons.setBackground(Color.WHITE);
        pPreviewListTotalButtons.add(pPreviewListTotal);
        pPreviewListTotalButtons.add(pPreviewListButtons);
        
        pPreviewListBottom.setLayout(new GridLayout(2,1,15,15));
        pPreviewListBottom.setBackground(Color.WHITE);
        pPreviewListBottom.add(pPreviewListDisplay);
        pPreviewListBottom.add(pPreviewListTotalButtons);
        
        
        pPreviewList.setLayout(new BoxLayout(pPreviewList, BoxLayout.Y_AXIS));
        pPreviewList.setBackground(Color.WHITE);
        pPreviewList.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        pPreviewList.add(pPreviewListDetails);
        pPreviewList.add(pPreviewListBottom);
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Finish List Page">
        
        pFinishedList = new JPanel();
        pFinishedListDetails = new JPanel();
        pFinishedListDisplay = new JPanel();
        pFinishedListTotal = new JPanel();
        pFinishedListButtons = new JPanel();
        pFinishedListCreateNew = new JPanel();
        pFinishedListHome = new JPanel();

        bFinishedListCreateNew = makeButton("CREATE NEW", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        bFinishedListHome = makeButton("HOME", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        
        dtmFinishedListDisplay = new DefaultTableModel(header, 0);
        tFinishedListDisplay = makeTable(dtmFinishedListDisplay);
        spFinishedListDisplay = new JScrollPane(tFinishedListDisplay);
        spFinishedListDisplay.setBackground(Color.WHITE);
        
        lFinishedListLogo = new JLabel();
        lFinishedListName = makeLabel("NULL NAME", MAIN_GREEN, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lFinishedListDate = makeLabel("NULL DATE ", MAIN_BLACK, makeFont(OPEN_SANS, Font.BOLD, 12));
        lFinishedListTotal = makeLabel("TOTAL PRICE:", MAIN_BLACK, makeFont(LEAGUE_SPARTAN, Font.BOLD, 18));
        lFinishedListTotalPrice = makeLabel("PHP NULL", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 40));
        
        lFinishedListLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lFinishedListName.setAlignmentX(Component.CENTER_ALIGNMENT);
        lFinishedListDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        lFinishedListTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        lFinishedListTotalPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lFinishedListLogo.setIcon(new ImageIcon(image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        
        pFinishedListDetails.setLayout(new BoxLayout(pFinishedListDetails, BoxLayout.Y_AXIS));
        pFinishedListDetails.setBackground(Color.WHITE);
        pFinishedListDetails.setBorder(BorderFactory.createEmptyBorder(50, 50, 0 ,50));
        pFinishedListDetails.add(lFinishedListLogo);
        pFinishedListDetails.add(lFinishedListName);
        pFinishedListDetails.add(lFinishedListDate);
        
        pFinishedListDisplay.setLayout(new GridLayout(1, 1));
        pFinishedListDisplay.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 50));
        pFinishedListDisplay.setBackground(Color.WHITE);
        pFinishedListDisplay.add(spFinishedListDisplay);
        
        pFinishedListTotal.setLayout(new BoxLayout(pFinishedListTotal, BoxLayout.Y_AXIS));
        pFinishedListTotal.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 50));
        pFinishedListTotal.setBackground(Color.WHITE);
        pFinishedListTotal.add(lFinishedListTotal);
        pFinishedListTotal.add(lFinishedListTotalPrice);
        
        bFinishedListCreateNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pFinishedList);
                AppGUI.this.add(pCreateList);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pFinishedListCreateNew.setBackground(Color.WHITE);
        pFinishedListCreateNew.add(bFinishedListCreateNew);
        
        bFinishedListHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pFinishedList);
                AppGUI.this.add(pWelcome);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pFinishedListHome.setBackground(Color.WHITE);
        pFinishedListHome.add(bFinishedListHome);
        
        pFinishedListButtons.setLayout(new GridLayout(2, 1, 15, 15 ));
        pFinishedListButtons.setBackground(Color.WHITE);
        pFinishedListButtons.setBorder(BorderFactory.createEmptyBorder(35, 50, 50, 50));
        pFinishedListButtons.add(bFinishedListCreateNew);
        pFinishedListButtons.add(bFinishedListHome);
        
        pFinishedList.setLayout(new BoxLayout(pFinishedList, BoxLayout.Y_AXIS));
        pFinishedList.setBackground(Color.WHITE);
        pFinishedList.add(pFinishedListDetails);
        pFinishedList.add(pFinishedListDisplay);
        pFinishedList.add(pFinishedListTotal);
        pFinishedList.add(pFinishedListButtons);
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Finished History List Page">
        
        pFinishedHistoryList = new JPanel();
        pFinishedHistoryListDetails = new JPanel();
        pFinishedHistoryListDisplay = new JPanel();
        pFinishedHistoryListTotal = new JPanel();
        pFinishedHistoryListButtons = new JPanel();
        pFinishedHistoryListRemove = new JPanel();
        pFinishedHistoryListHome = new JPanel();

        bFinishedHistoryListRemove = makeButton("REMOVE LIST", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        bFinishedHistoryListGoBack = makeButton("GO BACK", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        
        dtmFinishedHistoryListDisplay = new DefaultTableModel(header, 0);
        tFinishedHistoryListDisplay = makeTable(dtmFinishedHistoryListDisplay);
        spFinishedHistoryListDisplay = new JScrollPane(tFinishedHistoryListDisplay);
        spFinishedHistoryListDisplay.setBackground(Color.WHITE);
        
        lFinishedHistoryListLogo = new JLabel();
        lFinishedHistoryListName = makeLabel("NULL NAME", MAIN_GREEN, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));
        lFinishedHistoryListDate = makeLabel("NULL DATE ", MAIN_BLACK, makeFont(OPEN_SANS, Font.BOLD, 12));
        lFinishedHistoryListTotal = makeLabel("TOTAL PRICE:", MAIN_BLACK, makeFont(LEAGUE_SPARTAN, Font.BOLD, 18));
        lFinishedHistoryListTotalPrice = makeLabel("PHP NULL", MAIN_BLUE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 40));
        
        lFinishedHistoryListLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lFinishedHistoryListName.setAlignmentX(Component.CENTER_ALIGNMENT);
        lFinishedHistoryListDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        lFinishedHistoryListTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        lFinishedHistoryListTotalPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lFinishedHistoryListLogo.setIcon(new ImageIcon(image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        
        pFinishedHistoryListDetails.setLayout(new BoxLayout(pFinishedHistoryListDetails, BoxLayout.Y_AXIS));
        pFinishedHistoryListDetails.setBackground(Color.WHITE);
        pFinishedHistoryListDetails.setBorder(BorderFactory.createEmptyBorder(50, 50, 0 ,50));
        pFinishedHistoryListDetails.add(lFinishedHistoryListLogo);
        pFinishedHistoryListDetails.add(lFinishedHistoryListName);
        pFinishedHistoryListDetails.add(lFinishedHistoryListDate);
        
        pFinishedHistoryListDisplay.setLayout(new GridLayout(1, 1));
        pFinishedHistoryListDisplay.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 50));
        pFinishedHistoryListDisplay.setBackground(Color.WHITE);
        pFinishedHistoryListDisplay.add(spFinishedHistoryListDisplay);
        
        pFinishedHistoryListTotal.setLayout(new BoxLayout(pFinishedHistoryListTotal, BoxLayout.Y_AXIS));
        pFinishedHistoryListTotal.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 50));
        pFinishedHistoryListTotal.setBackground(Color.WHITE);
        pFinishedHistoryListTotal.add(lFinishedHistoryListTotal);
        pFinishedHistoryListTotal.add(lFinishedHistoryListTotalPrice);
        
        bFinishedHistoryListRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(!removeList()) {
                    return;
                }
                
                updateHistory(spHistoryDisplay, curUser.getHistory());
                AppGUI.this.remove(pFinishedHistoryList);
                AppGUI.this.add(pHistory);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pFinishedHistoryListRemove.setBackground(Color.WHITE);
        pFinishedHistoryListRemove.add(bFinishedHistoryListRemove);
        
        bFinishedHistoryListGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateHistory(spHistoryDisplay, curUser.getHistory());
                
                AppGUI.this.remove(pFinishedHistoryList);
                AppGUI.this.add(pHistory);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pFinishedHistoryListHome.setBackground(Color.WHITE);
        pFinishedHistoryListHome.add(bFinishedHistoryListGoBack);
        
        pFinishedHistoryListButtons.setLayout(new GridLayout(2, 1, 15, 15 ));
        pFinishedHistoryListButtons.setBackground(Color.WHITE);
        pFinishedHistoryListButtons.setBorder(BorderFactory.createEmptyBorder(35, 50, 50, 50));
        pFinishedHistoryListButtons.add(bFinishedHistoryListRemove);
        pFinishedHistoryListButtons.add(bFinishedHistoryListGoBack);
        
        pFinishedHistoryList.setLayout(new BoxLayout(pFinishedHistoryList, BoxLayout.Y_AXIS));
        pFinishedHistoryList.setBackground(Color.WHITE);
        pFinishedHistoryList.add(pFinishedHistoryListDetails);
        pFinishedHistoryList.add(pFinishedHistoryListDisplay);
        pFinishedHistoryList.add(pFinishedHistoryListTotal);
        pFinishedHistoryList.add(pFinishedHistoryListButtons);
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="History Page">
        pHistory = new JPanel();
        pHistoryLabel = new JPanel();
        pHistoryDisplay = new JPanel();
        pHistoryGoBack = new JPanel();

        bHistoryGoBack = makeButton("GO BACK", MAIN_GREEN, Color.WHITE, makeFont(OPEN_SANS, Font.BOLD, 20));
        
        tfHistorySearch = makeTextField();
        spHistoryDisplay = new JScrollPane(new JPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        lHistoryLabel = makeLabel("PAST GROCERIES", Color.WHITE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 30));;
        
        lHistoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        pHistoryLabel.setLayout(new GridLayout(1, 1));
        pHistoryLabel.setBackground(Color.WHITE);
        pHistoryLabel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        pHistoryLabel.setPreferredSize(new Dimension(350, 110));
        pHistoryLabel.setBackground(MAIN_GREEN);
        pHistoryLabel.add(lHistoryLabel);
        
        spHistoryDisplay.setPreferredSize(new Dimension(350, 450));
        spHistoryDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
       
        tfHistorySearch.addKeyListener(new KeyListener() {
            
            public void keyPressed(KeyEvent e) {
                
            }
            public void keyReleased(KeyEvent e) {
                updateHistory(spHistoryDisplay, curUser.getHistory());
            }
            public void keyTyped(KeyEvent e) {
                
            }
        });
        tfHistorySearch.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0), tfHistorySearch.getBorder()));
        
        pHistoryDisplay.setLayout(new BoxLayout(pHistoryDisplay, BoxLayout.Y_AXIS));
        pHistoryDisplay.setBackground(Color.WHITE);
        pHistoryDisplay.setBorder(BorderFactory.createEmptyBorder(35, 50, 0, 50));
        pHistoryDisplay.add(tfHistorySearch);
        pHistoryDisplay.add(spHistoryDisplay);
        
        bHistoryGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AppGUI.this.remove(pHistory);
                AppGUI.this.add(pWelcome);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pHistoryGoBack.setBorder(BorderFactory.createEmptyBorder(35, 0, 50, 0));
        pHistoryGoBack.setBackground(Color.WHITE);
        pHistoryGoBack.add(bHistoryGoBack);
        
        pHistory.setLayout(new BoxLayout(pHistory, BoxLayout.Y_AXIS));
        pHistory.add(pHistoryLabel);
        pHistory.add(pHistoryDisplay);
        pHistory.add(pHistoryGoBack);
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
    
    JPanel testpanel;
    
    public void run() {
        setVisible(true);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Helper Functions">
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
            throw new IllegalArgumentException("Empty Fields");
        }
        
    }
    
    private void registerUser() throws IllegalArgumentException {
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
            File userHistoryDr = new File(userDataDr + "\\history");
            userHistoryDr.mkdir();
            
            credentialsMap.put(username, password);
            FileWriter fw = new FileWriter(logCred, true);
            fw.write(username + "," + password + "," + firstname + "\n");
            
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private void createList() throws IllegalArgumentException {
        String name = tfCreateListName.getText();
        String yyyy = ((String) cbCreateListDateYYYY.getSelectedItem()).replaceAll(" ", "");
        String mm = ((String) cbCreateListDateMM.getSelectedItem()).replaceAll(" ", "");
        String dd = ((String) cbCreateListDateDD.getSelectedItem()).replaceAll(" ", "");
        LocalDate date;
        
        // <editor-fold defaultstate="collapsed" desc="Info Checking">
        // Name Validation
        if (name.length() > 20) {
            throw new IllegalArgumentException("List Name exceeds character limit");
        } else if (name.replaceAll(" ", "").length() == 0) {
            throw new IllegalArgumentException("List Name Field is empty");
        }
        
        // Date Validation
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMdduuuu")
                                                .withResolverStyle(ResolverStyle.STRICT);
        try {
            date = LocalDate.parse(mm+dd+yyyy, df);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid Date");
        }
        
        date = LocalDate.parse(mm+dd+yyyy, df);
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date is in the Future");
        }
        // </editor-fold>
        
        ShoppingList list = new ShoppingList(name, date, new ArrayList<Item>());
        
        File csvFile = new File("csv\\" + curUser.getUsername() + "\\" + list.toString() + ".csv");
        try {
            csvFile.createNewFile();
            FileWriter fw = new FileWriter(csvFile);
            
            for (Item i : list.getList()) {
                fw.write(i.getName() + "," +
                         i.getQuantity() + "," +
                         i.getPrice() + "\n");
            }
            
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        curUser.refreshUser();
    }
    
    private void addItemToUnfinishedList() throws IllegalArgumentException {
        String name = tfAddItemName.getText();
        int quantity = 0;
        double price = 0;
        
        String quantityStr = tfAddItemQuantity.getText();
        String priceStr = tfAddItemPrice.getText();
        
        // <editor-fold defaultstate="collapsed" desc="Info Checking">
        
        // Name Validation
        if (name.length() == 0) {
            throw new IllegalArgumentException("Item Name field is empty");
        }
        
        if (name.length() > 20) {
            throw new IllegalArgumentException("Item Name exceeds character limit");
        }
        
        // Quantity Validation
        if (quantityStr.length() == 0) {
            throw new IllegalArgumentException("Item Quantity field is empty");
        }
        
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Quantity");
        }
        
        // Price Validation
        if (priceStr.length() == 0) {
            throw new IllegalArgumentException("Item Price field is empty");
        }
        
        try {
            price = Double.parseDouble(priceStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Price");
        }
        
        // </editor-fold>
        
        // Clear fields after removing;
        tfAddItemName.setText("");
        tfAddItemQuantity.setText("");
        tfAddItemPrice.setText("");
        
        curUser.addItemToUnfinishedList(new Item(name, quantity, price));
    }
    
    private void handleError(IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "An IllegalArgumentExceptionCaught: " + e.getMessage() + ". Please Try again.", 
                                              "Error Screen", JOptionPane.ERROR_MESSAGE);
    }
    
    private void displayShoppingList(DefaultTableModel model, ShoppingList list, JLabel price) {
        for (int i = model.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }
        
        
        for (Item item : list.getList()) {
            Object[] row = item.toString().split("-");
            row[0] = ((String)row[0]);
            
            model.addRow(row);
        }
        
        lPreviewListName.setText(curUser.getUnfinishedList().getName());
        lPreviewListDate.setText(curUser.getUnfinishedList().getDate()
                                                            .format(DateTimeFormatter
                                                            .ofPattern("MM/dd/uuuu")));
        
        price.setText(String.format("PHP %1.2f", list.getTotal()));
        
    }
    
    private void finishList(double total) {
        String userDataDr = System.getProperty("user.dir") + "\\csv\\" + curUser.getUsername();
        File[] files = (new File(userDataDr)).listFiles(File::isFile);  
        
        for (File file : files) {
            String name = file.getName();
            
            if (name.substring(name.length()-4).equals(".csv")) {
                File finished = new File(userDataDr + "\\history\\" + 
                                                    name.substring(0, name.length()-4) + 
                                                    "-" + String.format("%.2f", total) + ".csv");
                
                try {          
                    file.renameTo(finished);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            }
        }
        
        
    }
    
    private void displayFinishedList(DefaultTableModel model, String fileName, JLabel price) {
        ShoppingList list = new ShoppingList();
        
        for (int i = model.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }
        
        for (ShoppingList sp : curUser.getHistory()) {
            if ((sp.toString() + "-" + sp.getTotal() + ".csv").equals(fileName)) {
                list = sp;
            }
        }
        
        for (Item item : list.getList()) {
            Object[] row = item.toString().split("-");
            
            model.addRow(row);
        }
        
        price.setText(String.format("PHP %1.2f", list.getTotal()));
        lFinishedListName.setText(list.getName());
        lFinishedListDate.setText(list.getDate()
                         .format(DateTimeFormatter
                         .ofPattern("MM/dd/uuuu")));
        
        lFinishedHistoryListName.setText(list.getName());
        lFinishedHistoryListDate.setText(list.getDate()
                         .format(DateTimeFormatter
                         .ofPattern("MM/dd/uuuu")));
        
    }
    
    private boolean removeList() {
        // Get the list
        String name = lFinishedHistoryListName.getText();
        String[] dateStr = lFinishedHistoryListDate.getText().split("/");

        String date = dateStr[2] + dateStr[0] + dateStr[1];
        String total = lFinishedHistoryListTotalPrice.getText().substring(4);
        String fileName = name + "-" + date + "-" + total + ".csv";

        // Prompt
        int sure = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this List?", "Remove " + name, JOptionPane.YES_NO_OPTION);
        if (sure == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Removed " + name);
        } else {
            return false;
        }
        
                
        // Remove the file
        String userHistoryDr = System.getProperty("user.dir") + "\\csv\\" + curUser.getUsername() + "\\history";
        File[] files = (new File(userHistoryDr)).listFiles(File::isFile);  
        
        for (File file : files) {
            String n = file.getName();
            
            if(n.equals(fileName)) {
                file.delete();
            }
        }
        // Remove the list in current Session
        ArrayList<ShoppingList> history = curUser.getHistory();
        ShoppingList toRemove = new ShoppingList();
        for (ShoppingList sp : history) {
            if (sp.toString().equals(name + "-" + date)) {
                toRemove = sp;
                break;
            }
        }
        
        curUser.removeList(toRemove);
        
        return true;
    }
    
    private JPanel makeHistoryPanel(ShoppingList list) {
        String name = list.getName();
        String date = list.getDate().format(DateTimeFormatter.ofPattern("MM/dd/uuuu"));
        String totalPrice = String.format("PHP %.2f", list.getTotal());
        
        JPanel pPanel = new JPanel();
        JPanel pTitle = new JPanel();
        JButton bTitle = makeButton(name, MAIN_GREEN, Color.WHITE, makeFont(LEAGUE_SPARTAN, Font.BOLD, 20));
        JLabel lDate = makeLabel(date, MAIN_BLACK, makeFont(OPEN_SANS, Font.BOLD, 18));
        JLabel lTotal = makeLabel(totalPrice,MAIN_BLACK, makeFont(OPEN_SANS, Font.BOLD, 18));
        
        bTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        lTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        bTitle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displayFinishedList(dtmFinishedHistoryListDisplay, list.toString() + "-" + list.getTotal() + ".csv", lFinishedHistoryListTotalPrice);
                
                AppGUI.this.remove(pHistory);
                AppGUI.this.add(pFinishedHistoryList);
                AppGUI.this.revalidate();
                AppGUI.this.repaint();
            }
        });
        pTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pTitle.setBackground(MAIN_GREEN);
        bTitle.setPreferredSize(new Dimension(300, 50));
        bTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pTitle.setPreferredSize(new Dimension(300, 50));
        pTitle.add(bTitle);
        
        pPanel.setLayout(new BoxLayout(pPanel, BoxLayout.Y_AXIS));
        pPanel.setMaximumSize(new Dimension(300, 125));
        pPanel.setBackground(Color.WHITE);
        pPanel.setBorder(BorderFactory.createLineBorder(MAIN_BLACK, 2));
        pPanel.add(pTitle);
        pPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        pPanel.add(lDate);
        pPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        pPanel.add(lTotal);
        
        
        return pPanel;
    }
    
    private void updateHistory(JScrollPane sp, ArrayList<ShoppingList> list) {
        String searched = tfHistorySearch.getText();
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.setBackground(Color.WHITE);
        
        for (ShoppingList l : list) {
            String s = l.getName();
            if (s.substring(0, searched.length()).toUpperCase().equals(searched.toUpperCase())) {
                newPanel.add(makeHistoryPanel(l));
                newPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
        newPanel.setPreferredSize(new Dimension(300, newPanel.getPreferredSize().height));
        newPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        JViewport viewport = new JViewport();
        viewport.add(newPanel);
        sp.setViewport(viewport);
        sp.revalidate();
        sp.repaint();
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
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="GUI Builder Functions"> 
    private static Font makeFont(File fontFile, int style,int size) {
        Font font;
        if (style == Font.BOLD) {
            fontFile = new File("fonts\\" + fontFile.getName().substring(0, fontFile.getName().length()-4) + "-Bold.ttf");
        }
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(style, size);
            
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
            
            return font;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private static JButton makeButton(String text, Color bg, Color fg, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(fg);
        button.setBackground(bg);
        Border line = new LineBorder(fg);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        
        button.setPreferredSize(new Dimension(250, 50));
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
        tf.setFont(makeFont(OPEN_SANS, Font.PLAIN, 14));
        
        return tf;
    }
    
    private static JPasswordField makePasswordField() {
        JPasswordField pf = new JPasswordField();
        
        Border line = new LineBorder(MAIN_BLACK, 3);
        Border empty = new EmptyBorder(0, 5, 0, 0);
        pf.setBorder(new CompoundBorder(line, empty));
        pf.setMargin(new Insets(0, 5, 0, 10));
        
        pf.setFont(makeFont(OPEN_SANS, Font.PLAIN, 14));
        
        return pf;
    }
    
    private static JComboBox makeDropDown() {
        JComboBox cb = new JComboBox();
        
        cb.setBackground(Color.WHITE);
        cb.setFocusable(false);
        cb.setFont(makeFont(OPEN_SANS, Font.PLAIN, 12));
        
        return cb;
    }
    
    private static JTable makeTable(DefaultTableModel model) {
        
        JTable table = new JTable(model) {
            @Override
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(String.class, centerRenderer);
        
        table.setFont(makeFont(OPEN_SANS, Font.BOLD, 10));
        table.setForeground(MAIN_BLACK);
        
        table.getTableHeader().setFont(makeFont(LEAGUE_SPARTAN, Font.BOLD, 14));
        table.getTableHeader().setForeground(MAIN_BLUE);
        
        table.setBackground(Color.WHITE);
        table.setShowGrid(false);
        
        TableColumnModel cm = table.getColumnModel();
        cm.getColumn(0).setPreferredWidth(150);
        cm.getColumn(1).setPreferredWidth(50);
        cm.getColumn(2).setPreferredWidth(125);
        cm.getColumn(3).setPreferredWidth(125);

        
        return table;    
    }
    
    
    // </editor-fold>
  
    
}
