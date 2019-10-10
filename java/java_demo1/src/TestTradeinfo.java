import dao.impl.TradeinfoDaoImpl;
import entity.Tradeinfo;

import java.util.List;

public class TestTradeinfo {
    public static void main(String[] args) {
        TradeinfoDaoImpl tradeinfoDaoImpl=new TradeinfoDaoImpl();
        // 分页查询
        List<Tradeinfo> list= tradeinfoDaoImpl.findTradeinfoByPageNo(2,10);
        for(Tradeinfo temp:list){
            System.out.println(temp.toString());
        }
        //找出本月单笔交易信息中金额最大的卡号
        System.out.println("月单笔交易信息中金额最大的卡号为："+tradeinfoDaoImpl.findTopMoneyToBankNo());
    }
}
