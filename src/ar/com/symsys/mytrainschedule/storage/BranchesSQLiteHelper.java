package ar.com.symsys.mytrainschedule.storage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BranchesSQLiteHelper extends SQLiteOpenHelper{
	private static final String 	dbName 		= "BranchesDb";
	private static final int		dbVersion	= 1;
	private Context					context;
	
	private static final String 	sqlCreateStaions = "CREATE TABLE " + BranchesTableSchema.TABLE_NAME + " ("
			+ BranchesTableSchema.BRANCH_ID + " INTEGER PRIMARY KEY, "
			+ BranchesTableSchema.NAME + " TEXT, "
			+ BranchesTableSchema.START_STATION_ID + " INTEGER, "
			+ BranchesTableSchema.END_STATION_ID + " INTEGER )";
	
	public BranchesSQLiteHelper(Context context){
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
		db.execSQL("DROP TABLE IF EXISTS " + BranchesTableSchema.TABLE_NAME );
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
				values.put(BranchesTableSchema.BRANCH_ID		, filas[BranchesTableSchema.colBRANCH_ID]);
				values.put(BranchesTableSchema.NAME 			, filas[BranchesTableSchema.colNAME]);
				values.put(BranchesTableSchema.START_STATION_ID	, filas[BranchesTableSchema.colSTART_STATIONID]);
				values.put(BranchesTableSchema.END_STATION_ID	, filas[BranchesTableSchema.colEND_STATION_ID]);
				db.insert(BranchesTableSchema.TABLE_NAME, null, values);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
