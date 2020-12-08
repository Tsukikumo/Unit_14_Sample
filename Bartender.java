/**
* Authored by Katherine Tomlinson
* Date: 11/17/20
* Assignment : Unit 11 Carly 
*/


/** 
* Bartender represents a bartender employee of Carly's Catering.  
*/
public class Bartender extends Employee {
    /**
    * Creates a Bartender Employee 
    * 
    * @parem id is the bartender's employee ID
    * @parem first is the bartender's first name
    * @parem last is the bartender's last name 
    * @parem rate is the  pay rate for the bartender
    */
    public Bartender(String id, String first, String last, double rate){
        setEmployeeID(id);
        setFirstName(first);
        setLastName(last);
        setRate(rate);
        setJobTitle();
    }

    private final static double BARTENDER_RATE_MAX = 18.00; //max rate possible for bartender position

    /**
    * This sets the rate for the bartender position and makes sure it stays between  
    * minimum wage and does not go above maximum rate for the position.
    *
    * @parem rate is the rate for the bartender
    */
    @Override
    protected void setRate(double rate){
        if(rate < MINIMUM_WAGE_CA){
            payRate = MINIMUM_WAGE_CA;
        }
        else if(rate > BARTENDER_RATE_MAX){
            payRate = BARTENDER_RATE_MAX;
        }
        else{
            payRate = rate;
        }
    }


    /**
    * This sets the job title to bartender
    */
    @Override
    protected void setJobTitle(){
        jobTitle = "Bartender";
    }
}