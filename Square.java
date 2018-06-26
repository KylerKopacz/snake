public class Square {
  private boolean hasSnake;
  private boolean hasApple;
  private int life;

  public Square() {
    hasSnake = false;
    hasApple = false;
    life = 0;
  }

  public boolean getApple() {
    return hasApple;
  }

  public void setApple(boolean tralse) {
    hasApple = tralse;
  }

  public void setLife(int newLife) {
    life = newLife;
  }

  public int getLife() {
    return life;
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
