
public class Ant {

    public int left, top, direction, prevLeft, prevTop;


    public Ant(int left, int top, int direction) {
        prevLeft = -1;
        prevTop = -1;
        this.left = left;
        this.top = top;
        this.direction = direction;

    }

    public void iterateAnt(boolean[][] state) {
        int height = state.length;
        int width = state[0].length;
        if (state[top][left]) {
            direction = (direction + 3) % 4;
        }
        else {
            direction = (direction + 1) % 4;
        }
        state[top][left] = !state[top][left];
        prevLeft = left;
        prevTop = top;
        switch (direction) {
            case 0:
                top = (top + height -1) % height;
                break;
            case 1:
                left = (left + 1) % width;
                break;
            case 2:
                top = (top + 1) % height;;
                break;
            case 3:
                left = (left + width -1) % width;
                break;
            default:
                break;
        }

    }

}
