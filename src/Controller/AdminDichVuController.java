package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.DichVuBean;
import Bo.DichVuBo;

/**
 * Servlet implementation class AdminDichVuController
 */
@WebServlet("/AdminDichVuController")
public class AdminDichVuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDichVuController() {
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

			DichVuBo dvbo = new DichVuBo();
			
			String tab= request.getParameter("tab");
			
			String madv= request.getParameter("txtmadv");
			String tendv=request.getParameter("txttendv");
			String giaStr=request.getParameter("txtgia");
			String gioithieu=request.getParameter("txtgioithieu");
			String anh=request.getParameter("txtanh");
			String maloai=request.getParameter("txtmaloai");
			
			if(request.getParameter("butadd")!=null) {
				long gia = Long.parseLong(giaStr);
				dvbo.ThemDichVu(madv, tendv, gia, gioithieu, anh, maloai);
			} else if(request.getParameter("butupdate")!=null) {
				long gia = Long.parseLong(giaStr);
				dvbo.SuaDichVu(madv, tendv, gia, gioithieu, anh, maloai);
			} else {
				String madichvu=request.getParameter("mdv");
				if(tab!=null&&tab.equals("xoa"))
					dvbo.XoaDichVu(madichvu);
			}
			
			ArrayList<DichVuBean> ds=dvbo.GetDichVu();
			request.setAttribute("dsdichvu", ds);
			RequestDispatcher rd = request.getRequestDispatcher("AdminDichVu.jsp");
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
