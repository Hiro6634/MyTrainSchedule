package ar.com.symsys.mytrainschedule.storage;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StationsInBranchDataSource {
	private StationsInBranchSQLiteHelper	stationsInBranchSQLiteHelper;
	private SQLiteDatabase					database;
//	private Context							context;
	
	public StationsInBranchDataSource(Context context){
//		this.context = context;
		stationsInBranchSQLiteHelper = new StationsInBranchSQLiteHelper(context);
	}
	
	public void openDataBase(){
		database = stationsInBranchSQLiteHelper.getWritableDatabase();
	}
	
	public void closeDatabase(){
		if( database != null && database.isOpen()){
			database.close();
		}
	}
	
	public void add(StationsInBranch element){
		synchronized (this) {
			try{
				openDataBase();
				ContentValues values = new ContentValues();
				
				values.put(StationsInBranchTableSchema.BRANCH_ID, element.getBranchId());
				values.put(StationsInBranchTableSchema.STATION_ID, element.getStationId());
				
				database.insertOrThrow(StationsInBranchTableSchema.TABLE_NAME, null, values);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					closeDatabase();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<Integer> getStationsByBranch( int branchId ){
		ArrayList<Integer> list = new ArrayList<Integer>();
		synchronized(this){
			try{
				Cursor cursor = database.query(
						StationsInBranchTableSchema.TABLE_NAME,
						StationsInBranchTableSchema.COLUMNS,
						StationsInBranchTableSchema.BRANCH_ID + " ?",
						new String[]{String.valueOf(branchId)},
						null,null,null);
				cursor.moveToFirst();
				while( !cursor.isAfterLast()){
					list.add(cursor.getInt(StationsInBranchTableSchema.colSTATION_ID));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					closeDatabase();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public List<Integer> getBranchsByStation( int stationId ){
		ArrayList<Integer> list = new ArrayList<Integer>();
		synchronized(this){
			try{
				Cursor cursor = database.query(
						StationsInBranchTableSchema.TABLE_NAME,
						StationsInBranchTableSchema.COLUMNS,
						StationsInBranchTableSchema.STATION_ID + " ?",
						new String[]{String.valueOf(stationId)},
						null,null,null);
				cursor.moveToFirst();
				while( !cursor.isAfterLast()){
					list.add(cursor.getInt(StationsInBranchTableSchema.colBRANCH_ID));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					closeDatabase();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
