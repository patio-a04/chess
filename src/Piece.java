import java.util.ArrayList;

import javax.swing.Icon;

public class Piece {
    private String pieceType;
    private int row;
    private int col;
    private String pieceColor;
    private Icon pieceImage;

    public Piece(String pieceType, int row, int col, String pieceColor, Icon pieceImage) {
        this.pieceType = pieceType;
        this.row = row;
        this.col = col;
        this.pieceColor = pieceColor;
        this.pieceImage = pieceImage;
    }


    public boolean canMove(int newRow, int newCol) {
        return false;
    }

    public void move(int newRow, int newCol) {
        Board boardObject = new Board();
        Piece[][] chessBoard = boardObject.getChessBoard();

        ArrayList<Piece> whitePieces = boardObject.getWhitePieces();
        ArrayList<Piece> blackPieces = boardObject.getBlackPieces();

        switch (getPieceType()) {
            case "White":
                for (int i = 0; i < whitePieces.size(); i++) {
                    if (whitePieces.get(i).getCol() == getCol() && whitePieces.get(i).getRow() == getRow()) {
                        whitePieces.get(i).setCol(newCol);
                        whitePieces.get(i).setRow(newRow);
                    }
                }

            case "Black":
                for (int i = 0; i < blackPieces.size(); i++) {
                    if (blackPieces.get(i).getCol() == getCol() && blackPieces.get(i).getRow() == getRow()) {
                        blackPieces.get(i).setCol(newCol);
                        blackPieces.get(i).setRow(newRow);
                    }
                }
        }

        chessBoard[row][col].setPieceType(null);
        chessBoard[newRow][newCol].setPieceType(getPieceType());

        setCol(newCol);
        setRow(newRow);
    }

    public void capture(int newRow, int newCol) {
        Board boardObject = new Board();
        Piece[][] chessBoard = boardObject.getChessBoard();

        ArrayList<Piece> wPieces = boardObject.getWhitePieces();
        ArrayList<Piece> bPieces = boardObject.getBlackPieces();

        if (getPieceColor() != chessBoard[newRow][newCol].getPieceColor()) {
            switch (getPieceColor()) {
                case "White":

                    for (int i = 0; i < bPieces.size(); i++) 
                        if(bPieces.get(i).getRow() == getRow() && bPieces.get(i).getCol() == getCol())
                            bPieces.remove(i);

                    for (int i = 0; i < wPieces.size(); i++) {
                        if (wPieces.get(i).equals(chessBoard[getRow()][getCol()])) {
                            wPieces.get(i).setRow(newRow);
                            wPieces.get(i).setCol(newCol);
                        }
                    }

                case "Black":

                    for (int i = 0; i < wPieces.size(); i++)
                        if (wPieces.get(i).getRow() == getRow() && wPieces.get(i).getCol() == getCol())
                            wPieces.remove(i);

                    for (int i = 0; i < bPieces.size(); i++) {
                        if (bPieces.get(i).equals(chessBoard[getRow()][getCol()])) {
                            bPieces.get(i).setRow(newRow);
                            bPieces.get(i).setCol(newCol);
                        }
                    }
            }
            chessBoard[getRow()][getCol()] = null;
            chessBoard[newRow][newCol].setPieceColor(getPieceColor());
            chessBoard[newRow][newCol].setPieceImage(getPieceImage());
            chessBoard[newRow][newCol].setPieceType(getPieceType());
        }
    }

    public String getPieceType() {
        return pieceType;
    }

    public void setPieceType(String pieceType) {
        this.pieceType = pieceType;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(String pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Icon getPieceImage() {
        return pieceImage;
    }

    public void setPieceImage(Icon pieceImage) {
        this.pieceImage = pieceImage;
    }

}
