package ar.com.symsys.mytrainschedule.storage;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ScheduleDataSource {
	private ScheduleSQLiteHelper	scheduleSQLiteHelper;
	private SQLiteDatabase			database;
//	private Context					context;
	
	public ScheduleDataSource(Context context){
//		this.context = context;
		scheduleSQLiteHelper = new ScheduleSQLiteHelper(context);
	}
	
	public void openDataBase(){
		database = scheduleSQLiteHelper.getWritableDatabase();
	}
	
	public void closeDatabase(){
		if( database != null && database.isOpen()){
			database.close();
		}
	}

	public List<Schedule> getSchedules( String where, String[] whereVals){
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		synchronized (this) {
			try{
				openDataBase();
				Cursor cursor = database.query(
						ScheduleTableSchema.TABLE_NAME,
						ScheduleTableSchema.COLUMNS,
						where,
						whereVals,
						null,null,null);
				if( cursor.moveToFirst()){
					while(!cursor.isAfterLast()){
						Schedule item = new Schedule();
						item.setTrainId(		cursor.getInt(ScheduleTableSchema.colTRAIN_ID));
						item.setTime( new Time(	cursor.getInt(ScheduleTableSchema.colTIME)));
						item.setStationId(		cursor.getInt(ScheduleTableSchema.colSTATION_ID));
						item.setNextStationId(	cursor.getInt(ScheduleTableSchema.colNEXT_STATION_ID));
						list.add(item);
					}
				}
			}
			catch( Exception e){
				e.printStackTrace();
			}
			
			finally{
				try{
					closeDatabase();
				}
				catch( Exception e){
					e.printStackTrace();
				}
			}
		}
		return list;
		
	}
	
}
