/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package viewLayer;

import businessLayer.ValidationException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.tutorBusinessLogic;
//import businessLayer.ValidationException;
import transferObjects.tutorcourse;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferObjects.tutorO;

/*
Student Name: Olamide Owolabi   
Student Number: 040982007
Course & Section #: 22S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
/**
 * The serverlet print out the html
 * @author Olamide Owolabi
 */
public class ViewTutor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tutors Teaching Course|OWO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Olamide TutorView at " + request.getContextPath() + "</h1>");
           
            
            //get username and Password
            String Usern = (String)request.getParameter("username");
            String Passw = (String)request.getParameter("pwd");
            
             tutorBusinessLogic logic = new tutorBusinessLogic(Usern,Passw);
             
            
             
         if(logic.CheckConnection())
          {
             String Fname = (String)request.getParameter("firstname");
             String Lname = (String)request.getParameter("lastname");
             String Ccode = (String)request.getParameter("coursecode");
             
             
             logic.OlaAction(Fname, Lname, Ccode);
             
             if(logic.OlaStats())
             {
                 //its passed draw table
                   out.println("<div>");
                    out.printf("Table of Tutors for %s",Ccode);
                    out.println("</div>");
                 List<tutorO> Tc = logic.getTutorAss(Ccode);
                  out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>TutorID</td>");
            out.println("<td>First Name</td>");
            out.println("<td>Last Name</td>");
            out.println("</tr>");
            for(tutorO toro : Tc){
                out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                    toro.GetId(), toro.GetFName(), toro.GetLName());
            }
              out.println("</table>");
             }
          }
         else
         {
             out.printf("<div>Error with connection: %s</div>",logic.ErrorMessage());
         }
             out.println("<br>");
             out.printf("<div> %s</div>",logic.OlaMessage());
            out.println("</body>");
            out.println("</html>");
        } catch (ValidationException ex) {
            Logger.getLogger(ViewTutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
