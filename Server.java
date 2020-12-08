/**
* Authored by Katherine Tomlinson
* Date: 11/17/20
* Assignment : Unit 11 Carly 
*/


/** 
* Server represents a server employee of Carly's Catering.  
*/
public class Server extends Employee {
    /**
    * Creates a Server Employee 
    * 
    * @parem id is the server's employee ID
    * @parem first is the server's first name
    * @parem last is the server's last name
    * @parem rate is the  pay rate for the server
    */
    public Server(String id, String first, String last, double rate){
        setEmployeeID(id);
        setFirstName(first);
        setLastName(last);
        setRate(rate);
        setJobTitle();
    }

    private final static double SERVER_RATE_MAX = 15.00; //max rate possible for server position

    /**
    * This sets the rate for the server position and makes sure it stays between minimum
    * wage and does not go above maximum rate for the position.
    *
    * @parem rate is the rate for the server
    */
    @Override
    protected void setRate(double rate){
        if(rate < MINIMUM_WAGE_CA){
            payRate = MINIMUM_WAGE_CA;
        }
        else if(rate > SERVER_RATE_MAX){
            payRate = SERVER_RATE_MAX;
        }
        else{
            payRate = rate;
        }
    }


    /**
    * This sets the job title to server
    */
    @Override
    protected void setJobTitle(){
        jobTitle = "Server";
    }

}