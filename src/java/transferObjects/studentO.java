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
 * the DTO for the student table
 * @author Olamide Owolabi
 */
public class studentO {
    
    private int StId;
    private String LName;
    private String FName;
    private String Em;
    private String PNum;
    
    /**
     * Get the student Id
     * @return Student Id
     */
    public int GetId()
    {
        return StId;
    }
    
    /**
     * Get the Student LastName
     * @return LastNAME
     */
    public String GetLastName()
    {
        return LName;
    }
    /**
     * Get the Student First name
     * @return Student First Name
     */
    public String getFirstName()
    {
        return FName;
    }
    
    /**
     * Get the student email
     * @return Student Email
     */
    public String getEmail()
    {
        return Em;
    }
    
    /**
     * Get the Studnet Phone Number
     * @return Phone Number
     */
    public String getPhone()
    {
        return PNum;
    }
    
    /**
     * Set the Student Id
     * @param val Id
     */
    public void SetId(int val)
    {
        StId = val;
    }
    
    /**
     * Set the STudent FirstName
     * @param val Firstname
     */
    public void SetFName(String val)
    {
        FName = val;
    }
    
    /**
     * Set the Student LastName
     * @param val LastName
     */
    public void SetLName(String val)
    {
        LName =val;
    }
    
    /**
     * Set the student Email
     * @param val Student Email
     */
    public void SetEmail(String val)
    {
        Em = val;
    }
    
    /**
     * Set the Student Phone number
     * @param val Phone Number
     */
    public void SetNum(String val)
    {
        PNum = val;
    }
}
