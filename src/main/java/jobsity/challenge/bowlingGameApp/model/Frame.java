package jobsity.challenge.bowlingGameApp.model;

public class Frame {

    int index;
    String ballOne;
    String ballTwo;
    String ballThree;
    int total;

    public Frame(int index, String ballOne, String ballTwo) {
        this.index = index;
        this.ballOne = ballOne;
        this.ballTwo = ballTwo;
    }

    public Frame(int index, String ballOne, String ballTwo, String ballThree) {
        this.index = index;
        this.ballOne = ballOne;
        this.ballTwo = ballTwo;
        this.ballThree = ballThree;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public String getBallThree() {
        return ballThree;
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
