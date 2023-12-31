package client;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import App.financialApproval.*;
import App.inventoryControl.*;
import App.loyaltyCard.*;
import App.priceControl.*;
import App.reportAnalysis.*;

import java.util.List;


public class Functionalities extends JFrame{

    // Instantiate the DAO implementation
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private ItemsDAOImpl itemsDAO = new ItemsDAOImpl();
    private SalesDAOImpl salesDAO = new SalesDAOImpl();
    private ProductSalesDAOImpl productSalesDAO = new ProductSalesDAOImpl();
    private Stock_LevelsDAOImpl stockSalesDAO = new Stock_LevelsDAOImpl();
    private CustomerInfoDAOImpl customerInfoDAO = new CustomerInfoDAOImpl();
    private FinancialApprovalDAOImpl financialApprovalDAO = new FinancialApprovalDAOImpl();
    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    private LoyaltyCardDAOImpl loyaltyCardDAO = new LoyaltyCardDAOImpl();
    private CustomerInfoReportDAOImpl customerInfoReportDAO = new CustomerInfoReportDAOImpl();
    private CustomerPurchaseReportDAOImpl customerPurchaseReportDAO = new CustomerPurchaseReportDAOImpl();

    

    final private Font maiFont = new Font("Segoe UI Black", Font.BOLD, 18); // Global variable -> Create a font for the main panel
    JLabel lbWelcome; // Global variable -> Create a label for the main panel
    JPanel cardPanel; // Global variable -> Create a card panel

    private boolean changeButtonAdded = false; // Create a boolean to check if the change button is added or not, and if so, do not add another button

    // Create the constructor of the class
    public Functionalities() {
        initFunctions(); // Call the method that will create the form panel

        setTitle("DE-Store: Functionalities"); // Set the title of the frame  
        setSize(500, 600); // Set the size of the frame
        setMinimumSize(new Dimension(300, 400)); // Set the minimum size of the frame
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Set the default close operation
        setVisible(true); // Set the visibility of the frame
    }

    public void initFunctions(){

        cardPanel = new JPanel();
        cardPanel.setLayout(new CardLayout()); // Set the layout manager of the card panel

        add(cardPanel); // Add the card panel to the frame

        // Create a welcome label
        lbWelcome = new JLabel();
        lbWelcome.setFont(maiFont); // Set the font of the label
        lbWelcome.setText("Welcome Back!");
        lbWelcome.setHorizontalAlignment(SwingConstants.CENTER); // Set the alignment of the label

        // Create a welcome panel
        JPanel welcomePanel = new JPanel(new BorderLayout()); // Set the layout manager of the welcome panel
        welcomePanel.setBackground(new Color(220, 220, 220)); // set the main colour of the panel
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // set margin of the panel
        welcomePanel.add(lbWelcome, BorderLayout.NORTH); // add the welcome label to the welcome panel
        
        cardPanel.add(welcomePanel, "welcomePanel"); // add the welcome panel to the card panel



        /* Some parts of code are from ChatGPT */
        // Create a panel for buttons arranged in two columns
        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 0 rows, 2 columns

        // Create button names
        String[] buttonNames = {
            "Price Control",
            "Inventory Control",
            "Loyalty Card",
            "Approval of Financial Support",
            "Performance Analysis"
        };

        // Create buttons and add action listeners
        for (int i = 0; i < buttonNames.length; i++) {
            final int index = i;
            JButton button = new JButton(buttonNames[i]);
            button.setFont(maiFont);
            button.setForeground(Color.WHITE);
            button.setBackground(getButtonColor(i)); // Get different colors for buttons
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Use switch case so when button is clicked,
                    // display results in the console

                    String buttonClicked = buttonNames[index];

                    switch(buttonClicked){
                        /*PRICE CONTROL*/
                        case "Price Control":
                            System.out.println("\n===========================\nPRICE CONTROL:\n===========================");
                            List<Product> products = productDAO.getProducts();
                            List<Sales> sales = salesDAO.getSales();
                            List<ProductSales> productSales = productSalesDAO.getProductSales();
                            
                            for (Product product : products) {
                                System.out.println(
                                    "Product ID: "+ product.getProductId() + 
                                    " , Name: " + product.getProductName() +
                                    " , Price: $" + product.getPrice()    
                                    );
                            }

                            System.out.println("\n-----------------------------------");

                            for (Sales sale : sales) {
                                System.out.println(
                                    "Sales ID: "+ sale.getSalesOfferId() + 
                                    " , Name: " + sale.getNameOfSalesOffer() +
                                    " , Description: " + sale.getDescriptionOfSalesOffer()    
                                    );
                            }

                            System.out.println("\n-----------------------------------");

                            for (ProductSales productSale : productSales) {
                                System.out.println(
                                    "Product ID: "+ productSale.getProductId() + 
                                    " , Sales Offer ID: " + productSale.getSalesOfferId()    
                                    );
                            }

                            // create a new button that when clicked, will display a prompt to a user
                            // to ask "What changes do you want?" then the user will insert new data into the
                            // Product table.
                            JButton btnChange = new JButton("Change");
                            btnChange.setFont(maiFont);
                            btnChange.setPreferredSize(new Dimension(100, 200));
                            
                            btnChange.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String promptInputFromUser = JOptionPane.showInputDialog("What changes do you want?");

                                    // check if the user typed "update" and proceed accordingly
                                    if(promptInputFromUser != null && promptInputFromUser.equalsIgnoreCase("update")){
                                        String productId = JOptionPane.showInputDialog("Enter Product ID: ");
                                        String productName = JOptionPane.showInputDialog("Enter Product Name: ");
                                        String productPrice = JOptionPane.showInputDialog("Enter Product Price: ");

                                        // update the product table
                                        productDAO.updateProduct(productId, productName, productPrice);
                                    }
                                } 
                            });
                            buttonPanel.add(btnChange);
                            buttonPanel.revalidate();
                            buttonPanel.repaint();
                            changeButtonAdded = true;
                        break;


                        /*INVENTORY CONTROL*/
                        case "Inventory Control":
                            System.out.println("\n===========================\nINVENTORY CONTROL:\n===========================");
                            List<Items> items = itemsDAO.getItems();
                            List<Stock_Levels> stocks = stockSalesDAO.getStocks();

                            for (Items item : items) {
                                System.out.println(
                                    "Item ID: "+ item.getItemID() + 
                                    " , Name: " + item.getItemName() +
                                    " , Category: " + item.getItemCategory() +
                                    " , Price: $" + item.getItemPrice() +  
                                    " , Description: " + item.getItemDescription() +
                                    " , Supplier: " + item.getSupplierOfItem()
                                    );
                            }

                            System.out.println("\n-----------------------------------");

                            for (Stock_Levels stock : stocks) {
                                System.out.println(
                                    "Item ID: "+ stock.getItemId() + 
                                    " , Quantity: " + stock.getQuantity()    
                                    );
                            }
                        break;


                        
                        /*LOYALTY CARD*/
                        case "Loyalty Card":
                            System.out.println("\n===========================\nLOYALTY CARD:\n===========================");
                            List<Customer> customers = customerDAO.getCustomer();
                            List<LoyaltyCard> cards = loyaltyCardDAO.getLoyaltyCards();

                            for (Customer customer : customers) {
                                System.out.println(
                                    "Customer ID: "+ customer.getCustomerId() + 
                                    " , Name: " + customer.getCustomerName() +
                                    " , Address: " + customer.getCustomerAddress() +
                                    " , Phone Number: " + customer.getCustomerPhone() +
                                    " , Email: " + customer.getCustomerEmail() +
                                    " , City: " + customer.getCustomerCity() +
                                    " , Zip Code: " + customer.getCustomerZipCode() +
                                    " , Country: " + customer.getCustomerCountry()
                                );
                            }

                            System.out.println("\n-----------------------------------");

                            for (LoyaltyCard card : cards) {
                                System.out.println(
                                    "Customer ID: "+ card.getCustomerId() +
                                    " , Card Number: " + card.getCardNumber() +
                                    " , Card ID: " + card.getCardId() +
                                    " , Total Points: " + card.getTotalPoints() +
                                    " , Points Used: " + card.getPoints()
                                );
                            }

                        break;


                        /*APPROVAL OF FINANCIAL SUPPORT*/
                        case "Approval of Financial Support":
                            System.out.println("\n===========================\nAPPROVAL OF FINANCIAL SUPPORT:\n===========================");
                            List<CustomerInfo> customersInfos = customerInfoDAO.getCustomerInfo();
                            List<FinancialApproval> financialApprovals = financialApprovalDAO.getFinancialApproval();

                            for (CustomerInfo customerInfo : customersInfos) {
                                System.out.println(
                                    "Customer ID: "+ customerInfo.getCustomerId() + 
                                    " , Name: " + customerInfo.getCustomerName() +
                                    " , Address: " + customerInfo.getCustomerAddress() +
                                    " , Phone Number: " + customerInfo.getCustomerPhone() +
                                    " , Email: " + customerInfo.getCustomerEmail() +
                                    " , City: " + customerInfo.getCustomerCity() +
                                    " , Zip Code: " + customerInfo.getCustomerZipCode() +
                                    " , Country: " + customerInfo.getCustomerCountry()
                                );
                            }

                            System.out.println("\n-----------------------------------");

                            for (FinancialApproval financialApproval : financialApprovals) {
                                System.out.println(
                                    "Customer ID: "+ financialApproval.getCustomerId() + 
                                    " , Approval ID: " + financialApproval.getApprovalId() +
                                    " , Amount: $" + financialApproval.getApprovalAmount() +
                                    " , Status: " + financialApproval.getApprovalStatus() +
                                    " , Time: " + financialApproval.getApprovalTime() +
                                    " , Date: " + financialApproval.getApprovalDate()
                                );
                            }
                        break;


                        /*PERFORMANCE ANALYSIS*/
                        case "Performance Analysis":
                            System.out.println("\n===========================\nPERFORMANCE ANALYSIS:\n===========================");
                            List<CustomerInfoReport> customersInfoReports = customerInfoReportDAO.getCustomerInfoReport();
                            List<CustomerPurchaseReport> customersPurchaseReports = customerPurchaseReportDAO.getCustomerPurchaseReport();

                            for (CustomerInfoReport customerInfoReport : customersInfoReports) {
                                System.out.println(
                                    "Customer ID: "+ customerInfoReport.getCustomerId() + 
                                    " , Name: " + customerInfoReport.getCustomerName() +
                                    " , Email: " + customerInfoReport.getCustomerEmail()
                                );
                            }

                            System.out.println("\n-----------------------------------");

                            for (CustomerPurchaseReport customerPurchaseReport : customersPurchaseReports) {
                                System.out.println(
                                    "Customer ID: "+ customerPurchaseReport.getCustomerId() + 
                                    " , Purchase ID: " + customerPurchaseReport.getPurchaseId() +
                                    " , Purchase Date: " + customerPurchaseReport.getPurchaseDate() +
                                    " , Purchase Time: " + customerPurchaseReport.getPurchaseTime() +
                                    " , Amount: $" + customerPurchaseReport.getPurchaseAmount()
                                );
                            }

                        break;


                        
                        default:
                            System.out.println("NO BUTTON CLICKED");
                        break;
                    }
                }
            });
            buttonPanel.add(button);
        }

        // Add the button panel to the main panel
        welcomePanel.add(buttonPanel, BorderLayout.CENTER);

        cardPanel.add(welcomePanel, "welcomePanel");
    }

    // Function to get different colors for buttons
    private Color getButtonColor(int index) {
        switch (index) {
            case 0:
                return Color.RED;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.ORANGE;
            case 4:
                return Color.MAGENTA;
            default:
                return Color.BLACK;
        }
    }
}