/**
* Authored by Katherine Tomlinson
* Date: 11/17/20
* Assignment : Unit 11 Carly 
*/


/**
* EventDemo is used to create Event objects based on user input 
* and display the information about the created events.
*/
import java.util.*;

public class WeddingEventDemo extends EventDemo {
    // public static void main(String[] args) {
    //     //creates 3 wedding events based on user input
    //     WeddingEvent[] weddings = new WeddingEvent [3];
        
    //     for(int x = 0; x < weddings.length; x++){
    //         int one = -1;
    //         weddings[x] = new WeddingEvent(askUserForEventNumber(), askUserForGuests(), 0, askUserForAppetizerChoice(), one = askUserForEntree(one), askUserForEntree(one), askForDessert(), askUserIfBuffet());
    //     }

    //     //Displays the event and menu details
    //     for(int x=0; x < weddings.length; x++){
    //         displayDetails(weddings[x]);
    //         System.out.println(weddings[x].getMenu());
    //     }

    //     System.out.println();
    //     System.out.println("Thank you! Events have been set!");
    // }

    /**
    * This method asks the user for their choice of appetizer
    *
    * @return the number to match appetizer choice
    */
    public static int askUserForAppetizerChoice(){
        int choice = -1;
        boolean isNumber = false;
        while(!isNumber){
            try{
                while(choice >= WeddingEvent.APPETIZER_CHOICES.length || choice < 0){
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please select your appetizer from the following options: ");
                    for(int sub = 0; sub < WeddingEvent.APPETIZER_CHOICES.length; sub++){
                        System.out.println("Enter " + sub + " for " + WeddingEvent.APPETIZER_CHOICES[sub]);
                }
                System.out.print(">> ");
                choice = input.nextInt();
                input.nextLine();
                isNumber = true;
                }
            }
            catch(InputMismatchException mistake){
                System.out.println("Whoops! Please be sure to enter a numerical choice");
            }
        }
        System.out.println();
        return choice;
    }


    /**
    * This method asks the user for their choice of first and then second entree and sets a marker next to first entree chosen previously. Making assumption it shouldn't be same as first?
    *
    * @parem one is a token variable that marks the transition from first to second entree choice
    * @return the number to match entree choice
    */
    public static int askUserForEntree(int one){
        int choice = -1;
        boolean isNumber = false;
        String firstOrSecond;
        if(one == -1){
            firstOrSecond = "first";
        }
        else{
            firstOrSecond = "second";
        }
        while(!isNumber){
            try {
                while(choice >= WeddingEvent.ENTREE_CHOICES.length || choice < 0){
                    Scanner input = new Scanner(System.in);
                    if(firstOrSecond == "first"){
                        System.out.println("Choose your " + firstOrSecond + " entree from the following entree options: ");
                    }
                    else{
                        System.out.println("Choose your " + firstOrSecond + " entree from the following entree options (different from first choice) : ");
                    }
                    for(int sub = 0; sub < WeddingEvent.ENTREE_CHOICES.length; sub++){
                        if(sub == one){
                            System.out.println("Enter " + sub + " for " + WeddingEvent.ENTREE_CHOICES[sub] + "----[First entree chosen]");
                        }
                        else{
                            System.out.println("Enter " + sub + " for " + WeddingEvent.ENTREE_CHOICES[sub]);
                        }
                    } 
                    System.out.print(">> ");
                    choice = input.nextInt();
                    input.nextLine();
                    choice = checkForDuplicate(choice, one); 
                    isNumber = true;
                }
            }
            catch(InputMismatchException mistake){
                System.out.println("Whoops! Please be sure to enter a numerical choice");
            }
        }
        System.out.println();
        return choice;
    }

    /**
    * Checks to make sure entree choices are not the same
    */
    public static int checkForDuplicate(int choice, int one){
        if (choice == one){
           System.out.println("Whoops! You chose the same entree twice. As a reminder your first choice was " + WeddingEvent.ENTREE_CHOICES[one] +". Please make a different selection.");
            choice = -1;
        }
        return choice;
    }

    /**
    * This method asks the user for their choice of dessert
    *
    * @return the number to match dessert choice
    */
    public static int askForDessert(){
        int choice = -1;
        boolean isNumber = false;
        while(!isNumber){
            try{
                while(choice >= WeddingEvent.DESSERT_CHOICES.length || choice < 0){
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please select your Dessert from the following options: ");
                    for(int sub = 0; sub < WeddingEvent.DESSERT_CHOICES.length; sub++){
                        System.out.println("Enter " + sub + " for " + WeddingEvent.DESSERT_CHOICES[sub]);
                    }
                    System.out.print(">> ");
                    choice = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    isNumber = true;
                }
            }
            catch(InputMismatchException mistake){
                System.out.println("Whoops! Please be sure to enter a numerical choice");
            }
        }
        return choice;
    }


    /**
    * This method asks the user whether they want the food served buffet style
    *
    * @return the true or false test result for correct verbage about whether it's a buffet
    */
    public static boolean askUserIfBuffet(){
        boolean isIt = false;
        char choice = 'N';
        char exit = 'E';
        while(choice != exit){
            System.out.println("Would you like the food to be served buffet style?");
            System.out.println("Select Y for YES, or N for NO");
            System.out.print(">> ");
            Scanner input = new Scanner(System.in);
            choice = input.next().charAt(0);
            System.out.println();
            if(choice == 'y' || choice == 'Y'){
                isIt = true;
                choice = exit;
            }
            else if(choice == 'n' || choice == 'N'){
                isIt = false;
                choice = exit;
            }
            else{
                System.out.println("Whoops! Please be sure to select one of the options.");
            }
        }
        return isIt;
    }


    /**
     * Prints out the information about the given Wedding Event
     * @param e The Wedding Event to display the details of
     */
    public static void displayDetails(WeddingEvent wedding) {
        System.out.println("\nWedding Event #" + wedding.getEventNumber());
        System.out.println("The price for a wedding event with " + wedding.getGuests() +
            " guests at $" + wedding.getPricePerGuest() + " per guest is $" + wedding.getPriceForEvent());
        System.out.println("Whether this is a large event is " + wedding.isLargeEvent());
    }
}