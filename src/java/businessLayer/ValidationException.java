
/*
Student Name: Olamide Owolabi   
Student Number: 040982007
Course & Section #: 22S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
package businessLayer;

/**
 * Creating a custom exception class to help
 * verifying the data
 * @author Olamide
 */
public class ValidationException extends Exception {
	
            /**
 * Constructs a new ValidationException with the specified detail message and cause. 
 
 */
	public ValidationException(){
		super("Data not in valid format");
	}
	
             /**
 * Constructs a new ValidationException with the specified detail message and cause. 
 * @param message the detail message of the exception. 
 
 */
	public ValidationException(String message){
		super(message);
	}
	
        /**
 * Constructs a new ValidationException with the specified detail message and cause. 
 * @param message the detail message of the exception. 
 * @param throwable the cause of the exception. 
 */
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	
        /**
 * Constructs a new ValidationException with the d cause. 
 
 * @param throwable the cause of the exception. 
 */
	public ValidationException(Throwable throwable){
		super(throwable);
	}
}
