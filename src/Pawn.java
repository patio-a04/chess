import javax.swing.ImageIcon;

public class Pawn extends Piece {
    private boolean hasMoved;

    public Pawn(String pieceType, int row, int col, String pieceColor, ImageIcon pieceImage, boolean hasMoved) {
        super("Pawn", row, col, pieceColor, pieceImage);
        // TODO Auto-generated constructor stub
        this.hasMoved = hasMoved;
    }

    public boolean canMove(int newRow, int newCol) {
        int row = getRow();
        int col = getCol();
        if (col == newCol) {
            boolean returnValue = Math.abs(row - newRow) == 1;
            // Checks to see if the difference between the new and old column is one
            return returnValue;
        }
        return false;
    }

    public void move(int newRow, int newCol) {
        if (canMove(newRow, newCol))
            super.move(newRow, newCol);
    }
}