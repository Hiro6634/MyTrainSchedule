package ar.com.symsys.mytrainschedule.storage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StationsSQLiteHelper extends SQLiteOpenHelper{
	private static final String 	dbName 		= "TrainStationsDb";
	private static final int		dbVersion	= 1;
	private Context					context;
	
	private static final String 	sqlCreateStaions = "CREATE TABLE " + StationsTableSchema.TABLE_NAME + " ("
			+ StationsTableSchema.STATION_ID + " INTEGER PRIMARY KEY, "
			+ StationsTableSchema.NAME + " TEXT, "
			+ StationsTableSchema.GPS_LATITUDE + " REAL, "
			+ StationsTableSchema.GPS_LONGITUDE + " REAL )";
	
	public StationsSQLiteHelper(Context context){
		super(context, dbName, null, dbVersion);
		this.context = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.execSQL(sqlCreateStaions);
//			InitialLoad(db);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + StationsTableSchema.TABLE_NAME );
		db.execSQL(sqlCreateStaions);
//		InitialLoad(db);
	}

	private void InitialLoad( SQLiteDatabase db){
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
			
			String[] filas = byteArrayOutputStream.toString().split("\r\n");
			for( i = 0; i < filas.length; i++){
				ContentValues values = new ContentValues();
				values.put(StationsTableSchema.STATION_ID	, filas[StationsTableSchema.colSTATION_ID]);
				values.put(StationsTableSchema.NAME 		, filas[StationsTableSchema.colNAME]);
				values.put(StationsTableSchema.GPS_LATITUDE	, filas[StationsTableSchema.colGPS_LATITUDE]);
				values.put(StationsTableSchema.GPS_LONGITUDE, filas[StationsTableSchema.colGPS_LONGITUDE]);
				db.insert(StationsTableSchema.TABLE_NAME, null, values);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
