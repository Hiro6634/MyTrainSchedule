package ar.com.symsys.mytrainschedule.storage;

public class ScheduleTableSchema {
	public static String 	TABLE_NAME		= "Schedule";
	public static String	TRAIN_ID		= "TrainId";
	public static String	TIME			= "Time";
	public static String	STATION_ID		= "StationId";
	public static String	NEXT_STATION_ID	= "BranchId";

    public static final String[]    COLUMNS = {
    	TRAIN_ID,
    	TIME,
    	STATION_ID,
    	NEXT_STATION_ID
    };

    public static final int colTRAIN_ID			= 0;
    public static final int colTIME				= 1;
    public static final int colSTATION_ID		= 2;
    public static final int colNEXT_STATION_ID	= 3;
}
