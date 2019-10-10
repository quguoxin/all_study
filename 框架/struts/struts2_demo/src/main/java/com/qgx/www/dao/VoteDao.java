package com.qgx.www.dao;

import com.qgx.www.entity.Choice;
import com.qgx.www.entity.Choice_option;

import java.util.List;

public interface VoteDao {
    /**
     * bootstrap-table分页列表
     * @param startIndex 起始下标
     * @param pageSize  也显示行数
     * @return
     */
    public List<Choice> findListByPage(int startIndex, int pageSize);

    /**
     * 查询总数量
     * @return
     */
    public int findCount();

    /**
     * 添加投票
     * @param choice
     * @return
     */
    public int addVote(Choice choice);

    /**
     * 获取添加的投票的Id
     * @param title
     * @return
     */
    public Choice getChoiceId(String title);


    /**
     * 添加选项
     * @param id
     * @param contentArray
     * @return
     */
    public int addOption(int id,String[] contentArray);

    /**
     * 根据投票id获取投票对象
     * @param cid
     * @return
     */
    public Choice getChoice(int cid);

    /**
     * 由cid获取选项
     * @param cid
     * @return
     */
    public List<Choice_option> getContentList(int cid);


    /**
     * 添加统计数据
     * @param cid
     * @param oid
     * @return
     */
    public int addtongji(int cid,String oid);

    /**
     * 由选项id查询投给此选项的数目
     * @param oid
     * @return
     */
    int findVoteCountByOid(int oid);
}
