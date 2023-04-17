/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
Student Name: Olamide Owolabi   
Student Number: 040982007
Course & Section #: 22S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
package transferObjects;

/**
 * the transferable object for the course table 
 * @author Olamide Owolabi
 */
public class course {
    private String CourseCode;
    private String CourseName;
    private String CourseDesp;
   
    /**
     * Get the CourseCode
     * @return CourseCode
     */
    public String GetCode()
    {
        return CourseCode;
    }
    
    /**
     * Get the coursename
     * @return Course name
     */
    public String GetName()
    {
        return CourseName;
    }
    
    /**
     * Get the Course Description
     * @return Description
     */
    public String GetDesp()
    {
        return CourseDesp;
    }
    
    
    /**
     * Set the Course Code
     * @param val Course Code
     */
    public void SetCode(String val)
    {
        CourseCode = val;
    }
    
    /**
     * Set The Course Name
     * @param Val Course Name
     */
    public void SetName(String Val)
    {
        CourseName = Val;
    }
    
    /**
     * Set the Course Description
     * @param Val Course Description
     */
    public void SetDesc(String Val)
    {
        CourseDesp = Val;
    }
}
