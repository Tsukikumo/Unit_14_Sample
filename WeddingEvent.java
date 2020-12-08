/**
* Authored by Katherine Tomlinson
* Date: 11/17/20
* Assignment : Unit 11 Carly 
*/


/** 
* Wedding Event represents an event subclass by Carly's Catering. 
*/
import java.util.*;
public class WeddingEvent extends Event{
    /**
    * Creates a wedding event with event constructor and additional information 
    * 
    * @parem aChoice is the appetizer choice 
    * @parem oneChoice is the first entree choice
    * @parem twoChoice is the second entree choice 
    * @parem dChoice is the dessert choice 
    * @parem isIt is the buffet style test result
    */
    public WeddingEvent(String num, int guests, int aChoice, int oneChoice, int twoChoice, int dChoice, boolean isIt){
        setEventNumber(num);
        setGuests(guests);
        setAppetizer(aChoice);
        setEntreeOne(oneChoice);
        setEntreeTwo(twoChoice);
        setDessert(dChoice);
        setIsBuffetStyle(isIt);
    }


    private int appetizerChoice; //Choice of appertizer for wedding from options
    private int entreeOne; //First entree choice from options
    private int entreeTwo; //Second entree choice from options
    private int dessertChoice; //Dessert choice from options
    private boolean isBuffetStyle = false; //whether wedding is a buffet

    public final static String APPETIZER_CHOICES[] = {"Mozzarella Sticks", "Buffalo Wings", "Shrimp Coctail", "Chips & Salsa"}; //The appetizer choices available, user can choose one
    public final static String ENTREE_CHOICES[] = {"Steak", "Chicken", "Fish", "Pizza", "Tacos"}; //Entree choices available, user may pick two (not same twice)
    public final static String DESSERT_CHOICES[] = {"Cheesecake", "Wedding Cake", "Cupcakes"}; //Dessert choices to choose from, user can choose one
    private Employee[] employees; //makes an array of employees working the wedding event (based on variables set)


    /**
    * Method to set the appetizer for the wedding
    */
    private void setAppetizer(int aChoice){
        if(aChoice >= WeddingEvent.APPETIZER_CHOICES.length || aChoice < 0){
            appetizerChoice = 0;
        }
        else {
            appetizerChoice = aChoice;
        }
    }

    /**
    * Method to set the first Entree for the wedding
    */
    private void setEntreeOne(int oneChoice){
        if(oneChoice >= WeddingEvent.ENTREE_CHOICES.length || oneChoice < 0){
            entreeOne = 0;
        }
        else{
            entreeOne = oneChoice;
        }
    }

    /**
    * Method to set second entree for wedding
    */
    private void setEntreeTwo(int twoChoice){
        if (twoChoice >= WeddingEvent.ENTREE_CHOICES.length || twoChoice < 0){
            if(entreeOne == 0){
                entreeTwo = 1;
            }
            else{
                entreeTwo = 0;
            }
        }
        else{
            entreeTwo = twoChoice;
        }
    }

    /**
    * Method to set dessert choice for wedding
    */
    private void setDessert(int dChoice){
        if(dChoice >= WeddingEvent.DESSERT_CHOICES.length || dChoice < 0){
            dessertChoice = 0;
        }
        else{
            dessertChoice = dChoice;
        }
    }

    /**
    * Asks user if they would like the dinner to be buffet style
    */
    private void setIsBuffetStyle(boolean isIt){
        isBuffetStyle = isIt;
    }

    /**
    * This sets the employees for the wedding
    *
    * @parem number is the total number of employees
    */
    protected void setEmployees(Employee[] tempEmployees){
        employees = tempEmployees;
    }

    /**
    * Gets the name of the appetizer based off the user choice 
    *
    * @return the appetizer choice
    */
    public String getAppetizerChoice(int appetizerChoice){
       return APPETIZER_CHOICES[appetizerChoice];
    }

    /**
    * Gets the name of the first entree based off the user choice
    *
    * @return the first entree choice
    */
    public String getEntreeOne(int entreeOne){
        return ENTREE_CHOICES[entreeOne];
    }

    /**
    * Gets the name of the second entree based off the user choice
    *
    * @return the first entree choice
    */
    public String getEntreeTwo(int entreeTwo){
        return ENTREE_CHOICES[entreeTwo];
    }

    /**
    * Gets the name of the dessert based off the user choice
    *
    * @return the first entree choice
    */
    public String getDessert(int dessertChoice){
        return DESSERT_CHOICES[dessertChoice];
    }

    /**
    * Gets the isBuffet result based on user choice
    *
    * @returns message on whether it's a buffet
    */
    public String getIsBuffet(boolean isBuffet){
        String buffet;
        if(isBuffet == true){
            buffet = "is buffet ";
        }
        else{
            buffet ="is not buffet ";
        }
        return buffet;
    }

    /**
    * Combines all menu information
    *
    * @returns message to display the menu information
    */
    public String getMenu() {
       String comma = ", ";
       String and = ", and ";
       String start = "The menu for this wedding event ";
       String buffet = getIsBuffet(isBuffetStyle);
       String nextPart = "and includes the following: ";
       String app =  getAppetizerChoice(appetizerChoice);
       String one = getEntreeOne(entreeOne);
       String two = getEntreeTwo(entreeTwo);
       String dessert =  getDessert(dessertChoice);
       String message = start + buffet + nextPart + app + comma + one + comma + two + and + dessert;
       return message;
    }

    /**
    * This gets the created employee array
    *
    * @return retrieves the array
    */
    public Employee[] getEmployees(){
        return employees;
    }

}


