package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.XacNhanBean;

public class ChiTietDao {
	public int Them(String madv, long soluongmua, Long mahd) throws Exception {
		//b1: Ket noi vao csdl
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		//b2: Tao cau lenh sql
		String sql= "INSERT INTO ChiTietHoaDon(madv,soluongmua,mahd,damua) VALUES (?,?,?,?)";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, madv);
		cmd.setLong(2, soluongmua);
		cmd.setLong(3, mahd);
		cmd.setBoolean(4, false);
		int kq=cmd.executeUpdate(); // thuc hien cau lenh sql
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int CapNhat(long machitiethd) throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "UPDATE ChiTietHoaDon SET damua=1 WHERE mact=?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setLong(1, machitiethd);
		int kq=cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public ArrayList<XacNhanBean> GetHoaDonChuaXacNhan() throws Exception {
		ArrayList<XacNhanBean> ds = new ArrayList<XacNhanBean>();
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "SELECT * FROM VXacNhan";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long makh=rs.getLong("makh");
			String hoten = rs.getString("hoten");
			String tendv= rs.getString("tendv");
			long gia=rs.getLong("gia");
			Date ngaymua=rs.getDate("ngaymua");
			long soluongmua=rs.getLong("soluongmua");
			boolean damua=rs.getBoolean("damua");
			long thanhtien=rs.getLong("thanhtien");
			long mact=rs.getLong("mact");
			ds.add(new XacNhanBean(makh, hoten, tendv, gia, ngaymua, soluongmua, damua, thanhtien, mact));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
