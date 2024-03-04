package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KhachHangBean;
import Bo.KhachHangBo;

/**
 * Servlet implementation class AdminDangNhapController
 */
@WebServlet("/AdminDangNhapController")
public class AdminDangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
	   		String un = request.getParameter("txtun");
	   		String pass = request.getParameter("txtpass");
   			KhachHangBo khbo = new KhachHangBo();
	   		if(un==null && pass==null) {
	   			RequestDispatcher rd = request.getRequestDispatcher("AdminDangNhap.jsp");
	   			rd.forward(request, response);
	   		} else {
	   			if(un.equals("admin") && pass.equals("123")) {	//ok
	   				HttpSession session = request.getSession();	
	   				session.setAttribute("dn", 1);
	   				response.sendRedirect("AdminXacNhanController");
	   			} else {	//ok
	   				request.setAttribute("kt", 1);
	   				RequestDispatcher rd = request.getRequestDispatcher("AdminDangNhap.jsp");
	   				rd.forward(request, response);
	   			}
	   		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
