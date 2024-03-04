package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.DichVuBean;

public class DichVuDao {
	public ArrayList<DichVuBean> GetDichVu() throws Exception {
		ArrayList<DichVuBean> ds = new ArrayList<DichVuBean>();
		//b1: Ket noi vao csdl
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		//b2: Tao cau lenh sql
		String sql= "select*from DichVu";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//b5: Duyet rs de luu vao ds
		while (rs.next()) {
			String madv = rs.getString("madv");
			String tendv = rs.getString("tendv");
			long gia = rs.getLong("gia");
			String gioithieu = rs.getString("gioithieu");
			String anh = rs.getString("anh");
			String maloai = rs.getString("maloai");
			
			ds.add(new DichVuBean(madv, tendv, gia, gioithieu, anh, maloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int ThemDichVu(String madv, String tendv, long gia, String gioithieu, String anh, String maloai) throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "INSERT INTO DichVu(madv, tendv, gia, gioithieu, anh, maloai) VALUES (?, ?, ?, ?,?, ?)";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, madv);
		cmd.setString(2, tendv);
		cmd.setLong(3, gia);
		cmd.setString(4, gioithieu);
		cmd.setString(5, anh);
		cmd.setString(6, maloai);
		int kq=cmd.executeUpdate(); 
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int SuaDichVu(String madv, String tendvmoi, long giamoi, String gioithieumoi, String anhmoi, String maloaimoi) throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "UPDATE DichVu SET tendv=?, gia=?, gioithieu=?, anh=?, maloai=? WHERE madv=?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, tendvmoi);
		cmd.setLong(2, giamoi);
		cmd.setString(3, gioithieumoi);
		cmd.setString(4, anhmoi);
		cmd.setString(5, maloaimoi);
		cmd.setString(6, madv);
		int kq=cmd.executeUpdate(); 
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int XoaDichVu(String madv) throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "DELETE FROM DichVu WHERE madv = ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, madv);
		int kq=cmd.executeUpdate(); 
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
