public class Snake {
  public int direction;
  private int length;
  public static int headX;
  public static int headY;

  public Snake() {
    length = 3;
    direction = 2;
    headX = 0;
    headY = 0;
  }

  public int getFacing() {
    return direction;
  }

  public int getLength() {
    return length;
  }

  public void addLength() {
    length++;
  }

  public void update() {
    switch(direction) {
      case 1:
        headY--;
        break;
      case 2:
        headX++;
        break;
      case 3:
        headY++;
        break;
      case 4:
        headX--;
        break;
      default:
        System.out.println("Invalid Direction.");
    }
  }
}
