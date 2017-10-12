

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoomServlet1
 */
public class RoomServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		 Random randomGenerator = new Random();    
		    int RoomId = randomGenerator.nextInt(100000000);
			String RoomName=request.getParameter("RoomName");
			int Capacity=Integer.parseInt(request.getParameter("Capacity"));
			int FloorNo=Integer.parseInt(request.getParameter("FloorNo"));
			//String Gender=request.getParameter("Gender");
			//String Address=request.getParameter("Address");
			
			 out.println(RoomId +"  "+RoomName+" "+Capacity+" "+FloorNo);
			 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
