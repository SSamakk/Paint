package MyPaint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import static java.lang.Math.abs;

/**
 *
 * @author shaym
 */
public class Rectangle extends AbstractShape{

    final int SIZE = 8;
    private int width;
    private int height;
    int index = -1;
    
    Rectangle2D[] points =  new Rectangle2D.Double[4];
    
    public Rectangle(Point position, int width, int height){
        super(position);
        this.width = width;
        this.height = height;
        points[0] = new Rectangle2D.Double(this.getPosition().x,this.getPosition().y,SIZE, SIZE); // top left
        points[1] = new Rectangle2D.Double(this.getPosition().x, this.getPosition().y + getHeight(),SIZE, SIZE); // bottom left
        points[2] = new Rectangle2D.Double(this.getPosition().x + this.getWidth(),this.getPosition().y,SIZE, SIZE); // top right
        points[3] = new Rectangle2D.Double(this.getPosition().x + this.getWidth(), this.getPosition().y + getHeight(),SIZE, SIZE); // bottom right
        
        
    }
    
    public int getWidth()
    {
        return this.width;
    }
    public int getHeight()
    {
        return this.height;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawRect(getPosition().x, getPosition().y, width, height);
        canvas.setColor(getFillColor());
        canvas.fillRect(getPosition().x, getPosition().y, width, height);
    }
    
    @Override
    public boolean Contains(Point point) { // mouse point
        java.awt.Rectangle r = new java.awt.Rectangle();
        r.setLocation(getPosition());
        r.setSize(width, height);
        return r.contains(point);
    }
    
    @Override
    public void MoveTo(Point point) {
        int xd = point.x - getDraggingPoint().x;
        int yd = point.y - getDraggingPoint().y;
        int newX = this.getPosition().x + xd;
        int newY = this.getPosition().y + yd;
        this.setPosition(new Point(newX, newY));
        this.setDraggingPoint(new Point(getDraggingPoint().x + xd, getDraggingPoint().y + yd));
    }
    
    @Override
    public void Resize(Point point) {
        
        switch(index) {
        // top left corner
            case 0:
                width = width + (int)getPosition().x - point.x;
                height = height + (int)getPosition().y - point.y;
                if(width > 0 && height > 0){
                    setPosition(point);
                }
                else
                    setPosition(fixPoints(point));
                break;
        // bottom left corner
            case 1:
                width = (int) width + (int) getPosition().x - point.x;
                height = point.y - (int) getPosition().y;
                if(width > 0 && height >0){
                    setPosition(new Point (point.x, getPosition().y));
                }
                else
                    setPosition(fixPoints(point));
                break;
        //top right corner
            case 2:
                width =  (int)point.x - getPosition().x;
                height = (int) height + (int) getPosition().y - point.y;
                if (width > 0 && height > 0){
                    setPosition(new Point (getPosition().x,point.y));
                }
                else {
                    setPosition(fixPoints(point));
                }   break;
        // bottom right corner
            case 3:
                width =  (int)point.x - getPosition().x;
                height = point.y - (int) getPosition().y;
                if (width > 0 && height >0){
                    setPosition(new Point (getPosition().x,getPosition().y));
                }
                else
                    setPosition(fixPoints(point));                 
                break;
            default:
                break;
        }
    }
    
    public Point fixPoints(Point point){
        Point newPoint = point;
        int x0 = (int)points[0].getX(), x2 = (int)points[2].getX();
        int x1=x0, x3 = x2;
        int y0 =(int)points[0].getY(), y1 = (int)points[1].getY();
        int y2 = y0, y3 = y1;
        
        if (x0 > x2 && y0 < y1 && index == 0 ) {
            newPoint.x = x2; 
            newPoint.y = y0;
            
        } 
        else if (x0 < x2 && y0 > y1 && index == 0) {
           newPoint.x = x0; 
           newPoint.y = y1;
        } 
        else if (x0 < x2 && y0 > y2) {
            newPoint.x = x0; 
            newPoint.y = y1;
        } 
        else if (x0 > x2 && index == 2) {
            newPoint.x = x2; 
            newPoint.y = y0;
        }
        else{
            width = abs(width);
            height = abs(height);
            return getPosition();
        
        }
        width = abs(width);
        height = abs(height);
        return newPoint;
    }

    @Override
    public void pointPressed(Point point, Graphics g) {
        points[0] = new Rectangle2D.Double(this.getPosition().x,this.getPosition().y, SIZE, SIZE); 
        points[1] = new Rectangle2D.Double(this.getPosition().x,this.getPosition().y +this.getHeight(),SIZE, SIZE);
        points[2] = new Rectangle2D.Double(this.getPosition().x + this.getWidth(),this.getPosition().y,SIZE, SIZE);
        points[3] = new Rectangle2D.Double(this.getPosition().x + this.getWidth(),this.getPosition().y + this.getHeight(),SIZE, SIZE);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < points.length; i++) 
        {
            if (points[i]!= null)  
                g2.fill(points[i]);   
        }
    }

    
    
    @Override
    public boolean readyToMove(Point point) {
        for (int i = 0; i < points.length; i++) 
        {
            if (points[i].contains(point.x, point.y)){
                index = i;
                return true;
            }              
        }
        return false;
    }

    @Override
    public void moveRec(Point point) {
        if(index !=-1)
            points[index] = new Rectangle2D.Double(point.getX(),point.getY(),SIZE,SIZE);
    }

}
