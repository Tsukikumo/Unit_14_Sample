/**
* Authored by Katherine Tomlinson
* Date: 11/17/20
* Assignment : Unit 11 Carly 
*/


/** 
* Event represents an event by Carly's Catering.  
*/
public class Event {
    public final static double HIGH_GUEST_PRICE = 35.00; // price for guest for small events
    public final static double LOW_GUEST_PRICE = 32.00; // discounted price for guests for large events
    public final static int LARGE_EVENT = 50; // minimum number of guests for a large event
    public final static int EVENT_NUM_LENGTH = 4; // required length of the event number
    public final static String EVENT_TYPES[] = {"wedding", "baptism", "birthday", "corporate", "other"};//event type descriptions. KEEP OTHER AS LAST OPTION

    private String eventNumber;
    private int numOfGuests;
    private double pricePerGuest;
    private double priceForEvent;
    int eventTypeNum; // number to correspond with type of event
    int numOfEvents = EVENT_TYPES.length; //decided to add this here to only have one update spot and for the verbage to make easier reading. 

    /**
    * Creates an Event where all the instance variables are set to default values
    */
    public Event() {
        this("A000", 0, (EVENT_TYPES.length - 1));
    }

    /**
    * Creates an Event with the given event number and number guests.  
    * It calculates the pricePerGuest and priceForEvent based on the number of guests.
    * Then it sets the type of event based on user input
    * Any remaining instance variables will be set to a default value
    * 
    * @param num The event number
    * @param guests The number of guests
    * @parem type The type of event
    */
    public Event(String num, int guests, int type) {
        setEventNumber(num);
        setGuests(guests);
        setEventType(type);
    }

    /**
    * Sets the value of the event number based on the given value.
    * If the given value is the required length, with a letter followed by 3 digits, 
    * then eventNumber is set to the uppercase version of the parameter.
    * Otherwise, it is set to a default value of "A000"
    * 
    * @param num The desired value for an event number
    */
    protected void setEventNumber(String num) {
        if (num.length() != EVENT_NUM_LENGTH ||
            !Character.isLetter(num.charAt(0)) ||
            !Character.isDigit(num.charAt(1)) ||
            !Character.isDigit(num.charAt(2)) ||
            !Character.isDigit(num.charAt(3))) {
            eventNumber = "A000";
        } else {
            eventNumber = num.toUpperCase();
        }
    }

    /** 
    * Sets the number of guests to the given value
    * It with also set the pricePerGuest and priceForEvent based on the size of the event
    * 
    * @param gsts Number of guests for the event
    */
    protected void setGuests(int gsts) {
        numOfGuests = gsts;
        if (isLargeEvent()) {
            pricePerGuest = LOW_GUEST_PRICE;
            priceForEvent = numOfGuests * LOW_GUEST_PRICE;
        } else {
            pricePerGuest = HIGH_GUEST_PRICE;
            priceForEvent = numOfGuests * HIGH_GUEST_PRICE;
        }
    }

    /**
    * Sets the event type number to compare to the event type array list.
    *
    * If the number is larger than list number it will default to "other" event type.
    */
    public void setEventType (int typeNum) {
        if (typeNum + 1 > numOfEvents || typeNum < 0) {
            eventTypeNum = numOfEvents - 1;
        }
        else {
            eventTypeNum = typeNum;
        }
    }

    /**
    * Gets the event number of this Event
    * 
    * @return this Event's eventNumber
    */
    public String getEventNumber() {
        return eventNumber;
    }

    /**
    * Gets the number of guests for this Event
    * 
    * @return this Event's numOfGuests
    */
    public int getGuests() {
        return numOfGuests;
    }

    /**
    * Gets the total price for this Event
    * 
    * @return this Event's priceForEvent
    */
    public double getPriceForEvent() {
        return priceForEvent;
    }

    /**
    * Gets the price for each guest for this Event
    * 
    * @return this Event's pricePerGuest
    */
    public double getPricePerGuest() {
        return pricePerGuest;
    }

    /**
    *Gets the name of the event type based off the event number reference
    *
    *@return this Event's event type
    */
    public String getEventType(int eventTypeNum) {
        return EVENT_TYPES[eventTypeNum];
    }


    /**
    * Checks if this Event is a large event
    * @return true if number of guests is greater than or equal to LARGE_EVENT.
    * 		Otherwise, it returns false.
    */
    public boolean isLargeEvent() {
        boolean isLarge = false;
        if (numOfGuests >= LARGE_EVENT) {
            isLarge = true;
        }
        return isLarge;
    }
}
