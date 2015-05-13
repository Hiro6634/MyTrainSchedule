package ar.com.symsys.mytrainschedule.storage;

public class StationsInBranchTableSchema {
	public static String 	TABLE_NAME			= "StationsInBranch";
	public static String	BRANCH_ID			= "BranchId";
	public static String	STATION_ID			= "StationId";
	public static String	NEXT_STATION_ID		= "NextStationId";
	public static String	NEXT_STATION_TIME	= "NextStationTime";

    public static final String[]    COLUMNS = {
    	BRANCH_ID,
    	STATION_ID,
    	NEXT_STATION_ID,
    	NEXT_STATION_TIME
    };

    public static final int colBRANCH_ID			= 0;
    public static final int colSTATION_ID			= 1;
    public static final int colNEXT_STATION_ID		= 2;
    public static final int colNEXT_STATION_TIME	= 3;
}
