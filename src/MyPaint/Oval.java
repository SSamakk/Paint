package MyPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import static java.lang.Math.abs;

/**
 *
 * @author shaym
 */
public class Oval extends AbstractShape{
    
    private int index = -1;
    private int xdiff, ydiff;
    private int vRadius , hRadius;
    Rectangle2D[] points =  new Rectangle2D.Double[4];
    final int SIZE = 8;

        public Oval(Point p, int hR, int vR) {
        super(p);
        this.vRadius = vR;
        this.hRadius = hR;
        this.setShapeName("Oval_");
        points[0] = new Rectangle2D.Double(this.getPosition().x-4,this.getPosition().y-4,SIZE, SIZE); 
        points[1] = new Rectangle2D.Double(this.getPosition().x-4,this.getPosition().y-4 +this.getvRadius()*2,SIZE, SIZE);
        points[2] = new Rectangle2D.Double(this.getPosition().x-4 + this.gethRadius()*2,this.getPosition().y-4,SIZE, SIZE);
        points[3] = new Rectangle2D.Double(this.getPosition().x-4 + this.gethRadius()*2,this.getPosition().y-4 + this.getvRadius()*2,SIZE, SIZE);
    }
    
   public int gethRadius() {
        return hRadius;
    }

    public void sethRadius(int hRadius) {
        this.hRadius = hRadius;
    }

    public int getvRadius() {
        return vRadius;
    }

    public void setvRadius(int radius) {
        this.vRadius = radius;
    }


    @Override
    public void draw(Graphics canvas) {
        Color oldColor = canvas.getColor();
        canvas.setColor(getColor());
        canvas.setColor(super.getFillColor());
        canvas.fillOval((int) this.getPosition().getX(), (int) this.getPosition().getY(), (int) (2 * hRadius), (int) (2 * vRadius));
        canvas.setColor(super.getColor());
        canvas.drawOval((int) this.getPosition().getX(), (int) this.getPosition().getY(), (int) (2 * hRadius), (int) (2 * vRadius));
        canvas.setColor(oldColor);
    }
    
    @Override
    public boolean Contains(Point point) {
        Point topLeft = getPosition();
        Point center = new Point((int) (topLeft.x + hRadius ), (int) (topLeft.y + vRadius));
        double p;
        p = ((double) Math.pow((point.getX() - center.getX()), 2) / (double) Math.pow(hRadius, 2)) + ((double) Math.pow((point.getY() - center.getY()), 2) / (double) Math.pow(vRadius, 2));
        if (p > 1) {
            return false;
        } else {
            return true;
        }
    }

    
    @Override
    public void setDraggingPoint(Point point) {
        super.setDraggingPoint(point);
        xdiff = (int) getPosition().getX() - (int) point.getX();
        ydiff = (int) getPosition().getY() - (int) point.getY();
    }
    
     public  int getDistance(Point point1,Point point2){
        return ( (int)( Math.sqrt(Math.pow(point1.x  - point2.x, 2) + Math.pow(point1.y - point2.y, 2) ) ));
    }
    
    @Override
    public void MoveTo(Point point) {
        this.setPosition(new Point((int) point.getX() + xdiff, (int) point.getY() + ydiff));
    }
    
    public static double distance(Point A, Point B) {
        return Math.sqrt((Math.pow((A.x - B.x), 2) + Math.pow((A.y - B.y), 2))); // distance between 2 points
    }

    @Override
    public void Resize(Point point) {
        switch (index) {
            case 1 -> {
                if(point.x >= points[2].getX()){
                    points[3].setRect(point.x, point.y,SIZE,SIZE);
                }
                else{
                    points[1].setRect(point.x, point.y,SIZE,SIZE) ;
                    points[0].setRect(point.x,(int)points[0].getY(),SIZE,SIZE);
                    points[3].setRect((int)points[3].getX(),point.y,SIZE,SIZE);
                }
            }
            case 0 -> {
                points[0].setRect(point.x,point.y,SIZE,SIZE);
            }
            
            case 2 -> { //top right 
                if(point.y >= points[1].getY()){
                    points[3].setRect(point.x,point.y,SIZE,SIZE);
                }
                else {
               points[2].setRect(point.x,point.y,SIZE,SIZE);            
               points[0].setRect((int)points[0].getX(),point.y,SIZE,SIZE);
               points[3].setRect(point.x,(int)points[3].getY(),SIZE,SIZE);
            }
            }
            
            case 3 -> {
             points[3].setRect(point.x, point.y,SIZE,SIZE);
             points[2].setRect((int)points[2].getX(),point.y,SIZE,SIZE);
             points[1].setRect(point.x,(int)points[1].getY(),SIZE,SIZE);
            }
            default -> {}
        }
              
            
        hRadius = (int)((points[3].getX() - points[0].getX())/2);
        vRadius = (int)((points[3].getY() -  points[0].getY())/2 );
        if(vRadius>0 && hRadius>0){
        setPosition(new Point ((int)points[0].getX(),(int)points[0].getY()));
        }
    
        else if( hRadius >0 && index ==0){ // vradius is negative
            int x1,x2,y1,y2;
            x1 = (int)points[0].getX(); y1 = (int)points[0].getY();
            x2 = (int) points[2].getX(); y2 = (int)points[2].getY();
            points[0].setRect((int)points[1].getX(),(int)points[1].getY(),SIZE,SIZE);
            points[2].setRect((int)points[3].getX(),(int)points[3].getY(),SIZE,SIZE);
            points[1].setRect(x1,y1,SIZE,SIZE);
            points[3].setRect(x2,y2,SIZE,SIZE);
            setPosition(new Point ((int)points[0].getX(),(int)points[0].getY()));
            hRadius = (int)((points[3].getX() - points[0].getX())/2);
            vRadius = (int)((points[3].getY() -  points[0].getY())/2 );
        } 
        else if (hRadius>0 && index ==1){
            points[0].setRect(point.x,point.y,SIZE,SIZE);
            setPosition(new Point ((int)points[0].getX(),(int)points[0].getY()));
            hRadius = (int)((points[3].getX() - points[0].getX())/2);
            vRadius = (int)((points[3].getY() -  points[0].getY())/2 );
        } 
        else if (vRadius >0){ //hradius <0
            int x0,x1,y0,y1;
            x0 = (int)points[0].getX(); y0 = (int)points[0].getY();
            x1 = (int) points[1].getX(); y1 = (int)points[1].getY();
            points[0].setRect((int)points[2].getX(),(int)points[2].getY(),SIZE,SIZE);
            points[1].setRect((int)points[3].getX(),(int)points[3].getY(),SIZE,SIZE);
            points[2].setRect(x0,y0,SIZE,SIZE);
            points[3].setRect(x1,y1,SIZE,SIZE);
            setPosition(new Point ((int)points[0].getX(),(int)points[0].getY()));
            hRadius = (int)((points[3].getX() - points[0].getX())/2);
            vRadius = (int)((points[3].getY() -  points[0].getY())/2 );
        }
    }

    @Override
    public void pointPressed(Point point, Graphics g) {
             points[0] = new Rectangle2D.Double(this.getPosition().x,this.getPosition().y,SIZE, SIZE); 
             points[1] = new Rectangle2D.Double(this.getPosition().x,this.getPosition().y +this.getvRadius()*2,SIZE, SIZE);
             points[2] = new Rectangle2D.Double(this.getPosition().x + this.gethRadius()*2,this.getPosition().y,SIZE, SIZE);
             points[3] = new Rectangle2D.Double(this.getPosition().x + this.gethRadius()*2,this.getPosition().y + this.getvRadius()*2,SIZE, SIZE);
             Graphics2D g2 = (Graphics2D) g;
        for (Rectangle2D point1 : points) {
            if (point1 != null) {
                g2.fill(point1);
            }
        }
    }
    
        public Point fixPoints(Point point){
        Point newPoint = point;
        int x0= (int)points[0].getX(), x2 = (int)points[2].getX();
        int x1=x0, x3 = x2;
        int y0 =(int)points[0].getY(), y1 = (int)points[1].getY();
        int y2 = y0, y3 =y1;
        if (x0>x2 && y0< y1 && index ==0 ) {
            newPoint.x = x2; newPoint.y = y0;
            
        } else if (x0 < x2 && y0 > y1 && index ==0) {
           newPoint.x = x0; newPoint.y = y1;
        } else if (x0 < x2 && y0 > y2) {
            newPoint.x = x0; newPoint.y = y1;
        } else if (x0 > x2 && index ==2) {
            newPoint.x = x2; newPoint.y = y0;
        }else {
            vRadius = abs(vRadius);
            hRadius = abs(hRadius);
            return getPosition();
        
        }vRadius = abs(vRadius);
        hRadius = abs(hRadius);
        return newPoint;
    }
    
    @Override
    public void moveRec (Point point){
        if(index !=-1){
        points[index] = new Rectangle2D.Double(point.getX(),point.getY(),SIZE,SIZE);
    }
    }
    
    @Override
    public boolean readyToMove(Point point) {
      for (int i = 0; i < points.length; i++) {
              if (points[i].contains(point.x, point.y)){
                  index =i;
                  return true;
              }       
             
    }
      return false;
    }
    
    
    
}

