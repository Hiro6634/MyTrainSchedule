package ar.com.symsys.mytrainschedule.storage;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class StationsDataSource {
	private StationsSQLiteHelper	stationsSQLiteHelper;
	private SQLiteDatabase			database;
//	private Context					context;
	
	public StationsDataSource(Context context){
//		this.context = context;
		stationsSQLiteHelper = new StationsSQLiteHelper(context);
	}
	
	public void openDataBase(){
		database = stationsSQLiteHelper.getWritableDatabase();
	}
	
	public void closeDatabase(){
		if( database != null && database.isOpen()){
			database.close();
		}
	}
	
	public Station getStationById( int stationId)
	{
		Station station = new Station();
		
		return station;
	}
	
	public Station getStationByName( String name ){
		Station station = new Station();
		
		return station;
	}

	public List<Station> getStationsByBranch( int BranchId ){
		ArrayList<Station> list = new ArrayList<Station>();
		
		return list;
	}
}
