/**
* Authored by Katherine Tomlinson
* Date: 11/17/20
* Assignment : Unit 11 Carly 
*/


/** 
* Manager represents a manager employee of Carly's Catering.  
*/
public class Manager extends Employee {
    /**
    * Creates a Manager Employee 
    * 
    * @parem id is the manager's employee ID
    * @parem first is the manager's first name 
    * @parem last is the manager's last name
    * @parem rate is the  pay rate for the manager
    */
    public Manager(String id, String first, String last, double rate){
        setEmployeeID(id);
        setFirstName(first);
        setLastName(last);
        setRate(rate);
        setJobTitle();
    }

    private final static double MANAGER_RATE_MAX = 30.00; //max rate possible for manager position

    /**
    * This sets the rate for the manager position and makes sure it stays between minimum
    * wage and does not go above maximum rate for the position.
    *
    * @parem rate is the rate for the manager
    */
    @Override
    protected void setRate(double rate){
        if(rate < MINIMUM_WAGE_CA){
            payRate = MINIMUM_WAGE_CA;
        }
        else if(rate > MANAGER_RATE_MAX){
            payRate = MANAGER_RATE_MAX;
        }
        else{
            payRate = rate;
        }
    }


    /**
    * This sets the job title to manager
    */
    @Override
    protected void setJobTitle(){
        jobTitle = "Manager";
    }
}