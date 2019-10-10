package dao;

import java.util.List;

/**
 * Created by Administrator on 2018/6/19.
 */
public interface TradeinfoDao {
    /**
     * 按照页码分页查询
     * @param pageNo 当前页码
     * @param pageSize 页显示行数
     * @return
     */
    public List findTradeinfoByPageNo(int pageNo, int pageSize);

    /**
     * 查询本月交易金额最高的卡号
     * @return
     */
    public String findTopMoneyToBankNo();

}
