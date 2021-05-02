package jobsity.challenge.bowlingGameApp.core;

import jobsity.challenge.bowlingGameApp.core.frame.Frame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldCalculateTotalForStrikeFrameFollowByTwoStrikeFrames() {
        List<Frame> game = new ArrayList<>();
        game.add(new Frame(0, "", "X"));
        game.add(new Frame(1, "", "X"));
        game.add(new Frame(2, "", "X"));

        assertEquals(Calculator.getTotal(game), 30);

    }

}