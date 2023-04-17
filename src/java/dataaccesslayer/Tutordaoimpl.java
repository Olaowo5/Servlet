

/*
Student Name: Olamide Owolabi   
Student Number: 040982007
Course & Section #: 22S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;


import java.util.List;
import transferObjects.tutorO;
import transferObjects.studentO;
import transferObjects.course;
import transferObjects.gradeO;
import transferObjects.tutorcourse;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;


/**
 * To Implement the TutorDAO interface
 * Why so many, why
 * @author Olamide Owolabi
 */
public class Tutordaoimpl implements TutorDAO{
    
    
    private String UserId;
    private String Pwd;
    private Boolean ErrorProb;
    private String ErrorMess;
    
    /**
     * Empty constructor
     */
    public Tutordaoimpl()
    {
        
    }
    
    /**
     * Constructor to pass the username and password
     * @param U the username
     * @param pwd Password entered
     */
      public Tutordaoimpl(String U, String pwd)
    {
        UserId =U; Pwd =pwd;
    }
      
       /**
     * For checking connection with database
     * @return is connected yes or no
     */
      @Override
      public boolean CheckConnection()
      {
          ErrorProb = false;
            Connection con = null;
          DataSource ds = new DataSource();
          con = ds.createConnection(UserId,Pwd);
          
          String Mess = ds.GetMessage();
          
          if(Mess.contains("Error"))
          {
              ErrorProb = true;
              ErrorMess = Mess;
          }
          
          try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
                                

          
          return !ErrorProb;
      }
      
       /**
     * Get the error message
     * @return connection fail, here is why
     */
      @Override
      public String GetErrorMess()
      {
      return ErrorMess;
      }
    
    //Get All Tutors
    /**
     * Get all tutors from database
     * @return List Tutors
     */
      @Override
    public List<tutorO> getAllTutors(){
    
        Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
                ArrayList<tutorO> tutoro = null;
                
                try{
                    DataSource ds = new DataSource();
                    con = ds.createConnection(UserId,Pwd);
                    
                    pstmt = con.prepareStatement(
					"SELECT * FROM tutor ORDER BY TutorID");
			rs = pstmt.executeQuery();
			tutoro = new ArrayList<tutorO>();
			while(rs.next()){
				tutorO toto = new tutorO();
                                toto.SetId(new Integer(rs.getInt("TutorID") ));
                                toto.SetFName(rs.getString("FirstName"));
                                toto.SetLName(rs.getString("LastName"));
                                toto.SetEm(rs.getString("Email"));
                                toto.SetStat(rs.getString("Status"));
                                toto.SetPhone(rs.getString("PhoneNumber"));
                                toto.SetExpId(new Integer(rs.getInt("experience_ExperienceID")));
                            
                                
				tutoro.add(toto);
                                        }
                    }
                        catch(SQLException e)
                                {
                                e.printStackTrace();
                                }
                        finally{
                                
                                try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
                                }
                                return tutoro;
                    
                }
    
     /**
     * To get All tutors assigned in a course
     * @param Cc CourseCode enter
     * @return  List of tutors assigned
     */
    @Override
    public List<tutorO> getTutorsAssigned(String Cc)
    {
      Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
                ArrayList<tutorO> tutoro = null;
                
                try{
                    DataSource ds = new DataSource();
                    con = ds.createConnection(UserId,Pwd);
                    
                    pstmt = con.prepareStatement(
					"SELECT * FROM tutor t1 "
                                                + "INNER JOIN tutorcourse t2 "
                                                + "ON"
                                                + " t1.TutorID = t2.tutor_TutorID "
                                                + "ORDER BY t1.TutorID");
			rs = pstmt.executeQuery();
			tutoro = new ArrayList<tutorO>();
			while(rs.next()){
				tutorO toto = new tutorO();
                                toto.SetId(new Integer(rs.getInt("TutorID") ));
                                toto.SetFName(rs.getString("FirstName"));
                                toto.SetLName(rs.getString("LastName"));
                                toto.SetEm(rs.getString("Email"));
                                toto.SetStat(rs.getString("Status"));
                                toto.SetPhone(rs.getString("PhoneNumber"));
                                toto.SetExpId(new Integer(rs.getInt("experience_ExperienceID")));
                            
                                
				tutoro.add(toto);
                                        }
                    }
                        catch(SQLException e)
                                {
                                e.printStackTrace();
                                }
                        finally{
                                
                                try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
                                }
                                return tutoro;   
    }
   
    /**
      * Get tutor from database, using the firstname and lastname
      * @param Fn firstName
      * @param Ln LastName
      * @return grt the tutor
      */
    @Override
    public tutorO getTut(String Fn, String Ln){
    
         Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        tutorO tut = new tutorO();
        
        try{
             DataSource ds = new DataSource();
             con = ds.createConnection(UserId,Pwd);
             pstmt = con.prepareStatement("SELECT * FROM tutor  WHERE FirstName = ?  AND LastName = ?");
             
              pstmt.setString(1, Fn);
               pstmt.setString(2, Ln);
             rs = pstmt.executeQuery();
             
             while(rs.next()){
             tut.SetId(new Integer(rs.getInt("TutorID")));
             tut.SetEm(rs.getString("Email"));
             tut.SetFName(rs.getString("FirstName"));
             tut.SetLName(rs.getString("LastName"));
             tut.SetExpId(new Integer(rs.getInt("experience_ExperienceID")));
             tut.SetPhone(rs.getString("PhoneNumber"));
             tut.SetStat(rs.getString("Status"));
             }
        }
      catch(SQLException e){
				e.printStackTrace();
			}
        finally{
            
            try{ if(pstmt != null){ pstmt.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
				try{ if(con != null){ con.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        
        
        return tut;
    
    }
            
     /**
       * Get tutor course
       * @return  list
       */
    @Override
    public List<tutorcourse> tutorC(){
    
            
             Connection con = null;
        PreparedStatement pstmt = null;
		ResultSet rs = null;
                ArrayList<tutorcourse> toroco = null;
                
                try{
                    DataSource ds = new DataSource();
                    con = ds.createConnection(UserId,Pwd);
                    
                    pstmt = con.prepareStatement(
					"SELECT * FROM tutorcourse ORDER BY tutor_TutorID");
			rs = pstmt.executeQuery();
			toroco = new ArrayList<tutorcourse>();
			while(rs.next()){
				tutorcourse toto = new tutorcourse();
                                toto.SetId(new Integer(rs.getInt("tutor_TutorID") ));
                                toto.SetCode(rs.getString("course_CourseCode"));
                                
                               
                            
                                
				toroco.add(toto);
                                        }
                    }
                        catch(SQLException e)
                                {
                                e.printStackTrace();
                                }
                        finally{
                                
                                try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
                                }
                                return toroco;
    }
    
     //get tutorcourse by tutorID
    @Override
   public  tutorcourse getTutorC(int Id)
   {
   
         Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        tutorcourse tut = new tutorcourse();
        
        try{
             DataSource ds = new DataSource();
             con = ds.createConnection(UserId,Pwd);
             pstmt = con.prepareStatement("SELECT * FROM tutorcourse WHERE tutor_TutorID = ?");
             pstmt.setInt(1,Id);
             
             rs = pstmt.executeQuery();
             
             while(rs.next()){
             tut.SetId(new Integer(rs.getInt("tutor_TutorID") ));
             tut.SetCode(rs.getString("course_CourseCode"));
             }
             
        }
      catch(SQLException e){
				e.printStackTrace();
			}
        finally{
            
            try{ if(pstmt != null){ pstmt.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
				try{ if(con != null){ con.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        
        
        return tut;
   
   }
   
     /**
     * To add the tutor to the teaching course in database
     * @param tc use the tutorcourse
     */
   @Override
   public void AddTutorCourse(tutorcourse tc)
   {
   
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        
        try{
			DataSource ds = new DataSource();
			con = ds.createConnection(UserId,Pwd);
			// do not insert AuthorID, it is generated by Database
			pstmt = con.prepareStatement(
					"INSERT INTO tutorcourse (tutor_TutorID, course_CourseCode)" +
			        "VALUES(?, ?)");
			pstmt.setInt(1, tc.GetId());
			pstmt.setString(2, tc.GetCode());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
   }
   
   /**
     * To get the course from the database
     * @param Cc using the coursecode
     * @return Course DTO
     */
   @Override
   public course getCourse(String Cc)
   {
         Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
         course cc = null;
        
        try{
             DataSource ds = new DataSource();
             con = ds.createConnection(UserId,Pwd);
             pstmt = con.prepareStatement("SELECT * FROM course Where CourseCode = ?");
             
             pstmt.setString(1, Cc);
             rs = pstmt.executeQuery();
              cc = new course();
             
              while(rs.next()){
                  
             cc.SetCode(rs.getString("CourseCode"));
             cc.SetName(rs.getString("CourseName"));
             cc.SetDesc(rs.getString("CourseDescription"));
              }
            
             
        }
      catch(SQLException e){
				e.printStackTrace();
			}
        finally{
            
            try{ if(pstmt != null){ pstmt.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
				try{ if(con != null){ con.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        
        
        return cc;
   }
   
   //check if their student
   /**
     * To get the student from the database using the firstname and lastname
     * @param Fn FirstName
     * @param Ln LastName
     * @return studentO
     */
   public studentO getStud(String Fn, String Ln)
   {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
         studentO std = null;
        
        try{
             DataSource ds = new DataSource();
             con = ds.createConnection(UserId,Pwd);
             pstmt = con.prepareStatement("SELECT * FROM student WHERE LastName = ? AND FirstName = ? ");
             pstmt.setString(1,Ln);
             pstmt.setString(2, Fn);
             rs = pstmt.executeQuery();
             
             while(rs.next()){
              std = new studentO();
             
              std.SetId(new Integer(rs.getInt("StudentID") ));
              std.SetFName(rs.getString("FirstName"));
              std.SetLName(rs.getString("LastName"));
              std.SetEmail(rs.getString("Email"));
              std.SetNum(rs.getString("PhoneNumber"));
             
             }
            
             
        }
      catch(SQLException e){
				e.printStackTrace();
			}
        finally{
            
            try{ if(pstmt != null){ pstmt.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
				try{ if(con != null){ con.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        
        
        return std;
   }
   
     /**
       * To get the Grade info from the database using the student info and coursecode
       * @param std student info
       * @param Cc coursecode
       * @return get gradepoint
       */
   public gradeO gradepoint(studentO std, String Cc)
   {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
         gradeO gd = null;
        
        try{
             DataSource ds = new DataSource();
             con = ds.createConnection(UserId,Pwd);
             pstmt = con.prepareStatement("SELECT * FROM grade WHERE student_StudentID = ? AND course_CourseCode = ?");
             pstmt.setInt(1, std.GetId());
             pstmt.setString(2,Cc);
             
             rs = pstmt.executeQuery();
              gd = new gradeO();
              while(rs.next()){
              gd.SetStud(new Integer(rs.getInt("student_StudentID")));
             gd.SetGrade(rs.getString("GradeCode"));
             gd.SetCCode(rs.getString("course_CourseCode"));
              }
             
            
            
             
        }
      catch(SQLException e){
				e.printStackTrace();
			}
        finally{
            
            try{ if(pstmt != null){ pstmt.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
				try{ if(con != null){ con.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        
        
        return gd;
   }
 }

