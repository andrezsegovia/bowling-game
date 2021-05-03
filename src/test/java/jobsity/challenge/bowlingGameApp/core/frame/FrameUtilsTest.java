package jobsity.challenge.bowlingGameApp.core.frame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FrameUtilsTest {

    @Test
    public void frameShouldBeStrike() {
        Frame frame = new Frame(0, "", "X");
        assertTrue(FrameUtils.isStrike(frame));
    }

    @Test
    public void frameShouldNotBeStrike() {
        Frame frame = new Frame(0, "8", "1");
        assertFalse(FrameUtils.isStrike(frame));
    }

    @Test
    public void frameShouldBeSpare() {
        Frame frame = new Frame(0, "8", "/");
        assertTrue(FrameUtils.isSpare(frame));
    }

    @Test
    public void frameShouldNotBeSpare() {
        Frame frame = new Frame(0, "F", "2");
        assertFalse(FrameUtils.isSpare(frame));
    }

    @Test
    public void shouldConvertBallValueFromStringToIntForBallOne() {
        Frame frame = new Frame(0, "7", "2");
        assertEquals(FrameUtils.ballValueToInt(frame, 1), 7);
    }

    @Test
    public void shouldConvertBallValueFromStringToIntForBallTwo() {
        Frame frame = new Frame(0, "7", "2");
        assertEquals(FrameUtils.ballValueToInt(frame, 2), 2);
    }

    @Test
    public void shouldConvertBallValueFromStringToIntForBallOneWhenIsFoul() {
        Frame frame = new Frame(0, "F", "2");
        assertEquals(FrameUtils.ballValueToInt(frame, 1), 0);
    }

    @Test
    public void shouldConvertBallValueFromStringToIntForBallOneWhenIsEmpty() {
        Frame frame = new Frame(0, "", "/");
        assertEquals(FrameUtils.ballValueToInt(frame, 1), 0);
    }

    @ParameterizedTest
    @CsvSource({
            "0, '', X, 0",
            "0, F, 2, 0",
            "0, 2, /, 2",
            "0, 0, 3, 0",
            "0, 2, 7, 2",
            "0, 2, F, 2"})
    public void shouldConvertBallValueFromStringToIntForBallOne(ArgumentsAccessor argumentsAccessor) {
        Frame frame = new Frame(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1),
                argumentsAccessor.getString(2));
        assertEquals(argumentsAccessor.getInteger(3), FrameUtils.ballValueToInt(frame, 1));
    }

    @ParameterizedTest
    @CsvSource({
            "0, '', X, 10",
            "0, F, 2, 2",
            "0, 2, /, 8",
            "0, 0, 3, 3",
            "0, 2, 7, 7",
            "0, 2, F, 0"})
    public void shouldConvertBallValueFromStringToIntForBallTwo(ArgumentsAccessor argumentsAccessor) {
        Frame frame = new Frame(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1),
                argumentsAccessor.getString(2));
        assertEquals(argumentsAccessor.getInteger(3),FrameUtils.ballValueToInt(frame, 2));
    }

    @ParameterizedTest
    @CsvSource({
            "0, '', X, 10",
            "0, F, 2, 2",
            "0, 2, /, 10",
            "0, 0, 3, 3",
            "0, 2, 7, 9",
            "0, 2, F, 2"})
    public void calculateTotalByFrame(ArgumentsAccessor argumentsAccessor) {
        Frame frame = new Frame(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1),
                argumentsAccessor.getString(2));
        assertEquals(argumentsAccessor.getInteger(3), FrameUtils.calculateTotalByFrame(frame));
    }


}