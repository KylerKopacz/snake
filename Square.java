public class Square {
  private boolean hasSnake;
  private boolean hasApple;
  private int life;

  public Square() {
    hasSnake = false;
    hasApple = false;
    life = 0;
  }

  public boolean getSnake() {
    return hasSnake;
  }

  public boolean getApple() {
    return hasApple;
  }

  public void setLife(int newLife) {
    life = newLife;
  }

  public void decrementLife() {
    life--;
  }

  public boolean hasLife() {
    if(this.life >= 1) {
      return true;
    } else {
      return false;
    }
  }
}
