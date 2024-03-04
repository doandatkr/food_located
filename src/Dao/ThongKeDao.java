package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.ThongKeBean;

public class ThongKeDao {
	public ArrayList<ThongKeBean> GetThongKe() throws Exception {
		ArrayList<ThongKeBean> ds = new ArrayList<ThongKeBean>();
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "SELECT * FROM VThongKe";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String tendv = rs.getString("tendv");
			long gia=rs.getLong("gia");
			long soluongmua=rs.getLong("soluongmua");
			boolean damua=rs.getBoolean("damua");
			Date ngaymua=rs.getDate("ngaymua");
			long thanhtien=rs.getLong("thanhtien");
			ds.add(new ThongKeBean(tendv, gia, soluongmua, damua, ngaymua, thanhtien));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public long TongThongKe() throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "select SUM(thanhtien) from VThongKe";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max=0;
		if(rs.next()) {
			//Lay ve gia tri cua cot dau tien trong rs
			max = rs.getLong(1);
		}
		rs.close();
		kn.cn.close();
		return max;
	}
	public ArrayList<ThongKeBean> GetThongKeChon(String tungay, String denngay) throws Exception {
		ArrayList<ThongKeBean> ds = new ArrayList<ThongKeBean>();
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "select * from VThongKe where ngaymua between ? and ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, tungay);
		cmd.setString(2, denngay);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String tendv = rs.getString("tendv");
			long gia=rs.getLong("gia");
			long soluongmua=rs.getLong("soluongmua");
			boolean damua=rs.getBoolean("damua");
			Date ngaymua=rs.getDate("ngaymua");
			long thanhtien=rs.getLong("thanhtien");
			ds.add(new ThongKeBean(tendv, gia, soluongmua, damua, ngaymua, thanhtien));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public long TongThongKeChon(String tungay, String denngay) throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "select SUM(thanhtien) from VThongKe where ngaymua between ? and ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, tungay);
		cmd.setString(2, denngay);
		ResultSet rs = cmd.executeQuery();
		long max=0;
		if(rs.next()) {
			//Lay ve gia tri cua cot dau tien trong rs
			max = rs.getLong(1);
		}
		rs.close();
		kn.cn.close();
		return max;
	}
}
