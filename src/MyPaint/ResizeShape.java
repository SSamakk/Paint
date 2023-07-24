package MyPaint;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author shaym
 */

public interface ResizeShape {
    public void Resize(Point point);
    public void pointPressed (Point point, Graphics g);
    public boolean readyToMove(Point point);
    public void moveRec (Point point);
}
