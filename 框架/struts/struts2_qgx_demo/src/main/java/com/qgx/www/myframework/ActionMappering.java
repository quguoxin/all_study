package com.qgx.www.myframework;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于储存Action节点配置信息
 */
public class ActionMappering {
    private String name;//action的name
    private String className;//action的class
    private Map<String,Result> resultMap =new HashMap<String, Result>();//action的result

    public ActionMappering() {
    }

    public ActionMappering(String name, String className, Map<String, Result> resultMap) {
        this.name = name;
        this.className = className;
        this.resultMap = resultMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, Result> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Result> resultMap) {
        this.resultMap = resultMap;
    }
}
