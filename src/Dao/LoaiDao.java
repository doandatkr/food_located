package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.LoaiBean;
import Dao.KetNoiDao;

public class LoaiDao {
	public ArrayList<LoaiBean> GetLoai() throws Exception{
		ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>(); 
		//b1: Ket noi vao csdl
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		//b2: Tao cau lenh sql
		String sql= "select*from loai";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//b5: Duyet rs de luu vao ds
		while (rs.next()) {
			String maloai=rs.getString("maloai");
			String tenloai=rs.getString("tenloai");
			ds.add(new LoaiBean(maloai, tenloai));
		}
		//b6: Dong rs va ket noi
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int ThemLoai(String maloai, String tenloai) throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "insert into Loai(maloai, tenloai) values (?, ?)";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int kq=cmd.executeUpdate(); 
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int XoaLoai(String maloai) throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "DELETE FROM Loai WHERE maloai = ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		int kq=cmd.executeUpdate(); 
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int SuaLoai(String maloai, String tenloaimoi) throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "UPDATE Loai SET tenloai=? WHERE maloai=?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, tenloaimoi);
		cmd.setString(2, maloai);
		int kq=cmd.executeUpdate(); 
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
