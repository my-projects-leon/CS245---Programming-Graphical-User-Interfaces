//
//	Name:	Leon, Pablo
//	Project:#3
//	Due:	November 18, 2014
//	Course: CS-245-01-f14
//
//	Description:
//				A window that read and sorts contact info into a Rolodex sorted into tabs
//
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

class Rolodex implements ActionListener {
	JTabbedPane tab;
	Rolodex(){
		File file = new File("contacts.txt");
		JFrame frame = new JFrame("Rolodex");
		frame.setSize(450,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JMenuBar jmb = new JMenuBar();
		//File Menu
		JMenu mfile = new JMenu("File");
		JMenuItem fopen = new JMenuItem("Open");
		JMenuItem fexit = new JMenuItem("Exit", KeyEvent.VK_X);
		mfile.add(fopen);
		fopen.setEnabled(false);
		mfile.addSeparator();
		mfile.add(fexit);
		
		jmb.add(mfile);
		//tabs menu
		JMenu mtab = new JMenu("Tabs");
		mtab.setMnemonic(KeyEvent.VK_T);
		JMenu tPlace = new JMenu("Placement");
		JMenu tLay = new JMenu("Layout Policy");
		JMenuItem tDef = new JMenuItem("Defaults", KeyEvent.VK_D);
		tDef.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		JMenuItem pTop = new JMenuItem("Top");
		JMenuItem pRight = new JMenuItem("Right");
		JMenuItem pBottom = new JMenuItem("Bottom");
		JMenuItem pLeft = new JMenuItem("Left");
		JMenuItem lScroll = new JMenuItem("Scroll");
		JMenuItem lWrap = new JMenuItem("Wrap");
		mtab.add(tPlace);
		mtab.add(tLay);
		mtab.addSeparator();
		mtab.add(tDef);
		tPlace.add(pTop);
		tPlace.add(pRight);
		tPlace.add(pBottom);
		tPlace.add(pLeft);
		tLay.add(lScroll);
		tLay.add(lWrap);
		
		jmb.add(mtab);
		//Help menu
		JMenu mhelp = new JMenu("Help");
		JMenuItem hAbout = new JMenuItem("About");
		mhelp.add(hAbout);
		
		jmb.add(mhelp);
		
		//adding action listeners
		fopen.addActionListener(this);
		fexit.addActionListener(this);
		pTop.addActionListener(this);
		pBottom.addActionListener(this);
		pLeft.addActionListener(this);
		pRight.addActionListener(this);
		tDef.addActionListener(this);
		lScroll.addActionListener(this);
		lWrap.addActionListener(this);
		hAbout.addActionListener(this);
		
		frame.setJMenuBar(jmb);
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		//panel to set in tab
		JPanel mypanel = new JPanel();
		//panel to set layout for tab
		mypanel.setLayout(new GridLayout(0,2));
		//create another panel to hold info
		JPanel myinfo = new JPanel();
		myinfo.setLayout(new GridLayout(2,0));
		JPanel pname = new JPanel();
		JPanel pemail = new JPanel();
		//create and add jpeg image
		try{
			BufferedImage pic = ImageIO.read(new File("nopic.jpg"));
			JLabel picL = new JLabel(new ImageIcon(pic));
			mypanel.add(picL);
		}catch(IOException ex)
		{
			System.out.println("no image found");
		}
		//create and add the info for the tab
		JLabel mylabel1 = new JLabel("Name:");
		JLabel mylabel2 =  new JLabel("Email:");
		JTextField myname = new JTextField("Leon, Pablo");
		JTextField myemail = new JTextField("pleon@csupomona.edu");
		pname.add(mylabel1);
		pname.add(myname);
		pemail.add(mylabel2);
		pemail.add(myemail);
		myinfo.add(pname);
		myinfo.add(pemail);
		mypanel.add(myinfo);
		tab.addTab("Leon, Pablo",mypanel);
		
		
		try
		{
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				//panel to set in tab
				JPanel panel = new JPanel();
				//panel to set layout for tab
				panel.setLayout(new GridLayout(0,2));
				//create another panel to hold info
				JPanel info = new JPanel();
				info.setLayout(new GridLayout(2,0));
				JPanel uname = new JPanel();
				JPanel uemail = new JPanel();
				String line = scan.nextLine();
				String[] parts = line.split("~");
				//create and add jpeg image
				try{
					BufferedImage pic = ImageIO.read(new File(parts[2]));
					JLabel picL = new JLabel(new ImageIcon(pic));
					panel.add(picL);
				}catch(IOException ex)
				{
					try{
						BufferedImage pic = ImageIO.read(new File("nopic.jpg"));
						JLabel picL = new JLabel(new ImageIcon(pic));
						panel.add(picL);
					}catch(IOException x)
					{
						System.out.println("Image Not Found");
					}
				}
				//create and add the info for the tab
				JLabel label1 = new JLabel("Name:");
				JLabel label2 =  new JLabel("Email:");
				JTextField name = new JTextField(parts[0]);
				JTextField email = new JTextField(parts[1]);
				uname.add(label1);
				uname.add(name);
				uemail.add(label2);
				uemail.add(email);
				info.add(uname);
				info.add(uemail);
				panel.add(info);
				tab.addTab(parts[0],panel);
				
			}
		}catch (FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		
		frame.getContentPane().add(tab);
	}

	// Handle menu item action events. 
	  public void actionPerformed(ActionEvent ae) {  
	    // Get the action command from the menu selection. 
	    String comStr = ae.getActionCommand();
	    JFrame aframe = new JFrame();
	 
	    // If user chooses Exit, then exit the program. 
	    if(comStr.equals("Exit")) 
	    	System.exit(0);
	    if(comStr.equals("Top"))
	    	tab.setTabPlacement(JTabbedPane.TOP);
	    
	    if(comStr.equals("Right")) 
	    	tab.setTabPlacement(JTabbedPane.RIGHT);
	    
	    if(comStr.equals("Bottom")) 
	    	tab.setTabPlacement(JTabbedPane.BOTTOM);
	    
	    if(comStr.equals("Left")) 
	    	tab.setTabPlacement(JTabbedPane.LEFT);
	    
	    if(comStr.equals("Scrol"))
	    	tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	    
	    if(comStr.equals("Wrap")) 
	    	tab.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
	    
	    if(comStr.equals("Defaults"))
	    {
	    	tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	    	tab.setTabPlacement(JTabbedPane.TOP);
	    }
	    
	    if(comStr.equals("About"))
	    	JOptionPane.showMessageDialog(aframe, "Rolodex version 0.1\n(c)2014 Leon");
	 
	  }  
	    
	  public static void main(String args[]) {   
	    // Create the frame on the event dispatching thread.   
	    SwingUtilities.invokeLater(new Runnable() {   
	      public void run() {   
	        new Rolodex();   
	      }   
	    });   
	  }   

}
