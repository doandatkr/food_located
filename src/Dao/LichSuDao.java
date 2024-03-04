package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.LichSuBean;

public class LichSuDao {
	public ArrayList<LichSuBean> GetLichSu(long makh) throws Exception {
		ArrayList<LichSuBean> ds = new ArrayList<LichSuBean>();
		KetNoiDao kn = new KetNoiDao();
		kn.KetNoi();
		String sql= "select * from vlichsu where makh = ? order by mact DESC";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			makh = rs.getLong("makh");
			Date ngaymua=rs.getDate("ngaymua");
			long soluongmua=rs.getLong("soluongmua");
			String tendv=rs.getString("tendv");
			long gia=rs.getLong("gia");
			long thanhtien=rs.getLong("thanhtien");
			long mact=rs.getLong("mact");
			ds.add(new LichSuBean(makh, ngaymua, soluongmua, tendv, gia, thanhtien, mact));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
