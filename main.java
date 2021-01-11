package FireWork;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class main extends trajectory{

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fireworks Simulator");
		JPanel bigFrame = new JPanel();
		JPanel buttons = new JPanel();
		trajectory f = new trajectory();
		
		JLabel blue = new JLabel("BLUE");
		JLabel green = new JLabel("GREEN");
		JLabel red = new JLabel("RED");
		JLabel delay = new JLabel("Delay");
		JLabel Angle = new JLabel("Angle");
		JLabel label1 = new JLabel("Speed");
		

		f.angle_Slider.addChangeListener(new ChangeListener() {	// Slider for the Angle changer

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					angle = f.angle_Slider.getValue();
					System.out.println("Angle Slider is working");
				}

			}
		});
		f.angle_Slider.setMajorTickSpacing(5);
		f.angle_Slider.setMinorTickSpacing(1);
		f.angle_Slider.setPaintTicks(true);
		f.angle_Slider.setPaintLabels(true);

		f.delay_slider.addChangeListener(new ChangeListener() {	//Slider for the Delay changer

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					DelayInput= f.delay_slider.getValue();
					System.out.println("Delay Slider is working");
				}

			}
		});
		f.delay_slider.setMajorTickSpacing(1);
		f.delay_slider.setMinorTickSpacing(1);
		f.delay_slider.setPaintTicks(true);
		f.delay_slider.setPaintLabels(true);

		f.red_Slider.addChangeListener(new ChangeListener() {//Slider for the Red color changer
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					R = f.red_Slider.getValue();
					System.out.println("Red Slider is working");
				}
			}
		});

		f.red_Slider.setMajorTickSpacing(255);
		f.red_Slider.setMinorTickSpacing(5);
		f.red_Slider.setPaintTicks(true);
		f.red_Slider.setPaintLabels(true);


		f.green_Slider.addChangeListener(new ChangeListener() {	//Slider for the Green color changer 

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					G = f.green_Slider.getValue();
					System.out.println("Green Slider is working");
				}
			}
		});

		f.green_Slider.setMajorTickSpacing(255);
		f.green_Slider.setMinorTickSpacing(5);
		f.green_Slider.setPaintTicks(true);
		f.green_Slider.setPaintLabels(true);


		f.blue_Slider.addChangeListener(new ChangeListener() {	// Slider for the Blue color changer

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					B = f.blue_Slider.getValue();
					System.out.println("Blue Slider is working");
				}
			}
		});

		f.blue_Slider.setMajorTickSpacing(255);
		f.blue_Slider.setMinorTickSpacing(5);
		f.blue_Slider.setPaintTicks(true);
		f.blue_Slider.setPaintLabels(true);

		// defining the speed slider

		f.speed_Slider.addChangeListener(new ChangeListener() {//shows when the user gives a certain input of the velocity and to ensure the user that it is working.
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					velocity = f.speed_Slider.getValue();
					System.out.println("Velocity Slider is working");
				}
			}
		});
		f.buttonExplosion1.addActionListener(new ActionListener() {//Notifys the user when they activate the First Explosion.
			@Override
			public void actionPerformed(ActionEvent e) {

				f.Trajectory();
				f.Explosions1();
				System.out.println("Explosion 1 Activated");
			}
		});

		f.buttonExplosion2.addActionListener(new ActionListener() {//Notifys the user when they activate the Second Explosion.
			@Override
			public void actionPerformed(ActionEvent e) {

				f.Trajectory();
				f.Explosion2();
				System.out.println("Explosion 2 Activated");

			}
		});


		f.buttonExplosion3.addActionListener(new ActionListener() { //Notifys the user when they activate the Third Explosion.
			@Override
			public void actionPerformed(ActionEvent e) {

				f.Trajectory();
				f.Explosion3();
				System.out.println("Explosion 3 Activated");

			}
		});

		f.buttonExplosion4.addActionListener(new ActionListener() {//Notifys the user when they activate the Fourth Explosion.
			@Override
			public void actionPerformed(ActionEvent e) {

				f.Trajectory();
				f.Explosion4();

				System.out.println("Explosion 4 Activated");
			}
		});

		f.buttonExplosion5.addActionListener(new ActionListener() {//Notifys the user when they activate the Fifth Explosion.
			@Override
			public void actionPerformed(ActionEvent e) {

				f.Trajectory();
				f.Explosion5();
				System.out.println("Explosion 5 Activated");
				
				
				
			}
		});

		f.buttonRefresh.addActionListener(new ActionListener() { //Notifys the user when they activate the Refresh Button.
			@Override
			public void actionPerformed(ActionEvent e) {

				f.Refresh();

				System.out.println("Refresh Activated");

			}
		});


		f.speed_Slider.setMajorTickSpacing(20);
		f.speed_Slider.setMinorTickSpacing(1);
		f.speed_Slider.setPaintTicks(true);
		f.speed_Slider.setPaintLabels(true);


		buttons.add(blue);
		buttons.add(f.blue_Slider);

		buttons.add(green);
		buttons.add(f.green_Slider);

		buttons.add(red);
		buttons.add(f.red_Slider);

		buttons.add(delay);
		buttons.add(f.delay_slider);
		
		buttons.add(Angle);
		buttons.add(f.angle_Slider);
		
		buttons.add(label1);
		buttons.add(f.speed_Slider);
		
		buttons.add(f.buttonRefresh);
		buttons.add(f.buttonExplosion1);
		buttons.add(f.buttonExplosion2);
		buttons.add(f.buttonExplosion3);
		buttons.add(f.buttonExplosion4);
		buttons.add(f.buttonExplosion5);


		frame.add(bigFrame);
		bigFrame.setLayout(new BorderLayout());
		bigFrame.add(buttons, BorderLayout.NORTH);
		bigFrame.add(f, BorderLayout.CENTER);
		frame.setSize(2000, 2000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


	}

}



