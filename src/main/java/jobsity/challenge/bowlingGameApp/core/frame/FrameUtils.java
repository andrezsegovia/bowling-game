package jobsity.challenge.bowlingGameApp.core.frame;

import java.util.List;

public class FrameUtils {

    public static boolean isStrike(Frame frame) {
        if(frame.getBallTwo().toLowerCase().equals("x")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static boolean isSpare(Frame frame) {
        if(frame.getBallTwo().equals("/")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static int calculateTotalByFrame(Frame frame) {
        return ballValueToInt(frame, 1) + ballValueToInt(frame, 2);
    }

    public static int ballValueToInt(Frame frame, int ballNumber) {
        Integer result;

        String ballValue = ballNumber == 1? frame.getBallOne(): frame.getBallTwo();

        if(ballValue == null) {
            throw new NullPointerException("Ball value is null");
        }

        switch (ballValue) {
            case "":
                result = 0;
                break;
            case "X":
                result = 10;
                break;
            case "/":
                result = 10 - Integer.valueOf(frame.getBallOne());
                break;
            case "F":
                result = 0;
                break;
            default:
                result = Integer.valueOf(ballValue);
        }
        return result.intValue();
    }


}
