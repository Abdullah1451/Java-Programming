package javaPackage;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadingFile
 */
@WebServlet("/UploadingFile")
public class UploadingFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadingFile() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Enetered in the Service");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        String form="<form action=\"UploadedFile\" method=\"POST\" enctype=\"multipart/form-data\" />"+
        			"<div><input type=\"text\" id=\"username\" placeholder=\"name@example.com\" name=\"user\" ></div>"+
        			"<br>"+
        			"<div><input type=\"password\" id=\"pword\" placeholder=\".....\" name=\"password\" ></div>"+
        			"<br>"+
        			"<div><input type=\"file\" id=\"file\"  name=\"Fname\" ></div>"+
        			"<br>"+
        			"<div><button type=\"submit\" >Submit</button></div>"+
        			"</form>";
        out.println(form);
        out.println("</body>");
        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath())
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
