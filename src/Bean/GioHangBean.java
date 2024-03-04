package Bean;

public class GioHangBean {
	private String madv;
	private String tendv;
	private long gia;
	private long soluongmua;
	private long thanhtien;
	public GioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GioHangBean(String madv, String tendv, long gia, long soluongmua) {
		super();
		this.madv = madv;
		this.tendv = tendv;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = gia*soluongmua;
	}
	public String getMadv() {
		return madv;
	}
	public void setMadv(String madv) {
		this.madv = madv;
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
	public long getThanhtien() {
		return soluongmua*gia;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
}
