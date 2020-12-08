/**
* Authored by Katherine Tomlinson
* Date: 11/17/20
* Assignment : Unit 11 Carly 
*/


/**
* EventDemo is used to create Event objects based on user input and display the information
* about the created events.
*/
import java.util.*;

public class EventDemo {
    // public static void main(String[] args) {
        // int sortChoice = 0;
        // int exit = 4;
        // Create 8 Events based on user input
        // Event[] events = new Event[8];

        // for(int x = 0; x < events.length; x++){
        //     events[x] = new Event(askUserForEventNumber(), askUserForGuests(), askUserforEventType(Event.EVENT_TYPES));
        // }


        // Asks user to choose method to sort events by, and then sorts it until user is happy with sort method.
        // sortItUntilUserIsHappy(events, sortChoice, exit);

    //     for(int x=0; x < weddings.length; x++){
    //       displayDetails(weddings[x]);
    //       System.out.println(WeddingEvent.getMenu(weddings[x]));
    //       }

    //     System.out.println("Thank you! Events have been set!");
    // }


    /**
    * Asks the user for the event number.
    * 
    * @return The event number provided by the user.
    */
    public static String askUserForEventNumber() {
        String num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter event number >> ");
        num = input.nextLine();
        return num;
    }

    /**
    * Asks the user for the number of guests until a valid response is given.
    * 
    * @return The number of guests provided by the user.
    */
    public static int askUserForGuests() {
        int guests = 0;
        final int MIN_GUESTS = 5;
        final int MAX_GUESTS = 100;
        boolean isNumber = false;
        while(!isNumber){
            try{
                Scanner input = new Scanner(System.in);
                System.out.print("Enter number of guests >> ");
                guests = input.nextInt();
                while (guests < MIN_GUESTS || guests > MAX_GUESTS) {
                    System.out.println("The number of guests must be between " +
                        MIN_GUESTS + " and " + MAX_GUESTS);
                    System.out.print("Please renter >> ");
                    guests = input.nextInt();
                    input.nextLine();
                }
                isNumber = true;
            }
            catch(InputMismatchException mistake){
                System.out.println("Whoops! Please be sure to make a numerical selection");
            }
        }
        return guests;
    }

    /**
    * This is to prompt user for the event type number 
    *
    *@return the event type number that corresponds to the correct type of event.
    */
    public static int askUserforEventType(String[] arr){
        int type;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number for the type of event as follows: ");
        for(int sub = 0; sub < arr.length; sub++){
            System.out.println("Enter " + sub + " for " + arr[sub]);
        }
        System.out.print(">> ");
        type = input.nextInt();
        input.nextLine();
        System.out.println();
        return type;
    }


    /**
    * This asks the user for their initial sort choice after event creation,
    *  then it sorts the events for them and checks if they are satisfied.
    *  If satisfied it exits, otherwise it re-prompts for sort choice.
    */
    public static void sortItUntilUserIsHappy(Event[] events, int sortChoice, int exit){
        while(sortChoice != exit){
            int decision = 0;
            sortChoice = askUserForSortBy();
            switch(sortChoice){
                case 1:
                    sortEventByEventNumber(events);
                    break;
                case 2:
                    sortEventByGuestCount(events);
                    break;
                case 3:
                    sortEventByEventType(events);
                    break;
            }
            for(int x=0; x < events.length; x++){
                displayDetails(events[x]);
            }
            System.out.println();
            while(decision !=1 || decision != 2){
                System.out.println("If you are happy with this sort method, select 1 to exit, or select 2 to reselect sort method.");
                System.out.print(">> ");
                Scanner input = new Scanner(System.in);
                decision = input.nextInt();
                input.nextLine();
                System.out.println();
                if(decision == 1){
                    sortChoice = exit;
                    break;
                }
                else if (decision == 2){
                    System.out.println("Ok! Let's try a different way.");
                    System.out.println();
                    break;
                }
                else{
                    System.out.println("Whoops, your selection is not one of the choices.");
                    System.out.println();
                }
            }
        }
    }

    /**
    * asks user how to sort events.
    */
    public static int askUserForSortBy(){
        int choice;
        System.out.println("How would you like to sort your event information?");
        System.out.println("Choose 1 to sort by event number");
        System.out.println("Choose 2 to sort by number of guests");
        System.out.println("Choose 3 to sort by event type");
        System.out.print(">> ");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        input.nextLine();
        System.out.println();
        while(!(0 < choice && choice < 4)){
            System.out.println("That selection is invalid. Please select from one of the three sort options. (1 to sort by event number, 2 to sort by number of guests, or 3 by event type)");
            System.out.print(">> ");
            choice = input.nextInt();
            input.nextLine();
            System.out.println();
        }
        return choice;
    }


    /**
    * This is to sort the events by event number
    */
    public static void sortEventByEventNumber(Event[] array){
        int a = 1;
        while(a < array.length){
            Event temp = array[a];
            int b = a - 1;
            while(b >= 0 && array[b].getEventNumber().compareTo(temp.getEventNumber()) > 0){
                array[b + 1] = array[b];
                --b;
            }
            array[b + 1] = temp;
            ++a;
        }
    }


    /**
    * This is to sort the events by guest count
    */
    public static void sortEventByGuestCount(Event[] array){
        int a = 1;
        while(a < array.length){
            Event temp = array[a];
            int b = a - 1;
            while(b >= 0 && array[b].getGuests() > temp.getGuests()){
                array[b + 1] = array[b];
                --b;
            }
            array[b + 1] = temp;
            ++a;
        }
    }


    /**
    * This is to sort the events by event type
    */
    public static void sortEventByEventType(Event[] array){
        int a = 1;
        while(a < array.length){
            Event temp = array[a];
            int b = a - 1;
            while(b >= 0 && array[b].getEventType(array[b].eventTypeNum).compareTo(temp.getEventType(temp.eventTypeNum)) > 0){
                array[b + 1] = array[b];
                --b;
            }
            array[b + 1] = temp;
            ++a;
        }
    }

    /**
    * Prints out the information about the given Event
    * @param e The Event to display the details of
    */
    public static void displayDetails(Event event) {
        System.out.println("\nEvent #" + event.getEventNumber());
        System.out.println("The price for an event with " + event.getGuests() +
            " guests at $" + event.getPricePerGuest() + " per guest is $" + event.getPriceForEvent());
        System.out.println("Whether this is a large event is " + event.isLargeEvent());
        System.out.println("The type of event is: " + event.getEventType(event.eventTypeNum));
    }
}
