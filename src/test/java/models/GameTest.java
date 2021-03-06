package models;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void newGame_instantiatesCorrectly() throws Exception {
        Game testGame = new Game();
        assertEquals(true, testGame instanceof Game);
    }

    @Test
    public void newGame_getsGuessedLetters_Array() throws Exception{
        Game testGame = new Game();
        assertEquals(true, testGame.getGuessedLetters() instanceof ArrayList);
    }

    @Test
    public void generateWord_randomlyChoosesWord_string() throws Exception{
        Game testGame = new Game();
        assertEquals(true, testGame.generateWord() instanceof String);
    }

    @Test
    public void newGame_getAnswer_zebra() throws Exception{
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        assertEquals("zebra", testGame.getAnswer());
    }


    @Test
    public void newGame_getUserPuzzle_String() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.setUserPuzzle();
        List<Character> expected = new ArrayList<Character>();
        expected.add('_');
        expected.add('_');
        expected.add('_');
        expected.add('_');
        expected.add('_');
        assertEquals(expected, testGame.getUserPuzzle());
    }

    @Test
    public void checkGuess_addsToCharacterGuessedList_ArrayList() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.checkGuess('z');
        ArrayList<Character> expected = new ArrayList<Character>();
        expected.add('z');
        assertEquals(expected, testGame.getGuessedLetters());
    }

    @Test
    public void checksGuess_checksIfGuessInAnswer_true() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        assertEquals(true, testGame.checkGuess('z'));
    }
    @Test
    public void checksGuess_checksIfGuessNotInAnswer_false() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        assertEquals(false, testGame.checkGuess('g'));
    }

    @Test
    public void revealLetters_revealsLettersInUserPuzzle_string() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.setUserPuzzle();
        testGame.revealLetters('z');
        List<Character> expected = new ArrayList<Character>();
        expected.add('z');
        expected.add('_');
        expected.add('_');
        expected.add('_');
        expected.add('_');
        assertEquals(expected, testGame.getUserPuzzle());

    }

    @Test
    public void checkWin_returnsFalseIfWrongGuess_false() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.setUserPuzzle();
        assertEquals(false, testGame.checkWin());
    }

    @Test
    public void checkWin_returnsTrueIfCorrectGuess_true() throws Exception {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.setUserPuzzle();
        testGame.revealLetters('z');
        testGame.revealLetters('e');
        testGame.revealLetters('b');
        testGame.revealLetters('r');
        testGame.revealLetters('a');
        assertEquals(true, testGame.checkWin());
    }

    @Test
    public void getWrongGuessCount_returnCount_0() {
        Game testGame = new Game();
        assertEquals(0, testGame.getWrongGuessCount());
    }

    @Test
    public void checkGuess_addToWrongGuessCount_1() {
        Game testGame = new Game();
        testGame.setAnswer("zebra");
        testGame.checkGuess('g');
        assertEquals(1, testGame.getWrongGuessCount());
    }
}