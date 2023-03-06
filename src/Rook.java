
import javax.swing.ImageIcon;

public class Rook extends Piece {

    public Rook(String pieceType, int row, int col, String pieceColor, ImageIcon pieceImage) {
        super("Rook", row, col, pieceColor, pieceImage);
        // TODO Auto-generated constructor stub
    }

    public boolean canMove(int newRow, int newCol) {
        int dRow = Math.abs(newRow - getRow()); // change in row
        int dCol = Math.abs(newCol - getCol()); // change in column

        // the move is valid if the rook moves in a straight line (either horizontally
        // or vertically)
        return (dRow == 0) || (dCol == 0);
    }

    public void move(int newRow, int newCol) {
        if (canMove(newRow, newCol))
            super.move(newRow, newCol);
    }

}
