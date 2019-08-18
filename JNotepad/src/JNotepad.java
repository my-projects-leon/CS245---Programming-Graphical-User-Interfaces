//
//	Name:	Leon, Pablo
//	Project:#4
//	Due:	December 4, 2014
//	Course: CS-245-01-f14
//
//	Description:
//				A Simple Notepad Text editor.
//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


class JNotepad implements ActionListener {
	JTextArea txt;
	JPopupMenu popm;
	JFrame frame;
	
	JNotepad(){
		frame = new JFrame("Notepad");
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		txt = new JTextArea("", 0,0);
		
		JScrollPane scroll = new JScrollPane(txt);
		frame.add(scroll);
		
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem fnew = new JMenuItem("New",KeyEvent.VK_N);
		fnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem open = new JMenuItem("Open...");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenuItem saveas = new JMenuItem("Save As...");
		JMenuItem pages = new JMenuItem("Page Setup...", KeyEvent.VK_U);
		JMenuItem print = new JMenuItem("Print...");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_X);
		file.add(fnew);
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.addSeparator();
		file.add(pages);
		pages.setEnabled(false);
		file.add(print);
		print.setEnabled(false);
		file.addSeparator();
		file.add(exit);
		jmb.add(file);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem undo = new JMenuItem("Undo");
		JMenuItem cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		JMenuItem paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		JMenuItem delete = new JMenuItem("Delete");
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		JMenuItem find = new JMenuItem("Find...");
		find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		JMenuItem findn = new JMenuItem("Find Next");
		JMenuItem replace = new JMenuItem("Replace...");
		replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem egoto = new JMenuItem("Go To...");
		egoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		JMenuItem sall = new JMenuItem("Select All");
		sall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		JMenuItem time = new JMenuItem("Time/Date");
		time.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		edit.add(undo);
		undo.setEnabled(false);
		edit.addSeparator();
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
		edit.addSeparator();
		edit.add(find);
		edit.add(findn);
		edit.add(replace);
		replace.setEnabled(false);
		edit.add(egoto);
		egoto.setEnabled(false);
		edit.addSeparator();
		edit.add(sall);
		sall.setEnabled(false);
		edit.add(time);
		jmb.add(edit);
		
		popm = new JPopupMenu();
		popm.add(cut);
		popm.add(copy);
		popm.add(paste);
		
		txt.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				if (me.isPopupTrigger())
					popm.show(me.getComponent(), me.getX(), me.getY());
			}
			public void mouseReleased(MouseEvent me){
				if (me.isPopupTrigger())
					popm.show(me.getComponent(), me.getX(), me.getY());
			}
		});
		
		
		JMenu format = new JMenu("Format");
		format.setMnemonic(KeyEvent.VK_O);
		JCheckBoxMenuItem wordw = new JCheckBoxMenuItem("Word Wrap");
		wordw.setMnemonic(KeyEvent.VK_W);
		wordw.setSelected(false);
		JMenuItem font = new JMenuItem("Font...",KeyEvent.VK_F);
		format.add(wordw);
		format.add(font);
		jmb.add(format);
		
		JMenu view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_V);
		JMenuItem statb = new JMenuItem("Status Bar", KeyEvent.VK_S);
		view.add(statb);
		statb.setEnabled(false);
		jmb.add(view);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem vhelp = new JMenuItem("View Help",KeyEvent.VK_H);
		JMenuItem about = new JMenuItem("About JNotepad");
		help.add(vhelp);
		vhelp.setEnabled(false);
		help.addSeparator();
		help.add(about);
		jmb.add(help);
		
		fnew.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		exit.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		delete.addActionListener(this);
		find.addActionListener(this);
		findn.addActionListener(this);
		time.addActionListener(this);
		font.addActionListener(this);
		about.addActionListener(this);
		
		frame.setJMenuBar(jmb);
		
		ItemListener iListener = new ItemListener()
		{
			public void itemStateChanged(ItemEvent event){
				AbstractButton abutton = (AbstractButton)event.getSource();
				int state = event.getStateChange();
				if (state == ItemEvent.SELECTED)
				{
					txt.setWrapStyleWord(true);
				}
				else
				{
					txt.setWrapStyleWord(false);
				}
			}
		};
		wordw.addItemListener(iListener);
	}
	

	public void actionPerformed(ActionEvent ae) {  
		String com = ae.getActionCommand();
		
		if(com.equals("New"))
		{
			txt.setText("");
		}
		
		if(com.equals("Open..."))
		{
			JFileChooser open = new JFileChooser();
			int option = open.showOpenDialog(open);
			if (option == JFileChooser.APPROVE_OPTION)
			{
				txt.setText("");
				try{
					Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
					while(scan.hasNext())
					{
						txt.append(scan.nextLine() + "\n");
					}
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		}
		
		if(com.equals("Save"))
		{
			JFileChooser save = new JFileChooser();
			int option  = save.showSaveDialog(save);
			if(option == JFileChooser.APPROVE_OPTION){
				try{
					BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
					out.write(this.txt.getText());
					out.close();
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
		
		if(com.equals("Save As..."))
		{
			
		}
		
		if(com.equals("Exit"))
		{
			System.exit(0);
		}
		
		if(com.equals("Cut"))
		{
			txt.cut();
		}
		
		if(com.equals("Copy"))
		{
			txt.copy();
		}
		
		if(com.equals("Paste"))
		{
			txt.paste();
		}
		
		if(com.equals("Delete"))
		{
			txt.setText(txt.getText().replace(txt.getSelectedText(),""));
		}
		
		if(com.equals("Find..."))
		{
			String findw = JOptionPane.showInputDialog("Enter String to Find");
			//ran out of time to finish the rest 
		}
		
		if(com.equals("Find Next"))
		{
			
		}
		
		if(com.equals("Time/Date"))
		{
			String timeDate = new java.text.SimpleDateFormat("h:mm a MM/dd/yyyy").format(new Date());
			txt.append(timeDate);
		}
		
		if(com.equals("Font..."))
		{
			
		}
		
		if(com.equals("About JNotepad"))
		{
			JOptionPane.showMessageDialog(frame, "JNotepad version 0.1\n(c)2014 Pablo Leon");
		}
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {   
		      public void run() {   
		        new JNotepad();   
		      }   
		    });   
	}

}
