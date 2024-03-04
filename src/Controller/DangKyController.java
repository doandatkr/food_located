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
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
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
			String name = request.getParameter("txtname");
			String phone = request.getParameter("txtphone");
			String address = request.getParameter("txtaddress");
	   		String un = request.getParameter("txtun");
	   		String pass = request.getParameter("txtpass");
	   		String rpass = request.getParameter("txtrepeatpass");
   			KhachHangBo khbo = new KhachHangBo();
   			
	   		if(name == null || phone == null || address == null || un == null || pass == null || rpass == null || 
	   		name.equals("")||phone.equals("")||address.equals("")||un.equals("")||pass.equals("")||rpass.equals("")) {
	   			RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp?kt=3");
	   			rd.forward(request, response);
	   		} else {
	   			KhachHangBean kh = khbo.KiemTraTK(un);
	   			if(kh!=null) {	//ok
	   				request.setAttribute("tb", "Tên đăng nhập đã tồn tại!");
	   				//Điều ướng sang SachController
	   				RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp?kt=0");
	   				rd.forward(request, response);
	   			} else {	//ok
	   				if(rpass.equals(pass)) {
	   					khbo.ThemKH(phone, name, un, pass, address);
	   					request.setAttribute("tb", "Đăng ký thành công!");
		   				RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp?kt=1");
		   				rd.forward(request, response);
	   				}else {
	   					request.setAttribute("tb", "Mật khẩu không trùng khớp!");
	   					RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp?kt=2");
	   					rd.forward(request, response);
	   				}
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
