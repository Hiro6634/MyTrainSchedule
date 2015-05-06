package ar.com.symsys.mytrainschedule.storage;

public class ScheduleTableSchema {
	public static String 	TABLE_NAME			= "Schedule";
	public static String	TRAIN_ID			= "TrainId";
	public static String	DEPARTURE_TIME		= "DepartureTime";
	public static String	END_STATION_ID		= "EndStationId";
	public static String	SCHEDULE_TYPE_ID	= "ScheduleTypeId";

    public static final String[]    COLUMNS = {
    	TRAIN_ID,
    	DEPARTURE_TIME,
    	END_STATION_ID,
    	SCHEDULE_TYPE_ID
    };

    public static final int colTRAIN_ID			= 0;
    public static final int colDEPARTURE_TIME	= 1;
    public static final int colEND_STATION_ID	= 2;
    public static final int colSCHEDULE_TYPE_ID = 3;
}
