package com.shelbot.utils;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import com.shelbot.windows.AboutWindow;


/**
 * responsible for the menubar on top of the simulator window
 * 
 * @author  
 * @version 5/16/20
 */

public class SimulatorMenu extends JMenuBar {

	private JFrame simulatorWindow;
	private JMenuItem exitItem, loadItem, saveItem, kitItem, helpItem, controlItem, bugItem, aboutItem, apiItem,
			settingsItem; // all jmenu items

	/**
	 * Simulator menu constructor
	 * 
	 * @param simulatorWindow simulator window
	 */
	public SimulatorMenu(JFrame simulatorWindow) {
		this.simulatorWindow = simulatorWindow;

		JMenu fileMenu = new JMenu("File");
		super.setBackground(Color.yellow);
		UIManager.put(super.getBackground(), new Color(77, 151, 254));
		fileMenu.setMnemonic('F');

		FileAction fileAction = new FileAction();
		loadItem = new JMenuItem("Open...");
		loadItem.addActionListener(fileAction);
		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(fileAction);
		aboutItem = new JMenuItem("About...");
		aboutItem.addActionListener(fileAction);
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(fileAction);

		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.add(aboutItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		add(fileMenu);

		JMenu helpMenu = new JMenu("Help");
		fileMenu.setMnemonic('F');

		bugItem = new JMenuItem("Report a bug");
		bugItem.addActionListener(fileAction);
		helpMenu.add(bugItem);
		add(helpMenu);
	}

	/**
	 * File action is an action listener that is executed when an option from the
	 * menubar is chosen
	 *
	 */
	private class FileAction implements ActionListener {
		private String pathname = System.getProperty("user.dir") + "/";

		public void actionPerformed(ActionEvent e) {
			JMenuItem m = (JMenuItem) e.getSource();
			if (m == bugItem) {
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					try {
						Desktop.getDesktop().browse(new URI(
								"https://forms.gle/ywWBTX9C5sYuUo5cA"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} 
		 	else if (m == exitItem) {
				System.exit(0);
			} else if (m == aboutItem) {
				try {
					AboutWindow aboutPanel = new AboutWindow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}