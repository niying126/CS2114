package cs2114.minesweeper;
import sofia.util.Random;
// -------------------------------------------------------------------------
/**
 *  The test program of the MinSweeperBoard
 *
 *  @author niy1987
 *  @version Jan 31, 2014
 */
public class MineSweeperTest extends student.TestCase
{
    private MineSweeperBoard board;
    // ----------------------------------------------------------
    /**
     * Create a new MineSweeperTest object.
     */
    public MineSweeperTest()
    {}
    public void setUp()
    {
        board.loadBoardState("    ",
                             "OOOO",
                             "O++O",
                             "OOOO");
        System.out.println(board);
    }
    // ----------------------------------------------------------
    /**
     * A test case for the randomExample() method.
     */
    public void testRandomExample()
    {
        board = new MineSweeperBoard(4, 4, 2);
        Random.setNextInts(1, 2, 3, 1);
        board.randomBoard();
        MineSweeperBoard expected = new MineSweeperBoard(4, 4, 2);
        expected.loadBoardState("0000",
            "00+0",
            "0000",
            "0+00");
        assertEquals(expected, board);
    }
    // ----------------------------------------------------------
    /**
     * Compare the expected and the real board
     * @param theBoard The original board
     * @param expected The expected board
     */
    public void assertBoard(MineSweeperBoard theBoard, String... expected)
    {
        MineSweeperBoard expectedBoard =
            new MineSweeperBoard(expected[0].length(), expected.length, 0);
        expectedBoard.loadBoardState(expected);
        assertEquals(expectedBoard, theBoard); // uses equals() from MineSweeperBoardBase
    }

    // ----------------------------------------------------------
    /**
     * A test case for the setCell() method.
     */
    public void testSetCell()
    {
        board.setCell(1, 2, MineSweeperCell.FLAGGED_MINE);

        assertBoard(board, "    ",
                           "OOOO",
                           "OM+O",
                           "OOOO");
    }
    // ----------------------------------------------------------
    /**
     * A test case for the flagCell() method.
     */
    public void testFlagCell()
    {
        board.flagCell(1, 2);
        assertBoard(board, "    ",
                           "OOOO",
                           "OM+O",
                           "OOOO");
    }
    // ----------------------------------------------------------
    /**
     * A test case for the getCell() method.
     */
    public void testGetCell()
    {
        assertEquals("M", board.getCell(1, 2).toString());
    }
    // ----------------------------------------------------------
    /**
     * A test case for the height() method.
     */
    public void testHeight()
    {
        assertEquals(4, board.height());
    }
    // ----------------------------------------------------------
    /**
     * A test case for the isGameLost() method.
     */
    public void testIsGameLost()
    {
        assertEquals(false, board.isGameLost());
    }
    // ----------------------------------------------------------
    /**
     * A test case for the isGameWon() method.
     */
    public void testIsGameWon()
    {
        assertEquals(false, board.isGameWon());
    }
    // ----------------------------------------------------------
    /**
     * A test case for the numberOfAdjacentMines() method.
     */
    public void testNumberOfAdjacentMines()
    {
        assertEquals(0, board.numberOfAdjacentMines(0, 0));
    }
    // ----------------------------------------------------------
    /**
     * A test case for the revealBoard() method.
     */
    public void testRevealBoard()
    {
        board.revealBoard();
        assertBoard(board, "    ",
                           "    ",
                           " MM ",
                           "    ");
    }
    // ----------------------------------------------------------
    /**
     * A test case for the uncoverBoard() method.
     */
    public void testUncoverCell()
    {
        board.uncoverCell(1, 1);
        assertBoard(board, "    ",
                           " OOO",
                           "OM+O",
                           "OOOO");
    }
    // ----------------------------------------------------------
    /**
     * A test case for the width() method.
     */
    public void testWidth()
    {
        assertEquals(4, board.width());
    }
}
