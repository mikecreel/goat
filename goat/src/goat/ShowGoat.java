package goat;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

	
public class ShowGoat {
	private Control cc;
	public JPanel jp1;
	public JTabbedPane smjtp;
	public JTabbedPane lgjtp;
	JTable table;
	JTable condtable;
	JTable medtable;
	JTable weighttable;
	JTable breedingtable;
	JTable servicetable;
	JTable kidstable;
	Color customColor; 
	String goat;
	String mygoat;
	goatInfo SGdata;
	QueryHerd SGquery;
	
	
		
	public ShowGoat(Control cc, String goat) {
		this.cc = cc;
		this.goat = goat;
		customColor = new Color(102,204,102);
	
		//Create object to hold goat data
		SGdata = new goatInfo();
		//Create object to conduct queries
		SGquery = new QueryHerd(SGdata);
	}

	public void Start() {
	
		/*
		 * 		Create main Panel
		 */
		
		jp1 = new JPanel();
		jp1.setLayout(null);
	    jp1.setBackground(Color.LIGHT_GRAY);
	    
	    /*
	     * Load goat data into SGdata
	     */
	    
	    mygoat = SGquery.getmygoat("SELECT * From GOAT.HERD WHERE name = '" + goat + "'");
	    
	    
	    /*
	     * Display goat tab header
	     */
	    
	    SGdisplayHeader myheader = new SGdisplayHeader(this, cc); 
	    myheader.displayHeader();
	    
	    
	    /*
	     * Create small tabbed pane
	     */
	    
	    smjtp = new JTabbedPane();
		smjtp.setBounds(0, 100, 1000, 150);
		jp1.add(smjtp);
	    
	    /*
	     * Create and add identification tab to small pane
	     */
		SGsmID mysmID = new SGsmID(this, cc);
	    mysmID.displayID();
	    
	    /*
	     * Create and add birth tab to small pane
	     */
	    SGsmBirth mysmBirth = new SGsmBirth(this, cc);
	    mysmBirth.birthDisplay();
	    
	    /*
	     * Create and add parentage tab to small pane
	     */
	    
	    SGsmParentage mysmParentage = new SGsmParentage(this, cc);
	    mysmParentage.displayParentage();
	    
	    /*
	     * Create and add purchase tab to small pane
	     */
	    
	    SGsmPurchase mysmPurchase = new SGsmPurchase(this, cc);
	    mysmPurchase.displayPurchase();
	    
	    /*
	     * Create and add death/sold tab to small pane
	     */
	    
	    SGsmDeathSold mysmDeathSold = new SGsmDeathSold(this, cc);
	    mysmDeathSold.displayDeathSold();
	    
	    /*
	     * Create large tabbed pane
	     */
		
		lgjtp = new JTabbedPane();
		lgjtp.setBounds(0, 250, 1000, 550);
		jp1.add(lgjtp);

		/*
		 * Create summary panel and add to large pane
		 */
		
		SGlgSummary mylgSummary = new SGlgSummary(this, cc);
	    mylgSummary.displaySummary();
	    
	    /*
		 * Create condition panel and add to large pane
		 */
		
		SGlgCondition mylgCondition = new SGlgCondition(this, cc);
	    mylgCondition.displayCondition();
	    
	    
	    /*
	     * Create medical panel and add to large pane
	     */
		
	    SGlgMedical mylgMedical = new SGlgMedical(this, cc);
	    mylgMedical.displayMedical();
	    
	    /*
	     *  Create notes panel and add to large pane
	     */
	    
	    SGlgNotes mylgNotes = new SGlgNotes(this, cc);
	    mylgNotes.displayNotes();
	    
	    /*
	     *  Create breeding panel (goat = doe) or  service panel (goat = buck) and add to large pane.
	     */
	    
	    if (SGdata.getGender().trim().equals("doe")) {
	    	SGlgBreeding mylgBreeding = new SGlgBreeding(this, cc);
		    mylgBreeding.displayBreeding();
	    } else {
	    	SGlgService mylgService = new SGlgService(this, cc);
		    mylgService.displayService();
	    }
	    
	    
	    /*
	     *  Create kids panel and add to large pane
	     */
	    
	    SGlgKids mylgKids = new SGlgKids(this, cc);
	    mylgKids.displayKids();
	    
	    /*
	     *  Create weight panel and add to large pane
	     */
	    
	    SGlgWeight mylgWeight = new SGlgWeight(this, cc);
	    mylgWeight.displayWeight();
	    
	    /*
	     *  Create pictures panel and add to large pane
	     */
	    
	    SGlgPictures mylgPictures = new SGlgPictures(this, cc);
	    mylgPictures.displayPictures();
	    
	    cc.mydb.jtp.addTab(goat, jp1);
	}
}
