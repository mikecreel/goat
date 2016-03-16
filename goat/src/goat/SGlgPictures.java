package goat;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import util.choosefile;
import static java.nio.file.StandardCopyOption.*;



public class SGlgPictures {
	
	ShowGoat SG;
	Control cc;
	JButton[] picButtons = new JButton[15];

	public SGlgPictures(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayPictures() {
		JPanel picturesPanel = new JPanel();
		picturesPanel.setLayout(null);
		SG.lgjtp.addTab("Pictures", picturesPanel);
		picturesPanel.setBackground(SG.customColor);
		
		String[] pics = {"empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg", "empty.jpg"};
		String[] basepics = {"A.jpg", "B.jpg", "C.jpg", "D.jpg", "E.jpg", "F.jpg", "G.jpg", "H.jpg", "I.jpg", "J.jpg", "K.jpg", "L.jpg", "M.jpg", "N.jpg", "O.jpg", "default.jpg"};
		String basepath = "C:\\Dropbox\\Dropbox\\Goat\\";
		File f = null;
	    String goatfilenum = SG.SGdata.getId().toString().trim();
	     
	    
	    try{
	    	
	    	for (int x = 0; x < 16; x++) {
	    		f = new File(basepath + goatfilenum + basepics[x]);
	    		if(f.isFile()) {
	    			pics[x] = goatfilenum + basepics[x];
		        } else {
		        	pics[x] = "empty.jpg"; 
		        }
	    	}
	    }catch(Exception e){
	    	// if any error occurs
	    	e.printStackTrace();
		
	    }
		
		Image[] image = new Image[16];	
		File sourceimage;
		
		for (int z = 0; z < 16; z++) {
			
			sourceimage = new File(basepath + pics[z]);
			
			try {
				image[z] = ImageIO.read(sourceimage);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
        Image image1=image[15].getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		JButton bigpicButton = new JButton();
		ImageIcon myphoto1 = new ImageIcon(image1);
		bigpicButton.setIcon(myphoto1);
		bigpicButton.setBounds(550, 10, 300, 300);
		picturesPanel.add(bigpicButton);
		
		//Action Listers for Big Picture Button
		bigpicButton.addActionListener(new ActionListener() {
  	    	  public void actionPerformed(ActionEvent e) {
  	    		
  	    		//TODO  Launch window with full size image
  	    	  }
  	      });
		// Add buttons to right side of screen
		
		// Add
		JButton addButton = new JButton("Add");
		addButton.setBounds(860, 10, 90, 30);
		picturesPanel.add(addButton);
		
    //    JButton[] picButtons = new JButton[15];
        JButton[] delpicButtons = new JButton[15];
        JButton[] defButtons = new JButton[15];
        ImageIcon[] myphoto = new ImageIcon[15];
        int[] col = {10, 110, 210, 310, 410, 10, 110, 210, 310, 410, 10, 110, 210, 310, 410,};
        int[] line = {10,10,10,10,10,140,140,140,140,140,270,270,270,270,270};
        
        for (int x = 0; x < 15; x++) {
        	
        	myphoto[x] = new ImageIcon(image[x].getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        	picButtons[x] = new JButton();
        	picButtons[x].setIcon(myphoto[x]);
        	picButtons[x].setBounds(col[x], line[x], 100, 100);
        	picturesPanel.add(picButtons[x]);
        	
        	delpicButtons[x] = new JButton("X");
        	delpicButtons[x].setBounds(col[x], line[x]+105, 50, 20);
        	picturesPanel.add(delpicButtons[x]);
        	
        	defButtons[x] = new JButton("D");
        	defButtons[x].setBounds(col[x]+50, line[x]+105, 50, 20);
        	picturesPanel.add(defButtons[x]);
        	
        	
        	//Action Listers for Picture Buttons
      		int y = x;
        	picButtons[x].addActionListener(new ActionListener() {
      	    	  public void actionPerformed(ActionEvent e) {
      	    		  bigpicButton.setIcon(new ImageIcon(image[y].getScaledInstance(375, 375, Image.SCALE_DEFAULT)));
      	    	  }
      	      });
        	
        	//Action Listers for Delete Buttons
        	
        	delpicButtons[x].addActionListener(new ActionListener() {
      	    	  public void actionPerformed(ActionEvent e) {
      	    		  Image imaged = null;
      	    		  try {
      	    			  imaged = ImageIO.read(new File("C:\\Dropbox\\Dropbox\\Goat\\empty.jpg"));
      	    		  } catch (IOException e2) {
      	    			  e2.printStackTrace();
      	    		  }
      	    		 for (int a=0;a < 14;a++) {
      	    			 if (e.getSource() == delpicButtons[a]) {
      	    				 picButtons[a].setIcon(new ImageIcon(imaged.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
      	    				 String fileName = basepath + goatfilenum + basepics[a];
      	    				 File f = new File(fileName);
      	    				 f.delete();
      	    			 }
      	    		 }
      	    	  
      	    	 }
      	    });
        	
        	defButtons[x].addActionListener(new ActionListener() {
    	    	  public void actionPerformed(ActionEvent e) {
    	    		  Image imagedef = null;
    	    		  
    	    		 for (int a=0;a < 14;a++) {
    	    			 if (e.getSource() == defButtons[a]) {
    	    				 String newdef = basepath + goatfilenum + basepics[a];
    	    				 try {
    	    	    			  imagedef = ImageIO.read(new File(newdef));
    	    	    		 } catch (IOException e2) {
    	    	    			  e2.printStackTrace();
    	    	    		 }
    	    				 bigpicButton.setIcon(new ImageIcon(imagedef.getScaledInstance(375, 375, Image.SCALE_DEFAULT)));
    	    				 String deffile = basepath + goatfilenum + "default.jpg";
    	    				 Path sourchpath = Paths.get(newdef);
    	    				 Path destpath = Paths.get(deffile);
    	    				 try {
    	    					 Files.copy(sourchpath, destpath, REPLACE_EXISTING);
    	    				 } catch (IOException e1) {
    	    					 e1.printStackTrace();
    	    				 }
    	    			 }
    	    		 }
    	    	  
    	    	 }
    	    });
        }
        
      //Action Listers for Add Button
      		addButton.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      				choosefile myfile = new choosefile("jpg files","jpg");
      				String mfile = myfile.myfile();
      				boolean stored = false;
      				for (int x = 0; x < 15; x++) {
      		    		
      					if (!stored) {
      						if(pics[x].equals("empty.jpg")) {
      							String destfile = basepath + goatfilenum + basepics[x];
      							Path sourchpath = Paths.get(mfile);
      							Path destpath = Paths.get(destfile);
      							try {
      								Files.copy(sourchpath, destpath, REPLACE_EXISTING);
      							} catch (IOException e1) {
      								e1.printStackTrace();
      							}
      							pics[x] = goatfilenum + basepics[x];
      							
      							try {
      								image[x] = ImageIO.read(new File(basepath + pics[x]));
      							} catch (IOException e1) {
      								e1.printStackTrace();
      							}	
      							myphoto[x] = new ImageIcon(image[x].getScaledInstance(100, 100, Image.SCALE_DEFAULT));
      							picButtons[x].setIcon(myphoto[x]);
      							stored=true;
      				        } else {
      				        	//TODO Dialog to say no more room, delete then add
      				        }
      					}
      		    		
      		    	}
      				
      		  	}
      		});  
      		
      		
	}
}
