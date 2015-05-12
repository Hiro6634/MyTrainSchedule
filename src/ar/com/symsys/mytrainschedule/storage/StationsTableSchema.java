package ar.com.symsys.mytrainschedule.storage;

public class StationsTableSchema {
	public static String 	TABLE_NAME			= "Stations";
	public static String	STATION_ID			= "StationId";
	public static String	NAME				= "Name";
	public static String	GPS_LATITUDE		= "GPSLatitude";
	public static String	GPS_LONGITUDE		= "GPSLongitude";

    public static final String[]    COLUMNS = {
    	STATION_ID,
    	NAME,
    	GPS_LATITUDE,
    	GPS_LONGITUDE
    };

    public static final int colSTATION_ID		= 0;
    public static final int colNAME				= 1;
    public static final int colGPS_LATITUDE		= 2;
    public static final int colGPS_LONGITUDE	= 3;
}
