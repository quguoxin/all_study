package day11.T1;

public class Animal {
    private String name;
    private String colour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void speak(String name, String colour){
        System.out.println("我的名字是："+name+"\n我的颜色是："+colour);
    }
}
