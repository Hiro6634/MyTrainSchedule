package ar.com.symsys.mytrainschedule.storage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StationsInBranchSQLiteHelper extends SQLiteOpenHelper{
	private static final String 	dbName 		= "StationsInBranchDb";
	private static final int		dbVersion	= 1;
	private Context					context;
	
	private static final String 	sqlCreateStaions = "CREATE TABLE " + StationsInBranchTableSchema.TABLE_NAME + " ("
			+ StationsInBranchTableSchema.BRANCH_ID + " INTEGER PRIMARY KEY, "
			+ StationsInBranchTableSchema.STATION_ID + " INTEGER PRIMARY KEY) ";
	
	public StationsInBranchSQLiteHelper(Context context){
		super(context, dbName, null, dbVersion);
		this.context = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.execSQL(sqlCreateStaions);
			InitialLoad(db);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + BranchesTableSchema.TABLE_NAME );
		db.execSQL(sqlCreateStaions);
		InitialLoad(db);
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
				values.put(StationsInBranchTableSchema.BRANCH_ID		, filas[StationsInBranchTableSchema.colBRANCH_ID]);
				values.put(StationsInBranchTableSchema.STATION_ID		, filas[StationsInBranchTableSchema.colSTATION_ID]);
				db.insert( StationsInBranchTableSchema.TABLE_NAME, null , values);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
