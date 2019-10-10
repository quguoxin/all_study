package day24;

public enum Sex {
    MAN(1,"我是男生","我爱小姐姐"),//实例1，实例2，之间用,号连接
    WOMAN(2,"我是女生","我爱小哥哥");

    //属性
    private int sexNo;
    private String sexShow;
    private String sexDesc;

    //通过编号获取实例的方法
    public static Sex getByNo(int no){
        Sex obj=null;
        Sex[] sexes=Sex.values(); //返回枚举类型的实例数组
        for(Sex sex:sexes){
            if(sex.getSexNo()==no){
                obj=sex;
                break;
            }
        }
        return obj;
    }



    @Override
    public String toString() {
        return "Sex{" +
                "sexNo=" + sexNo +
                ", sexShow='" + sexShow + '\'' +
                ", sexDesc='" + sexDesc + '\'' +
                '}';
    }

    //构造器
    Sex(int sexNo, String sexShow, String sexDesc) {
        this.sexNo = sexNo;
        this.sexShow = sexShow;
        this.sexDesc = sexDesc;
    }

    public int getSexNo() {
        return sexNo;
    }

    public void setSexNo(int sexNo) {
        this.sexNo = sexNo;
    }

    public String getSexShow() {
        return sexShow;
    }

    public void setSexShow(String sexShow) {
        this.sexShow = sexShow;
    }

    public String getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(String sexDesc) {
        this.sexDesc = sexDesc;
    }
}
