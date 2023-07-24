package MyPaint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author shaym
 */
public class Line extends AbstractShape{

    final int SIZE = 8;
    private Point p2;
    Rectangle2D[] points =  new Rectangle2D.Double[4];
    int index = -1;
    
    public Line(Point p1, Point p2){
        super(p1);
        this.p2 = p2;
    }
    
    public void setEndPoint(Point p2)
    {
        this.p2 = p2;
    }
    public Point getEndPoint()
    {
        return this.p2;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawLine(getPosition().x, getPosition().y, p2.x, p2.y);
    }
    
    @Override
    public boolean Contains(Point point) {

        int d = (int) getPosition().distance(p2);
        return (int)(point.distance(getPosition()) + point.distance(p2)) == d;
    }

    @Override
    public void MoveTo(Point point) {
        int xd = point.x - this.getDraggingPoint().x; // realeased point - clicked point
        int yd = point.y - this.getDraggingPoint().y;
        Point newPosition = new Point((this.getPosition().x + xd), (this.getPosition().y + yd)); // position + distance
        Point newEndPoint = new Point((p2.x + xd), p2.y + yd);
        setPosition(newPosition);
        p2 = newEndPoint;
        setDraggingPoint(new Point(getDraggingPoint().x + xd, getDraggingPoint().y + yd));
    }

    @Override
    public void Resize(Point point){
        if(index !=-1)
            points[index] = new Rectangle2D.Double(point.getX(),point.getY(),SIZE,SIZE);
    
        try{
            switch(index) 
            {
                case 0:
                    setPosition(point);
                    break;
                    
                case 1:
                    setEndPoint(point);
                    break;
            } 
        }
        catch(IndexOutOfBoundsException e)
        {
            
        }
    }

    @Override
    public void pointPressed(Point point, Graphics g) {
        points[0] = new Rectangle2D.Double(this.getPosition().x, this.getPosition().y-4,SIZE, SIZE); 
        points[1] = new Rectangle2D.Double(this.getEndPoint().x, this.getEndPoint().y-4,SIZE, SIZE);
        points[2] = null;
        points[3] = null;
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < points.length; i++) {
            if (points[i]!= null)
                g2.fill(points[i]);
        }
    }

    @Override
    public void moveRec(Point point) {
        if(index !=-1){
            points[index] = new Rectangle2D.Double(point.getX(),point.getY(),SIZE,SIZE);
    }
    }
    
    @Override
    public boolean readyToMove(Point point) {
        for (int i = 0; i < 2; i++) {
            if (points[i].contains(point.x, point.y)){
                index =i;
                return true;
            }              
        }
        return false;
    }

}
