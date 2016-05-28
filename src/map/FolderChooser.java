package map;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FolderChooser extends JPanel {//For choosing folders

    JButton go;//Button for folder chooser
    JFileChooser chooser;//Chooser
    String choosertitle;//Title for the window

    public String FolderChooser() {
        String filePath = "";//Initializes the filePath string
        chooser = new JFileChooser(); //Creates a jfilechooser
        chooser.setCurrentDirectory(new java.io.File(".")); //sets dir to file
        chooser.setDialogTitle(choosertitle); //sets the dialog title to the file selection
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //Only allows directories
        chooser.setAcceptAllFileFilterUsed(false); //Only allows folder selections.
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {//If the approve option is selected
            filePath = chooser.getSelectedFile().toString(); //Set the file path
        } else {
            System.out.println("No Selection ");//Drop it because they didnt select anything
        }
        return filePath;//Return the newfound filepath
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);//window size
    }

    public static void main(String s[]) {//JFrame information name
        JFrame frame = new JFrame("");//Jframe for the window
        FolderChooser panel = new FolderChooser();//The panel is the folderchooser full repo
        frame.addWindowListener(//The window listener waits for close or confirm
                new WindowAdapter() {//This is the type of window listener which allows for window movement and prevents bugs
            @Override
            public void windowClosing(WindowEvent e) {//Closes the window on event
                System.exit(0);
            }
        }
        );
        frame.getContentPane().add(panel, "Center");//centers the chooser into all of the panel
        frame.setSize(panel.getPreferredSize());//sets the panel to the same size as the window
        frame.setVisible(true);//opens the window
    }
}
