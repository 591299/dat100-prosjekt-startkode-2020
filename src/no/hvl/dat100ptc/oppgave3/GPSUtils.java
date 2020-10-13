package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		max = da[0];		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}		
		return max;
	}

	
	public static double findMin(double[] da) {
		
		double min;
		min = da[0];		
		for (double d: da) {
			if (d<min) {
				min=d;
			}
		}
		return min;
	}

	
	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		
		double[] la = new double[gpspoints.length];
		for (int i=0; i<la.length; i++) {
			la[i] = gpspoints[i].getLatitude();
		}
		return la;
	}

	
	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] lo = new double[gpspoints.length];
		for(int i=0; i<lo.length;i++) {		
		lo[i] = gpspoints[i].getLongitude();
		}
		return lo;	
		}

	
	private static int R = 6371000;
	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		double lat1 = toRadians(gpspoint1.getLatitude());
		double lon1 = toRadians(gpspoint1.getLongitude());
		double lat2 = toRadians(gpspoint2.getLatitude());
		double lon2 = toRadians(gpspoint2.getLongitude());
		double lat3 = lat2 - lat1;
		double lon3 = lon2 - lon1;		
		double a = pow(sin(lat3/2), 2) + cos(lat1) * cos(lat2) * pow(sin(lon3/2), 2);
		double b = 2 * atan2(sqrt(a), sqrt(1-a));
		int R = 6371000;
		double c = R*b;
		return c;
	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int sec;
		sec = gpspoint2.getTime() - gpspoint1.getTime();
		double distance = distance(gpspoint1, gpspoint2);
		return 3.6 * distance / sec;
	}

	
	public static String formatTime(int secs) {
        String timestr;
        String TIMESEP = ":";
		
		int hrs = secs / 3600;
		int min = secs % 3600 / 60;
		int sec = secs;		
		return String.format(" %02d:%02d:%02d ", hrs, min, sec);

	}

		
		private static int TEXTWIDTH = 10;
		public static String formatDouble(double d) {
			String str = "";

			double factor = Math.pow(10, 2);
			d *= factor;
			double tmp = Math.round(d);
			double rounded = tmp / factor;
			str += rounded;
			while (str.length() < TEXTWIDTH) {
				str = " " + str;
			}
			return str;
		}		
	}

