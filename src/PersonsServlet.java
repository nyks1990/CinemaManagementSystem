

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
public class PersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection conn1 = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonsServlet() {
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
		
		String dateDOB = request.getParameter("DOB");
	    java.util.Date date=null;
	  //  SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //date = format.parse(dateDOB);
      //  java.sql.Date sql = new java.sql.Date(parsed.getTime());
	    try {
			 date = new SimpleDateFormat("MM/dd/yyyy").parse(dateDOB);
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    out.println("new date"+sqlDate.toString());
		
	    Random randomGenerator = new Random();    
	    int PersonId = randomGenerator.nextInt(100000000);
		String PersonName=request.getParameter("Name");
		//Date len=Integer.parseInt(request.getParameter("DOB"));
		String email=request.getParameter("EmailID");
		String Gender=request.getParameter("Gender");
		String Address=request.getParameter("Address");
		
		 out.println(PersonName +"   "+email+" "+Gender+" "+Address);
		 
		// String SQLCommand = "INSERT INTO MOVIES "
			//        + "(movieID,title,pgRating,length,genre,releaseYear) " + "VALUES "
			  //      + "("+MovieId+",'"+MovieTitle+"','"+Rating+"','"+len+"','"+Genre+"',"+Year+")";
		 
		// String SQLCommand = "INSERT INTO PERSON "
			//        + "(PERSONID,NAME,GENDER,EMAILID,ADDRESS) " + "VALUES "
			  //      + "("+PersonId+",'"+PersonName+"',"+ to_date("'06/06/2006'", "'mm/dd/yyyy'")+",'"+Gender+"','"+email+"','"+Address+"')";
			   // String url = "jdbc:odbc:Contacts";
		 String insertTableSQL = "INSERT INTO PERSON"
					+ "(PERSONID,NAME,DATEOFBIRTH,GENDER,EMAILID,ADDRESS) VALUES"
					+ "(?,?,?,?,?,?)";
		 String SQLCommandType=null;
		 String PersonType=request.getParameter("Type");
		 out.println("person type"+PersonType);
		 
		 if(PersonType.equals("Actor"))
		 {
		 SQLCommandType = "INSERT INTO ACTOR "
			        + "(ACTORID,PERSONID) " + "VALUES "
			        + "("+randomGenerator.nextInt(100000000)+","+PersonId+")";
		 }
		 if(PersonType.equals("Director"))
		 {
		 SQLCommandType = "INSERT INTO DIRECTOR "
			        + "(DIRECTORID,PERSONID) " + "VALUES "
			        + "("+randomGenerator.nextInt(100000000)+","+PersonId+")";
		 }
		 if(PersonType.equals("Writer"))
		 {
		 SQLCommandType = "INSERT INTO WRITER "
			        + "(WRITERID,PERSONID) " + "VALUES "
			        + "("+randomGenerator.nextInt(100000000)+","+PersonId+")";
		 }
		 
		 PreparedStatement preparedStatement = null;
		
		        try {
		        	preparedStatement = conn1.prepareStatement(insertTableSQL);
					preparedStatement.setInt(1, PersonId);
					preparedStatement.setString(2, PersonName);
					preparedStatement.setDate(3, sqlDate);
					preparedStatement.setString(4, Gender);
					preparedStatement.setString(5, email);
					preparedStatement.setString(6, Address);
					// execute insert SQL stetement
					preparedStatement.executeUpdate();
		        	
					Statement stmt = conn1.createStatement();
					stmt.execute(SQLCommandType);
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
