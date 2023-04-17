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
 * the transfer data object for tutorcourse
 * @author Olamide Owolabi
 */
public class tutorcourse {
    
    private int ttID;
    private String CCode;
    
    /**
     * To get the iD of the tutor
     * @return tutorId
     */
    public int GetId()
    {
        return ttID;
    }
    
    /**
     * To get the Course their assigned
     * @return coursecode
     */
    public String GetCode()
    {
        return CCode;
    }
    
    /**
     * to set the TutorId
     * @param Val TutorId
     */
    public void SetId(int Val)
    {
        ttID = Val;
    }
    
    /**
     * To set the coursecode
     * @param val coursecode
     */
    public void SetCode(String val)
    {
        CCode =val;
    }
}
