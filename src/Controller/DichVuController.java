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
import Bean.LoaiBean;
import Bo.DichVuBo;
import Bo.LoaiBo;

/**
 * Servlet implementation class DichVuController
 */
@WebServlet("/DichVuController")
public class DichVuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DichVuController() {
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
			ArrayList<DichVuBean> ds=dvbo.GetDichVu();
			
			String ml=request.getParameter("ml"); //get ma loai
			String key=request.getParameter("txtkey"); // get value of input
			
			if(ml!=null) {
				ds=dvbo.TimMa(ml);
				request.setAttribute("selected", ml);
			}else if(key!=null) 
				ds=dvbo.Tim(key);
			LoaiBo lbo=new LoaiBo();
			ArrayList<LoaiBean> dsloai=lbo.GetLoai();
			
			//Chuyen ve htsach.jsp: ds va dsloai
			
			request.setAttribute("dsdv", ds);
			request.setAttribute("dsloai", dsloai);
			RequestDispatcher rd = request.getRequestDispatcher("htDichVu.jsp");
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
