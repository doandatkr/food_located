package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HoaDonDao {
	public int Them(long makh) throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "INSERT INTO HoaDon (makh,ngaymua,damua) VALUES (?,?,?)";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		Date n1 = new Date();
		SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
		//Doi ngay util sang chuoi theo dinh dang
		String tam = dd.format(n1);
		Date n2 = dd.parse(tam); // doi chuoi ra ngay util
		//doi ngay util sang ngay sql va dua vao tham so
		cmd.setDate(2, new java.sql.Date(n2.getTime()));
		cmd.setBoolean(3, false);
		int kq=cmd.executeUpdate(); 
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public long GetMaxHD() throws Exception {
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "select max(mahd) as maxhd from	hoadon";
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
}
