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
                PieceListener pieceListener = new PieceListener();

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
                piece.addActionListener(pieceListener);
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

    public class PieceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            PieceButton buttonClicked = (PieceButton) e.getSource();
            Color darkSquare = new Color(118, 150, 86);
            Color lightSquare = new Color(238, 238, 210);
            Color canMoveToSquare = new Color(255, 137, 115);
            Color selectedSquare = new Color(255, 234, 181);


            if (buttonClicked.getSquareColor().equals(lightSquare)
                    || buttonClicked.getSquareColor().equals(darkSquare)) {
                buttonClicked.setSquareColor(selectedSquare);
                String pieceType = buttonClicked.getPieceType();
                String pieceColor = buttonClicked.getPieceColor();

                try {
                    switch (pieceType) {

                        case "Pawn":
                            Pawn tempPawn = new Pawn(pieceType, buttonClicked.getRow(), buttonClicked.getCol(),
                                    pieceColor,
                                    buttonClicked.getPieceImage(), false);
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 8; j++) {
                                    if (tempPawn.canMove(i, j)) {
                                        // Color in the squares which it can move orange
                                        Component tempPieceButton = frame.getComponentAt(i, j);
                                        tempPieceButton.setBackground(canMoveToSquare);
                                        frame.remove(frame.getComponentAt(i, j));
                                        // frame.add(tempPieceButton, i);
                                        break;
                                    }
                                }
                            }
                        case "Knight":
                            Knight tempKnight = new Knight(pieceType, buttonClicked.getRow(), buttonClicked.getCol(),
                                    pieceColor,
                                    buttonClicked.getPieceImage());
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 8; j++) {
                                    if (tempKnight.canMove(i, j)) {
                                        // Color in the squares which it can move orange
                                        Component tempPieceButton = frame.getComponentAt(i, j);
                                        tempPieceButton.setBackground(canMoveToSquare);
                                        break;
                                    }
                                }
                            }
                        case "Bishop":
                            Bishop tempBishop = new Bishop(pieceType, buttonClicked.getRow(), buttonClicked.getCol(),
                                    pieceColor,
                                    buttonClicked.getPieceImage());
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 8; j++) {
                                    if (tempBishop.canMove(i, j)) {
                                        // Color in the squares which it can move orange
                                        Component tempPieceButton = frame.getComponentAt(i, j);
                                        tempPieceButton.setBackground(canMoveToSquare);
                                        break;
                                    }
                                }
                            }
                        case "Rook":
                            Rook tempRook = new Rook(pieceType, buttonClicked.getRow(), buttonClicked.getCol(),
                                    pieceColor,
                                    buttonClicked.getPieceImage());
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 8; j++) {
                                    if (tempRook.canMove(i, j)) {
                                        // Color in the squares which it can move orange
                                        Component tempPieceButton = frame.getComponentAt(i, j);
                                        tempPieceButton.setBackground(canMoveToSquare);
                                        break;
                                    }
                                }
                            }
                        case "Queen":
                            Queen tempQueen = new Queen(pieceType, buttonClicked.getRow(), buttonClicked.getCol(),
                                    pieceColor,
                                    buttonClicked.getPieceImage());
                            for (int i = 0; i < 7; i++) {
                                for (int j = 0; j < 7; j++) {
                                    if (tempQueen.canMove(i, j)) {
                                        // Color in the squares which it can move orange
                                        Component tempPieceButton = frame.getComponentAt(i, j);
                                        tempPieceButton.setBackground(canMoveToSquare);
                                        break;
                                    }
                                }
                            }
                        case "King":
                            King tempKing = new King(pieceType, buttonClicked.getRow(), buttonClicked.getCol(),
                                    pieceColor,
                                    buttonClicked.getPieceImage());
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 8; j++) {
                                    if (tempKing.canMove(i, j)) {
                                        // Color in the squares which it can move orange
                                        Component tempPieceButton = frame.getComponentAt(i, j);
                                        tempPieceButton.setBackground(canMoveToSquare);
                                        break;
                                    }
                                }
                            }
                    }
                    frame.repaint();
                } catch (java.lang.NullPointerException a) {
                    // TODO: handle exception

                }
                // Moves the piece to the selected square
                if (buttonClicked.getSquareColor().equals(canMoveToSquare)) {

                    Color color = ((buttonClicked.getRow() + buttonClicked.getCol()) % 2 == 0) ? lightSquare
                            : darkSquare;
                    buttonClicked.setSquareColor(color);

                    Board boardObject = new Board();
                    Piece[][] chessBoard = boardObject.getChessBoard();
                    ArrayList<Piece> wPieces = boardObject.getWhitePieces();
                    ArrayList<Piece> bPieces = boardObject.getBlackPieces();

                    Piece tempPiece = new Piece(buttonClicked.getPieceType(), buttonClicked.getRow(),
                            buttonClicked.getCol(), buttonClicked.getPieceColor(), buttonClicked.getIcon());
                    System.out.println("Square");

                }
            }
        }

        public static void main(String[] args) {
            Game x = new Game();
        }
    }
}