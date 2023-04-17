
/*
Student Name: Olamide Owolabi   
Student Number: 040982007
Course & Section #: 22S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataaccesslayer;
import java.util.List;
import transferObjects.tutorO;
import transferObjects.studentO;
import transferObjects.course;
import transferObjects.gradeO;
import transferObjects.tutorcourse;
/**
 * Am Hungry
 * The interface used for transferring data between the database and program
 * @author Olamide Owolabi
 */
public interface TutorDAO {
    
    //Get All Tutors
    /**
     * Get all tutors from database
     * @return List Tutors
     */
    List<tutorO> getAllTutors();
    
    /**
     * To get All tutors assigned in a course
     * @param Cc CourseCode enter
     * @return  List of tutors assigned
     */
    List<tutorO>getTutorsAssigned(String Cc);
    
    //Get All Student
   // List<studentO> getAllStudents();
    
    //for checking connection
    /**
     * For checking connection with database
     * @return is connected yes or no
     */
    boolean CheckConnection();
   
    //Get the error message
    /**
     * Get the error message
     * @return connection fail, here is why
     */
    String GetErrorMess();
    //get Student
    /**
     * To get the student from the database using the firstname and lastname
     * @param Fn FirstName
     * @param Ln LastName
     * @return studentO
     */
     studentO getStud(String Fn, String Ln);
    
    //get Tutor
     /**
      * Get tutor from database, using the firstname and lastname
      * @param Fn firstName
      * @param Ln LastName
      * @return grt the tutor
      */
    tutorO getTut(String Fn, String Ln);
    
    //Add Tutor
   // void AddTutor(tutorO tu);
    
    //get Course by course code
    /**
     * To get the course from the database
     * @param Cc using the coursecode
     * @return Course DTO
     */
      course getCourse(String Cc);
    
    //get course by student
   // course getCourseStud(String Std);
      
      //get grade by student and course
      /**
       * To get the Grade info from the database using the student info and coursecode
       * @param std student info
       * @param Cc coursecode
       * @return get gradepoint
       */
      gradeO gradepoint(studentO std, String Cc);
              
    
    //get Tutor Course
      /**
       * Get tutor course
       * @return  list
       */
    List<tutorcourse> tutorC();
    
    //get tutorcourse by tutorID
    /**
     * get the tutor course by using tutor ID
     * @param Id the tutor Id
     * @return get tutorcourse
     */
    tutorcourse getTutorC(int Id);
    
    //add the tutorcourse
    /**
     * To add the tutor to the teaching course in database
     * @param tc use the tutorcourse
     */
    void AddTutorCourse(tutorcourse tc);
    
    
}
