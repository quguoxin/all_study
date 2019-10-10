package com.qgx.www.service.impl;

import com.qgx.www.dao.VoteDao;
import com.qgx.www.dao.impl.VoteDaoImpl;
import com.qgx.www.entity.Choice;
import com.qgx.www.entity.Choice_option;
import com.qgx.www.service.VoteService;

import java.util.List;

public class VoteServiceImpl implements VoteService {
    VoteDao voteDao=new VoteDaoImpl();
    @Override
    public List<Choice> findListByPage(int startIndex, int pageSize) {
        return voteDao.findListByPage(startIndex,pageSize);
    }

    @Override
    public int findCount() {
        return voteDao.findCount();
    }

    @Override
    public int addVote(Choice choice) {
        return voteDao.addVote(choice);
    }

    @Override
    public int getChoiceId(String title) {
        return voteDao.getChoiceId(title).getId();
    }

    @Override
    public int addOption(int id, String[] contentArray) {
        return voteDao.addOption(id,contentArray);
    }

    @Override
    public Choice getChoice(int cid) {
        return voteDao.getChoice(cid);
    }

    @Override
    public List<Choice_option> getContentList(int cid) {
        return voteDao.getContentList(cid);
    }

    @Override
    public int addtongji(int cid, String oid) {
        return voteDao.addtongji(cid,oid);
    }

    @Override
    public String[] findContentArrayById(int cid) {
        List<Choice_option> choiceOptionList=voteDao.getContentList(cid);//获得所有选项对象
        String[] contentArray=new String[choiceOptionList.size()];
        for(int i = 0;i<choiceOptionList.size();i++){//将选项转为数组
            contentArray[i]=choiceOptionList.get(i).getContent();
        }
        return contentArray;
    }

    @Override
    public int[] findNumArrayById(int cid) {
        List<Choice_option> choiceOptionList=voteDao.getContentList(cid);//获得所有选项对象
        int[] numArray=new int[choiceOptionList.size()];
        for (int i = 0; i <choiceOptionList.size() ; i++) {//由选项对象里面的选项查询选择他的人数并存进数组
            int oid=choiceOptionList.get(i).getId();
            numArray[i]=voteDao.findVoteCountByOid(oid);
        }
        return numArray;
    }
}
