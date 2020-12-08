/**
* Authored by Katherine Tomlinson
* Date: 12/1/20
* Assignment : Unit 13 Carly 
*/


/**
* EventDemoAndCreateFile is used to create Event objects based on user input, 
* then save the information onto a file.
*/
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.AccessMode.*;
import java.util.*;

public class EventDemoAndCreateFile extends EventDemo {
    public static void main(String[] args) {
        //Creates 3 event objects
        Event eventOne = new Event(askUserForEventNumber(), askUserForGuests(), askUserforEventType(Event.EVENT_TYPES));
        Event eventTwo = new Event(askUserForEventNumber(), askUserForGuests(), askUserforEventType(Event.EVENT_TYPES));
        Event eventThree = new Event(askUserForEventNumber(), askUserForGuests(), askUserforEventType(Event.EVENT_TYPES));

        //Makes an event array
        Event[] events = new Event[3];

        //Fills array with created events
        events[0] = eventOne;
        events[1] = eventTwo;
        events[2] = eventThree;
        
        //write data to file
        writeEventData(events);
    }


    /**
    * This method is to write data to file (if exists), otherwise it creates it
    */ 
    public static void writeEventData(Event[] events){
        String delimiter = ",";
        String s = ""; //String to fill with event info
        Path file = Paths.get("EventData.txt"); //File for event info
        try{
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE, APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            for(int x = 0; x < events.length; x++){
                s = events[x].getEventNumber() + delimiter + events[x].eventTypeNum + delimiter + events[x].getGuests() + delimiter + events[x].getPriceForEvent();
                writer.write(s, 0, s.length());
                writer.newLine();
            }
            writer.close();
        }
        catch(Exception e){
            System.out.println("Message: " + e);
        }
    }
}