package client;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    final private Font maiFont = new Font("Segoe UI Black", Font.BOLD, 18); // Global variable -> Create a font for the main panel
    JTextField textField1, textField2; // Global variable -> Create a text field for the main panel
    JLabel lbWelcome; // Global variable -> Create a label for the main panel
    JPanel cardPanel; // Global variable -> Create a card panel
    CardLayout cardLayout; // Global variable -> Create a card layout



    // Create the constructor of the class
    public MainFrame() {

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout); // Set the layout manager of the card panel

        initialisation(); // Call the method that will create the form panel
        createWelcomePanel(); // Call the method that will create the welcome panel

        add(cardPanel); // Add the card panel to the frame

        setTitle("DE-Store"); // Set the title of the frame  
        setSize(500, 600); // Set the size of the frame
        setMinimumSize(new Dimension(300, 400)); // Set the minimum size of the frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Set the default close operation
        setVisible(true); // Set the visibility of the frame
    }

    // Create a method that will allow the
    // initialisation of each statement in a frame
    public void initialisation(){
        /********************Form Panel**********************/

        //COMPONENETS
        // Create label of the main panel for this frame
        JLabel label1 = new JLabel("Retail Name");
        label1.setFont(maiFont); // Set the font of the label

        textField1 = new JTextField();
        textField1.setFont(maiFont); // Set the font of the text field


        JLabel label2 = new JLabel("Branch");
        label2.setFont(maiFont); // Set the font of the label

        textField2 = new JTextField();
        textField2.setFont(maiFont); // Set the font of the text field


        // Create the form panel that will contain the components above
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5)); // Set the layout manager of the form panel
        formPanel.setOpaque(false); // make form panel transparent
        formPanel.add(label1);
        formPanel.add(textField1);
        formPanel.add(label2);
        formPanel.add(textField2);



        /********************Welcome Label**********************/

        // lbWelcome = new JLabel();
        // lbWelcome.setFont(maiFont); // Set the font of the label
        // lbWelcome.setHorizontalAlignment(JLabel.CENTER); // Set the alignment of the label


        /********************Button Panel**********************/

        JButton btnOK = new JButton("OK");
        btnOK.setFont(maiFont); // Set the font of the button
        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // This method will be executed when the button is clicked.
                // What happens here is to read the text in the 2 textfields, and display them
                // in the Welcome Label.
                // String text1 = textField1.getText();
                // String text2 = textField2.getText();
                // lbWelcome.setText("Welcome " + text1 + " " + " - " + text2);
                lbWelcome.setText("\nOpening the functionalities window...");
                cardLayout.show(cardPanel, "welcomePanel");     
                
                // Call the method that will display the functionalities window
                Functionalities functionalities = new Functionalities();
                functionalities.setVisible(true);
            } 
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(maiFont); // Set the font of the button

        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // This method will be executed when the cancel button is clicked.
                // What happens here is that it will make the textfields empty
                textField1.setText("");
                textField2.setText("");
                lbWelcome.setText("");
                cardLayout.show(cardPanel, "formPanel");
            }    
        });


        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5)); // Set the layout manager of the button panel
        buttonPanel.setOpaque(false); // make button panel transparent
        buttonPanel.add(btnOK); 
        buttonPanel.add(btnCancel);

        // Create a main panel for this frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // Set the layout manager of the main panel
        mainPanel.setBackground(new Color(220, 220, 220)); // set the main colour of the panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // set margin of the panel

        //add form panel and welcome label to main panel
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        cardPanel.add(mainPanel, "formPanel"); // add the main panel to the card panel
    }

    // Create a method that will create the welcome panel
    public void createWelcomePanel(){
        lbWelcome = new JLabel();
        lbWelcome.setFont(maiFont); // Set the font of the label
        lbWelcome.setHorizontalAlignment(JLabel.CENTER); // Set the alignment of the label

        // Create a welcome panel
        JPanel welcomePanel = new JPanel(new BorderLayout()); // Set the layout manager of the welcome panel
        welcomePanel.setBackground(new Color(220, 220, 220)); // set the main colour of the panel
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // set margin of the panel
        welcomePanel.add(lbWelcome, BorderLayout.CENTER); // add the welcome label to the welcome panel
        
        cardPanel.add(welcomePanel, "welcomePanel"); // add the welcome panel to the card panel
    }
}