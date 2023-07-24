package MyPaint;
  
import java.awt.Color;
import java.io.File;
import java.nio.file.Path;
import javax.swing.JColorChooser;

/**
 *
 * @author shaym
 */
public class Paint extends javax.swing.JFrame implements Node{

    private Node parent;
    public static int NbOfOvals;
    public static int NbOfLines;
    public static int NbOfSquares;
    public static int NbOfRect;
    public static int NbOfTriangles;

    /**
     * Creates new form Paint
     */
    private DrawingEngine engine;

    
    public Paint() {
        initComponents();
        engine = (DrawingEngine) jPanel1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        lineB = new javax.swing.JButton();
        rectB = new javax.swing.JButton();
        ChooseShape = new javax.swing.JComboBox<>();
        Label = new javax.swing.JLabel();
        colorB = new javax.swing.JButton();
        deleteB = new javax.swing.JButton();
        triangleB = new javax.swing.JButton();
        jPanel1 = new MyPaint.MyPanel2(this);
        ovalB = new javax.swing.JButton();
        copyB = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jSaveAs = new javax.swing.JMenuItem();
        jLoad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vector Drawing Application");

        lineB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lineB.setText("Line Segment");
        lineB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineBActionPerformed(evt);
            }
        });

        rectB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rectB.setText("Rectangle");
        rectB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectBActionPerformed(evt);
            }
        });

        ChooseShape.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ChooseShape.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Shape" }));
        ChooseShape.setName(""); // NOI18N
        ChooseShape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseShapeActionPerformed(evt);
            }
        });

        Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Label.setText("Select Shape");

        colorB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorB.setText("Colorize");
        colorB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorBActionPerformed(evt);
            }
        });

        deleteB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteB.setText("Delete");
        deleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBActionPerformed(evt);
            }
        });

        triangleB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        triangleB.setText("Triangle");
        triangleB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleBActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ovalB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ovalB.setText("Oval");
        ovalB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovalBActionPerformed(evt);
            }
        });

        copyB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        copyB.setText("Copy");
        copyB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyBActionPerformed(evt);
            }
        });

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setDoubleBuffered(true);

        jMenu.setText("File");

        jSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jSaveAs.setText("Save as");
        jSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveAsActionPerformed(evt);
            }
        });
        jMenu.add(jSaveAs);

        jLoad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jLoad.setText("Load");
        jLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoadActionPerformed(evt);
            }
        });
        jMenu.add(jLoad);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label)
                    .addComponent(ChooseShape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorB)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(deleteB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addComponent(copyB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ovalB)
                        .addGap(18, 18, 18)
                        .addComponent(rectB)
                        .addGap(18, 18, 18)
                        .addComponent(triangleB)
                        .addGap(18, 18, 18)
                        .addComponent(lineB)
                        .addGap(117, 117, 117))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChooseShape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(colorB)
                .addGap(18, 18, 18)
                .addComponent(deleteB)
                .addGap(18, 18, 18)
                .addComponent(copyB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ovalB)
                    .addComponent(rectB)
                    .addComponent(triangleB)
                    .addComponent(lineB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ChooseShape.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ovalBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovalBActionPerformed
        OvalFront c = new OvalFront(engine, ChooseShape);
        c.setVisible(true);
        c.setParentNode(this);
        this.setVisible(false); 
    }//GEN-LAST:event_ovalBActionPerformed
             
    private void ChooseShapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseShapeActionPerformed
             
    }//GEN-LAST:event_ChooseShapeActionPerformed

    private void lineBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineBActionPerformed
        LineFront l = new LineFront(engine, ChooseShape);
        l.setVisible(true);
        l.setParentNode(this);
        this.setVisible(false);
    }//GEN-LAST:event_lineBActionPerformed

    private void rectBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectBActionPerformed
        RectangleFront r = new RectangleFront(engine, ChooseShape);
        r.setVisible(true);
        r.setParentNode(this);
        this.setVisible(false);
    }//GEN-LAST:event_rectBActionPerformed

    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        if(ChooseShape.getSelectedIndex() == 0)
            return;
        int index = ChooseShape.getSelectedIndex();
        engine.removeShape(engine.getShapes()[index-1]);
        engine.refresh(null);
        ChooseShape.removeItemAt(index);
    }//GEN-LAST:event_deleteBActionPerformed

    private void colorBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorBActionPerformed
        if(ChooseShape.getSelectedIndex() == 0)
            return;
        int i = ChooseShape.getSelectedIndex();
        Color color = JColorChooser.showDialog(null,"Choose Border Color",Color.black);
        engine.getShapes()[i-1].setColor(color);
        if (!engine.getShapes()[i-1].toString().contains("Line")){
            Color fillColor = JColorChooser.showDialog(null,"Choose Fill Color",Color.black);
            engine.getShapes()[i-1].setFillColor(fillColor);
        }
        engine.refresh(null);
    }//GEN-LAST:event_colorBActionPerformed

    private void triangleBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleBActionPerformed
        TriangleFront t = new TriangleFront(engine, ChooseShape);
        t.setVisible(true);
        t.setParentNode(this);
        this.setVisible(false);
    }//GEN-LAST:event_triangleBActionPerformed

    private void jSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveAsActionPerformed
        // TODO add your handling code here:
        fileChooser.showSaveDialog(this);
        File f = fileChooser.getSelectedFile();
        Path path = f.toPath();
        ((MyPanel2) engine).save(f.getAbsolutePath());  
        System.out.println("Saved!");
        
    }//GEN-LAST:event_jSaveAsActionPerformed

    private void copyBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyBActionPerformed
        
        if(getComboIndex() == 0)
        {
            return;
        }
        Shape s = engine.getShapes()[getComboIndex()-1];
        if(s instanceof Rectangle rectangle)
        {
            Rectangle r = new Rectangle(s.getPosition(), rectangle.getWidth(), rectangle.getHeight());
            ChooseShape.addItem("Rectangle_" + (++NbOfRect));
            r.setColor(rectangle.getColor());
            r.setFillColor(rectangle.getFillColor());
            engine.addShape(r);
            engine.refresh(null);
        }    
        else if(s instanceof Line line){
            Line l = new Line(line.getPosition(), line.getEndPoint());
            ChooseShape.addItem("Line_" + (++NbOfLines));
            l.setColor(line.getColor());
            engine.addShape(l);
            engine.refresh(null);
        }
        else if(s instanceof Oval oval){
            Oval o = new Oval(oval.getPosition(), oval.gethRadius(), oval.getvRadius());
            ChooseShape.addItem("Oval_" + (++NbOfOvals));
            o.setColor(oval.getColor());
            o.setFillColor(oval.getFillColor());
            engine.addShape(o);
            engine.refresh(null);
        }
        else if(s instanceof Triangle triangle){ 
            Triangle t = new Triangle(s.getPosition(), triangle.getPoint2(), triangle.getPoint3());
            ChooseShape.addItem("Triangle_" + (++NbOfTriangles));      
            t.setColor(triangle.getColor());
            t.setFillColor(triangle.getFillColor());
            engine.addShape(t);
            engine.refresh(null); 
            
        }
    }//GEN-LAST:event_copyBActionPerformed

    private void jLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoadActionPerformed
        // TODO add your handling code here:
        ChooseShape.removeAllItems();
        ChooseShape.addItem("Choose Shape");
        fileChooser.showOpenDialog(this);
        File f = fileChooser.getSelectedFile();
        ((MyPanel2) engine).load(f.getAbsolutePath());
        System.out.println("loaded Successfully!");     
        
    }//GEN-LAST:event_jLoadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ChooseShape;
    private javax.swing.JLabel Label;
    private javax.swing.JButton colorB;
    private javax.swing.JButton copyB;
    private javax.swing.JButton deleteB;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenuItem jLoad;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jSaveAs;
    private javax.swing.JButton lineB;
    private javax.swing.JButton ovalB;
    private javax.swing.JButton rectB;
    private javax.swing.JButton triangleB;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getParentNode() {
        return parent;
    }

    @Override
    public void setParentNode(Node node) {
        this.parent = node;
    }
    
    public void setComboIndex(int i){
        ChooseShape.setSelectedIndex(i);
    }
    public int getComboIndex(){
        return ChooseShape.getSelectedIndex();
    }
    
    public void addToComboAndPanel(Shape shape){ // for loading
        engine.addShape(shape); 
        engine.refresh(null);
        int i = 0;
        if (shape instanceof Oval) {
            ChooseShape.addItem("Oval_" + (++NbOfOvals));
        } else if (shape instanceof Rectangle) {
            ChooseShape.addItem("Rectangle_" + (++NbOfRect));
        } else if (shape instanceof Triangle) {
            ChooseShape.addItem("Triangle_" + (++NbOfTriangles));
        } else if (shape instanceof Line) {
            ChooseShape.addItem("Line_" + (++NbOfLines));
        }
    }
}