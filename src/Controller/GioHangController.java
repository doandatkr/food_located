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
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
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

	        String madv = request.getParameter("madv");
			String tendv = request.getParameter("tendv");
			String giatam = request.getParameter("gia");

			if(madv!=null && tendv!=null && giatam!=null){
				HttpSession session = request.getSession();
				long gia = Long.parseLong(giatam);
				GioHangBo gh = null;
				
				//Neu chua tao session("gh") thi tao ra
				if(session.getAttribute("gh")==null){
					gh = new GioHangBo();
					session.setAttribute("gh", gh);
				}
				gh = (GioHangBo)session.getAttribute("gh"); 
				gh.ThemHang(madv, tendv, gia, 1);

				session.setAttribute("gh", gh);
				session.setAttribute("sl", gh.ds.size());;
				response.sendRedirect("htGioHangController");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("htGioHangController");
				rd.forward(request, response);
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
