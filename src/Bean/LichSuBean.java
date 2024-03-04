package Bean;

import java.util.Date;

public class LichSuBean {
	private long makh;
	private Date ngaymua;
	private long soluongmua;
	private String tendv;
	private long gia;
	private long thanhtien;
	private long mact;
	public LichSuBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LichSuBean(long makh, Date ngaymua, long soluongmua, String tendv, long gia, long thanhtien, long mact) {
		super();
		this.makh = makh;
		this.ngaymua = ngaymua;
		this.soluongmua = soluongmua;
		this.tendv = tendv;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.mact = mact;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
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
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public long getMact() {
		return mact;
	}
	public void setMact(long mact) {
		this.mact = mact;
	}
}
