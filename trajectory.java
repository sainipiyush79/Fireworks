package FireWork;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Random;

 
public class trajectory extends JComponent implements ActionListener, ChangeListener {
    Random rand = new Random();  
	protected JButton button;
	protected JLabel label;
	protected JTextField textField;
	protected Timer timer;
	protected JPanel jpanel;

	
	
	
	static final int VelocityMin = 0; 	//set minum values for the Velocity 
	static final int VelocityMax = 120; 
	static final int VelocityDL = 20;

	static final int AngleMin = 0;	//set values for the Angle Slider.
	static final int AngleMax = 90;
	static final int AngleDL = 5;

	static final int DelayMin = 0; 	//set values for the Delay Slider.
	static final int DelayMax = 20;
	static final int DelayDL = 1;
	
	static final int BlueMin = 0;	//set values for the Blue Slider.
	static final int BlueMax = 255;
	static final int BlueDL = 5;
	
	static final int GreenMin = 0;	//set values for the Green Slider. 
	static final int GreenMax = 255;
	static final int GreenDL = 5;
	
	static final int RedMin = 0;		//set values for the Red Slider.
	static final int RedMax = 255;
	static final int RedDL = 5;



	double x = 0;
	double y = 0;
	double dx = 0;
	double dy = 0;

	static int R = 0;
	static int G = 0;
	static int B = 0;

	double LocationY = getHeight() - 1;
	double LocationDY = 0;

	public static int EXPLOSION = 0;
	public static double velocity = 80;
	public static double angle = 70;
	public static int DelayInput = 0;

	JButton buttonRefresh = new JButton("Refresh");
	JButton buttonExplosion1 = new JButton("Snowflake FireWork ");
	JButton buttonExplosion2 = new JButton("Sun FireWork");
	JButton buttonExplosion3 = new JButton("Star FireWork");
	JButton buttonExplosion4 = new JButton("4th of July firework");
	JButton buttonExplosion5= new JButton("Wave firework");


	JSlider blue_Slider = new JSlider(JSlider.VERTICAL, BlueMin, BlueMax, BlueDL);
	JSlider green_Slider = new JSlider(JSlider.VERTICAL, GreenMin, GreenMax, GreenDL);
	JSlider red_Slider = new JSlider(JSlider.VERTICAL, RedMin, RedMax, RedDL);

	JSlider delay_slider = new JSlider(JSlider.VERTICAL, DelayMin, DelayMax, DelayDL);
	JSlider angle_Slider = new JSlider(JSlider.VERTICAL, AngleMin, AngleMax, AngleDL); 
	JSlider speed_Slider = new JSlider(JSlider.VERTICAL, VelocityMin, VelocityMax, VelocityDL);
	
	

	public void buttons() {

		add(speed_Slider);
		add(angle_Slider);
		add(delay_slider);

		add(red_Slider); //The Slider for the color Red
		add(green_Slider); //The Slider for the color Green
		add(blue_Slider); //The Color for the color Blue 

		add(buttonRefresh); //Button for the Refresh 
		add(buttonExplosion1); //Button for the Explosion 1 
		add(buttonExplosion2); //Button for the Explosion 2
		add(buttonExplosion3); //Button for the Explosion 3
		add(buttonExplosion4); //Button for the Explosion 4
		add(buttonExplosion5); //Button for the Explosion 5

		jpanel.add(speed_Slider);
		jpanel.add(angle_Slider);
		jpanel.add(delay_slider);

		jpanel.add(red_Slider);
		jpanel.add(green_Slider);
		jpanel.add(blue_Slider);

		jpanel.add(buttonRefresh);
		jpanel.add(buttonExplosion1);
		jpanel.add(buttonExplosion2);
		jpanel.add(buttonExplosion3);
		jpanel.add(buttonExplosion4);
		jpanel.add(buttonExplosion5);

	}
	public void Trajectory(){
		Graphics g = getGraphics();
		double LocationY = getHeight() - 1;
		for (double t = 0; t < DelayInput; t += 0.01) {

			double gravity = 9.8;
			double radian = Math.toRadians(angle);

			x = velocity * Math.cos(radian) * t;
			y = (velocity * Math.sin(radian) * t) - ((.5) * (gravity) * Math.pow(t, 2));

			dx = velocity * Math.cos(radian) * DelayInput;
			dy = (velocity * Math.sin(radian) * DelayInput) - ((.5) * (gravity) * Math.pow(DelayInput, 2));
			int groundY = getHeight();
			LocationY = groundY - y;
			
			g.setColor(new Color(R,G,B)); //This creates the color for the trajectory
			g.fillOval((int) x, (int) LocationY, 5, 5);

		}
	}

	public void Refresh () {
		Graphics g = getGraphics();
		g.setColor(new Color(0,0,255));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.yellow);
		g.fillOval( 50,  50 , 100 , 100);
		
		g.setColor(new Color(0,100,0));
		g.fillRect(0, getHeight() - 100, getWidth(), getHeight()/4 );
		

	}
	public void Explosions1 (){
		Graphics g = getGraphics();

		for (double t = 0; t <DelayInput; t += 0.01) {
			double gravity = 9.8;
			double radian = Math.toRadians(angle);

			x = velocity * Math.cos(radian) * t;
			y = (velocity * Math.sin(radian) * t) - ((.5) * (gravity) * Math.pow(t, 2));

			dx = velocity * Math.cos(radian) *  DelayInput;
			dy = (velocity * Math.sin(radian) * DelayInput) - ((.5) * (gravity) * Math.pow( DelayInput, 2));

			int groundY = getHeight();

			LocationDY = groundY - dy; //The firework will start at the ground and will change the line as the dy changes. 
		}
		
		Color c_1 = new Color(R,G,B);
		Color c_2 = new Color(B,R,G);
		Color c_3 = new Color(G,B,R);
	
		for(int i = 0; i <= 2 ; i++) {
		g.setColor(Color.red);
		g.fillOval((int)  dx  + rand.nextInt(10)* 15, (int)LocationDY + rand.nextInt(10) * 15, 30, 30);
		g.setColor(c_1);
		g.fillOval((int)dx  + rand.nextInt(10)* 15, (int)LocationDY + rand.nextInt(10) * 15, 50, 50);
		g.setColor(c_2);
		g.fillOval((int) dx  + rand.nextInt(10)* 15, (int)LocationDY + rand.nextInt(10) * 15 , 30, 30);
		g.setColor(Color.orange);
		g.fillOval((int) dx  + rand.nextInt(10)* 15, (int)LocationDY + rand.nextInt(10) * 15 , 15, 15);
		g.setColor(c_3);
		g.fillOval((int) dx  + rand.nextInt(10)* 15, (int)LocationDY + rand.nextInt(10) * 15 , 20, 20);
		g.setColor(Color.blue);
		g.fillOval((int) dx  + rand.nextInt(10)* 15, (int)LocationDY + rand.nextInt(10) * 15 , 20, 20);
		}
	
	}
	
	public void Explosion2 () { //The drawing for the Second Explosion of the firework. 
		Graphics g = getGraphics();
		Graphics2D f = (Graphics2D) g;


		for (double t = 0; t <  DelayInput; t += 0.01) {
			final double gravity = 9.8;
			double radian = Math.toRadians(angle);

			x = velocity * Math.cos(radian) * t;
			y = (velocity * Math.sin(radian) * t) - ((.5) * (gravity) * Math.pow(t, 2));

			dx = velocity * Math.cos(radian) *  DelayInput;
			dy = (velocity * Math.sin(radian) *  DelayInput) - ((.5) * (gravity) * Math.pow( DelayInput, 2));
			int groundY = getHeight();
			LocationDY = groundY - dy;
		}

		
		for ( int Num =0; Num<= 5; Num++) {
			
		
		
			double d_1 = dx  + rand.nextInt(10)* 10, y_1 = LocationDY + rand.nextInt(10) * 10;
			
			f.setPaint(new RadialGradientPaint((int) d_1, (int) y_1, 30, new float[] { 0, 0.3f, 1 }, new Color[] { Color.RED, Color.YELLOW, Color.ORANGE }));
		    f.fill(createStar( d_1 ,  y_1 , 30 , 20, 20, 0));
			
		}
	}
	
	public void Explosion3() {	//The drawing for the Third Explosion of the firework.
		Graphics g = getGraphics();
		Graphics2D f = (Graphics2D) g;
		for (double t = 0; t <  DelayInput; t += 0.01) {
			double gravity = 9.8;
			double radian = Math.toRadians(angle);

			x = velocity * Math.cos(radian) * t;
			y = (velocity * Math.sin(radian) * t) - ((.5) * (gravity) * Math.pow(t, 2));

			dx = velocity * Math.cos(radian) *  DelayInput;
			dy = (velocity * Math.sin(radian) *  DelayInput) - ((.5) * (gravity) * Math.pow( DelayInput, 2));
			int groundY = getHeight();
			LocationDY = groundY - dy;
		}
		for ( int Num =0; Num<= 5; Num++) {
			
			Color c_1 = new Color(R,G,B);
			
			Color c_3 = new Color(G,B,R);
		
			
			
			f.setPaint(c_1);
	        f.fill(createStar(dx + rand.nextInt(10)* 10, LocationDY + rand.nextInt(10) * 10, 10, 20, 10, 0));
	        
	        f.setPaint(Color.red);
	        f.fill(createStar(dx + rand.nextInt(10) * 10 , LocationDY + rand.nextInt(10) * 10, 5, 10, 10, 0));
	        
	        f.setPaint(c_3);
	        f.fill(createStar(dx + rand.nextInt(10) * 10, LocationDY + rand.nextInt(10) * 10, 5, 10, 10, 0));
	     
	  
		}

	}
	
	
	
	public void Explosion4() {  //The drawing for the Fourth Explosion of the firework.
		Graphics g = getGraphics();
		

		for (double t = 0; t <  DelayInput; t += 0.01) {
			double gravity = 9.8;
			double radian = Math.toRadians(angle);

			x = velocity * Math.cos(radian) * t;
			y = (velocity * Math.sin(radian) * t) - ((.5) * (gravity) * Math.pow(t, 2));

			dx = velocity * Math.cos(radian) *  DelayInput;
			dy = (velocity * Math.sin(radian) *  DelayInput) - ((.5) * (gravity) * Math.pow( DelayInput, 2));
			int groundY = getHeight();
			LocationDY = groundY - dy;
		}
		int r = 0;
		for ( int i =0;  i <=12; i++) {
			r +=10;
	
			
			if( i % 2 == 0) { // if stament to change the color of the circle depending if is an even or odd
				g.setColor(Color.white);
			}else {
				g.setColor(Color.red);
			}

			g.drawOval((int)(dx-(r/2)), (int) (LocationDY-(r/2)),r-7,r-7);
			if( i % 2 == 0) { // if stament to change the color of the circle depending if is an even or odd
				g.setColor(Color.red);
			}else {
				g.setColor(Color.blue);
			}

			g.drawOval((int)(dx-(r/2)), (int) (LocationDY-(r/2)),r-15,r-15);	
			if( i % 2 == 0) { // if stament to change the color of the circle depending if is an even or odd
				g.setColor(Color.blue);
			}else {
				g.setColor(Color.white);
			}

			g.drawOval((int)(dx-(r/2))-20, (int) (LocationDY-(r/2))+24,r,r);
			if( i % 2 == 0) { // if stament to change the color of the circle depending if is an even or odd
				g.setColor(Color.white);
			}else {
				g.setColor(Color.red);
			}
			g.drawOval((int)(dx-(r/2))-45, (int) (LocationDY-(r/2))+55,r-8,r-8);
			
			if( i % 2 == 0) { // if stament to change the color of the circle depending if is an even or odd
				g.setColor(Color.red);
			}else {
				g.setColor(Color.blue);
			}
			g.drawOval((int)(dx-(r/2))-23, (int) (LocationDY-(r/2))+64,r-20,r-20);
			
			if( i % 2 == 0) { // if stament to change the color of the circle depending if is an even or odd
				g.setColor(Color.blue);
			}else {
				g.setColor(Color.white);
			}
			g.drawOval((int)(dx-(r/2))+35, (int) (LocationDY-(r/2))-45,r,r);
			
			if( i % 2 == 0) { // if stament to change the color of the circle depending if is an even or odd
				g.setColor(Color.white);
			}else {
				g.setColor(Color.red);
			}
			g.drawOval((int)(dx-(r/2))+50, (int) (LocationDY-(r/2))-24,r-7,r-7);
			
			if( i % 2 == 0) { // if stament to change the color of the circle depending if is an even or odd
				g.setColor(Color.red);
			}else {
				g.setColor(Color.blue);
			}
			g.drawOval((int)(dx-(r/2))+10, (int) (LocationDY-(r/2))-23,r-25,r-25);
		}

	}

	public void Explosion5() { //The drawing for the Fifth Explosion of the firework.
		Graphics g = getGraphics();
		Graphics2D f = (Graphics2D) g;
		for (double t = 0; t <  DelayInput; t += 0.01) {
			double gravity = 9.8;
			double radian = Math.toRadians(angle);

			x = velocity * Math.cos(radian) * t;
			y = (velocity * Math.sin(radian) * t) - ((.5) * (gravity) * Math.pow(t, 2));

			dx = velocity * Math.cos(radian) *  DelayInput;
			dy = (velocity * Math.sin(radian) *  DelayInput) - ((.5) * (gravity) * Math.pow( DelayInput, 2));
			int groundY = getHeight();
			LocationDY = groundY - dy;
		}
		for ( int z = 0; z <= 3; z ++) {
			Color c_1 = new Color(R,G,B);
			Color c_2 = new Color(B,R,G);
			double d_1 = dx  + rand.nextInt(10)* 20, y_1 = LocationDY + rand.nextInt(10) * 20;
			
			 f.setPaint(new RadialGradientPaint((int) d_1 + 40, (int) y_1 + 40, 10, new float[] { 0, 0.3f, 1 }, new Color[] { Color.red , c_2, Color.ORANGE }, CycleMethod.REPEAT));
			 f.fillOval((int) d_1, (int) y_1, 80, 80);
			}

		



	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void stateChanged(ChangeEvent e) {

	}


private static Shape createStar(double centerX, double centerY,
    double innerRadius, double outerRadius, int numRays,
    double startAngleRad)
{
    Path2D path = new Path2D.Double();
    double deltaAngleRad = Math.PI / numRays;
    for (int i = 0; i < numRays * 2; i++)
    {
        double angleRad = startAngleRad + i * deltaAngleRad;
        double ca = Math.cos(angleRad);
        double sa = Math.sin(angleRad);
        double relX = ca;
        double relY = sa;
        if ((i & 1) == 0)
        {
            relX *= outerRadius;
            relY *= outerRadius;
        }
        else
        {
            relX *= innerRadius;
            relY *= innerRadius;
        }
        if (i == 0)
        {
            path.moveTo(centerX + relX, centerY + relY);
        }
        else
        {
            path.lineTo(centerX + relX, centerY + relY);
        }
    }
    path.closePath();
    return path;
}
}
