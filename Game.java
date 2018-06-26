import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
//import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener {
  Board b;

  public Game() {
    this.setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT));
    addKeyListener(this);
    setFocusable(true);
    b = new Board(Settings.HEIGHT/Settings.sqDim, Settings.WIDTH/Settings.sqDim);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.BLACK);
    g.fillRect(0, 0, Settings.WIDTH, Settings.HEIGHT);

    drawGrid(g);
    drawSquares(g);
  }

  public void drawGrid(Graphics g) {
    g.setColor(Color.white);
    for(int i = 0; i < b.numRows + 1; i++) {
      g.drawLine(0, i*Settings.sqDim, Settings.WIDTH, i*Settings.sqDim);
    }
    for(int i = 0; i < b.numCols + 1; i++) {
      g.drawLine(i*Settings.sqDim, 0, i*Settings.sqDim, Settings.HEIGHT);
    }
  }

  public void drawSquares(Graphics g) {
    for(int i = 0; i < b.numRows; i++) {
      for(int j = 0; j < b.numCols; j++) {
        if(b.board[i][j].hasLife()) {
          g.setColor(Color.blue);
          g.fillRect(j*Settings.sqDim, i*Settings.sqDim, Settings.sqDim, Settings.sqDim);
        }
        if(b.board[i][j].getApple()) {
          g.setColor(Color.yellow);
          g.fillRect(j*Settings.sqDim, i*Settings.sqDim, Settings.sqDim, Settings.sqDim);
        }

      }
    }
  }

  public void runGame() {
    b.placeApple();
    while(true) {
      try {
        b.update();
        b.drawBoard();
        repaint();
        Thread.sleep(Settings.snakeSpeed);
      } catch(Exception e) {
        //Lol don't do anything
      }
    }
  }

  public void keyPressed(KeyEvent e) {
    char c = e.getKeyChar();
    switch(c) {
      case 'w':
        if(b.snake.direction != 1 && b.snake.direction != 3) {
          b.snake.direction = 1;
        }
        break;
      case 'a':
        if(b.snake.direction != 4 && b.snake.direction != 2) {
          b.snake.direction = 4;
        }
        break;
      case 's':
        if(b.snake.direction != 3 && b.snake.direction != 1) {
          b.snake.direction = 3;
        }
        break;
      case 'd':
        if(b.snake.direction != 4 && b.snake.direction != 2) {
          b.snake.direction = 2;
        }
        break;
      default:
        break;
    }
    System.out.println("You pressed: " + c);
  }

  public void keyReleased(KeyEvent e) {

  }

  public void keyTyped(KeyEvent e) {

  }

  public void initGame() {

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Snake");
    frame.setSize(Settings.WIDTH,Settings.HEIGHT);
    Game game = new Game();
    frame.setContentPane(game);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);

    game.runGame();
  }
}
