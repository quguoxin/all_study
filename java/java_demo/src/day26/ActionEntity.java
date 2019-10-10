package day26;

import java.util.List;

public class ActionEntity {
    private String name;
    private String className;
    private String method;
    private List<Result> resultlist;

    @Override
    public String toString() {
        return "ActionEntity{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", method='" + method + '\'' +
                ", resultlist=" + resultlist +
                '}';
    }

    public ActionEntity() {
    }

    public ActionEntity(String name, String className, String method, List<Result> resultlist) {
        this.name = name;
        this.className = className;
        this.method = method;
        this.resultlist = resultlist;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Result> getResultlist() {
        return resultlist;
    }

    public void setResultlist(List<Result> resultlist) {
        this.resultlist = resultlist;
    }
}
