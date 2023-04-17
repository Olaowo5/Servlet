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
 * The transferobject for the grade table
 * @author Olamide Owolabi
 */
public class gradeO {
    
    private int StudId;
    private String CCode;
    private String Grade;
    
    
    /**
     * Get the student ID
     * @return ID
     */
    public int GetStudId()
    {
        return StudId;
    }
    
    /**
     * Get the coursecode
     * @return  CourseCode
     */
    public String GetCode()
    {
        return CCode;
    }
    
    /**
     * Get the grade
     * @return grade
     */
    public String getGrade()
    {
        return Grade;
    }
    
    /**
     * Set the student Id
     * @param Sid Student iD
     */
    public void SetStud(int Sid)
    {
        StudId = Sid;
    }
    
    /**
     * Get the course Code
     * @param Cd  Course Code
     */
    public void SetCCode(String Cd)
    {
        CCode =Cd;
    }
    
    /**
     * Set the Grade
     * @param Gc Grade
     */
    public void SetGrade(String Gc)
    {
        Grade = Gc;
    }
}
