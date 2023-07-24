package MyPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author shaym
 */
public class Triangle extends AbstractShape{

    private Point p2;
    private Point p3;
    private int x1diff, y1diff, x2diff, y2diff, x3diff, y3diff;
    final int SIZE = 8;
    int index = -1;
    
    Rectangle2D[] points =  new Rectangle2D.Double[4];
    
    public Triangle(Point p1, Point p2, Point p3){
        super(p1);
        this.p2 = p2;
        this.p3 = p3;
        points[0] = new Rectangle2D.Double(this.getPosition().x,this.getPosition().y,SIZE, SIZE); 
        points[1] = new Rectangle2D.Double(this.getPoint2().x-4,this.getPoint2().y-4,SIZE, SIZE);
        points[2] = new Rectangle2D.Double(this.getPoint3().x,this.getPoint3().y-4,SIZE, SIZE);
    }
    public void setPoint2(Point point2){
        this.p2 = point2;
    }
    public Point getPoint2(){
        return p2;
    }
    public void setPoint3(Point point3){
        this.p3 = point3;
    }
    public Point getPoint3(){
        return p3;
    }

    @Override
    public void draw(Graphics canvas) {
        
        Color oldColor = canvas.getColor();
        canvas.setColor(getColor());
        canvas.setColor(super.getFillColor());
        canvas.fillPolygon(new int[]{(int) getPosition().getX(), (int) getPoint2().getX(), (int) getPoint3().getX()}, new int[]{(int) getPosition().getY(), (int) getPoint2().getY(), (int) getPoint3().getY()}, 3);
        canvas.setColor(super.getColor());
        canvas.drawPolygon(new int[]{(int) getPosition().getX(), (int) getPoint2().getX(), (int) getPoint3().getX()}, new int[]{(int) getPosition().getY(), (int) getPoint2().getY(), (int) getPoint3().getY()}, 3);
        canvas.setColor(oldColor);
    }

    @Override
    public boolean Contains(Point p) {
        int A = Area ((int)getPosition().getX(),(int)getPosition().getY(), (int)p2.getX(), (int)p2.getY(), (int)p3.getX(), (int)p3.getY());
	int A1 = Area ((int)p.x, (int)p.getY(),(int)p2.getX(), (int)p2.getY(), (int)p3.getX(), (int)p3.getY());
	int A2 = Area ((int)p.x, (int)p.getY(),(int)getPosition().getX(), (int)getPosition().getY(), (int)p3.getX(), (int)p3.getY());
	int A3 = Area ((int)p.x, (int)p.getY(),(int)getPosition().getX(), (int)getPosition().getY(), (int)p2.getX(), (int)p2.getY());	
	return A == A1 + A2 + A3;
    }

    @Override
    public void MoveTo(Point point) {
        this.setPosition(new Point((int) point.getX() + x1diff, (int) point.getY() + y1diff));
        this.setPoint2(new Point((int) point.getX() + x2diff, (int) point.getY() + y2diff));
        this.setPoint3(new Point((int) point.getX() + x3diff, (int) point.getY() + y3diff));
    }
    
    private int Area(int x1, int y1, int x2, int y2,int x3, int y3)
	{
	return (int)Math.abs((x1*(y2-y3) + x2*(y3-y1)+x3*(y1-y2))/2.0);
	}

    @Override
    public void Resize(Point point) {
        moveRec(point);
        switch (index) {
            case 0 -> this.setPosition(point);
            case 1 -> setPoint2(point);
            case 2 -> setPoint3(point);
            default -> {}
        }
    }

    @Override
    public void pointPressed(Point point, Graphics g) {
        points[0] = new Rectangle2D.Double(this.getPosition().x, this.getPosition().y,SIZE, SIZE); 
        points[1] = new Rectangle2D.Double(this.getPoint2().x - 4, this.getPoint2().y - 4,SIZE, SIZE);
        points[2] = new Rectangle2D.Double(this.getPoint3().x, this.getPoint3().y - 4,SIZE, SIZE);
        points[3] = null;
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < points.length; i++) {
            if (points[i]!= null) 
                g2.fill(points[i]);
        }
    }
    
    @Override
    public void setDraggingPoint(Point point) {
        super.setDraggingPoint(point); //point where mousePressed
        x1diff = (int) getPosition().getX() - (int) point.getX();
        y1diff = (int) getPosition().getY() - (int) point.getY();
        x2diff = (int) p2.getX() - (int) point.getX();
        y2diff = (int) p2.getY() - (int) point.getY();
        x3diff = (int) p3.getX() - (int) point.getX();
        y3diff = (int) p3.getY() - (int) point.getY();
        
    }
    
    @Override
    public void moveRec (Point point){
        if(index !=-1)
            points[index] = new Rectangle2D.Double(point.getX(),point.getY(),SIZE,SIZE);
    }
    
    @Override
    public boolean readyToMove(Point point) {
        for (int i = 0; i < 3; i++) {
            if (points[i].contains(point.x, point.y)){
                index = i;
                return true;
            }              
        }
        return false;
    }

}
