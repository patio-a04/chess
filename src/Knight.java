
import javax.swing.ImageIcon;

public class Knight extends Piece {

    public Knight(String pieceType, int row, int col, String pieceColor, ImageIcon pieceImage) {
        super("Knight", row, col, pieceColor, pieceImage);
        // TODO Auto-generated constructor stub
    }

    public boolean canMove(int newRow, int newCol) {
        int dRow = Math.abs(newRow - getRow()); // change in row
        int dCol = Math.abs(newCol - getCol()); // change in column

        // the move is valid if it is an L-shape (2 squares in one direction and 1
        // square in the other)
        return (dRow == 2 && dCol == 1) || (dRow == 1 && dCol == 2);
    }

    public void move(int newRow, int newCol) {
        if (canMove(newRow, newCol))
            super.move(newRow, newCol);
    }

}
