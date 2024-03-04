package Bo;

import java.util.ArrayList;

import Bean.LoaiBean;
import Dao.LoaiDao;

public class LoaiBo {
	LoaiDao ldao = new LoaiDao();
	ArrayList<LoaiBean> ds;
	public ArrayList<LoaiBean> GetLoai() throws Exception {
		return ldao.GetLoai();
	}
	public int ThemLoai(String maloai, String tenloai) throws Exception {
		return ldao.ThemLoai(maloai, tenloai);
	}
	public int XoaLoai(String maloai) throws Exception {
		return ldao.XoaLoai(maloai);
	}
	public int SuaLoai(String maloai, String tenloaimoi) throws Exception {
		return ldao.SuaLoai(maloai, tenloaimoi);
	}
}
