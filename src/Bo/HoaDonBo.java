package Bo;

import Dao.HoaDonDao;

public class HoaDonBo {
	HoaDonDao hddao = new HoaDonDao();
	public int Them(long makh) throws Exception {
		return hddao.Them(makh);
	}
	public long GetMaxHD() throws Exception {
		return hddao.GetMaxHD();
	}
}
