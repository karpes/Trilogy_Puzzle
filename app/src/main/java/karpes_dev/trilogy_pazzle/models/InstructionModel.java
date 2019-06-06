package karpes_dev.trilogy_pazzle.models;

public class InstructionModel {

    private String text;
    private int count, count2;

    public InstructionModel(int count, int count2, String text) {
        this.text = text;
        this.count = count;
        this.count2 = count2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }
}
