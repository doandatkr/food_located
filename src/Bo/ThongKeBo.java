package Bo;

import java.util.ArrayList;

import Bean.ThongKeBean;
import Dao.ThongKeDao;

public class ThongKeBo {
	ThongKeDao tkdao = new ThongKeDao();
	public ArrayList<ThongKeBean> GetThongKe() throws Exception {
		return tkdao.GetThongKe();
	}
	public ArrayList<ThongKeBean> GetThongKeChon(String tungay, String denngay) throws Exception {
		return tkdao.GetThongKeChon(tungay, denngay);
	}
	public long TongThongKe() throws Exception {
		return tkdao.TongThongKe();
	}
	public long TongThongKeChon(String tungay, String denngay) throws Exception {
		return tkdao.TongThongKeChon(tungay, denngay);
	}
}
