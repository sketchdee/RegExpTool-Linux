//This is a open source project form get-hub,author is six519.
//https://github.com/six519/Java-Notepad
//modify by sketchdee,used by regexp tool.
package RegExpTool;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Locale;

public class Notepad extends JFrame implements ActionListener, WindowListener {

    JTextArea jta = new JTextArea ();
    File fnameContainer;

    public Notepad () {
        Container con = getContentPane ();

        JMenuBar jmb = new JMenuBar ();
        JMenu jmfile = new JMenu ("File");
        JMenu jmedit = new JMenu ("Edit");
        JMenu jmhelp = new JMenu ("Help");

        con.setLayout (new BorderLayout ());
        //trying to add scrollbar
        JScrollPane sbrText = new JScrollPane (jta);
        sbrText.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sbrText.setVisible (true);


        jta.setFont(new java.awt.Font("Arial Unicode MS", 0, 14));
        jta.setLineWrap (true);
        jta.setWrapStyleWord (true);

        con.add (sbrText);

        createMenuItem (jmfile, "New");
        createMenuItem (jmfile, "Open");
        createMenuItem (jmfile, "Save");
        jmfile.addSeparator ();
        createMenuItem (jmfile, "Exit");

        createMenuItem (jmedit, "Cut");
        createMenuItem (jmedit, "Copy");
        createMenuItem (jmedit, "Paste");

        createMenuItem (jmhelp, "About Notepad");

        jmb.add (jmfile);
        jmb.add (jmedit);
        jmb.add (jmhelp);

        setJMenuBar (jmb);
        //setIconImage (Toolkit.getDefaultToolkit ().getImage ("notepad.gif"));
        addWindowListener (this);
        setSize (500, 500);
        setTitle ("Untitled.txt - Notepad");

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) screensize.getWidth() / 2 - getWidth() / 2;
        int y = (int) screensize.getHeight() / 2 - getHeight() / 2;
        setLocation(x, y);

        setVisible (true);

    }

    public Notepad(File file) throws IOException {
        Container con = getContentPane ();

        JMenuBar jmb = new JMenuBar ();
        JMenu jmfile = new JMenu ("File");
        JMenu jmedit = new JMenu ("Edit");
        JMenu jmhelp = new JMenu ("Help");

        con.setLayout (new BorderLayout ());
        //trying to add scrollbar
        JScrollPane sbrText = new JScrollPane (jta);
        sbrText.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sbrText.setVisible (true);


        jta.setFont(new java.awt.Font("Arial Unicode MS", 0, 14));
        jta.setLineWrap (true);
        jta.setWrapStyleWord (true);

        con.add (sbrText);

        createMenuItem (jmfile, "New");
        createMenuItem (jmfile, "Open");
        createMenuItem (jmfile, "Save");
        jmfile.addSeparator ();
        createMenuItem (jmfile, "Exit");

        createMenuItem (jmedit, "Cut");
        createMenuItem (jmedit, "Copy");
        createMenuItem (jmedit, "Paste");

        createMenuItem (jmhelp, "About Notepad");

        jmb.add (jmfile);
        jmb.add (jmedit);
        jmb.add (jmhelp);

        setJMenuBar (jmb);
        //setIconImage (Toolkit.getDefaultToolkit ().getImage ("notepad.gif"));
        addWindowListener (this);
        setSize (500, 500);
        setTitle (file.getName ()+" - Notepad");
        OpenFile(file.getAbsolutePath ());
        this.fnameContainer=file;

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) screensize.getWidth() / 2 - getWidth() / 2;
        int y = (int) screensize.getHeight() / 2 - getHeight() / 2;
        setLocation(x, y);

        setVisible (true);
    }

    public void createMenuItem (JMenu jm, String txt) {
        JMenuItem jmi = new JMenuItem (txt);
        jmi.addActionListener (this);
        jm.add (jmi);
    }

    public void actionPerformed(ActionEvent e){
        JFileChooser jfc = new JFileChooser ();

        if (e.getActionCommand ().equals ("New")) {
            //new
            this.setTitle ("Untitled.txt - Notepad");
            jta.setText ("");
            fnameContainer = null;
        } else if (e.getActionCommand ().equals ("Open")) {
            //open
            int ret = jfc.showDialog (null, "Open");

            if (ret == JFileChooser.APPROVE_OPTION) {
                try {
                    File fyl = jfc.getSelectedFile ();
                    OpenFile (fyl.getAbsolutePath ());
                    this.setTitle (fyl.getName () + " - Notepad");
                    fnameContainer = fyl;
                } catch (IOException ers) {
                }
            }

        } else if (e.getActionCommand ().equals ("Save")) {
            //save
            if (fnameContainer != null) {
                jfc.setCurrentDirectory (fnameContainer);
                jfc.setSelectedFile (fnameContainer);
            } else {
                //jfc.setCurrentDirectory(new File("."));
                jfc.setSelectedFile (new File ("Untitled.txt"));
            }

            int ret = jfc.showSaveDialog (null);

            if (ret == JFileChooser.APPROVE_OPTION) {
                try {

                    File fyl = jfc.getSelectedFile ();
                    SaveFile (fyl.getAbsolutePath ());
                    this.setTitle (fyl.getName () + " - Notepad");
                    fnameContainer = fyl;

                } catch (Exception ers2) {
                }
            }

        } else if (e.getActionCommand ().equals ("Exit")) {
            //exit
            Exiting ();
        } else if (e.getActionCommand ().equals ("Copy")) {
            //copy
            jta.copy ();
        } else if (e.getActionCommand ().equals ("Paste")) {
            //paste
            jta.paste ();
        } else if (e.getActionCommand ().equals ("About Notepad")) {
            //about
            JOptionPane.showMessageDialog (this, "Created by: Ferdinand Silva (http://ferdinandsilva.com)", "Notepad", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getActionCommand ().equals ("Cut")) {
            jta.cut ();
        }
    }

    public void OpenFile (String fname) throws IOException {
        //open file code here
        BufferedReader d = new BufferedReader (new InputStreamReader (new FileInputStream (fname)));
        String l;
        //clear the textbox
        jta.setText ("");

        setCursor (new Cursor (Cursor.WAIT_CURSOR));
        setTitle (fname+" - Notepad");

        while ((l = d.readLine ()) != null) {
            jta.setText (jta.getText () + l + "\r\n");
        }

        setCursor (new Cursor (Cursor.DEFAULT_CURSOR));
        d.close ();
    }

    public void SaveFile (String fname) throws IOException {
        setCursor (new Cursor (Cursor.WAIT_CURSOR));
        DataOutputStream o = new DataOutputStream (new FileOutputStream (fname));
        o.writeBytes (jta.getText ());
        o.close ();
        setCursor (new Cursor (Cursor.DEFAULT_CURSOR));
    }

    public void windowDeactivated (WindowEvent e) {
    }

    public void windowActivated (WindowEvent e) {
    }

    public void windowDeiconified (WindowEvent e) {
    }

    public void windowIconified (WindowEvent e) {
    }

    public void windowClosed (WindowEvent e) {
    }

    public void windowClosing (WindowEvent e) {
        Exiting ();
    }

    public void windowOpened (WindowEvent e) {
    }

    public void Exiting () {
        //Don't use System.exit(),it will destroy root windows,it's a JVM Operation.
        //"dispose()" only destroy current JFrame window.
        //"setVisible(false)" can hide the window without close it,cost a little more memory but fast.

        // setVisible(false);
        dispose();
    }

    public static void main (String[] args) {
        try{
            LinkedList<String>a =(Tools.ConsoleExec("/home/sketchdee/Desktop/RegExpTool/exresource/netcoreapp3.1/RegTestapp.exe -\\w -exresource/.sourcetmp"));
            Notepad notp = new Notepad (new File("E:\\CSrepos\\JAVA\\JavaNotepad\\JavaNotepad.iml"));
        }catch(Exception ex){System.out.print(ex.getMessage ());}
    }
}

