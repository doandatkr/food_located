package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.GioHangBean;
import Bean.KhachHangBean;
import Bo.ChiTietBo;
import Bo.GioHangBo;
import Bo.HoaDonBo;

/**
 * Servlet implementation class XacNhanController
 */
@WebServlet("/XacNhanController")
public class XacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			KhachHangBean kh = (KhachHangBean)session.getAttribute("dn");
			if(kh==null) {
				RequestDispatcher rd = request.getRequestDispatcher("DangNhap.jsp");
				rd.forward(request, response);
			} else {
				GioHangBo gh=(GioHangBo)session.getAttribute("gh");
				if(gh!=null) { 
					//Tao 1 hoa don
					HoaDonBo hdbo=new HoaDonBo();
					hdbo.Them(kh.getMakh());
					long mahd=hdbo.GetMaxHD();
					//Duyet gio de luu vao cthoadon
					ChiTietBo ctbo=new ChiTietBo();
					for(GioHangBean g : gh.ds) 
						ctbo.Them(g.getMadv(), g.getSoluongmua(), mahd);
					//xoa gio hang
					session.removeAttribute("gh");
					request.setAttribute("mahd", mahd);
					RequestDispatcher rd = request.getRequestDispatcher("ThanhToan.jsp");
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
