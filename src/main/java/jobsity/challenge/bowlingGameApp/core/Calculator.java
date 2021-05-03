package jobsity.challenge.bowlingGameApp.core;

import jobsity.challenge.bowlingGameApp.model.Frame;
import jobsity.challenge.bowlingGameApp.utils.FrameUtils;

import java.util.Iterator;
import java.util.List;

public class Calculator {


    public static void compute(List<Frame> game) {
        Iterator<Frame> frameIterator =  game.iterator();
        Frame currentFrame;
        while (frameIterator.hasNext()) {
            currentFrame = frameIterator.next();
            if(FrameUtils.isStrike(currentFrame)) {
                if(currentFrame.getIndex() <= 6) {
                    if(strikeIsFollowByTwoMoreStrikes(game, currentFrame)) {
                        currentFrame.setTotal(
                                FrameUtils.calculateTotalByFrame(currentFrame)
                                + FrameUtils.calculateTotalByFrame(game.get(currentFrame.getIndex()+1))
                                + FrameUtils.calculateTotalByFrame(game.get(currentFrame.getIndex()+2))
                                + (currentFrame.getIndex() > 0 ? game.get(currentFrame.getIndex()-1).getTotal():0));
                    } else if(FrameUtils.isStrike(game.get(currentFrame.getIndex()+1))) {
                        currentFrame.setTotal(
                                FrameUtils.calculateTotalByFrame(currentFrame)
                                        + FrameUtils.calculateTotalByFrame(game.get(currentFrame.getIndex()+1))
                                        + FrameUtils.ballValueToInt(game.get(currentFrame.getIndex()+2),1)
                                        + (currentFrame.getIndex()>0? game.get(currentFrame.getIndex()-1).getTotal():0));
                    } else {
                        currentFrame.setTotal(
                                FrameUtils.calculateTotalByFrame(currentFrame)
                                        + FrameUtils.calculateTotalByFrame(game.get(currentFrame.getIndex()+1))
                                        + (currentFrame.getIndex()>0? game.get(currentFrame.getIndex()-1).getTotal():0));

                    }

                } else {
                    if (currentFrame.getIndex() == 7) {
                        currentFrame.setTotal(
                                FrameUtils.calculateTotalByFrame(currentFrame)
                                        + FrameUtils.calculateTotalByFrame(game.get(currentFrame.getIndex() + 1))
                                        + FrameUtils.ballValueToInt(game.get(currentFrame.getIndex()+2),1)
                                        + (currentFrame.getIndex() > 0 ? game.get(currentFrame.getIndex() - 1).getTotal() : 0));
                    } else if (currentFrame.getIndex() == 8) {
                        currentFrame.setTotal(
                                FrameUtils.calculateTotalByFrame(currentFrame)
                                        + FrameUtils.calculateTotalByFrame(game.get(currentFrame.getIndex() + 1))
                                        + (currentFrame.getIndex() > 0 ? game.get(currentFrame.getIndex() - 1).getTotal() : 0));
                    } else {
                        currentFrame.setTotal(
                                FrameUtils.calculateTotalByFrameWithThreeBalls(currentFrame)
                                        + (currentFrame.getIndex() > 0 ? game.get(currentFrame.getIndex() - 1).getTotal() : 0));

                    }
                }
            } else if(FrameUtils.isSpare(currentFrame)) {
                if(currentFrame.getIndex() == 9) {
                    currentFrame.setTotal(
                            FrameUtils.calculateTotalByFrameWithThreeBalls(currentFrame)
                                    + (currentFrame.getIndex() > 0 ? game.get(currentFrame.getIndex()-1).getTotal() : 0));
                } else {
                    currentFrame.setTotal(
                            FrameUtils.calculateTotalByFrame(currentFrame)
                                    + FrameUtils.ballValueToInt(game.get(currentFrame.getIndex()+1), 1)
                                    + (currentFrame.getIndex() > 0 ? game.get(currentFrame.getIndex()-1).getTotal() : 0));
                }
            } else {
                if(currentFrame.getIndex() == 9) {
                    currentFrame.setTotal(
                            FrameUtils.calculateTotalByFrameWithThreeBalls(currentFrame)
                                    + (currentFrame.getIndex() > 0 ? game.get(currentFrame.getIndex()-1).getTotal() : 0));
                } else {
                    currentFrame.setTotal(
                            FrameUtils.calculateTotalByFrame(currentFrame)
                                    + (currentFrame.getIndex() > 0 ? game.get(currentFrame.getIndex()-1).getTotal() : 0));
                }
            }
            game.get(currentFrame.getIndex()).setTotal(currentFrame.getTotal());
        }
    }

    public static boolean strikeIsFollowByTwoMoreStrikes(List<Frame> game, Frame currentFrame) {
        boolean isFirstNextFrameStrike = FrameUtils.isStrike(game.get(currentFrame.getIndex() + 1));
        boolean isSecondNextFrameStrike = FrameUtils.isStrike(game.get(currentFrame.getIndex() + 2));
        return isFirstNextFrameStrike & isSecondNextFrameStrike;
    }

}
