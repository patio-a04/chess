import java.util.ArrayList;

import javax.swing.ImageIcon;

public class King extends Piece {

    public King(String pieceType, int row, int col, String pieceColor, ImageIcon pieceImage) {
        super("King", row, col, pieceColor, pieceImage);
        // TODO Auto-generated constructor stub
    }

    public boolean inCheck() {
        Board boardObject = new Board();
        switch (getPieceColor()) {
            case "White":
                ArrayList<Piece> bPieces = boardObject.getBlackPieces();
                for (int i = 0; i < bPieces.size(); i++) {
                    if (bPieces.get(i).canMove(getRow(), getCol()))
                        return true;
                }

            case "Black":
                ArrayList<Piece> wPieces = boardObject.getWhitePieces();
                for (int i = 0; i < wPieces.size(); i++) {
                    if (wPieces.get(i).canMove(getRow(), getCol()))
                        return true;
                }
        }
        return false;
    }

    public boolean canMove(int newRow, int newCol) {
        int dRow = Math.abs(newRow - getRow()); // change in row
        int dCol = Math.abs(newCol - getCol()); // change in column

        // the move is valid if the change in row and column is at most 1 (king can move
        // one square in any direction)
        return (dRow <= 1) && (dCol <= 1);
    }

    public void move(int newRow, int newCol) {
        if (!inCheck())
            if (canMove(newRow, newCol))
                super.move(newRow, newCol);
    }

}
