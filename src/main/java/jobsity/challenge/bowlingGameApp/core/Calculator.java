package jobsity.challenge.bowlingGameApp.core;

import jobsity.challenge.bowlingGameApp.core.frame.Frame;
import jobsity.challenge.bowlingGameApp.core.frame.FrameUtils;

import java.util.Iterator;
import java.util.List;

public class Calculator {

    public static int getTotal(List<Frame> game) {

        Iterator<Frame> frameIterator =  game.iterator();
        Frame currentFrame;
        while (frameIterator.hasNext()) {
            currentFrame = frameIterator.next();
            if(strikeIsFollowByTwoMoreStrikes(game, currentFrame)) {

            }
        }
        return 0;
    }

    public static boolean strikeIsFollowByTwoMoreStrikes(List<Frame> game, Frame currentFrame) {
        boolean isFirstNextFrameStrike = FrameUtils.isStrike(game.get(currentFrame.getIndex() + 1));
        boolean isSecondNextFrameStrike = FrameUtils.isStrike(game.get(currentFrame.getIndex() + 2));
        return isFirstNextFrameStrike & isSecondNextFrameStrike;
    }

}
