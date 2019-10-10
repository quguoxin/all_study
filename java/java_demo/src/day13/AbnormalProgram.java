package day13;

public class AbnormalProgram {
    private String Abnormal;
    private String program;

    public String getAbnormal() {
        return Abnormal;
    }

    public void setAbnormal(String abnormal) {
        Abnormal = abnormal;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public AbnormalProgram() {
    }

    public AbnormalProgram(String abnormal, String program) {
        Abnormal = abnormal;
        this.program = program;
    }

    public void  register(int number) throws Exception{
           if(number==1){
               System.out.println("进入");
           }else if(number==2){
               System.out.println("退出");
           }else {
               throw new MyException("只能輸入1或者2");
           }
    }

    public static void main(String[] args) {
        AbnormalProgram[] array = new AbnormalProgram[5];
        array[1] = new AbnormalProgram("嘻嘻", "嘻嘻");
        array[3] = new AbnormalProgram("嘻嘻", "嘻嘻");
        try {
            array[5] = new AbnormalProgram("嘻嘻", "嘻嘻");
        }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("数组下标越界");
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null) {
                    array[i] = new AbnormalProgram("哈哈", "呵呵");
            }
        }

        for (int i = 0; i < array.length; i++) {
            try {
                System.out.println(array[i].getAbnormal() + array[i].getProgram());
            } catch (Exception e) {
                System.out.println("空指针异常");
            }
        }

        AbnormalProgram abnormalProgram =new AbnormalProgram();

        try {
            abnormalProgram.register(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
