import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexServelet
 */
public class indexServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection conn1 = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

    boolean getConnection()
    {
    	 //conn1 = null;
	        
 		try 
 		{
 			   Class.forName("oracle.jdbc.driver.OracleDriver");
 		}
 			catch(ClassNotFoundException ex) 
 		    {
 			   System.out.println("Error: unable to load driver class!");
 			   System.exit(1);
 			}
 		String URL = "jdbc:oracle:thin:mpatekar/YCsBUo3.uK3Y@fourier.cs.iit.edu:1521:orcl";
 		String USER = "mpatekar";
 		String PASS = "YCsBUo3.uK3Y";
 		try {
 			 conn1 = DriverManager.getConnection(URL, USER, PASS);
 		    } 
 		catch (SQLException e) 
 		{
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		finally
 		{
 			  try {
 	                if (conn1 != null && !conn1.isClosed())
 	                {
 	                    //conn1.close();
 	                    System.out.println("Connection Established");
 	                    return true;
 	                }
 			      }
 			  catch (SQLException ex) 
 			  {
 	                ex.printStackTrace();
 	          }
 	    } 
return false;

    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String mit="miesh";
		//request.setAttribute("data",mit);

		  //Disptching request

	//	RequestDispatcher view = getServletContext().getRequestDispatcher("/Admin.jsp");   
		//view.forward(request,response); 

		boolean flag=getConnection();
		 PrintWriter out = response.getWriter();
		if(flag==true)
		{
			out.println("connection established");
		}
		else
		{
			out.println("no connection established");
		}
		
		Random randomGenerator = new Random();    
	    int MovieId = randomGenerator.nextInt(100000000);
		String MovieTitle=request.getParameter("MovieTittle");
		float len=Integer.parseInt(request.getParameter("MovieLength"));
		String Rating=request.getParameter("Rating");
		String Genre=request.getParameter("Genre");
		int Year=Integer.parseInt(request.getParameter("Year"));
		
		 out.println(MovieTitle +"   "+len+" "+Rating+" "+Genre+" "+Year );
		 
		 String SQLCommand = "INSERT INTO MOVIES "
			        + "(movieID,title,pgRating,length,genre,releaseYear) " + "VALUES "
			        + "("+MovieId+",'"+MovieTitle+"','"+Rating+"','"+len+"','"+Genre+"',"+Year+")";
		 			   
		        try {
					
					 Statement stmt = conn1.createStatement();
					    stmt.execute(SQLCommand);
					conn1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mit="miesh";
		request.setAttribute("data",mit);

		  //Disptching request

		RequestDispatcher view = getServletContext().getRequestDispatcher("/Admin.jsp");   
		view.forward(request,response); 
	}

}
