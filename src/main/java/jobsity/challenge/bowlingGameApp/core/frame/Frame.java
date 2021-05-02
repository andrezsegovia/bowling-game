package jobsity.challenge.bowlingGameApp.core.frame;

public class Frame {

    int index;
    String ballOne;
    String ballTwo;
    int total;

    public Frame(int index, String ballOne, String ballTwo) {
        this.index = index;
        this.ballOne = ballOne;
        this.ballTwo = ballTwo;
    }

    public int getTotal() {
        return total;
    }

    public int getIndex() {
        return index;
    }

    public String getBallOne() {
        return ballOne;
    }

    public String getBallTwo() {
        return ballTwo;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "index=" + index +
                ", ballOne='" + ballOne + '\'' +
                ", ballTwo='" + ballTwo + '\'' +
                ", total=" + total +
                '}';
    }
}
