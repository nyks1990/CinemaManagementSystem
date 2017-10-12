import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.*;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class RoomServlet
 */
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection conn1 = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServlet() {
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
	    int RoomId = randomGenerator.nextInt(100000000);
		String RoomName=request.getParameter("RoomName");
		int Capacity=Integer.parseInt(request.getParameter("Capacity"));
		int FloorNo=Integer.parseInt(request.getParameter("FloorNo"));
		//String Gender=request.getParameter("Gender");
		//String Address=request.getParameter("Address");
		
		 out.println(RoomId +"  "+RoomName+" "+Capacity+" "+FloorNo);
		 
		
		 String insertShowingSQL = "INSERT INTO ROOM"
					+ "(ROOMID,ROOMNAME,CAPACITY,FLOORNO) VALUES"
					+ "(?,?,?,?)";
		 PreparedStatement preparedStatement = null;
		
		        try {
		        	preparedStatement = conn1.prepareStatement(insertShowingSQL);
					preparedStatement.setInt(1, RoomId);
					preparedStatement.setString(2, RoomName);
					preparedStatement.setInt(3, Capacity);
					preparedStatement.setInt(4,FloorNo);
					
					
					// execute insert SQL stetement
					preparedStatement.executeUpdate();
		        	
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
	}
}
