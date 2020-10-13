package no.hvl.dat100ptc.oppgave2;
 
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import static java.lang.Integer.*;
public class GPSDataConverter {

	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
        hr = Integer.parseInt(timestr.substring(TIME_STARTINDEX, 13));
        min = Integer.parseInt(timestr.substring(14,16));
        sec = Integer.parseInt(timestr.substring(17,19));
        
        secs = hr*3600 + min*60 + sec;
        return secs;    
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint = new GPSPoint(toSeconds(timeStr) , Double.parseDouble(latitudeStr), Double.parseDouble(longitudeStr), Double.parseDouble(elevationStr));

		return gpspoint;
	    
	}
	
}
