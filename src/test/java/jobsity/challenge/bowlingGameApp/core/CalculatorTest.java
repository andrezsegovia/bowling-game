package jobsity.challenge.bowlingGameApp.core;

import jobsity.challenge.bowlingGameApp.core.frame.Frame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CalculatorTest {

    @Test
    public void shouldCalculateTotalForEachFrameAllStrikes() {
        List<Frame> game = new ArrayList<>();
        game.add(new Frame(0, "", "X"));
        game.add(new Frame(1, "", "X"));
        game.add(new Frame(2, "", "X"));
        game.add(new Frame(3, "", "X"));
        game.add(new Frame(4, "", "X"));
        game.add(new Frame(5, "", "X"));
        game.add(new Frame(6, "", "X"));
        game.add(new Frame(7, "", "X"));
        game.add(new Frame(8, "", "X"));
        game.add(new Frame(9, "X", "X", "X"));

        int[] totals = {30,60,90,120,150,180,210,240,270,300};
        Calculator.compute(game);
        int[] result = game.stream().mapToInt(Frame::getTotal).toArray();
        assertArrayEquals(totals, result);
    }

    @Test
    public void shouldCalculateTotalForEachAllSpare() {
        List<Frame> game = new ArrayList<>();
        game.add(new Frame(0, "2", "/"));
        game.add(new Frame(1, "2", "/"));
        game.add(new Frame(2, "2", "/"));
        game.add(new Frame(3, "2", "/"));
        game.add(new Frame(4, "2", "/"));
        game.add(new Frame(5, "2", "/"));
        game.add(new Frame(6, "2", "/"));
        game.add(new Frame(7, "2", "/"));
        game.add(new Frame(8, "2", "/"));
        game.add(new Frame(9, "2", "/", "2"));

        int[] totals = {12,24,36,48,60,72,84,96,108,120};
        Calculator.compute(game);
        int[] result = game.stream().mapToInt(Frame::getTotal).toArray();
        assertArrayEquals(totals, result);
    }

    @Test
    public void shouldCalculateTotalForEachFrame() {
        List<Frame> game = new ArrayList<>();
        game.add(new Frame(0, "", "X"));
        game.add(new Frame(1, "7", "/"));
        game.add(new Frame(2, "9", "0"));
        game.add(new Frame(3, "", "X"));
        game.add(new Frame(4, "0", "8"));
        game.add(new Frame(5, "8", "/"));
        game.add(new Frame(6, "F", "6"));
        game.add(new Frame(7, "", "X"));
        game.add(new Frame(8, "", "X"));
        game.add(new Frame(9, "X", "8", "1"));

        int[] totals = {20,39,48,66,74,84,90,120,148,167};
        Calculator.compute(game);
        int[] result = game.stream().mapToInt(Frame::getTotal).toArray();
        assertArrayEquals(totals, result);
    }

    @Test
    public void shouldCalculateTotalForEachFrame2() {
        List<Frame> game = new ArrayList<>();
        game.add(new Frame(0, "3", "/"));
        game.add(new Frame(1, "6", "3"));
        game.add(new Frame(2, "", "X"));
        game.add(new Frame(3, "8", "1"));
        game.add(new Frame(4, "", "X"));
        game.add(new Frame(5, "", "X"));
        game.add(new Frame(6, "9", "0"));
        game.add(new Frame(7, "7", "/"));
        game.add(new Frame(8, "4", "4"));
        game.add(new Frame(9, "X", "9", "0"));

        int[] totals = {16,25,44,53,82,101,110,124,132,151};
        Calculator.compute(game);
        int[] result = game.stream().mapToInt(Frame::getTotal).toArray();
        assertArrayEquals(totals, result);
    }


}