import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

public class Board {
  public Square[][] board;
  public int numRows;
  public int numCols;
  public Snake snake;
  private Random r;

  public Board(int rows, int cols) {
    r = new Random();
    snake = new Snake();
    board = new Square[rows][cols];
    numRows = rows;
    numCols = cols;
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        board[i][j] = new Square();
      }
    }
    board[snake.headY][snake.headX].setLife(snake.getLength());
  }


  public void drawBoard() {
    System.out.println(numRows + " " + numCols);
    for(int i = 0; i < numRows; i++) {
      System.out.println(i + " ");
      for(int j = 0; j < numCols; j++) {
        if(board[i][j].hasLife()) {
          System.out.print('O');
        } else {
          System.out.print('X');
        }
      }
    }
    System.out.println();
    System.out.println();
  }

  public void update() {
    for(int i = 0; i < numRows; i++) {
      for(int j = 0; j < numCols; j++) {
        board[i][j].decrementLife();
      }
    }

    snake.update();

    try {
      board[snake.headY][snake.headX].setLife(snake.getLength());
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Game over!");
      System.exit(1);
    }

  }

  public boolean placeApple() {
    return false;
  }
}
