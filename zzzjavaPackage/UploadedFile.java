package javaPackage;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadedFile
 */
@WebServlet("/UploadedFile")
@MultipartConfig(maxFileSize = 65535)
public class UploadedFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadedFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getMethod());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UploadFile upload = new UploadFile();
		System.out.println("Enetered in the POST of Upload File");
		response.setContentType("text/html");
        String user = request.getParameter("user");

        Part filePart = request.getPart("fileData");
        boolean bool = upload.uploadFile(user,filePart);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        if(bool == true){
        	out.println("<h1> Welcome "+user+"</h1>");
        	out.println("<h2> Succesful </h2>");
        	System.out.println("Uploaded To DataBase");
        }
        else {
        	out.println("<h1> UnSuccesful "+"</h1>");
        	System.out.println("Unsuccesful");
        }
       // out.println("<h2> Welcome "+user+" And "+password+"</h2>");
        out.println("<h3>Hello World! Again...</h3>");
        
        out.println("</body>");
        out.println("</html>");
	}

}
/*<%
	
	UploadFile uploadFile = new UploadFile();
	System.out.println("Enetered in the POST of Uploades_Page");
  	String user = request.getParameter("user");

    Part filePart = request.getPart("fileData");
    boolean bool = uploadFile.uploadFile(user,filePart);
    pageContext.setAttribute("bool", bool);

%> */
