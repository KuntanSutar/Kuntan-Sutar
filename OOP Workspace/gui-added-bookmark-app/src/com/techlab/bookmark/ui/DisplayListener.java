package com.techlab.bookmark.ui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class DisplayListener implements ActionListener {

	private File bookmarksCSVFile = new File("data\\BookmarksCSVFile.csv");
	private BookmarkFrame bookmarkFrame;
	private JLabel discription;
	private JLabel url;
	private int yCoordinate=50;
	String urlName, addressName;
	
	public DisplayListener(BookmarkFrame newBookmarkFrame) {
		bookmarkFrame=newBookmarkFrame;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			displayBookmark();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void displayBookmark() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(bookmarksCSVFile));
		String line;
		while((line=bufferedReader.readLine())!=null) {
			
			String[] discriptionAndUrl = line.split(",");
			urlName=discriptionAndUrl[0];
			addressName=discriptionAndUrl[1];
			
			discription=new JLabel(urlName);
			discription.setBounds(50, yCoordinate+200, 200, 30);
			
			url=new JLabel(addressName);
			url.setBounds(200, yCoordinate+200, 600, 30);
			
			discription.setVisible(true);
			url.setVisible(true);

			bookmarkFrame.add(discription);
			bookmarkFrame.add(url);
			SwingUtilities.updateComponentTreeUI(bookmarkFrame);
			
			url.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseClicked(MouseEvent me) {
					try {
						URI uri = new URI(discriptionAndUrl[1]);
						Desktop.getDesktop().browse(uri);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
			
			yCoordinate=yCoordinate+40;
		}
		bufferedReader.close();
	}

}
