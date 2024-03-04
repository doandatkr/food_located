package Bean;

public class DichVuBean {
	private String madv;
	private String tendv;
	private long gia;
	private String gioithieu;
	private String anh;
	private String maloai;
	public DichVuBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DichVuBean(String madv, String tendv, long gia, String gioithieu, String anh, String maloai) {
		super();
		this.madv = madv;
		this.tendv = tendv;
		this.gia = gia;
		this.gioithieu = gioithieu;
		this.anh = anh;
		this.maloai = maloai;
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
	public String getGioithieu() {
		return gioithieu;
	}
	public void setGioithieu(String gioithieu) {
		this.gioithieu = gioithieu;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
}
