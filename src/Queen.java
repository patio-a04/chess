import javax.swing.ImageIcon;

public class Queen extends Piece {

    public Queen(String pieceType, int row, int col, String pieceColor, ImageIcon pieceImage) {
        super("Queen", row, col, pieceColor, pieceImage);
        // TODO Auto-generated constructor stub
    }

    public boolean canMove(int newRow, int newCol) {
        int dRow = Math.abs(newRow - getRow()); // change in row
        int dCol = Math.abs(newCol - getCol()); // change in column

        // the move is valid if it is either a valid move for a bishop or a rook
        return (dRow == dCol) || (dRow == 0) || (dCol == 0);
    }

    public void move(int newRow, int newCol) {
        if (canMove(newRow, newCol)) {
            super.move(newRow, newCol);
        }
    }
}