package ar.com.symsys.mytrainschedule.storage;

import android.content.Context;
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

	
}
