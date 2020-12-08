/**
* Authored by Katherine Tomlinson
* Date: 11/17/20
* Assignment : Unit 11 Carly 
*/


/** 
* Employee represents an employee of Carly's Catering.  
*/
public abstract class Employee {
    private String employeeID; //The employee's ID number, possible letter/number combinations
    private String employeeLastName; //The employee's last name
    private String employeeFirstName; //The employee's first name
    protected double payRate; //Pay rate for the employee
    protected String jobTitle; //Job title for the employee
    public final static double MINIMUM_WAGE_CA = 12.00; //This is the minimum wage for California (Where I am)


    /**
    * This sets the employee ID number
    *
    * @parem id is the ID number entered
    */
    protected void setEmployeeID(String id){
        employeeID = id;
    }

    /**
    * This sets the last name for the employee
    *
    * @parem last is the last name entered
    */
    protected void setLastName(String last){
        employeeLastName = last;
    }

    /**
    * This sets the first name for the employee
    *
    * @parem first is the first name entered
    */
    protected void setFirstName(String first){
        employeeFirstName = first;
    }

    /**
    * This will set pay rate dependant on job. Leaving abstract so individal job can set as needed.
    *
    * @parem rate will be rate for job
    */
    protected abstract void setRate(double rate);

    /**
    * This will set the job title dependant on the job. Leaving abstract so individual job can set as needed
    */
    protected abstract void setJobTitle();

    /**
    * This returns the employee ID
    */
    public String getEmployeeID(){
        return employeeID;
    }

    /**
    * This returns the first name of the employee
    */
    public String getFirstName(){
        return employeeFirstName;
    }

    /**
    * This returns the employee's last name
    */
    public String getLastName(){
        return employeeLastName;
    }

    /**
    * This returns the pay rate for the employee
    */
    public double getRate(){
        return payRate;
    }

    /**
    * This returns the job title
    */
    public String getJobTitle(){
        return jobTitle;
    }
}