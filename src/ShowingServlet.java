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
 * Servlet implementation class indexServelet
 */
public class ShowingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection conn1 = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowingServlet() {
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
		
		String showDateStr = request.getParameter("ShowDate");
	    java.util.Date date=null;
	  //  SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //date = format.parse(dateDOB);
      //  java.sql.Date sql = new java.sql.Date(parsed.getTime());
	    try {
			 date = new SimpleDateFormat("MM/dd/yyyy").parse(showDateStr);
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    out.println("new date"+sqlDate.toString());
		
	    Random randomGenerator = new Random();    
	    int ShowingId = randomGenerator.nextInt(100000000);
		int MovieId=Integer.parseInt(request.getParameter("MovieId"));
		int RoomId=Integer.parseInt(request.getParameter("RoomId"));
		float ShowTime=Float.parseFloat(request.getParameter("ShowTime"));
		//String Gender=request.getParameter("Gender");
		//String Address=request.getParameter("Address");
		
		 out.println(ShowingId +"  "+MovieId+" "+RoomId+" "+ShowTime);
		 
		
		 String insertShowingSQL = "INSERT INTO SHOWING"
					+ "(SHOWINGID,MOVIEID,ROOMID,MOVIEDATE,MOVIETIME) VALUES"
					+ "(?,?,?,?,?)";
		 PreparedStatement preparedStatement = null;
		
		        try {
		        	preparedStatement = conn1.prepareStatement(insertShowingSQL);
					preparedStatement.setInt(1, ShowingId);
					preparedStatement.setInt(2, MovieId);
					preparedStatement.setInt(3, RoomId);
					preparedStatement.setDate(4,sqlDate);
					preparedStatement.setFloat(5, ShowTime);
					
					// execute insert SQL stetement
					preparedStatement.executeUpdate();
		        	
					//Statement stmt = conn1.createStatement();
					//stmt.execute(SQLCommandType);
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
