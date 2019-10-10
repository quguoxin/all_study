package com.qgx.www.myframework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 开发一个用来管理ActionMapping的类即Actions
 */
public class ActionMappingManager {
    public static Map<String,ActionMappering> actionMapperingMap=new HashMap<String, ActionMappering>();

    public void init(String configFileName){//init:初始化
        //1.解析配置文件
        //a.创建输入流对象：InputStream
        InputStream inputStream=this.getClass().getResourceAsStream("/"+configFileName);
        //b.创建SAXReader
        SAXReader saxReader=new SAXReader();
        try {
            //c.创建Document对象，将xml转为倒装的树形结构
            Document document=saxReader.read(inputStream);
            //d.读取节点信息，获取根节点
            Element root = document.getRootElement();
            //e.获取actions节点
            Element actionsElement=(Element) root.elementIterator("actions").next();
            //f.获取action节点
            Iterator<Element> actionIterator = actionsElement.elementIterator("action");
            while (actionIterator.hasNext()){
                Element actionElement= actionIterator.next();
                //g.获取属性和子节点
                String actionName=actionElement.attributeValue("name");
                String calssName =actionElement.attributeValue("class");
                Iterator<Element> resultIterator=actionElement.elementIterator("result");
                Map<String,Result> resultMap=new HashMap<String, Result>();//用于装Result集合
                while (resultIterator.hasNext()){
                    Element resultElement = resultIterator.next();
                    String resultName = resultElement.attributeValue("name");
                    boolean isRedirect = false;
                    if(resultElement.attribute("name")!=null&&resultElement.attribute("name").equals("true")){//如果这个节点存在则为true
                        isRedirect=true;
                    }
                    String viewPath = resultElement.getTextTrim();//获得文本内容viewPath
                    //封装Result节点
                    Result result=new Result();
                    result.setName(resultName);
                    result.setRedirect(isRedirect);
                    result.setViewPath(viewPath);
                    //将一个个Result加入到集合中
                    resultMap.put(resultName,result);//用result的name做键
                }
                ActionMappering actionMappering=new ActionMappering();
                actionMappering.setName(actionName);
                actionMappering.setClassName(calssName);
                actionMappering.setResultMap(resultMap);
                actionMapperingMap.put(actionName,actionMappering);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
