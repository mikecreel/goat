package goat;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SGlgSummary {
	
	ShowGoat SG;
	Control cc;

	public SGlgSummary(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displaySummary() {
		JPanel summaryPanel = new JPanel();
		summaryPanel.setLayout(null);
		summaryPanel.setBackground(SG.customColor);
		SG.lgjtp.addTab("Summary", summaryPanel);
		
		
		Image image = null;
		File sourceimage;
		String goatfilenum = SG.SGdata.getId().toString().trim();
		sourceimage = new File("C:\\Dropbox\\Dropbox\\Goat\\" + goatfilenum + "default.jpg" );

		try {
			image = ImageIO.read(sourceimage);
		} catch (IOException e) {
			sourceimage = new File("C:\\Dropbox\\Dropbox\\Goat\\empty.jpg");
			try {
				image = ImageIO.read(sourceimage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}	
		
		
        image=image.getScaledInstance(375, 375, Image.SCALE_DEFAULT);
		JButton bigpicButton = new JButton();
		ImageIcon myphoto1 = new ImageIcon(image);
		bigpicButton.setIcon(myphoto1);
		bigpicButton.setBounds(600, 10, 375, 375);
		summaryPanel.add(bigpicButton);
		
	}

}