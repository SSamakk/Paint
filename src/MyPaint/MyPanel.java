package MyPaint;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 *
 * @author shaym
 */
public class MyPanel extends JPanel implements DrawingEngine{

    /**
     *
     */
    private ArrayList<Shape> shapes;
    
    public MyPanel(){
        shapes = new ArrayList<>();
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Shape s : shapes)
            s.draw(g);
    }
    
    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        return shapes.toArray(Shape[]::new);
    }

    @Override
    public void refresh(Graphics canvas) {
        repaint();
    }
}
