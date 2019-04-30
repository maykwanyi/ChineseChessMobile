package com.example.chinesechess;

import java.awt.List;

public class Piece {
    public Piece(boolean isRed, int X, int Y, int id)
    {
        this.X = X;
        this.Y = Y;
        this.isRed = isRed;
        isEmpty = false;
        this.id = id;
    }

    public Piece(int X, int Y)
    {
        this.X = X;
        this.Y = Y;
        isEmpty = true;
    }

    public void eat(Board board)
    {
        if (!board.board[X][Y].isEmpty && board.board[X][Y].isRed != isRed)
        {
            board.board[X][Y] = this;
            if (new Point2D(X, Y).Equals(board.RGP))
                Game.checkmate("RED");
            else if (new Point2D(X, Y).Equals(board.BGP))
                Game.checkmate("BLACK");
        }
    }
}
