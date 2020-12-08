/**
* Authored by Katherine Tomlinson
* Date: 12/1/20
* Assignment : Unit 13 Carly 
*/


/**
* DisplayEventFile is used to display the created file information.
*/
import java.nio.file.*;
import java.io.*;
import java.nio.file.StandardOpenOption.*;
import java.nio.file.AccessMode.*;
import java.util.*;

public class DisplayEventFile {
    public static void main(String[] args) {
        Path file = Paths.get("EventData.txt"); //File for event information
        String s = ""; //string to fill with event info
        String delimiter = ",";
        String[] array = new String[4]; //array to fill with pieces of event info
        String eventNum; //event number
        int type; //ID for event type
        int guests; //guest count
        double price; //total price of event
        try{
            if(Files.exists(file)){
                InputStream input = new BufferedInputStream(Files.newInputStream(file));
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                s = reader.readLine();
                while (s != null){
                    array = s.split(delimiter);
                    eventNum = array[0];
                    type = Integer.parseInt(array[1]);
                    guests = Integer.parseInt(array[2]);
                    price = Double.parseDouble(array[3]);
                    System.out.println("Event # " + eventNum);
                    System.out.println("Event type number: " + type + " - " + Event.EVENT_TYPES[type]);
                    System.out.println("Guest count: " + guests);
                    System.out.println("Price : $" + price);
                    System.out.println();
                    s = reader.readLine();
                }
                reader.close();
            }
            else{
                System.out.println("No Event Data saved yet!");
            }
        }

        catch(Exception e){
            System.out.println("Message: " + e);
        }
    }
}