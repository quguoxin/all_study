import dao.impl.UserInfoDaoImpl;
import entity.UserInfo;

import java.util.List;

public class TestUserInfo {
    public static void main(String[] args) {
        UserInfoDaoImpl userInfoDao=new UserInfoDaoImpl();
        System.out.println("**************挂失名单****************************");
        String sql="select * from userinfo a,(select userid from bankcard  where isloss=1) b where a.userid=b.userid";
        List<UserInfo> list=userInfoDao.getLossUers(sql);
        for(UserInfo userInfo:list){
            System.out.println(userInfo.toString());
        }

        System.out.println("**************月末催款名单********************");
        sql="select * from userinfo a,(select userid from bankcard where balance <200) b where a.userid=b.userid";
        list=userInfoDao.getLossUers(sql);
        for(UserInfo userInfo:list){
            System.out.println(userInfo.toString());
        }
    }
}
