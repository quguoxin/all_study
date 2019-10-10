package day26;

public class Result {
    private String name;
    private String txtValue;

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", txtValue='" + txtValue + '\'' +
                '}';
    }

    public Result() {
    }

    public Result(String name, String txtValue) {
        this.name = name;
        this.txtValue = txtValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTxtValue() {
        return txtValue;
    }

    public void setTxtValue(String txtValue) {
        this.txtValue = txtValue;
    }
}
