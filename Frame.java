/**
* Authored by Katherine Tomlinson
* Date: 12/8/20
* Assignment : Unit 14 Carly 
*/


/** 
* Frame represents a JFrame for Carly's Catering to get user input 
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener, ItemListener{
    int guestNumber = 0; //number of guests, default of 0
    int entreeType = 0; //identifies which entree array item it is
    String entree = "not selected"; //a default display when no entree is selected
    String[] entreeOptions = {"-SELECT ENTREE-","Chicken", "Fish", "Pizza", "Steak"}; //entree options
    String firstChoice = ""; //first side dish choice
    String secondChoice = ""; //second side dish choice
    int dessertType = 0; //identifies which dessert array item it is;
    String dessert = "not selected"; //a default display when no dessert is selected
    String[] dessertOptions = {"-SELECT DESSERT-","Cupcakes", "Ecclairs", "Pie"}; //dessert options
    final double PRICE = 35; //price per person

    JLabel userGuestQuery = new JLabel("Please enter number of guests"); //this label prompts the user for guest count
    JTextField guestInputField = new JTextField(4); //guest text field
    JButton guestSubmitButton = new JButton("Submit"); //submit button
    JLabel userEntryQuery = new JLabel("Please select an entree: "); //prompts user for entree choice
    JComboBox entreeChoice = new JComboBox(entreeOptions); //entree drop down
    JLabel userSideDishQuery = new JLabel("Please select two side dishes: "); //prompts user to select two side dishes
    JCheckBox corn = new JCheckBox("Corn", false); //corn side dish box
    JCheckBox salad = new JCheckBox("Salad", false); //salad side dish box
    JCheckBox soup = new JCheckBox("Soup", false); //soup side dish box
    JCheckBox zucchini = new JCheckBox("Zucchini", false); //zucchini side dish box
    JLabel userDessertQuery = new JLabel("Please select a dessert"); //prompts user to select a dessert
    JComboBox dessertChoice = new JComboBox(dessertOptions); //dessert drop down
    JLabel guestInfoDisplay = new JLabel(""); //displays user's guest count choice
    JLabel entreeDisplay = new JLabel(""); //displays user's entree choice
    JLabel sideDisplay = new JLabel(""); //displays user's side dish choice
    JLabel dessertDisplay = new JLabel(""); //displays user's dessert choice
    JLabel space = new JLabel("                "); //spacer to center text
    JLabel space2 = new JLabel("           "); //second smaller spacer to center text

    /**
    * A frame extended from JFrame specific to Carly's Catering needs
    */
    public Frame(){
        super("Carly's Catering");
        final int FRAME_WIDTH = 370; //frame width
        final int FRAME_HEIGHT = 300; //frame height
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(new FlowLayout());
        add(userGuestQuery);
        add(guestInputField);
        add(guestSubmitButton);
        add(userEntryQuery);
        add(entreeChoice);
        add(space);
        add(userSideDishQuery);
        add(space2);
        add(corn);
        add(salad);
        add(soup);
        add(zucchini);
        add(userDessertQuery);
        add(dessertChoice);
        add(guestInfoDisplay);
        add(entreeDisplay);
        add(sideDisplay);
        add(dessertDisplay);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guestSubmitButton.addActionListener(this);
        guestInputField.addActionListener(this);
        entreeChoice.addActionListener(this);
        corn.addItemListener(this);
        salad.addItemListener(this);
        soup.addItemListener(this);
        zucchini.addItemListener(this);
        dessertChoice.addActionListener(this);
    }
     
    /**
    * This received the actions for the guest count, entree choice, & dessert
    * For guest count it ensures no letters
    * For entree choice it pulls the word from the array
    * For dessert choice it pulls the word from the array
    */
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        //if guest entry check max length of input for letters
        if(source == guestSubmitButton || source == guestInputField){
            String userGuestInput = guestInputField.getText();
            for(int x = 0; x < userGuestInput.length(); x++){
                if(Character.isDigit(userGuestInput.charAt(x)) == false){
                    x = userGuestInput.length() + 1;
                    userGuestInput = "0";
                }
            }
            guestNumber = Integer.parseInt(userGuestInput);
        }
        else if(source == entreeChoice){
            entreeType = entreeChoice.getSelectedIndex();
            entree = entreeOptions[entreeType];
        }
        else{
            dessertType = dessertChoice.getSelectedIndex();
            dessert = dessertOptions[dessertType];
        }
        displayDetails();
    }

    /**
    * This populates the two choice options for side dishes via check box
    * If user tries to select more than two it resets the choices
    */
    @Override
    public void itemStateChanged(ItemEvent check){
        //as long as choices are not filled, check the boxes and set to appropriate selection (first or second)
        if(firstChoice == "" || secondChoice == ""){
            if(corn.isSelected() == true){
                if(firstChoice == ""){
                    firstChoice = "corn";
                }
                else if(secondChoice == "" && firstChoice != "corn"){
                    secondChoice = "corn";
                }
            }
            if(salad.isSelected() == true){
                if(firstChoice == ""){
                    firstChoice = "salad";
                }
                else if(secondChoice == "" && firstChoice != "salad"){
                    secondChoice = "salad";
                } 
            }
            if(soup.isSelected() == true){
                if(firstChoice == ""){
                    firstChoice = "soup";
                }
                else if(secondChoice == "" && firstChoice != "soup"){
                    secondChoice = "soup";
                } 
            }
            if(zucchini.isSelected() == true){
                if(firstChoice == ""){
                    firstChoice = "zuchinni";
                }
                else if(secondChoice == "" && firstChoice != "zucchini"){
                    secondChoice = "zucchini";
                } 
            }
        }
        //if both have been filled, set everything clear again
        else { 
            corn.setSelected(false);
            salad.setSelected(false);
            soup.setSelected(false);
            zucchini.setSelected(false);
            firstChoice = "";
            secondChoice = "";
        }
        displayDetails();
    }


    /**
    * This displays the information for the user based on their choices
    */
    public void displayDetails(){
        String displayGuests = "Guest count is " + guestNumber + " for an event cost of $" + (PRICE * guestNumber);
        String displayEntree = "Your entree choice is " + entree;
        String sideChoices = "Your side dishes are: " + firstChoice + " and " + secondChoice;
        String displayDessert = "Your dessert choice is " + dessert;
        guestInfoDisplay.setText(displayGuests);
        entreeDisplay.setText(displayEntree);
        sideDisplay.setText(sideChoices);
        dessertDisplay.setText(displayDessert);
    }
}