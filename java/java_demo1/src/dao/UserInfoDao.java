package dao;

import entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
    //查询挂失客户  and  催款
    public List<UserInfo> getLossUers(String sql);


}
