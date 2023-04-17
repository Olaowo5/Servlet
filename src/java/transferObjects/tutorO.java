/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferObjects;

/*
Student Name: Olamide Owolabi   
Student Number: 040982007
Course & Section #: 22S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/

/**
 * The transfer data Something Object for tutor table
 * @author Olamide
 */
public class tutorO {
    
    private int TId;
    
    private String LName;
    private String FName;
    private String Em;
    private String Stat;
    private int ExpId;
    private String PhoneNo;
    
    /**
     * Get the tutor ID
     * @return tutor Id
     */
    public int GetId()
    {
        return TId;
    }
    
    /**
     * Get the Tutor Last Name
     * @return Last Name
     */
    public String GetLName()
    {
        return LName;
    }
    
    /**
     * Get the tutor First Name
     * @return first Name
     */
    public String GetFName()
    {
        return FName;
    }
    
    /**
     * Get the tutor Email
     * @return tutor Email
     */
    public String GetEmail()
    {
        return Em;
    }
    
    /**
     * Get the tutor Status
     * @return Status (feeling depressed)
     */
    public String GetStat()
    {
        return Stat;
    }
    
    /**
     * Get the experience Id, their all Ones
     * @return experience Id
     */
    public int GetExpId()
    {
        return ExpId;
    }
    
    /**
     * Get the tutor Phone Number
     * @return Phone No
     */
    public String getPhoneNo()
    {
        return PhoneNo;
    }
    
    /**
     * Set the tutor Id
     * @param val the Id to set
     */
    public void SetId(int val)
    {
        TId =val;
    }
    
    /**
     * Set the tutor FirstName
     * @param val FirstName
     */
    public void SetFName(String val)
    {
        FName =val;
    }
    
    /**
     * Set the Tutor LastName
     * @param val LastName
     */
    public void SetLName(String val)
    {
        LName =val;
    }
    
    /**
     * Set the Tutor Email
     * @param val email
     */
    public void SetEm(String val)
    {
        Em =val;
    }
    
    /**
     * Set the tutor Status
     * @param Val the status
     */
    public void SetStat(String Val)
    {
        Stat =Val;
    }
    
    /**
     * Set the experience Id
     * @param Vsl  experience Id
     */
    public void SetExpId (int Vsl)
    {
        ExpId = Vsl;
    }
    /**
     * Set the phone Number
     * @param Val Phone Number
     */
    public void SetPhone(String Val)
    {
        PhoneNo = Val;
    }
}
