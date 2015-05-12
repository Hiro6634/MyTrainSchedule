package ar.com.symsys.mytrainschedule.storage;

public class StationsInBranchTableSchema {
	public static String 	TABLE_NAME			= "StationsInBranch";
	public static String	BRANCH_ID			= "BranchId";
	public static String	STATION_ID			= "StationId";

    public static final String[]    COLUMNS = {
    	BRANCH_ID,
    	STATION_ID
    };

    public static final int colBRANCH_ID		= 0;
    public static final int colSTATION_ID		= 1;
}
