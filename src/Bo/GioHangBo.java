package Bo;

import java.util.ArrayList;

import Bean.GioHangBean;

public class GioHangBo {
	public ArrayList<GioHangBean> ds= new ArrayList<GioHangBean>();
	public void ThemHang(String madv,String tendv,long gia, long soluongmua) {
		//Kiem tra xem hang da co trong ds chua
		//neu co thi tang so luong
		for(GioHangBean h: ds) 
			if(h.getMadv().equals(madv)) {
				h.setSoluongmua(h.getSoluongmua()+soluongmua);
				return;
			}
		GioHangBean h= new GioHangBean(madv, tendv, gia, soluongmua);
		ds.add(h); //Them hang vao gio
	}
	//Xoa hang ra khoi ds
	public void XoaHang(String madv) {
		for(GioHangBean h: ds)
			if(h.getMadv().equals(madv)) {
				ds.remove(h);
				return;
			}
	}
	//Sua lai so luong
	public void Sua(String madv, long soluongmoi) {
		int n=ds.size();  //Lay so sach trong ds
		for(int i=0;i<n;i++) {
			GioHangBean h=ds.get(i); //Lay sach thu i
			if(h.getMadv().equals(madv)) {
				h.setSoluongmua(soluongmoi);  //Sua so luong
				ds.set(i, h);  //Luu lai vao ds
				return;
			}
		}
	}
	//Tinh tong tien
	public long Tong() {
		long s=0;
		for(GioHangBean h: ds) {
			s=s+h.getThanhtien();
		}
		return s;
	}
}
