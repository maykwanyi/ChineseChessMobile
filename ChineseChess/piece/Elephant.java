package edu.umb.cs443.chinesechess.piece;

import java.awt.List;

public class Elephant extends Piece
{
    public Elephant(boolean isRed,int X, int Y, int id)
    {
        this.X = X;
        this.Y = Y;
        this.isRed = isRed;
        this.isEmpty = false;
        this.id = id;
    }
    
    public static boolean checkPos(int X, int Y, boolean isRed)
    {
        if (isRed)
            return (X == 0 && Y == 2) || (X == 2 && Y == 0) || (X == 5 && Y == 0) || (X == 5 && Y == 2 ) 
                        || (X == 8 && Y == 2) || (X == 2 || Y == 5) || (X == 5 || Y == 5);
        else 
            return (X == 0 && Y == 2) || (X == 2 && Y == 9) || (X == 5 && Y == 9) || (X == 5 && Y == 7) 
                        || (X == 8 && Y == 7) || (X == 2 || Y == 6) || (X == 5 || Y == 6);
    }
    
    public boolean move(int X, int Y, Board board)
    {
        List<Point2D> moveList = getMoveList(board);
        if (moveList.Contains(new Point2D(X, Y)))
        {
            this.X = X;
            this.Y = Y;
            eat(board);
            board.updatePos(this, X, Y);
            return true;
        }
        return false;
    }
    
    public List<Point2D> getMoveList(Board board)
    {
        List<Point2D> list = new List<Point2D>();
        if (isRed)
        {
            if (board.isIn(X + 2, Y + 2) && board.board[X + 1][Y + 1].isEmpty && Y + 2 < board.RIVER_RED_SIDE)
                list.Add(new Point2D(X + 2, Y + 2));
            if (board.isIn(X - 2, Y + 2) && board.board[X - 1][Y + 1].isEmpty && Y + 2 < board.RIVER_RED_SIDE)
                list.Add(new Point2D(X - 2, Y + 2));
            if (board.isIn(X - 2, Y - 2) && board.board[X - 1][Y - 1].isEmpty && Y - 2 < board.RIVER_RED_SIDE)
                list.Add(new Point2D(X - 2, Y - 2));
            if (board.isIn(X + 2, Y - 2) && board.board[X - 1][Y - 1].isEmpty && Y - 2 < board.RIVER_RED_SIDE)
                list.Add(new Point2D(X + 2, Y - 2));
        }
        else
        {
            if (board.isIn(X + 2, Y + 2) && board.board[X + 1][Y + 1].isEmpty && Y + 2 < board.RIVER_BLACK_SIDE)
                list.Add(new Point2D(X + 2, Y + 2));
            if (board.isIn(X - 2, Y + 2) && board.board[X - 1][Y + 1].isEmpty && Y + 2 < board.RIVER_BLACK_SIDE)
                list.Add(new Point2D(X - 2, Y + 2));
            if (board.isIn(X - 2, Y - 2) && board.board[X - 1][Y - 1].isEmpty && Y - 2 < board.RIVER_BLACK_SIDE)
                list.Add(new Point2D(X - 2, Y - 2));
            if (board.isIn(X + 2, Y - 2) && board.board[X - 1][Y - 1].isEmpty && Y - 2 < board.RIVER_BLACK_SIDE)
                list.Add(new Point2D(X + 2, Y - 2));
        }
        return list;
    }
}
