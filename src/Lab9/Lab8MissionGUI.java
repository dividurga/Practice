package labs.drone;

/**
 * @authors Divija
 * Basic GUI for controlling TelloEdu Drones
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import tellolib.camera.TelloCamera;
import external.Picture;
//class with paint
import homework8.q1;

//import tellolib.command.TelloFlip;
import tellolib.control.DroneControl;
import tellolib.command.TelloFlip;

public class Lab8MissionGUI {

	public static void main(String[] args) {
		
		DroneControl myDrone = DroneControl.getInstance();
		TelloCamera camera = TelloCamera.getInstance();
		myDrone.connect();
		myDrone.enterCommandMode();
		
		myDrone.streamOn();
		camera.startVideoCapture(true);
		// Start recording the video stream to a .avi file in the Photos directory of this

		// workspace.
		camera.startRecording(System.getProperty("user.dir") +"\\Photos");
		
        JFrame frame = new JFrame("ECE 115 Drone Control GUI");
        frame.setLayout(new FlowLayout());
        frame.setSize(450, 200);
        frame.setBackground(Color.GRAY);
        Picture img = new Picture("/Users/divija/Downloads/Poster 4.jpg");
        // Create a 4x4 array of buttons
        JButton[][] buttons = new JButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton("Button " + i + " " + j);
            }
        }
        
        // Add the buttons to the frame
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                frame.add(buttons[i][j]);
            }
        }
        		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		
	
        buttons[0][0].setText("Take Off");
		buttons[0][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Taking Off....");
				myDrone.takeOff();
			}
		});
		buttons[0][1].setText("UP (30cm)");
		buttons[0][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Moving up...");
				myDrone.up(30);
			}
		});
		
		buttons[0][2].setText("Poster 1");
		buttons[0][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Taking Picture of Poster 1...");
				camera.takePicture(System.getProperty("user.dir") + "\\Photos", "Poster 1");
			}
		});
		
		buttons[0][3].setText("Move Forward (50 cm)");
		buttons[0][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Moving Forward...");
				myDrone.forward(30);
			}
		});
		buttons[1][0].setText("Left (50 cm)");
		buttons[1][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Moving left...");
				myDrone.left(50);
			}
		});
		
		buttons[1][1].setText("Print Height");
		buttons[1][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Printing Height...");
				myDrone.getHeight();
			}
		});
		
		buttons[1][2].setText("Right (30cm) ");
		buttons[1][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Moving Right...");
				myDrone.right(50);
				
			}
		});
		
		buttons[1][3].setText("Move Back (50 cm) ");
		buttons[1][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Moving back...");
				myDrone.backward(50);
				
			}
		});
		
		buttons[2][0].setText("Poster 2 ");
		buttons[2][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Taking Picture of Poster 2...");
				camera.takePicture(System.getProperty("user.dir") + "\\Photos", "Poster 2");
				
				
			}
		});
		
		buttons[2][1].setText("Down (30 cm) ");
		buttons[2][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Moving Down...");
				myDrone.down(30);
				
			}
		});
		
		buttons[2][2].setText("Poster 3");
		buttons[2][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Taking Picture of Poster 3...");
				camera.takePicture(System.getProperty("user.dir") + "\\Photos", "Poster 3");
				
			}
		});
		
		buttons[2][3].setText("Rotate Right");
		buttons[2][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Rotating Right...");
				myDrone.rotateLeft(90);
				
			}
		});
		
		buttons[3][0].setText("Poster 4");
		buttons[3][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Taking Picture of Poster 4...");
				camera.takePicture(System.getProperty("user.dir") + "\\Photos", "Poster 4");
				
			}
		});
		
		buttons[3][1].setText("Poster 5");
		buttons[3][1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Taking Picture of Poster 5...");
				camera.takePicture(System.getProperty("user.dir") + "\\Photos", "Poster 5");
				
			}
		});
		
		buttons[3][2].setText("Flip Backward");
		buttons[3][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Flipping Backward...");
				myDrone.doFlip(TelloFlip.backward);
				
			}
		});
		
		
        //// Code for Landing
		buttons[3][3].setText("Land");
		buttons[3][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Landing....");
				myDrone.land();
				
				Picture img1 = new Picture("REDACTED/Poster 1.jpg");
				q1.distanceCluster(img1);
				Picture img2 = new Picture("REDACTED/Poster 2.jpg");
				q1.distanceCluster(img2);
				Picture img3 = new Picture("REDACTED/Poster 3.jpg");
				q1.distanceCluster(img3);
				Picture img4 = new Picture("REDACTED/Poster 4.jpg");
				q1.distanceCluster(img4);
				Picture img5 = new Picture("REDACTED/Poster 5.jpg");
				q1.distanceCluster(img5);
			}
		});
        

		

	}
}
