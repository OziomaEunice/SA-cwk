package client;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

import Database.Items;
import Database.ItemsDAOImpl;
import Database.Product;
import Database.ProductDAOImpl;


public class Functionalities extends JFrame{

    final private Font maiFont = new Font("Segoe UI Black", Font.BOLD, 18); // Global variable -> Create a font for the main panel
    JLabel lbWelcome; // Global variable -> Create a label for the main panel
    JPanel cardPanel; // Global variable -> Create a card panel

    // Instantiate the DAO implementation
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private ItemsDAOImpl itemsDAO = new ItemsDAOImpl();

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



        /* This part of code from ChatGPT */
        // Create a panel for buttons arranged in two columns
        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 0 rows, 2 columns

        // Create button names
        String[] buttonNames = {
            "Price Control",
            "Inventory Control",
            "Delivery Charge",
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
                        case "Price Control":
                            System.out.println("\n==================================");
                            List<Product> products = productDAO.getProducts();
                            for (Product product : products) {
                                System.out.println(
                                    "Produc ID: "+ product.getProductId() + 
                                    " , Name: " + product.getProductName() +
                                    " , Price: " + product.getPrice()    
                                    );
                            }
                        break;

                        case "Inventory Control":
                            System.out.println("\n==================================");
                            List<Items> items = itemsDAO.getItems();
                            for (Items item : items) {
                                System.out.println(
                                    "Item ID: "+ item.getItemID() + 
                                    " , Name: " + item.getItemName() +
                                    " , Category: " + item.getItemCategory() +
                                    " , Price: " + item.getItemPrice() +  
                                    " , Description: " + item.getItemDescription() +
                                    " , Supplier: " + item.getSupplierOfItem()
                                    );
                            }
                        break;


                        case "Delivery Charge":
                            System.out.println("\n==================================");
                            System.out.println("Delivery Charge");

                        break;


                        case "Approval of Financial Support":
                            System.out.println("\n==================================");
                            System.out.println("Approval of Financial Support");
                        
                        break;


                        case "Performance Analysis":
                            System.out.println("\n==================================");
                            System.out.println("Performance Analysis");

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