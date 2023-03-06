import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Game {
    private static final int TILE_SIZE = 80;
    private static final int WIDTH = 8 * TILE_SIZE;
    private static final int HEIGHT = 8 * TILE_SIZE;
    private JFrame frame;

    public Game() {
        frame = new JFrame("Chess");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8, 8));

        // Pawn image
        ImageIcon wPawn = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_plt60.png");
        ImageIcon bPawn = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_pdt60.png");

        // Knight image
        ImageIcon wKnight = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_nlt60.png");
        ImageIcon bKnight = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_ndt60.png");

        // Bishop image
        ImageIcon wBishop = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_blt60.png");
        ImageIcon bBishop = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_bdt60.png");

        // Rook image
        ImageIcon wRook = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_rlt60.png");
        ImageIcon bRook = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_rdt60.png");

        // Queen image
        ImageIcon wQueen = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_qlt60.png");
        ImageIcon bQueen = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_qdt60.png");

        // King image
        ImageIcon wKing = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_klt60.png");
        ImageIcon bKing = new ImageIcon(
                "/Users/vedantpatil/Desktop/CS/Personal/JavaCoding/Chess/src/images/Chess_kdt60.png");

        Color darkSquare = new Color(118, 150, 86);
        Color lightSquare = new Color(238, 238, 210);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Color color = ((row + col) % 2 == 0) ? lightSquare : darkSquare;
                PieceButton piece = new PieceButton();
                pieceListener pieceListener = new pieceListener();

                // White
                if (row == 0 || row == 1) {
                    piece.setPieceColor("White");
                    if (row == 0 && (col == 0 || col == 7)) {
                        piece.setPieceType("Rook");
                        piece.setIcon(wRook);
                    }
                    if (row == 0 && (col == 1 || col == 6)) {
                        piece.setPieceType("Knight");
                        piece.setIcon(wKnight);
                    }
                    if (row == 0 && (col == 2 || col == 5)) {
                        piece.setPieceType("Bishop");
                        piece.setIcon(wBishop);
                    }
                    if (row == 0 && col == 4) {
                        piece.setPieceType("Queen");
                        piece.setIcon(wQueen);
                    }
                    if (row == 0 && col == 3) {
                        piece.setPieceType("King");
                        piece.setIcon(wKing);
                    }
                    if (row == 1) {
                        piece.setPieceType("Pawn");
                        piece.setIcon(wPawn);
                    }
                }

                // Black
                if (row == 6 || row == 7) {
                    piece.setPieceColor("Black");
                    if (row == 7 && (col == 0 || col == 7)) {
                        piece.setPieceType("Rook");
                        piece.setIcon(bRook);
                    }
                    if (row == 7 && (col == 1 || col == 6)) {
                        piece.setPieceType("Knight");
                        piece.setIcon(bKnight);
                    }
                    if (row == 7 && (col == 2 || col == 5)) {
                        piece.setPieceType("Bishop");
                        piece.setIcon(bBishop);
                    }
                    if (row == 7 && col == 4) {
                        piece.setPieceType("Queen");
                        piece.setIcon(bQueen);
                    }
                    if (row == 7 && col == 3) {
                        piece.setPieceType("King");
                        piece.setIcon(bKing);
                    }
                    if (row == 6) {
                        piece.setPieceType("Pawn");
                        piece.setIcon(bPawn);
                    }
                }

                piece.setRow(row);
                piece.setCol(col);
                piece.setSquareColor(color);
                piece.setOpaque(true);
                piece.setBorder(null);
                piece.addMouseListener(pieceListener);
                piece.addMouseMotionListener(pieceListener);
                piece.setBackground(color);
                frame.add(piece);
            }
        }
        frame.repaint();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public class PieceButton extends JButton {
        private int row;
        private int col;
        private String pieceType;
        private String pieceColor;
        private ImageIcon pieceImage;
        private Color squareColor;

        public PieceButton() {
            setPreferredSize(new Dimension(900, 900));
            setOpaque(true);
            setBorderPainted(false);
        }

        public PieceButton(int row, int col, String pieceColor, String pieceType, ImageIcon pieceImage) {
            this.row = row;
            this.col = col;
            this.pieceType = pieceType;
            this.pieceColor = pieceColor;
            this.pieceImage = pieceImage;
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

        public String getPieceType() {
            return pieceType;
        }

        public void setPieceType(String pieceType) {
            this.pieceType = pieceType;
        }

        public ImageIcon getPieceImage() {
            return pieceImage;
        }

        public void setPieceIcon(ImageIcon pieceImage) {
            this.pieceImage = pieceImage;
        }

        public String getPieceColor() {
            return pieceColor;
        }

        public void setPieceColor(String pieceColor) {
            this.pieceColor = pieceColor;
        }

        public Color getSquareColor() {
            return squareColor;
        }

        public void setSquareColor(Color squareColor) {
            this.squareColor = squareColor;
        }

    }

    public class pieceListener implements MouseListener, MouseMotionListener {

        public void mousePressed(MouseEvent e) {
            int currentX = e.getX();
            int currentY = e.getY();

            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Piece currentPiece = (Piece) frame.getComponentAt(new Point(e.getX(), e.getY()));

            if(currentPiece.getPieceType() != null)
            {
                
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        // Irrelevant methods, do nothing for these mouse behaviors
        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    public static void main(String[] args) {
        Game x = new Game();
    }
}
