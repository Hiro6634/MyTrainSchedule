package ar.com.symsys.mytrainschedule.storage;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ScheduleDataSource {
	private ScheduleSQLiteHelper	scheduleSQLiteHelper;
	private SQLiteDatabase			database;
	private Context					context;
	
	public ScheduleDataSource(Context context){
		this.context = context;
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

	public List<Schedule> getSchedules( ScheduleFilter filter){
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		synchronized (this) {
			try{
				openDataBase();
				
				Cursor cursor = database.query(
						ScheduleTableSchema.TABLE_NAME,
						ScheduleTableSchema.COLUMNS,
						ScheduleTableSchema.SCHEDULE_TYPE_ID + " = ? AND "
						+ ScheduleTableSchema.DEPARTURE_TIME + " >= ? AND "
						+ ScheduleTableSchema.END_STATION_ID + " = ? ",
						new String[] {filter.scheduleId},
						null,null.null);
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
