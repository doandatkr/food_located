package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ThongKeBean;
import Bo.ThongKeBo;

/**
 * Servlet implementation class AdminThongKeController
 */
@WebServlet("/AdminThongKeController")
public class AdminThongKeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminThongKeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ThongKeBo tkBo = new ThongKeBo();
			ArrayList<ThongKeBean> ds = new ArrayList<ThongKeBean>();
			
			String tungay = request.getParameter("tungay");
			String denngay = request.getParameter("denngay");
			long tong = 0;
			ds = tkBo.GetThongKe();
			tong = tkBo.TongThongKe();
			if(tungay!=null && denngay!=null) {
				ds = tkBo.GetThongKeChon(tungay, denngay);
				tong = tkBo.TongThongKeChon(tungay, denngay);
			}
			request.setAttribute("dsthongke", ds);
			request.setAttribute("tong", tong);
			RequestDispatcher rd = request.getRequestDispatcher("AdminThongKe.jsp");
			rd.forward(request, response);
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
