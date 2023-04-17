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
 * the DTO for the experience table
 * @author Olamide Owolabi
 */
public class exps {
    
    private int ExpId;
    private String textp;
    
    /**
     * Get The ID
     * @return Id Table
     */
    public int GetId()
    {
        return ExpId;
    }
    
    /**
     * Get the experience description
     * @return a wall of text
     */
    public String Gettextp()
    {
        return textp;
    }
    
    /**
     * Set the Experience ID
     * @param val id value
     */
    public void setId(int val)
    {
        ExpId =val;
    }
    
    /**
     * Set the experience description
     * @param val text value
     */
    public void Gettextp(String val)
    {
        textp =val;
    }
}
