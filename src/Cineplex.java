import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cineplex implements Serializable {
	// Attributes
	private String cineplexID;
	private String cineplexName;
	private List<Cinema> cinemas;
	private List<String> cinemaIDs;
	
	
	// Constructor
	public Cineplex(String cineplexID) {
		this.cinemas = new ArrayList<Cinema>();
		this.cinemaIDs = new ArrayList<String>();
		this.setCineplexID(cineplexID);
		this.openCinemaFile(cineplexID);
	}


	// Getters
	public String getCineplexID() {return this.cineplexID;}
	public String getCineplexName() {return this.cineplexName;}
	public List<Cinema> getCinemas() {return this.cinemas;}
	public List<String> getCinemaIDs() {return this.cinemaIDs;}


	// Setters
	public void setCineplexID(String cineplexID) {this.cineplexID = cineplexID;}
	public void setCineplexName(String cineplexName) {this.cineplexName = cineplexName;}
	
	public void addCinemas(String cinemaID) {
    	Cinema cinema = new Cinema(cinemaID);
    	this.cinemas.add(cinema); 
    	this.cinemaIDs.add(cinemaID);
	}
	
	
	
	
	
	
	
	
	
	
	
	// Initializers: Below code used only for the very first run of the app
    // File Reader
    public void openCinemaFile(String cineplexID) {
		try {
			// Get filepath
			String filePath = ProjectRootPathFinder.findProjectRootPath();
			
			if (filePath == null) {
				throw new IOException("Cannot find root");
			} else {
				filePath = filePath + "/data/cineplexes/cineplex_" + cineplexID + ".txt";
			}			
			
			// Open file and traverse it			
			FileReader frStream = new FileReader( filePath );
			BufferedReader brStream = new BufferedReader( frStream );
			String inputLine;
			int i = 0;
			do {
				inputLine = brStream.readLine(); // read in a line
				if (inputLine == null) {break;} // end of file
				
				if (i==0) {
					// first line of file is the cineplex name
					this.setCineplexName(inputLine);
				}
				else {	
					// all other lines are lists of cinemas the cineplex has
					this.addCinemas(inputLine);
				}

				i++;
			} while (inputLine != null);
			
			brStream.close();	
			
		} catch ( FileNotFoundException e ) {
			System.out.println( "Error opening the input file!" + e.getMessage() );
			System.exit( 0 );
		} catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
			e.printStackTrace();
			System.exit( 0 );
		}           
    }		
}
