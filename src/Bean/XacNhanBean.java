package Bean;

import java.util.Date;

public class XacNhanBean {
	private long makh;
	private String hoten;
	private String tendv;
	private long gia;
	private Date ngaymua;
	private long soluongmua;
	private boolean damua;
	private long thanhtien;
	private long mact;
	public XacNhanBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XacNhanBean(long makh, String hoten, String tendv, long gia, Date ngaymua, long soluongmua, boolean damua,
			long thanhtien, long mact) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.tendv = tendv;
		this.gia = gia;
		this.ngaymua = ngaymua;
		this.soluongmua = soluongmua;
		this.damua = damua;
		this.thanhtien = thanhtien;
		this.mact = mact;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
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
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
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
