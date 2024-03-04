package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.KhachHangBean;
import Dao.KetNoiDao;

public class KhachHangDao {
	public KhachHangBean KiemTraDN(String taikhoan, String matkhau) throws Exception{
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql="select * from khachhang where taikhoan=? and matkhau=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, taikhoan);
		cmd.setString(2, matkhau);
		ResultSet rs = cmd.executeQuery();
		KhachHangBean kh=null;
		if(rs.next()) {
			long makh = rs.getLong("makh");
			String sdt = rs.getString("sdt");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			kh = new KhachHangBean(makh, sdt, hoten, taikhoan, matkhau, diachi);
		}
		return kh;
	}
	public KhachHangBean KiemTraTK(String taikhoan) throws Exception{
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql="select * from khachhang where taikhoan=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, taikhoan);
		ResultSet rs = cmd.executeQuery();
		KhachHangBean kh=null;
		if(rs.next()) {
			long makh = rs.getLong("makh");
			String sdt = rs.getString("sdt");
			String hoten = rs.getString("hoten");
			String matkhau = rs.getString("matkhau");
			String diachi = rs.getString("diachi");
			kh = new KhachHangBean(makh, sdt, hoten, taikhoan, matkhau, diachi);
		}
		return kh;
	}
	public int ThemKH(String sdt, String hoten, String taikhoan, String matkhau, String diachi) throws Exception {
		KetNoiDao kn =new KetNoiDao();
		kn.KetNoi();
		String sql = "insert into KhachHang(sdt, hoten, taikhoan, matkhau, diachi) values(?, ?, ?, ?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, sdt);
		cmd.setString(2, hoten);
		cmd.setString(3, taikhoan);
		cmd.setString(4, matkhau);
		cmd.setString(5, diachi);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
