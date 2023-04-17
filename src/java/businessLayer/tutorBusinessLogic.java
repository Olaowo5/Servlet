/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessLayer;
import java.util.List;
import dataaccesslayer.TutorDAO;
import dataaccesslayer.Tutordaoimpl;

import transferObjects.tutorO;
import transferObjects.tutorcourse;
import transferObjects.course;
import transferObjects.studentO;
import transferObjects.gradeO;

/*
Student Name: Olamide Owolabi   
Student Number: 040982007
Course & Section #: 22S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
/**
 * tutorBusinessLogic
 * Buts all the item together
 * @author Olamide Owolabi
 */
public class tutorBusinessLogic {
    
    
    private TutorDAO pidgey = null;
    private studentO stdu =null;
    private tutorO tut = null;
    private String CourseCode = "";
    
    private String Userd, Pwd;
    final private String ComputerEssential = "CST8101";
    private String PlayerMessage;
    protected boolean Ispassed;
    
    private static final int FIRST_NAME_MAX_LENGTH = 20;
	private static final int COURSE_MAX_LENGTH = 9;
    
        /**
         * Empty constructor
         */
    public tutorBusinessLogic()
    {
        pidgey = new Tutordaoimpl();
        tut =null;
      //  pidgey =null;
        stdu = null;
        CourseCode = "";
        Ispassed = false;
    }
    
    /**
     * Constructor, Sending the login credentials for the database
     * @param Usr Username
     * @param Pwd Password
     */
    public tutorBusinessLogic(String Usr, String Pwd)
    {
        Userd =Usr; this.Pwd = Pwd;
        
        pidgey = new Tutordaoimpl(Usr,Pwd);
        tut =null;
      //  pidgey =null;
        stdu = null;
        CourseCode = "";
        Ispassed = false;
        
    }
 
    /**
     * To check if there is connection to the database
     * @return connection status
     */
    public boolean CheckConnection()
    {
        if(pidgey == null)
            System.out.println ("No otto");
            
        return pidgey.CheckConnection();
    }
    
    /**
     * To display error message, when connection fail
     * @return connection error
     */
    public String ErrorMessage()
    {
        return pidgey.GetErrorMess();
    }
    
    /**
     * Handles the code function, the table and all that jazz, gets the details from the form outside of username and password
     * @param Fn The FirstName 
     * @param Ln The last Name
     * @param Cc The Course Code
     * @throws ValidationException no idea what this is
     */
    public void OlaAction(String Fn, String Ln, String Cc) throws ValidationException
    {
        //Vallidate names
        validateString(Fn, "FirstName",FIRST_NAME_MAX_LENGTH,false);
        validateString(Ln, "LastName",FIRST_NAME_MAX_LENGTH,false);
        validateString(Cc, "CourseCode",COURSE_MAX_LENGTH,false);
    
        CourseCode = Cc;
         //check course exists
        boolean CheckC = CheckCourse(Cc);
        
        if(!CheckC)
        {
            PlayerMessage = "Course Does not exists :" + Cc;
            return;
        }
    
        //Check Tutor
        boolean TutorHere = TutorAvailable(Fn,Ln);
        
        if(!TutorHere)
        {
            PlayerMessage = Fn +" " + Ln+ " Is not register has a Tutor here :C";
            return;
        }
        
        //CheckTutor is already a tutor here in the course
        
        boolean Tutoralready = CheckTutor();
        
        if(Tutoralready)
        {
            //draw table
            PlayerMessage = Fn + " "+ Ln+ " "+ "is already registered as a Tutor";
            Ispassed = true;
            return;
        }
        
        
        //Bool check if their a student
        boolean IsStudent = CheckStudent();
        
        if(!IsStudent)
        {
            PlayerMessage = Fn + " "+ Ln+ " "+ "is not a registered Student";
            return;
        }
        
        String TutorResult = CheckTutorII();
        
        
        if(TutorResult == "Pass")
        {
            PlayerMessage = Fn + " Has passed and is now tutoring the course";
            //pass add
            AddTutor();
            
            Ispassed = true;
        }
        else if(TutorResult == "Fail")
        {
            PlayerMessage = Fn + " does not qualify to tutor this course as the obtained grade is not sufficient";
        }
        else{
            
            PlayerMessage = Fn+" "+ "Not qualifed cause hasnt taken the course";
        }
    }
    
    //will be used to determing if the call for teacher tutor passed
    /**
     * Used to determine if the person entered is a tutor or student
     * @return Is the person a student/ tutor
     */
    public boolean OlaStats()
    {
        return Ispassed;
    }
    
    /**
     * Display the message, we get from stuff
     * @return the message info on how it went
     */
    public String OlaMessage()
    {
        return PlayerMessage;
    }
    //first get tutor, check if he is available
    /**
     * Use to check if the person enter is a tutor
     * @param Fn FIrstName
     * @param Ln LastName
     * @return the person a tutor yes or no
     */
    public boolean TutorAvailable(String Fn, String Ln)
    {
        boolean HasTutor = false;
        
         tut = pidgey.getTut(Fn, Ln);
        
        if(tut != null)   
        {
            if(tut.GetId() != 0)
             HasTutor = true;
        }
        
       
        
        return HasTutor;
    }
    
    /**
     * To check if the tutor is already tutoring the course entered
     * @return is already tutoring status
     */
        public boolean CheckTutor()
    {
       boolean TeachingAlready = false;
       
       int Tid = tut.GetId();
       
       tutorcourse Tc = pidgey.getTutorC(Tid);
       
       if(Tc == null){System.out.println("Null tutorcourse");}
       else
           System.out.println("Dude " + Tc.GetCode());
       
       
       if(Tc == null)
       {
           return TeachingAlready;
       }
       else if(Tc.GetCode() == null)
       {
           return TeachingAlready;
       }
       else if( Tc.GetCode().equals(CourseCode))
       {
           TeachingAlready = true;
       }
       
       return TeachingAlready;
    }
    
    /**
     * Orignally used to make only Computer essential course is entered
     * currently not in use
     * @return Is Computer essential used?
     */
    public boolean ComputerEssOnly()
    {
        boolean isComputer = true;
        
        if(CourseCode != ComputerEssential)
        {
            isComputer = false;
        }
        
        return isComputer;
    }
    
    /**
     * Used to check if the tutor is qualified for the course
     * @return return decision
     */
    public String CheckTutorII()
    {
        String QualifyMess = "";
        
        gradeO gd = pidgey.gradepoint(stdu,CourseCode);
        
        String GradeP = "";
        if(gd == null)
        {
            GradeP = "N/A";
           
        }
        else if(gd.getGrade() == null)
        {
            GradeP = "N/A";
        }
        else
        {
            GradeP = gd.getGrade();
        }
        
        
        
        switch (GradeP){
            case "A":
            {
                QualifyMess = "Pass";
                break;
            }
            case "A-":
            {
                         QualifyMess = "Pass";
                        break;
            }
            
            case "A+":
            {
                 QualifyMess = "Pass";
                break;
            }
            case "N/A":
            {
                 QualifyMess = "Not In Course";
                break;
            }
            default:{
                QualifyMess = "Fail";
                break;
            }
    }
        
       
        
        return QualifyMess;
    }
    
    /**
     * To check if the person entered is a student
     * @return Is Student,
     */
    public boolean CheckStudent()
    {
        boolean IsStud = false;
        
        stdu = pidgey.getStud(tut.GetFName(), tut.GetLName());
        
        if(stdu != null)
        {
            if(stdu.GetId() > 0)
            IsStud = true;
        }
        
        return IsStud;
    }
    
    /**
     * To add the person to the tutor experience database or close enough
     * anyway the person pass qualification and is now a tutor, Hoozah
     */
    public void AddTutor()
    {
        tutorcourse otto = new tutorcourse();
        
        otto.SetId(tut.GetId());
        otto.SetCode(CourseCode);
        pidgey.AddTutorCourse(otto);
    }
    
    
   /**
    * To check if course entered exists
    * @param Cc CourseCode from form
    * @return  course exists or not
    */
    public boolean CheckCourse(String Cc)
    {
        boolean courseIsHere = false;
        
        course cc = pidgey.getCourse(Cc);
        
        if(cc != null){
        
            if(cc.GetCode() != null)
                  courseIsHere = true;
        }
          
        
        return courseIsHere;
    }
    
    /**
     * To get all the tutors from the database
     * @return gets the DTO of tutors
     */
    public List<tutorO> getTutors()
    {
            return pidgey.getAllTutors();
    }
    
    /**
     * Gets only the tutors assigned from the coursecode
     * @param Cc CourseCode
     * @return DTO
     */
    public List<tutorO> getTutorAss(String Cc)
    {
        return pidgey.getTutorsAssigned(Cc);
    }
    /**
     * Get the tutorcourse
     * @return tutorcourse
     */
    public List<tutorcourse> getTutorCourse()
    {
        return pidgey.tutorC();
    }
    
    /**
     * For validating the string, to make sure no error or blank space
     * @param value the stuff passed through
     * @param fieldName the field
     * @param maxLength max lenegth
     * @param isNullAllowed if null is allowed
     * @throws ValidationException 
     */
   	private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}
}
