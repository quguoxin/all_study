package dao.impl;

import dao.TradeinfoDao;
import entity.Tradeinfo;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeinfoDaoImpl extends JdbcUtil implements TradeinfoDao {

    //分页查询
    @Override
    public List findTradeinfoByPageNo(int pageNo, int pageSize) {
        Object[] params={pageNo,pageSize,pageNo,pageSize};
        String sql="select b.* from \n" +
                "    (select rownum ra,a.* from \n" +
                "        (select t.* from tradeinfo t where t.tradecardid ='6217001111111111111' order by t.tradedate desc\n" +
                "      )a where rownum <=?*?\n" +
                "    )b where b.ra>(?-1)*?";
        List<Tradeinfo> list = new ArrayList<Tradeinfo>();
        ResultSet resultSet=super.commonQuery(sql,params);
        try{
            while (resultSet.next()){
                 String tradeNo=resultSet.getString("tradeno");
                 Date tradeDate=resultSet.getDate("tradedate");
                 int tradeType=resultSet.getInt("tradetype");
                 String tradeCardId=resultSet.getString("tradecardid");
                 String acceptCardId=resultSet.getString("acceptcardid");
                 double tradeMoney=resultSet.getDouble("trademoney");
                 int currencyTypeId=resultSet.getInt("currencytypeid");
                 int tradeDirection=resultSet.getInt("tradedirection");
                 String remark=resultSet.getString("remark");
                 list.add(new Tradeinfo(tradeNo,tradeDate,tradeType,tradeCardId,acceptCardId,tradeMoney,currencyTypeId,tradeDirection,remark));
            }
            return  list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    //找出本月单笔交易信息中金额最大的卡号
    @Override
    public String findTopMoneyToBankNo() {
        String tradeCardId="";
        Object[] params={};
        String sql="select tradecardid from tradeinfo where trademoney=(select max(trademoney) from tradeinfo  \n" +
                "where extract(MONTH from  tradeinfo.tradedate )=6) group by tradecardid";
        ResultSet resultSet=super.commonQuery(sql,params);
        try {
            if(resultSet.next()){
                tradeCardId=resultSet.getString("tradecardid");
            }
            return tradeCardId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tradeCardId;
    }
}
