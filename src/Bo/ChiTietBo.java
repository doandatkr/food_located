package Bo;

import java.util.ArrayList;

import Bean.XacNhanBean;
import Dao.ChiTietDao;

public class ChiTietBo {
	ChiTietDao ctdao = new ChiTietDao();
	public int Them(String madv, long soluongmua, Long mahd) throws Exception {
		return ctdao.Them(madv, soluongmua, mahd);
	}
	public int CapNhat(long machitiethd) throws Exception {
		return ctdao.CapNhat(machitiethd);
	}
	public ArrayList<XacNhanBean> GetHoaDonChuaXacNhan() throws Exception {
		return ctdao.GetHoaDonChuaXacNhan();
	}
}
