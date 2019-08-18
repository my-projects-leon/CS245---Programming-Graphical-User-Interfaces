//
//	Name:	Leon, Pablo
//	Homework:#1
//	Due:	November 6, 2014
//	Course: CS-245-01-f14
//
//	Description:
//				A simple stopwatch that is started by a selected time on a slider.
//


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

class StopWatchRT implements ActionListener {

    JLabel jlab;
    long start;
    JButton jbtnStart;
    Timer stTimer;
    JSlider slider;

    StopWatchRT() {

        JFrame jfrm = new JFrame("A Simple Stopwatch");
        jfrm.getContentPane().setLayout(new GridLayout(3,0));
        jfrm.setSize(300, 300);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jbtnStart = new JButton("Start");
        
        slider = new JSlider(5,15);
        slider.setMajorTickSpacing(1);
        slider.setLabelTable(slider.createStandardLabels(1));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);

        jbtnStart.addActionListener(this);
 
        jlab = new JLabel("Pablo Leon");
        
        ActionListener updateTime = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	start--;
                jlab.setText("" + start + "s");
                if(start == 0)
                {
                	stTimer.stop();
                    jlab.setText("Done timing: "
                            + jlab.getText());
                    jbtnStart.setText("Start");
                }
            }
        };
        
        stTimer = new Timer(1000, updateTime); 

        jfrm.add(jlab);
        jfrm.add(jbtnStart);
        jfrm.add(slider);
         
        jfrm.getRootPane().setDefaultButton(jbtnStart);
        jfrm.setVisible(true);
    }
 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Start")) { 
            start = slider.getValue();
            stTimer.start();
            jlab.setText("Stopwatch is Running...");
            jbtnStart.setText("Stop");
        } else
        {
            stTimer.stop();
            jlab.setText("Remaining time is "
                    + jlab.getText());
            jbtnStart.setText("Start");
        }
    }

    public static void main(String args[]) {

        // Create the frame on the event dispatching thread. 
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StopWatchRT();
            }
        });
    }

}