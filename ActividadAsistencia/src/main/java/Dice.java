import java.util.Random;

public class Dice {
    private int upperFace;

    public Dice() {
        this.upperFace = 1;
    }

    public int getUpperFace() {
        return upperFace;
    }

    public void setUpperFace(int upperFace) {
        this.upperFace = upperFace;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "upperFace=" + upperFace +
                '}';
    }

    public void roll(){
        this.upperFace = new Random().nextInt(6)+1;
    }
}
