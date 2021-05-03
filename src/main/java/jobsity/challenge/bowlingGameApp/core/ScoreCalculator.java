package jobsity.challenge.bowlingGameApp.core;

import java.util.List;

public class ScoreCalculator {
    public int[] calculateScoresByPlayer(List<String> buildKnockedDownPinsByBall) {
        int[] result = new int[10];
        for(int i = 0; i < 10; i++) {
            if(buildKnockedDownPinsByBall.get(i).toString() == "") {
                if(buildKnockedDownPinsByBall.get(i+1) == "X") {
                    result[i] = getValue(buildKnockedDownPinsByBall, i+1);
                    if(nextFrameIsStrike(buildKnockedDownPinsByBall, i < 2 ? 2: i*2)) {
                        result[0] = result[0] + getValue(buildKnockedDownPinsByBall, i+3);
                    }
                    if(nextFrameIsStrike(buildKnockedDownPinsByBall, i+4)) {
                        result[0] = result[0] + getValue(buildKnockedDownPinsByBall, i+5);
                    }

                }
            }

        }

        return result;
    }

    public int getValue(List<String> buildKnockedDownPinsByBall, int position) {
        String currentValue = buildKnockedDownPinsByBall.get(position);
        if(currentValue == "/") {
            String previousValue = buildKnockedDownPinsByBall.get(position-1);
            return 10 - Integer.valueOf(previousValue);
        }

        if (currentValue == "X") {
            return 10;
        }

        if(currentValue == "" || currentValue == "F") {
            return 0;
        }

        return Integer.valueOf(currentValue);
    }

    public boolean nextFrameIsStrike(List<String> buildKnockedDownPinsByBall, int index) {
        String ballOne = buildKnockedDownPinsByBall.get(index);
        String ballTwo = buildKnockedDownPinsByBall.get(index+1);
        if(ballOne == "" & ballTwo == "X") {
            return true;
        }
        return false;
    }
}
