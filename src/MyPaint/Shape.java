package MyPaint;
/**
 *
 * @author shaym
 */
public interface Shape
{
    /* set position */
    public void setPosition(java.awt.Point position);
    public java.awt.Point getPosition();
    /* colorize */
    public void setColor(java.awt.Color color);
    public java.awt.Color getColor();
    public void setFillColor(java.awt.Color color);
    public java.awt.Color getFillColor();
    /* redraw the shape on the canvas */
    public void draw(java.awt.Graphics canvas);
}
