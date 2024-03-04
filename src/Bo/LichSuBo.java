package Bo;

import java.util.ArrayList;

import Bean.LichSuBean;
import Dao.LichSuDao;

public class LichSuBo {
	LichSuDao lsdao = new LichSuDao();
	public ArrayList<LichSuBean> GetLichSu(long makh) throws Exception {
		return lsdao.GetLichSu(makh);
	}
}
