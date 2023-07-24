package MyPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author shaym
 */
public abstract class AbstractShape implements Shape, Moveable, ResizeShape{
    
    private Color border;
    private Color fill;
    private Point position;
    private Point dragPoint;
    private Point pressedPoint;
    private String ShapeName;
    
    public AbstractShape(Point position){
        this.position = position;
    }
    
    public void setShapeName(String ShapeName) {
        this.ShapeName = ShapeName;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setColor(Color color) {
        this.border = color;
    }

    @Override
    public Color getColor() {
        return border;
    }

    @Override
    public void setFillColor(Color color) {
        this.fill = color;
    }

    @Override
    public Color getFillColor() {
        return fill;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(border);
    }

    @Override
    public void setDraggingPoint(Point point) {
        this.dragPoint = point;
    }

    @Override
    public Point getDraggingPoint() {
        return dragPoint;
    }
    
    
    public JSONObject toJsonobject() 
    {
        JSONObject obj = new JSONObject();
        JSONObject pointPos = new JSONObject();
        pointPos.put("pos.x", position.x + "");
        pointPos.put("pos.y", position.y + "");

        obj.put("position", pointPos);
        
        JSONObject borderCol = new JSONObject();
        if (this.border == null)
            this.border = Color.BLACK;
        borderCol.put("r", (int)border.getRed());
        borderCol.put("g", (int)border.getGreen());
        borderCol.put("b", (int)border.getBlue());
        obj.put("BorderColor", borderCol);
        
        JSONObject fillCol = new JSONObject();
        if (this.fill == null) 
            this.fill = Color.BLACK;
        fillCol.put("r", (int)fill.getRed());
        fillCol.put("g", (int)fill.getGreen());
        fillCol.put("b", (int)fill.getBlue());
        obj.put("FillColor", fillCol);

        if(this instanceof Oval oval) {

            obj.put("Hradius", oval.gethRadius());
            obj.put("Vradius", oval.getvRadius());
            obj.put("Shape", "0");
        } 
        else if (this instanceof Line line) {
            JSONObject endPoint = new JSONObject();
            endPoint.put("end.x", line.getEndPoint().x + "");
            endPoint.put("end.y", line.getEndPoint().y + "");
            obj.put("EndPoint", endPoint);
            obj.put("Shape", "2");
        } 
        else if (this instanceof Rectangle rec) {
            obj.put("height", rec.getHeight());
            obj.put("width", rec.getWidth());
            obj.put("Shape", "1");
        } 
        else if (this instanceof Triangle t) {
            JSONObject point2 = new JSONObject();
            point2.put("p2.x", t.getPoint2().x + "");
            point2.put("p2.y", t.getPoint2().y + "");
            obj.put("p2", point2);
            
            JSONObject point3 = new JSONObject();
            point3.put("p3.x", t.getPoint3().x + "");
            point3.put("p3.y", t.getPoint3().y + "");
            obj.put("p3", point3);
            obj.put("Shape","3");
        }
        return obj;
    }
    
    public static AbstractShape JObjectToShape(JSONObject obj) 
    {
        JSONObject posObj = (JSONObject) obj.get("position");
        Point pos = new Point( Integer.parseInt((String) posObj.get("pos.x")) ,Integer. parseInt((String) posObj.get("pos.y")));
        
        JSONObject BorderColor = (JSONObject) obj.get("BorderColor");
        Color borderC = new Color((int)((long) BorderColor.get("r")), 
                (int)((long) BorderColor.get("g")), (int)((long) BorderColor.get("b")));
        JSONObject FillColor = (JSONObject) obj.get("FillColor");
        Color fillC = new Color((int)((long) FillColor.get("r")), 
                (int)((long) FillColor.get("g")), (int)((long) FillColor.get("b")));

        String type = (String) obj.get("Shape");
        switch (type) {
            case "0":
            {
                Oval o = new Oval( pos, (int)((long) obj.get("Hradius")), (int)((long) obj.get("Vradius")) );
                o.setColor(borderC);
                o.setFillColor(fillC);
                return o;
            }
            case "1":
            {
                Rectangle r = new Rectangle( pos, (int)((long)obj.get("width")), (int)((long)obj.get("height")) );
                r.setColor(borderC);
                r.setFillColor(fillC);
                return r;
            }
            case "2":
            {
                JSONObject endPoint = (JSONObject) obj.get("EndPoint");
                Point end = new Point( Integer.parseInt((String) endPoint.get("end.x")), Integer.parseInt((String) endPoint.get("end.y")) );
                Line l = new Line( pos, end );
                l.setColor(borderC);
                return l;
            }           
            case "3":
            {
                JSONObject point2 = (JSONObject) obj.get("p2");
                JSONObject point3 = (JSONObject) obj.get("p3");
                Point p2 = new Point( Integer.parseInt((String) point2.get("p2.x")), Integer.parseInt((String) point2.get("p2.y")));
                Point p3 = new Point( Integer.parseInt((String) point3.get("p3.x")) ,Integer.parseInt((String) point3.get("p3.y")));
                Triangle t = new Triangle( pos, p2, p3 );

                t.setColor(borderC);
                t.setFillColor(fillC);
                return t;
            }
            default:
                return null;
        }
    }
    
}