package map;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FolderChooser extends JPanel {
    
    JButton go;
    JFileChooser chooser;
    String choosertitle;

    public String FolderChooser() {
        String filePath = "";
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            filePath = chooser.getSelectedFile().toString();
        } else {
            System.out.println("No Selection ");
        }
        return filePath;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public static void main(String s[]) {
        JFrame frame = new JFrame("");
        FolderChooser panel = new FolderChooser();
        frame.addWindowListener(
                new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );
        frame.getContentPane().add(panel, "Center");
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);
    }
}
