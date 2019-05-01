package edu.umb.cs443.chinesechess.piece;

import java.awt.List;

public class Advisor extends Piece
{
    public Advisor(boolean isRed, int X, int Y, int id)
    {
        this.X = X;
        this.Y = Y;
        this.isRed = isRed;
        this.isEmpty = false;
        this.id = id;
    }

    public boolean move(int X, int Y, Board board)
    {
        List<Point2D> moveList = new List<Point2D>();
        if (moveList.Contains(new Point2D(X, Y)))
        {
            this.X = X;
            this.Y = Y;
            eat(board);
            board.updatePos(this,X,Y);
            return true;
        }
        return false;
    }

    public List<Point2D> getMoveList(Board board)
    {
        List<Point2D> list = new List<Point2D>();
        if (isRed)
        {
            if (board.isInRedPalace(X + 1, Y + 1))
                list.Add(new Point2D(X + 1, Y + 1));
            if (board.isInRedPalace(X - 1, Y - 1))
                list.Add(new Point2D(X - 1, Y - 1));
            if (board.isInRedPalace(X + 1, Y - 1))
                list.Add(new Point2D(X + 1, Y - 1));
            if (board.isInRedPalace(X - 1, Y + 1))
                list.Add(new Point2D(X - 1, Y + 1));
        }
        else
        {
            if (board.isInBlackPalace(X + 1, Y + 1))
                list.Add(new Point2D(X + 1, Y + 1));
            if (board.isInBlackPalace(X - 1, Y - 1))
                list.Add(new Point2D(X - 1, Y - 1));
            if (board.isInBlackPalace(X + 1, Y - 1))
                list.Add(new Point2D(X + 1, Y - 1));
            if (board.isInBlackPalace(X - 1, Y + 1))
                list.Add(new Point2D(X - 1, Y + 1));
        }
        return list;
    }
    
    public static boolean checkPos(int X, int Y,boolean isRed)
    {
        if (isRed && (X == 4 && Y == 0) || (X == 5 && Y == 1) || (X == 6 && Y == 0) || (X == 4 && Y == 2) || (X == 6 && Y == 2))
            return true;
        else if (!isRed && (X == 4 && Y == 9) || (X == 5 && Y == 8) || (X == 6 && Y == 9) || (X == 4 && Y == 7) || (X == 6 && Y == 7))
            return true;
        return false;
    }
}
