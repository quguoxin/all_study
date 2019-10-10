package day24;

public enum Color {
    RED(1,"我是红色"),
    YELLOW(2,"我是黄色"),
    BLUE(3,"我是蓝色");

    private int colorNo;
    private String  colorDesc;

    @Override
    public String toString() {
        return "Color{" +
                "colorNo=" + colorNo +
                ", colorDesc='" + colorDesc + '\'' +
                '}';
    }

    Color(int colorNo, String colorDesc) {
        this.colorNo = colorNo;
        this.colorDesc = colorDesc;
    }

    public int getColorNo() {
        return colorNo;
    }

    public void setColorNo(int colorNo) {
        this.colorNo = colorNo;
    }

    public String getColorDesc() {
        return colorDesc;
    }

    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;
    }
}
