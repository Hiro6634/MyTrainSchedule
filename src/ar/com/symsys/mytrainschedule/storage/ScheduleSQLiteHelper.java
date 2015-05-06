package ar.com.symsys.mytrainschedule.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScheduleSQLiteHelper extends SQLiteOpenHelper {
	private static final String 	dbName 		= "TrainScheduleDb";
	private static final int		dbVersion	= 1;
	
	private static final String 	sqlCreateSchedule = "CREATE TABLE " + ScheduleTableSchema.TABLE_NAME + " ("
			+ ScheduleTableSchema.TRAIN_ID + " INTEGER PRIMARY KEY, "
			+ ScheduleTableSchema.DEPARTURE_TIME + " INTEGER, "
			+ ScheduleTableSchema.END_STATION_ID + " INTEGER, "
			+ ScheduleTableSchema.SCHEDULE_TYPE_ID + " INTEGER )";
	
	public ScheduleSQLiteHelper(Context context){
		super(context, dbName, null, dbVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreateSchedule);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + ScheduleTableSchema.TABLE_NAME );
		db.execSQL(sqlCreateSchedule);
	}

}
