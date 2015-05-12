package ar.com.symsys.mytrainschedule.storage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Time;
import java.text.SimpleDateFormat;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScheduleSQLiteHelper extends SQLiteOpenHelper {
	private static final String 	dbName 		= "TrainScheduleDb";
	private static final int		dbVersion	= 1;
	private Context					context;
	private static final String 	sqlCreateSchedule = "CREATE TABLE " + ScheduleTableSchema.TABLE_NAME + " ("
			+ ScheduleTableSchema.TRAIN_ID 			+ " INTEGER PRIMARY KEY, "
			+ ScheduleTableSchema.TIME 				+ " INTEGER, "
			+ ScheduleTableSchema.STATION_ID 		+ " INTEGER, "
			+ ScheduleTableSchema.NEXT_STATION_ID 	+ " INTEGER )";
	
	public ScheduleSQLiteHelper(Context context){
		super(context, dbName, null, dbVersion);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreateSchedule);
		InitialLoad(db);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + ScheduleTableSchema.TABLE_NAME );
		db.execSQL(sqlCreateSchedule);
		InitialLoad(db);
	}

	private void InitialLoad(SQLiteDatabase db){
		//TODO: Insertar el objeto con el csv para inicializar la tabla
		InputStream 			inputStream 			= this.context.getResources().openRawResource(0);
		ByteArrayOutputStream	byteArrayOutputStream 	= new ByteArrayOutputStream();
		int						i;
		
		try{
			i = inputStream.read();
			while( i != -1){
				byteArrayOutputStream.write(i);
				i = inputStream.read();
			}
			inputStream.close();
			SimpleDateFormat sdf = new SimpleDateFormat(Schedule.TIME_FORMAT);
			String[] filas = byteArrayOutputStream.toString().split("\r\n");
			for( i = 0; i < filas.length; i++){
				ContentValues values = new ContentValues();
				values.put(ScheduleTableSchema.TRAIN_ID, filas[ScheduleTableSchema.colTRAIN_ID]);
				values.put(ScheduleTableSchema.TIME, sdf.parse(filas[ScheduleTableSchema.colTIME]).getTime());
				values.put(ScheduleTableSchema.STATION_ID, filas[ScheduleTableSchema.colSTATION_ID]);
				values.put(ScheduleTableSchema.NEXT_STATION_ID, filas[ScheduleTableSchema.colNEXT_STATION_ID]);
				db.insert(ScheduleTableSchema.TABLE_NAME, null, values);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}


