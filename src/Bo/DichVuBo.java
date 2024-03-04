package Bo;

import java.util.ArrayList;

import Bean.DichVuBean;
import Dao.DichVuDao;

public class DichVuBo {
	DichVuDao dvdao = new DichVuDao();
	ArrayList<DichVuBean> ds;
	public ArrayList<DichVuBean> GetDichVu() throws Exception {
		ds = dvdao.GetDichVu();
		return ds;
	}
	public ArrayList<DichVuBean> TimMa(String maloai) throws Exception {
		ArrayList<DichVuBean> tam = new ArrayList<DichVuBean>();
		for(DichVuBean dv:ds) 
			if(dv.getMaloai().equals(maloai)) 
				tam.add(dv);
		return tam;
	}
	public ArrayList<DichVuBean> Tim(String key) throws Exception {
		ArrayList<DichVuBean> tam = new ArrayList<DichVuBean>();
		for(DichVuBean dv:ds) 
			if(dv.getTendv().toLowerCase().contains(key.toLowerCase())) 
				tam.add(dv);
		return tam;
	}
	public DichVuBean TimMaDV(String madv) throws Exception {
		DichVuBean tam = new DichVuBean();
		for(DichVuBean dv:ds) 
			if(dv.getMadv().equals(madv)) 
				tam = dv;
		return tam;
	}
	public int ThemDichVu(String madv, String tendv, long gia, String gioithieu, String anh, String maloai) throws Exception {
		return dvdao.ThemDichVu(madv, tendv, gia, gioithieu, anh, maloai);
	}
	public int SuaDichVu(String madv, String tendvmoi, long giamoi, String gioithieumoi, String anhmoi, String maloaimoi) throws Exception {
		return dvdao.SuaDichVu(madv, tendvmoi, giamoi, gioithieumoi, anhmoi, maloaimoi);
	}
	public int XoaDichVu(String madv) throws Exception {
		return dvdao.XoaDichVu(madv);
	}
}
