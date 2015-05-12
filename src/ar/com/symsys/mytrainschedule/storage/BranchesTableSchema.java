package ar.com.symsys.mytrainschedule.storage;

public class BranchesTableSchema {
	public static String 	TABLE_NAME			= "Branches";
	public static String	BRANCH_ID			= "BranchId";
	public static String	NAME				= "Name";
	public static String	START_STATION_ID	= "StartStationId";
	public static String	END_STATION_ID		= "EndStationId";

    public static final String[]    COLUMNS = {
    	BRANCH_ID,
    	NAME,
    	START_STATION_ID,
    	END_STATION_ID
    };

    public static final int colBRANCH_ID		= 0;
    public static final int colNAME				= 1;
    public static final int colSTART_STATIONID	= 2;
    public static final int colEND_STATION_ID	= 3;
}
