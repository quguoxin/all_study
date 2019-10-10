package com.qgx.www.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qgx.www.bean.BootPageBean;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Choice;
import com.qgx.www.entity.Choice_option;
import com.qgx.www.service.VoteService;
import com.qgx.www.service.impl.VoteServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class VoteAction extends BaseAction {
    private Choice choice;


    //传统方式
   /* public String list(){
        choice=new Choice(1,"我是不是最帅的人",1);
        PrintWriter printWriter= null;
        try {
            printWriter = response.getWriter();
            printWriter.write(JSON.toJSONString(choice));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    //json方式
    //展示投票列表
    private int offset;//起始下标
    private int limit;//页显示行数
    private BootPageBean<Choice> bootPageBean;
    public String list2(){
        //调用业务
        bootPageBean=new BootPageBean();
        VoteService voteService=new VoteServiceImpl();
        List<Choice> list = voteService.findListByPage(offset,limit);
        int total = voteService.findCount();
        bootPageBean.setRows(list);
        bootPageBean.setTotal(total);
        //响应输出
        return "success_show";
    }

    //发布投票
    private String title;//投票标题
    private int optionType;//单选or多选
    private String[] countArray;
    public String add(){
        Choice choice=new Choice();
        choice.setTitle(title);
        choice.setOptionType(optionType);
        VoteService voteService=new VoteServiceImpl();
        int a=voteService.addVote(choice);
        int id=voteService.getChoiceId(title);
        int b=voteService.addOption(id,countArray);
        if(a==1&&b>0){
            return "success_add";
        }
        return "";
    }


    //展示选项进行投票
    private int choiceid;
    public String show(){
        VoteService voteService=new VoteServiceImpl();
        String title2=voteService.getChoice(choiceid).getTitle();
        int optionType2=voteService.getChoice(choiceid).getOptionType();
        List<Choice_option> choiceOptionList=voteService.getContentList(choiceid);
        Choice choice=new Choice(choiceid,title2,optionType2,choiceOptionList);
        session.put("choice",choice);
        return "success_vote";
    }


    //投票
    private String[] select;
    public String vote(){
        VoteService voteService=new VoteServiceImpl();
        Choice choice=(Choice) session.get("choice");
        int cid=choice.getId();
        String oid=",";
        for(int i=0;i<select.length;i++){
            oid+=select[i]+",";
        }
        int a=voteService.addtongji(cid,oid);
        return "success_toupiao";
    }

    //统计
    private ResponseBody responseBody;
    private int cid;
    public String tongji(){
        VoteService voteService=new VoteServiceImpl();
        String[] contentArray=voteService.findContentArrayById(cid);
        int[] numArray=voteService.findNumArrayById(cid);

        responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("统计结果！");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("contentArray",contentArray);
        jsonObject.put("numArray",numArray);
        responseBody.setData(jsonObject);
        return "success_tongji";
    }

    /////////////////get or  set/////////////////////////


    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }



    public String[] getSelect() {
        return select;
    }

    public void setSelect(String[] select) {
        this.select = select;
    }

    public String[] getCountArray() {
        return countArray;
    }

    public void setCountArray(String[] countArray) {
        this.countArray = countArray;
    }

    public int getChoiceid() {
        return choiceid;
    }

    public void setChoiceid(int choiceid) {
        this.choiceid = choiceid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOptionType() {
        return optionType;
    }

    public void setOptionType(int optionType) {
        this.optionType = optionType;
    }

    public BootPageBean getBootPageBean() {
        return bootPageBean;
    }

    public void setBootPageBean(BootPageBean bootPageBean) {
        this.bootPageBean = bootPageBean;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}
