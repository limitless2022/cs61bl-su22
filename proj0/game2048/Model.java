package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author Guo
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board _board;
    /** Current score. */
    private int _score;
    /** Maximum score so far.  Updated when game ends. */
    private int _maxScore;

    /** True iff game is ended. */
    private boolean _gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        //空的！
        this._board = new Board(size);
        this._score = 0;
        this._maxScore = 0;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        this._score = score;
        this._maxScore = maxScore;
        this._gameOver = gameOver;
        this._board = new Board(rawValues, score);
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     */
    public Tile tile(int col, int row) {
        return _board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return _board.size();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (_gameOver) {
            _maxScore = Math.max(_score, _maxScore);
        }
        return _gameOver;
    }

    /** Return the current score. */
    public int score() {
        return _score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return _maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        _score = 0;
        _gameOver = false;
        _board.clear();
        setChanged();
    }
    //两两合一。tile.value() Model类代表游戏的整个状态(所有棋盘Tile对象是什么，分数是多少。)
    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        _board.addTile(tile);
        checkGameOver();
        setChanged();
    }


    public boolean checkmove(Board b,int c,int r,int now) {
        Tile t = b.tile(c,r),t_now =b.tile(c,now);
        if (t == null) return true;
        if (t.value()==t_now.value()) {
            if (r - now != 1) {//上下相同则可移动。
                for (int i = r - 1; i > now; i--) {//相隔的情况
                    if (b.tile(c, i) != null) return false;
                }
            }
            return true;
        }
        return false;
    }
    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     */
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;
        //test
        Board b = _board;
        b.setViewingPerspective(side);
        for (int c=0;c<b.size();c++) {
            for (int ori=b.size()-1;ori>=0;ori--) {//从小处移动到大处。
                for (int now=ori-1;now>=0;now--) {
                    Tile t_now = b.tile(c,now);
                    if (t_now==null) continue;
                    if (checkmove(b,c,ori,now)) {
                        boolean temp = b.move(c,ori,t_now);
                        changed = true;
                        if (!temp) ori++;
                        else _score += b.tile(c,ori).value();
                        break;
                    }
                }
            }
        }
        b.setViewingPerspective(Side.NORTH);


        checkGameOver();
        if (changed) {
            setChanged();
        }
        return changed;
    }

    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        _gameOver = checkGameOver(_board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     */
    public static boolean emptySpaceExists(Board b) {
        for (int i=0;i < b.size();i++) {
            for (int j=0;j < b.size();j++) {
                Tile t = b.tile(i,j);
                if (t == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        for (int i=0;i < b.size();i++) {
            for (int j=0;j < b.size();j++) {
                Tile t = b.tile(i,j);
                if (t != null&&t.value()==MAX_PIECE) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        int[] dx = {0,-1,0,1};
        int[] dy = {-1,0,1,0};
        for (int i=0;i < b.size();i++) {
            for (int j=0;j < b.size();j++) {
                Tile t = b.tile(i,j);
                if (t == null) {
                    return true;
                } else {//有两个相邻(四个方向)的瓦片具有相同的值。
                    //四个方向和两值比较--how? dx、dy
                    for (int k=0;k<4;k++) {
                            int x = i+dx[k],y = j+dy[k];
                            if (x>=0&&y< b.size()&&y>=0&&x<b.size()){
                                Tile c = b.tile(x,y);
                                if (c!=null&&t.value()==c.value()) return true;
                            }
                    }
                }
            }
        }
        return false;
    }

    /** Returns the model as a string, used for debugging. */
    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    /** Returns whether two models are equal. */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    /** Returns hash code of Model’s string. */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
