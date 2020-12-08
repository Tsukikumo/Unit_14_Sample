/**
* Authored by Katherine Tomlinson
* Date: 11/17/20
* Assignment : Unit 11 Carly 
*/


/**
* StaffWeddingEventDemo is used to create a WeddingEvent object
* and staff it based on user input, then display the 
* information about the created events and staff.
*/
import java.util.*;

public class StaffWeddingEventDemo extends WeddingEventDemo {
    // public static void main(String[] args) {
    //     //creates 1 wedding event based on user input
    //     WeddingEvent[] weddings = new WeddingEvent [1];

    //     //gets all the details for the wedding  
    //     getWeddingDetails(weddings);

    //     //Displays the event, menu, & employee details
    //     for(int i = 0; i < weddings.length; i++){
    //         displayDetails(weddings[i]);
    //         System.out.println(weddings[i].getMenu());
    //         System.out.println("Your employees will be: ");
    //         showEmployeeDetails(weddings[i].getEmployees());
    //     }

    //     System.out.println();
    //     System.out.println("Thank you! Events have been set!");
    // }
    

    /**
    * This will get all the details for the wedding event 
    *
    * @parem weddings is the set of wedding events to populate
    */
    public static void getWeddingDetails(WeddingEvent[] weddings){
        for(int x = 0; x < weddings.length; x++){
            int one = -1;
            int guests;
            int servers = 0;
            int bartenders = 0;
            boolean isBuffet = false;
            weddings[x] = new WeddingEvent(askUserForEventNumber(), guests = askUserForGuests(), askUserForAppetizerChoice(), one = askUserForEntree(one), askUserForEntree(one), askForDessert(), isBuffet = askUserIfBuffet());
            servers = setNumbersOfServers(isBuffet, guests);
            bartenders = setNumberOfBartenders(guests);
            int number = servers + bartenders + 1;
            Employee[] employees = new Employee[number];
            if(servers > 0){
                staffServers(servers, employees);  
            }
            if(bartenders > 0){
               staffBartenders(bartenders, employees, servers);
            }
            System.out.println("Manager");
            employees[number - 1] = new Manager(askUserForEmployeeID(),askUserForEmployeeFirstName(),askUserForEmployeeLastName(),askUserForRate());
            weddings[x].setEmployees(employees);
        } 
    }

    /**
    * This asks the user for the employee's ID number 
    *
    * @return the ID number
    */ 
    public static String askUserForEmployeeID(){
        String ID;
        System.out.print("Please enter the employee number >> ");
        Scanner input = new Scanner(System.in);
        ID = input.nextLine();
        return ID;
    }

    /**
    * This asks the user for the first name of the employee
    *
    * @return the first name of the employee
    */
    public static String askUserForEmployeeFirstName(){
        String name;
        System.out.print("Please enter employee first name >> ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        return name;
    }

    /**
    * This asks the user for the employee's last name 
    * 
    * @return the employee's last name
    */
    public static String askUserForEmployeeLastName(){
        String name;
        System.out.print("Please enter employee last name >> ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        return name;
    }

    /**
    * This asks the user to supply the rate that will be payed to
    * the employee for the event 
    *
    * @return the rate for the employee 
    */
    public static double askUserForRate(){
        double rate = 0;
        boolean isNumber = false;
        while(!isNumber){
            try {
                System.out.print("Please enter the rate they will be paid >> ");
                Scanner input = new Scanner(System.in);
                rate = input.nextDouble();
                input.nextLine(); 
                isNumber = true;
            }
            catch(InputMismatchException mistake){
                System.out.println("Whoops! Please be sure to enter a numerical rate of pay.");
            }
        }
        System.out.println();
        return rate;
    } 

    /**
    * This sets the number of servers based on whether it's a buffet and number of 
    * guests for event 
    *
    * @parem isBuffet indicates if it's a buffet 
    * @parem guests is guest count 
    *
    * @return servers for event 
    */
    public static int setNumbersOfServers(boolean isBuffet, int guests){
        int servers;
        if (isBuffet == false){
            if(guests > 12 ){
                servers = (guests / 12) + 1;
            }
            else{
                servers = 1;
            }
        }
        else {
            if(guests > 30){
                servers = (guests / 30) + 3;
            }
            else{
                servers = 3;
            }
        }
        return servers;
    }   


    /**
    * This sets the number of bartenders based on number of guests for event 
    *
    * @parem guests is guest count 
    *
    * @return bartenders for event 
    */
    public static int setNumberOfBartenders(int guests){
        int bartenders;
        if(guests > 20){
            bartenders = (guests / 20) + 1;
        }
        else{
            bartenders = 1;
        }
        return bartenders;
    }


    /**
    * This staffs the servers for the event based on number needed 
    *
    * @parem servers is previously set number of servers
    * @param employees is the employee array to staff 
    */
    public static void staffServers(int servers, Employee[] employees){
        int x;
        for(x = 0; x <= servers - 1; ++x){
            System.out.println("Server");
            employees[x] = new Server(askUserForEmployeeID(),askUserForEmployeeFirstName(),askUserForEmployeeLastName(),askUserForRate());
        }
    }


    /**
    * This staffs the bartenders for the event based on number needed 
    *
    * @parem bartenders is previously set number of bartenders 
    * @param employees is the employee array to staff 
    * @parem servers is previously set number of servers 
    */
    public static void staffBartenders(int bartenders, Employee[] employees, int servers){
        int x;
        for(x = 0; x <= bartenders - 1; ++x){
            System.out.println("Bartender");
            int theServers = servers;
            employees[theServers + x] = new Bartender(askUserForEmployeeID(),askUserForEmployeeFirstName(),askUserForEmployeeLastName(),askUserForRate());
        }
    }
    
    /**
    * This displays all the details for each employee scheduled 
    * for the event 
    */
    public static void showEmployeeDetails(Employee[] employees) {
        for(int x=0; x < employees.length; ++x){
            System.out.println(employees[x].getJobTitle() + " - " +  employees[x].getFirstName() + " " + employees[x].getLastName() + "(Employee ID: " + employees[x].getEmployeeID()+ ") at a rate of $" + employees[x].getRate() + " per hour.");
        }
        
    }

    
}