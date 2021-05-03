package jobsity.challenge.bowlingGameApp.utils;

import jobsity.challenge.bowlingGameApp.model.Frame;

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

    public static int calculateTotalByFrameWithThreeBalls(Frame frame) {
        return ballValueToInt(frame, 1) + ballValueToInt(frame, 2)
                + (frame.getBallThree() != null && !frame.getBallThree().isEmpty() ? ballValueToInt(frame, 3) : 0);
    }

    public static int ballValueToInt(Frame frame, int ballNumber) {
        Integer result;

        String ballValue = null;

        if(ballNumber == 1) {
            ballValue = frame.getBallOne();
        } else if(ballNumber == 2) {
            ballValue = frame.getBallTwo();
        } else if(ballNumber == 3) {
            ballValue = frame.getBallThree();
        }

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
