import javax.swing.ImageIcon;

public class Bishop extends Piece {

    public Bishop(String pieceType, int row, int col, String pieceColor, ImageIcon pieceImage) {
        super("Bishop", row, col, pieceColor, pieceImage);
        // TODO Auto-generated constructor stub
    }

    public boolean canMove(int newRow, int newCol) {
        int dRow = newRow - getRow(); // change in row
        int dCol = newCol - getCol(); // change in column

        // the move is valid if dRow and dCol have the same sign, and their absolute
        // values are equal
        return (dRow != 0 && dCol != 0) && (Math.abs(dRow) == Math.abs(dCol));

    }

    public void move(int newRow, int newCol) {
        if (canMove(newRow, newCol)) {
            super.move(newRow, newCol);
        }
    }
}