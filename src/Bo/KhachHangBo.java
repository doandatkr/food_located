package Bo;

import Bean.KhachHangBean;
import Dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khdao = new KhachHangDao();

	public KhachHangBean KiemTraDN(String taikhoan, String matkhau) throws Exception{
		return khdao.KiemTraDN(taikhoan, matkhau);
	}
	public KhachHangBean KiemTraTK(String taikhoan) throws Exception{
		return khdao.KiemTraTK(taikhoan);
	}
	public int ThemKH(String sdt, String hoten, String taikhoan, String matkhau, String diachi) throws Exception {
		return khdao.ThemKH(sdt, hoten, taikhoan, matkhau, diachi);
	}
}
