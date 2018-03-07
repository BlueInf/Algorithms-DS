import javax.swing.*;
import java.awt.*;


/**
 * Recursive Draw Class
 This is created by drawing a circle in the center of diameter W/3 of an imaginary line of width W. Three more circles are then drawn in the centers of the three line segments obtained by dividing the line in equal parts - and so on.
 The shades of green represent the level of recursion depth.
 */
public class RecursiveDraw extends JFrame{

    private int width=1200;
    private int height=1000;
    private int radius=width/6;
    /** Constructor */
    public RecursiveDraw(String title) {
        super(title);
    }

    /** Init method */
    public void init() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        ShapePanel shapePanel=new ShapePanel();
        this.setContentPane(shapePanel);

        this.setSize(1200, 1000);
        setVisible(true);

    }

    /** Main method */
    public static void main(String[] args){

    RecursiveDraw recursiveDraw=new RecursiveDraw("Window");
    recursiveDraw.init();

    }

    /**
     * ShapePanel extends JPanel
     * Where we draw our circles
     */
    class ShapePanel extends JPanel {

        public ShapePanel(){
            super();
            this.setLayout(null);
        }


        /**
         * paintComponent method
         * @param g
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            Graphics2D g2d = (Graphics2D) g;

            //Anti alias graphics.
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // We paint the main circle in the centre
            g2d.setColor(Color.GREEN);
            g2d.fillOval(width/2-radius,height/2-radius,radius*2,radius*2);

            // Then we call our recursive function
            drawCircles(g2d,0,1200,1);

        }

        /**
         * Recursive function drawCircles
         * This is created by drawing a circle in the center of diameter W/3 of an imaginary line of width W. Three more circles are then drawn in the centers of the three line segments obtained by dividing the line in equal parts - and so on.
         * The shades of green represent the level of recursion depth.
         * @param graphics2D
         * @param xBeg
         * @param xEnd
         * @param depth
         */
        public void drawCircles(Graphics2D graphics2D,int xBeg,int xEnd,int depth){

            // Y for the middle Y axis
            int y=500;

            // Width is calculated by the values of the two X
            width=xEnd-xBeg;

            // If the width is less than 30 then return
            if(width<30) return;

            //The Radius is calculated
            int radius=(width)/18;

            // We set the shade of the green to be blacker
            Color green=new Color(0,255-depth*40,0);
            graphics2D.setColor(green);

            // We draw the 3 circles in the centres of the 3 line segments
            graphics2D.fillOval(xBeg+width/6-radius,y-radius,radius*2,radius*2);
            graphics2D.fillOval(xBeg+width/2-radius,y-radius,radius*2,radius*2);
            graphics2D.fillOval(xBeg+5*width/6-radius,y-radius,radius*2,radius*2);

            // We call the draw Circles for the 3 line segments
            // Therefore we separate the line into 3 more
            drawCircles(graphics2D,xBeg,xBeg+width/3,depth+1);
            width=xEnd-xBeg;
            drawCircles(graphics2D,xBeg+width/3,xBeg+2*width/3,depth+1);
            width=xEnd-xBeg;
            drawCircles(graphics2D,xBeg+2*width/3,xBeg+width,depth+1);

        }

    }

}

