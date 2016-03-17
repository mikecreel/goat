package goat;



public class Control {
	Dashboard mydb;
	goatInfo goatdata;
	GoatTree myTree;
	GoatTab myGoatTab;
	QueryHerd myQuery;
	MainMenu myMenu; 
	ShowGoat mygoat;
	public Control() {
		//Create object to hold goat data
		goatdata = new goatInfo();
		
		//Create object that handles all database queries.
		myQuery = new QueryHerd(goatdata);
		
		//Create main working screen
		mydb = new Dashboard(this);  
		
		//Add menu to main working screen
		myMenu = new MainMenu(this);
		myMenu.Start();
		
		//Add tree to main working screen
		myTree = new GoatTree(this);
		myTree.Start();
		
		//Add tab for adding new goats.
		myGoatTab = new GoatTab(this);
		myGoatTab.Start();
		
	}


	public void Launch() {
		// TODO This does nothing but starts the program.  Anything to add here?
	}
	

}
