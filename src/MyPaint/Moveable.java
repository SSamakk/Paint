package MyPaint;

/**
 *
 * @author shaym
 */
public interface Moveable {
    
    public void setDraggingPoint(java.awt.Point point);
    public java.awt.Point getDraggingPoint();
    public boolean Contains(java.awt.Point point);
    public void MoveTo(java.awt.Point point);
}
