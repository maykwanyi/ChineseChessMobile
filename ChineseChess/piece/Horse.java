package edu.umb.cs443.chinesechess.piece;

import java.awt.List;

public class Horse extends Piece {
    public Horse(boolean isRed, int X, int Y, int id)
    {
        this.X = X;
        this.Y = Y;
        this.isRed = isRed;
        this.isEmpty = false;   // false = having stuff on it
        this.id = id;
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

        if(board.isIn(X + 1, Y))
        {
            if (board.board[X + 1][Y].isEmpty && board.isIn(X + 2, Y + 1))
            { list.Add(new Point2D(X + 2, Y + 1)); }
            if (board.board[X + 1][Y].isEmpty && board.isIn(X + 2, Y - 1))
                list.Add(new Point2D(X + 2, Y - 1));
        }
        if (board.isIn(X - 1, Y)){
            if (board.board[X - 1][Y].isEmpty && board.isIn(X - 2, Y + 1))
            { list.Add(new Point2D(X + 2, Y + 1)); }
            if (board.board[X - 1][Y].isEmpty && board.isIn(X - 2, Y - 1))
                list.Add(new Point2D(X + 2, Y - 1));
        }
        if (board.isIn(X, Y + 1))
        {
            if (board.board[X][Y + 1].isEmpty && board.isIn(X + 1, Y + 2))
            { list.Add(new Point2D(X + 2, Y + 1)); }
            if (board.board[X - 1][Y].isEmpty && board.isIn(X - 1, Y + 2))
                list.Add(new Point2D(X + 2, Y - 1));
        }
        if (board.isIn(X, Y - 1))
        {
            if (board.board[X][Y - 1].isEmpty && board.isIn(X + 1, Y - 2))
            { list.Add(new Point2D(X + 2, Y + 1)); }
            if (board.board[X][Y - 1].isEmpty && board.isIn(X - 1, Y - 2))
                list.Add(new Point2D(X + 2, Y - 1));
        }
        return list;
    }
}
