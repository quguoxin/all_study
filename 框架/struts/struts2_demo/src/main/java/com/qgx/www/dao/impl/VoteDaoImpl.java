package com.qgx.www.dao.impl;

import com.qgx.www.dao.VoteDao;
import com.qgx.www.entity.Choice;
import com.qgx.www.entity.Choice_option;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class VoteDaoImpl extends DBUtils implements VoteDao {
    @Override
    public List<Choice> findListByPage(int startIndex, int pageSize) {
        String sql="select * from choice limit ?,?";
        return super.getAll(Choice.class,sql,startIndex,pageSize);
    }

    @Override
    public int findCount() {
        String sql="select count(1) as totalCount from choice";
        return super.getCount(sql);
    }

    @Override
    public int addVote(Choice choice) {
        String sql="INSERT INTO `choice` (`title`,`optionType`) VALUES (?,?)";
        return super.update(sql,choice.getTitle(),choice.getOptionType());
    }

    @Override
    public Choice getChoiceId(String title) {
        String sql="select *  from choice where `title`=?";
        return super.getOne(Choice.class,sql,title);
    }

    @Override
    public int addOption(int id, String[] contentArray) {
        String sql="INSERT INTO `choice_option` (`content`,`cid`) VALUES ('";
        for(int i=0;i<contentArray.length;i++){
            if(i==contentArray.length-1){
                sql+=contentArray[i]+"',"+id+")";
            }else {
                sql+=contentArray[i]+"',"+id+"),('";
            }
        }
        return super.update(sql);
    }

    @Override
    public Choice getChoice(int cid) {
        String sql="select * from  `choice` where id = ?";
        return super.getOne(Choice.class,sql,cid);
    }

    @Override
    public List<Choice_option> getContentList(int cid) {
        String sql="select * from  `choice_option` where cid = ?";
        return super.getAll(Choice_option.class,sql,cid);
    }

    @Override
    public int addtongji(int cid, String oid) {
        String sql="INSERT INTO `tongji` (`cid`,`oid`) VALUES (?,?)";
        return super.update(sql,cid,oid);
    }

    @Override
    public int findVoteCountByOid(int oid) {
        String sql="SELECT COUNT(1) as totalCount FROM `tongji` t WHERE t.`oid` LIKE CONCAT('%,',?,',%')";
        return super.getCount(sql,oid);
    }


}
