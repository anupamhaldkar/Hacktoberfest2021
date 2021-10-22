import board.*;

public class Missile extends Sprite {

    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y) {
        super(x, y);

        initMissile();
    }

    private void initMissile() {

        loadImage("/Docs/Java Programs/resources/missile.png");
        getImageDimension();
    }

    public void move() {

        x += MISSILE_SPEED;

        if (x > BOARD_WIDTH)
            visible = false;
    }
}
