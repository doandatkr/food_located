package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.GioHangBo;

/**
 * Servlet implementation class SuaHangController
 */
@WebServlet("/SuaHangController")
public class SuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String madv = request.getParameter("madv");
		String sl = request.getParameter("txtsl");
		//Luu Session ra bien
		GioHangBo gh = (GioHangBo)session.getAttribute("gh");
		//Sua lai so luong
		long soluong = Long.parseLong(sl);
		if(soluong>0)
			gh.Sua(madv, soluong);
		//Luu bien vao session
		session.setAttribute("gh", gh);
		//Quay ve trang htgio.jsp
		RequestDispatcher rd = request.getRequestDispatcher("htGioHangController");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
