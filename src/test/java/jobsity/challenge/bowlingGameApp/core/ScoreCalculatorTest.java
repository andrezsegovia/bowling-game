package jobsity.challenge.bowlingGameApp.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class ScoreCalculatorTest {

    private ScoreCalculator scoreCalculator;

    @BeforeEach
    public void setUp() throws Exception {
        scoreCalculator = new ScoreCalculator();
    }

    @Test
    public void getScoreWhenAllFrameAreStrike() {
        String[] knockedDownPinsByBall = {"", "X", "", "X", "", "X", "", "X", "", "X", "", "X", "", "X", "", "X", "", "X", "X", "X", "X"};
        int[] expectedResult = {30,60,90,120,150,180,210,240,270,300};
        int[] score = scoreCalculator.calculateScoresByPlayer(buildKnockedDownPinsByBall());
        assertEquals(buildExpectedScoreByPlayer(), score);
    }

    private List<String> buildKnockedDownPinsByBall() {
        String[] knockedDownPinsByBall = {"", "X", "7", "/", "9", "0", "", "X", "0", "8", "8", "/", "F", "6", "", "X", "", "X", "X", "8", "1"};
        return Arrays.asList(knockedDownPinsByBall);
    }

    private int[] buildExpectedScoreByPlayer() {
        return new int[] {20,39,48,66,74,84,90,120,148,167};
    }


}