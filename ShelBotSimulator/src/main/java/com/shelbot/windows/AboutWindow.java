package com.shelbot.windows;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.studiohartman.jamepad.ControllerUnpluggedException;
/**
 * Description: The about panel to tell user what version of the simulator they
 * are using and who built the simulator
 * 
 * @author  
 * @version 5/14/20
 */
public class AboutWindow extends JPanel {

    JFrame frame;
    private BufferedImage image;

    public String release = "v1.0.3";

    public static ImageIcon globalIcon;

    /**
     * Constructor for About panel which tells the user about the version and the
     * developers
     * 
     * @throws IOException ioexception
     */
    public AboutWindow() throws IOException {

        ImageIcon icon = new ImageIcon("src/main/resources/icon.png");

        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon = new ImageIcon(newimg); // transform it back
        globalIcon = icon;

        // // the message
        // JOptionPane pane = new JOptionPane("Version: " + release + "\nDevelopers: Pallavi Das, \n  :)",
        //         JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, icon);
        // JDialog dialog = pane.createDialog(null, "About");
        // // dialog.add(new JLabel(new ImageIcon(ImageIO.read(new File("icon.png")))));
        // dialog.setBounds((ShelBot.width / 2 - ShelBot.width / 12), (ShelBot.height / 2 - ShelBot.height / 4),
        //         ShelBot.width / 6, ShelBot.height / 2);
        // dialog.show();
        JOptionPane.showMessageDialog(null, "Version: " + release + "\nDevelopers: Pallavi Das, \n  :)",
        "About", JOptionPane.OK_OPTION, icon);
    }

    /**
     * Close method when close button is pressed
     */
    public void close() {
        frame.setVisible(false);
        frame.dispose();
    }

}