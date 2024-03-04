package Bean;

import java.util.Date;

public class ThongKeBean {
	private String tendv;
	private long gia;
	private long soluongmua;
	private boolean damua;
	private Date ngaymua;
	private long thanhtien;
	public ThongKeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongKeBean(String tendv, long gia, long soluongmua, boolean damua, Date ngaymua, long thanhtien) {
		super();
		this.tendv = tendv;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.damua = damua;
		this.ngaymua = ngaymua;
		this.thanhtien = thanhtien;
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
}
