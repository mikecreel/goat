package goat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class QueryHerd{
    static String dbURL = "jdbc:derby:C:\\Dropbox\\Dropbox\\eclipseWorkSpace\\MyDB;create=true";
    static String tableName = "goat.herd";
    static Connection conn = null;
    static Statement stmt = null;
    goatInfo goatdata;
	
    
    public QueryHerd(goatInfo goatdata) {
    	
		this.goatdata = goatdata;
	}
    
    

	private static void createConnection()

	
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
	private static void shutdown()

    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    
	}
    
	public String[] getnames(String myquery)
    {
    	createConnection();
    	ArrayList <String> mygoats = new ArrayList<String>();
        mygoats.add("");
    	try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(myquery);
            while(results.next())
            {
                String name = results.getString("name");
                mygoats.add(name);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    	String[] names = mygoats.toArray(new String[mygoats.size()]);
    	
    	shutdown();
    	
    	return names;
    }
	
	public String getname(String id)
    {
    	createConnection();
    	String goatname=null;
    	try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT name From GOAT.HERD WHERE ID = " + id);
            while(results.next())
            {
                goatname = results.getString("name");
                
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    	
    	
    	shutdown();
    	
    	return goatname;
    }	
	
	
	public String getmygoat(String myquery) {
		String goatname = null;
		createConnection();
		try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(myquery);

            results.next();
            	goatdata.setId(results.getInt("id"));
                goatdata.setTag(results.getString("tag"));
                goatdata.setScrapie(results.getString("scrapie"));
            	goatdata.setName(results.getString("name"));
            	goatdata.setNkr(results.getString("nkr"));
            	goatdata.setAkga(results.getString("akga"));
            	goatdata.setIkga(results.getString("ikga"));
            	goatdata.setTattool(results.getString("tattool"));
            	goatdata.setTattoor(results.getString("tattoor"));
            	goatdata.setMicrochip(results.getString("microchip"));
            	goatdata.setColor(results.getString("color"));
            	goatdata.setGender(results.getString("gender"));
            	goatdata.setHerdgroup(results.getString("herdgroup"));
            	goatdata.setBirthdate(results.getString("birthdate"));
            	goatdata.setNotes(results.getString("notes"));
            	goatdata.setDam(results.getString("dam"));
            	goatdata.setFirstlactation(results.getString("firstlactation"));
            	goatdata.setSire(results.getString("buck"));
            	goatdata.setBirthweight(results.getString("birthweight"));
            	goatdata.setBirthrank(results.getString("birthrank"));
            	goatdata.setBirthnotes(results.getString("birthnotes"));
            	goatdata.setDambreed(results.getString("dambreed"));
            	goatdata.setSirebreed(results.getString("sirebreed"));
            	goatdata.setPercentage(results.getString("percentage"));
            	goatdata.setPurchasedate(results.getString("purchasedate"));
            	goatdata.setPrice(results.getString("price"));
            	goatdata.setSeller(results.getString("seller"));
            	goatdata.setSellernotes(results.getString("sellernotes"));
            	goatdata.setSold(results.getString("sold"));
            	goatdata.setAmount(results.getString("amount"));
            	goatdata.setFees(results.getString("fees"));
            	goatdata.setSolddate(results.getString("solddate"));
            	goatdata.setSoldnote(results.getString("soldnote"));
            	goatdata.setDeath(results.getString("death"));
            	goatdata.setDeathdate(results.getString("deathdate"));
            	goatdata.setDnotes(results.getString("dnotes"));
            	goatdata.setReferenceonly(results.getString("referenceonly"));
            	goatdata.setOwned(results.getString("owned"));
            	
            	
                results.close();
                stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
		shutdown();
		return goatname;
	}
	public boolean checktag(String myquery) {
		boolean tagfound = true;
		createConnection();
		try
        {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet results = stmt.executeQuery(myquery);
            if (!results.isBeforeFirst() ) {    
            	tagfound = false; 
            	} else {
            	tagfound = true;	
            	}
            
            
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
		
		shutdown();
		return tagfound;
		
	}
	
	public void updateGoat(String insertquery) {
		createConnection();
		try
			{
				stmt = conn.createStatement();
				stmt.execute(insertquery);
				stmt.close();
			}
		catch (SQLException sqlExcept)
			{
				sqlExcept.printStackTrace();
			}
	}

	public String[][] getconds(String condquery)
    {
    	String conddate;
    	String condition;
    	String famacha;
    	String condnote;
    	
		int x = 0;
		System.out.println(condquery);
		
		createConnection();
    	String [][] myconds = new String[100][4];

    	try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(condquery);
            while(results.next())
            {
                conddate = results.getString("conddate");
                condition = results.getString("condition");
                famacha = results.getString("famacha");
                condnote = results.getString("condnote");
                 
                myconds[x][0] = conddate;
                myconds[x][1] = condition;
                myconds[x][2] = famacha;
                myconds[x][3] = condnote;
                
                x=x+1;
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    
    	
    	shutdown();
    	
    	return myconds;
    }
	
	public String[][] getbreeding(String breedingquery, Boolean doe)
    {
    	String breedingdate;
    	String buckname;
    	String estkiddingdate;
    	String note;
    	String id;
    	System.out.println(breedingquery);
		int x = 0;
		
		createConnection();
    	String [][] mybreedings = new String[100][4];
    	
    	try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(breedingquery);
            while(results.next())
            {
            	breedingdate = results.getString("bdate");
            	buckname = results.getString("buckname");
            	estkiddingdate = results.getString("estkiddate");
                note = results.getString("note");
                id = results.getString("id");
                 
                mybreedings[x][0] = breedingdate;
                if (doe) {
                	mybreedings[x][1] = buckname;
                } else {
                	
                	mybreedings[x][1] = id;
                }
                	
                mybreedings[x][2] = note;
                mybreedings[x][3] = estkiddingdate;
                
                x=x+1;
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    
    	
    	shutdown();
    	
    	return mybreedings;
    }

	public String[][] getkids(String kidsquery)
    {
    	String birthdate;
    	String buckname;
    	String doename;
    	String id;
    	System.out.println(kidsquery);
		int x = 0;
		
		createConnection();
    	String [][] kids = new String[100][4];
    	
    	try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(kidsquery);
            while(results.next())
            {
            	birthdate = results.getString("birthdate");
            	buckname = results.getString("buck");
            	doename = results.getString("dam");
                id = results.getString("id");
                 
                kids[x][0] = birthdate;
                kids[x][1] = buckname;
                kids[x][2] = doename;
                kids[x][3] = id;
                
                x=x+1;
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    
    	
    	shutdown();
    	
    	return kids;
    }
	
	
	
	
	public String[][] getnotes(String notesquery)
    {
    	String notedate;
    	String note;
		int x = 0;
		System.out.println(notesquery);
		
		createConnection();
    	String [][] mynotes = new String[100][2];

    	try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(notesquery);
            while(results.next())
            {
                notedate = results.getString("notedate");
                note = results.getString("note");
                 
                mynotes[x][0] = notedate;
                mynotes[x][1] = note;
                x=x+1;
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    
    	
    	shutdown();
    	
    	return mynotes;
    }

	public String[][]  getweights(String weightsquery)
    {
    	String wdate;
    	String weight;
    	String ww;
		int x = 0;
		System.out.println(weightsquery);
		
		createConnection();
    	String [][] myweights = new String[100][3];

    	try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(weightsquery);
            while(results.next())
            {
                wdate = results.getString("wdate");
                weight = results.getString("weight");
                ww = results.getString("ww"); 
                myweights[x][0] = wdate;
                myweights[x][1] = weight;
                myweights[x][2] = ww;
                x=x+1;
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    
    	
    	shutdown();
    	
    	return myweights;
    }
	
	public String getsingledata(String myquery, String fieldname)
    {
    	createConnection();
    	String reqdata = null;
    	try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(myquery);
            while(results.next())
            {
                reqdata = results.getString(fieldname);
                
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    	
    	shutdown();
    	
    	return reqdata;
    }
	
	
	
}


