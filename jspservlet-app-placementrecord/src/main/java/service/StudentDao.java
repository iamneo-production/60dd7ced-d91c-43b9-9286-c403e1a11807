package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddStudent")
public class StudentDao extends HttpServlet {

    //create the query
	private static final String INSERT_QUERY ="INSERT INTO USERS(studentId,studentName,companyName,salaryOffered,batch) VALUES(?,?,?,?,?)";
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listStudents(request, response);
				break;
				
				
			case "LOAD":
				loadStudent(request, response);
				break;
				
			case "UPDATE":
				updateStudent(request, response);
				break;
			
			case "DELETE":
				deleteStudent(request, response);
				break;
				
			default:
				listStudents(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
					
			// route to the appropriate method
			switch (theCommand) {
							
			case "ADD":
				addStudent(request, response);
				break;
								
			default:
				listStudents(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}
	
	private void deleteStudent(HttpServletRequest req, HttpServletResponse res)
		throws Exception {

        PrintWriter pw = res.getWriter();
		//set Content type
		res.setContentType("text/hmtl");
		//read the form values
		String studentId = req.getParameter("studentId");
		//load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        String DELETE_QUERY ="DELETE FROM USERS where studentId =" + studentId ;
		//create the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbname","root","examly");
				PreparedStatement ps = con.prepareStatement(DELETE_QUERY);){
			//set the values
			
			//execute the query
			boolean count = ps.execute();
			
			if(count== true) {
				pw.println("Record deleted from Database");
			}else {
				pw.println("Record deleted from Database");
			}
		}catch(SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
		}catch(Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		
		//close the stream
		pw.close();
		
		// send them back to "list students" page
		listStudents(req, res);

	}

	private void updateStudent(HttpServletRequest req, HttpServletResponse res)
		throws Exception {

        PrintWriter pw = res.getWriter();
		//set Content type
		res.setContentType("text/hmtl");
		//read the form values
		String studentId = req.getParameter("studentId");
		String studentName = req.getParameter("studentName");
		String companyName = req.getParameter("companyName");
		String salaryOffered = req.getParameter("salaryOffered");
		String batch = req.getParameter("batch");
		//load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String UPDATE_QUERY ="update users set studentId = " + studentId +", studentName= "+studentName + ", companyName= " +companyName + ", salaryOffered= "+salaryOffered + ", batch= " +batch ;
		//create the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbname","root","examly");
				PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);){
			//set the values
			
			//execute the query
			boolean count = ps.execute();
			
			if(count== true) {
				pw.println("Record deleted from Database");
			}else {
				pw.println("Record deleted from Database");
			}
		}catch(SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
		}catch(Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		
		//close the stream
		pw.close();
		// send them back to the "list students" page
		listStudents(req, res);
		
	}

	private void loadStudent(HttpServletRequest req, HttpServletResponse res) 
		throws Exception {
            PrintWriter pw = res.getWriter();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String SELECT_QUERY ="select * from users ";
            //create the connection
            try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbname","root","examly");
                    PreparedStatement ps = con.prepareStatement(SELECT_QUERY);){
                //set the values
                
                //execute the query
                ResultSet rs = ps.executeQuery(SELECT_QUERY);
                while (rs.next()) {
                    int studentId = rs.getInt("studentId");
                    String studentName = rs.getString("studentName");
                    String companyName = rs.getString("companyName");
                    double salaryOffered = rs.getDouble("salaryOffered");
                    String batch = rs.getString("batch");
                    System.out.println(studentId + ", " + studentName + ", " + companyName +
                                       ", " + salaryOffered + ", " + batch);
                  }
            
            }catch(SQLException se) {
                pw.println(se.getMessage());
                se.printStackTrace();
            }catch(Exception e) {
                pw.println(e.getMessage());
                e.printStackTrace();
            }
            
            //close the stream
            pw.close();
				
	}

	private void addStudent(HttpServletRequest req, HttpServletResponse res) throws Exception {

		PrintWriter pw = res.getWriter();
		//set Content type
		res.setContentType("text/hmtl");
		//read the form values
		String studentId = req.getParameter("studentId");
		String studentName = req.getParameter("studentName");
		String companyName = req.getParameter("companyName");
		String salaryOffered = req.getParameter("salaryOffered");
		String batch = req.getParameter("batch");
		//load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbname","root","examly");
				PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
			//set the values
			ps.setString(1, studentId);
			ps.setString(2, studentName);
			ps.setString(3, companyName);
			ps.setString(4, salaryOffered);
            ps.setString(5, batch);
			
			//execute the query
			int count = ps.executeUpdate();
			
			if(count==0) {
				pw.println("Record not stored into database");
			}else {
				pw.println("Record Stored into Database");
			}
		}catch(SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
		}catch(Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		
		//close the stream
		pw.close();
				
		// send back to main page (the student list)
		// SEND AS REDIRECT to avoid multiple-browser reload issue
		res.sendRedirect(req.getContextPath() + "/StudentDao?command=LIST");
	}

	private void listStudents(HttpServletRequest req, HttpServletResponse res) 
		throws Exception {
            PrintWriter pw = res.getWriter();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String SELECT_QUERY ="select * from users ";
            //create the connection
            try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbname","root","examly");
                    PreparedStatement ps = con.prepareStatement(SELECT_QUERY);){
                //set the values
                
                //execute the query
                ResultSet rs = ps.executeQuery(SELECT_QUERY);
                while (rs.next()) {
                    int studentId = rs.getInt("studentId");
                    String studentName = rs.getString("studentName");
                    String companyName = rs.getString("companyName");
                    double salaryOffered = rs.getDouble("salaryOffered");
                    String batch = rs.getString("batch");
                    System.out.println(studentId + ", " + studentName + ", " + companyName +
                                       ", " + salaryOffered + ", " + batch);
                  }
            
            }catch(SQLException se) {
                pw.println(se.getMessage());
                se.printStackTrace();
            }catch(Exception e) {
                pw.println(e.getMessage());
                e.printStackTrace();
            }
            
            //close the stream
            pw.close();
				
	}
}
