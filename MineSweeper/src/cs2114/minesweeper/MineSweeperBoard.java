package cs2114.minesweeper;
import java.util.Random;
// -------------------------------------------------------------------------
/**
 *  A program of sweeper mine board
 *  The subclass of MineSweeperBoardBase that it declares how to initialize the
 *  board and how the board works
 *
 *  @author niy1987
 *  @version Jan 31, 2014
 */
public class MineSweeperBoard extends MineSweeperBoardBase
{
    private int row;
    private int col;
    private MineSweeperCell[][] m;
    // ----------------------------------------------------------
    /**
     * Create a new MineSweeperBoard object.
     * @param w The number of column of the board
     * @param h The number of rows of the board
     * @param n The number of mines in the board
     */
    public MineSweeperBoard(int w, int h, int n)
    {
        row = h;
        col = w;

        m = new MineSweeperCell[row][col];
        Random r = new sofia.util.Random();
        int count = 0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                setCell(j, i, MineSweeperCell.COVERED_CELL);
            }
        }
        while (count < n)
        {
            int i = r.nextInt(col);
            int j = r.nextInt(row);
            if (getCell(i, j) != MineSweeperCell.MINE)
            {
                setCell(i, j, MineSweeperCell.MINE);
                count++;
            }
        }
    }
    /**
     * Place or remove a flag from the specified cell.
     * @param x The column number
     * @param y The row number
     */
    public void flagCell(int x, int y)
    {
        if (getCell(x, y) == MineSweeperCell.COVERED_CELL)
        {
            setCell(x, y, MineSweeperCell.FLAG);
        }
        else if (getCell(x, y) == MineSweeperCell.MINE)
        {
            setCell(x, y, MineSweeperCell.FLAGGED_MINE);
        }
        else if (getCell(x, y) == MineSweeperCell.FLAG)
        {
            setCell(x, y, MineSweeperCell.COVERED_CELL);
        }
        else if (getCell(x, y) == MineSweeperCell.FLAGGED_MINE)
        {
            setCell(x, y, MineSweeperCell.MINE);
        }
    }
    /**
     * Get the contents of the specified cell on this MineSweeperBoard.
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The contents of the specified cell
     */
    public MineSweeperCell getCell(int x, int y)
    {
        if (x >= col || x < 0 || y >= row || y < 0)
        {
            return MineSweeperCell.INVALID_CELL;
        }
        else
        {
            return m[y][x];
        }
    }
    /**
     * Get the number of rows in this MineSweeperBoard.
     * @return The rows of the board
     */
    public int height()
    {
        return row;
    }
    /**
     * Determine if the player has lost the current game.
     * @return The game is lost or not
     */
    public boolean isGameLost()
    {
        boolean found = false;

        for (int i = 0; i < row; i++)
        {
            int j = 0;
            while (!found && j < col)
            {
                if (getCell(j, i) != MineSweeperCell.UNCOVERED_MINE)
                {
                    j++;
                }
                else
                {
                    found = true;
                }
            }
        }
        return found;
    }
    /**
     * Determine if the player has won the current game.
     * @return Whether the game is won or not
     */
    public boolean isGameWon()
    {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (getCell(j, i) == MineSweeperCell.FLAG || getCell(j, i) ==
                    MineSweeperCell.COVERED_CELL ||
                    getCell(j, i) == MineSweeperCell.UNCOVERED_MINE ||
                    getCell(j, i) == MineSweeperCell.MINE)
                {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Count the number of mines that appear in cells that are adjacent to the
     * specified cell.
     * @param x The x coordinate
     * @param y The y coordinate
     * @return the number of adjacent mines
     */
    public int numberOfAdjacentMines(int x, int y)
    {
        int count = 0;
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        startX = x - 1 < 0 ? 0 : x - 1;
        endX = x + 2 >= col ? col : x + 2;

        startY = y - 1 < 0 ? 0 : y - 1;
        endY = y + 2 >= row ? row : y + 2;

        for (int i = startY; i < endY; i++)
        {
            for (int j = startX; j < endX; j++)
            {
                if (getCell(j, i) == MineSweeperCell.MINE || getCell(j, i)
                    == MineSweeperCell.FLAGGED_MINE || getCell(j, i)
                    == MineSweeperCell.UNCOVERED_MINE)
                {
                    count++;
                }

            }
        }
        return count;
    }
    /**
     * Uncover all of the cells on the board.
     */
    public void revealBoard()
    {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                uncoverCell(j, i);
            }
        }
    }
    /**
     * Uncover the specified cell.
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public void uncoverCell(int x, int y)
    {
        if (getCell(x, y) == MineSweeperCell.MINE)
        {
            setCell(x, y, MineSweeperCell.UNCOVERED_MINE);
        }
        else if (getCell(x, y) == MineSweeperCell.COVERED_CELL)
        {
            setCell(x, y,
                MineSweeperCell.adjacentTo(numberOfAdjacentMines(x, y)));
        }
    }
    /**
     * Get the number of columns in this MineSweeperBoard.
     * @return The number of columns
     */
    public int width()
    {
        return col;
    }
    /**
     * Set the contents of the specified cell on this MineSweeperBoard.
     * @param x The x coordinate
     * @param y The y coordinate
     * @param value The MineSweeperCell value
     */
    protected void setCell(int x, int y, MineSweeperCell value)
    {
        m[y][x] = value;
    }
}
