package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.LoaiBean;
import Bo.LoaiBo;

/**
 * Servlet implementation class AdminLoaiController
 */
@WebServlet("/AdminLoaiController")
public class AdminLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoaiBo lbo = new LoaiBo();
			
			String tab= request.getParameter("tab");
			String ml= request.getParameter("txtmaloai");
			String tenloai=request.getParameter("txttenloai");
			if(request.getParameter("butadd")!=null) {
				lbo.ThemLoai(ml, tenloai);
			} else if(request.getParameter("butupdate")!=null) {
				lbo.SuaLoai(ml, tenloai);
			} else {
				String maloai=request.getParameter("ml");
				if(tab!=null&&tab.equals("xoa"))
					lbo.XoaLoai(maloai);
			}

			request.setAttribute("dsloai", lbo.GetLoai());
			RequestDispatcher rd = request.getRequestDispatcher("AdminLoai.jsp");
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
