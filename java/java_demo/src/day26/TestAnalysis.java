package day26;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

public class TestAnalysis {
    public static void main(String[] args) {
        //创建最终的结果集
        Map<String,ActionEntity> map=new HashMap();
        //读取文件
        File file =new File("D:\\java_demo\\src\\day26\\struts.xml");
        try {
            //创建xml读取流SaxReader reader
            SAXReader reader=new SAXReader();
            //.执行读取方法reader.read(文件对象/输入流)，将xml转为倒装的树形结构
            Document document=reader.read(file);
            //得到根节点
            Element rootElement=document.getRootElement();
            //获得下属节点集合list1
            List<Element> list1=rootElement.elements("action");
            for(Element e1:list1){
                //再次获取下属节点集合list2
                List<Element> list2=e1.elements("result");
                //创建Result集合resultList
                List<Result> resultList=new ArrayList<Result>();
                for(Element e2:list2){
                    //为resultList添加元素
                    resultList.add(new Result(e2.attributeValue("name"),e2.getTextTrim()));
                }
                //为map集合添加键和值
                map.put(e1.attributeValue("name"),new ActionEntity(e1.attributeValue("name"),e1.attributeValue("class"),e1.attributeValue("method"),resultList));
            }
            //处理map集合，循环输出
            Set<String> set=map.keySet();
            Iterator<String> it=set.iterator();
            while (it.hasNext()){
                String key =it.next();
                ActionEntity actionEntity=map.get(key);
                System.out.println(actionEntity.toString());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
