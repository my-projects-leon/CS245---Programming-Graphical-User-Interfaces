// Demonstrate a simple JTabbedPane. 
  
import javax.swing.*;  
   
class TabbedPaneDemo {  
  
  TabbedPaneDemo() {  
    // Create a new JFrame container. Use the default 
    // border layout. 
    JFrame jfrm = new JFrame("Tabbed Pane Demo");  
 
    // Give the frame an initial size.  
    jfrm.setSize(380, 150);  
  
    // Terminate the program when the user closes the application.  
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
    // Create a tabbed pane. 
    JTabbedPane jtp = new JTabbedPane(); 
    
    JLabel lab = new JLabel("<html>1<br>2<br>3<br>4");
    JScrollPane jsp = new JScrollPane(lab);
 
    // Add tabs to the tabbed pane 
    jtp.addTab("File Manager", 
               new JLabel(" This is the File Manager tab.")); 
    jtp.addTab("Performance", 
               jsp);
    JPanel pan = new JPanel();
    pan.add(new JButton("B1"));
    pan.add(new JButton("B2"));
    jtp.addTab("Reports", 
               pan); 
    jtp.addTab("Customize", 
               new JLabel(" This is the Customize tab.")); 
 
    // Add the tabbed pane to the content pane. 
    jfrm.getContentPane().add(jtp); 
  
    // Display the frame.  
    jfrm.setVisible(true);  
  }  
 
  public static void main(String args[]) {  
    // Create the frame on the event dispatching thread.  
    SwingUtilities.invokeLater(new Runnable() {  
      public void run() {  
        new TabbedPaneDemo();  
      }  
    });   
  }  
}