package Bean;

public class KhachHangBean {
	private long makh;
	private String sdt;
	private String hoten;
	private String taikhoan;
	private String matkhau;
	private String diachi;
	public KhachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHangBean(long makh, String sdt, String hoten, String taikhoan, String matkhau, String diachi) {
		super();
		this.makh = makh;
		this.sdt = sdt;
		this.hoten = hoten;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.diachi = diachi;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
}
