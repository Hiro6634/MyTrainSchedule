package ar.com.symsys.mytrainschedule.storage;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;

public class StorageManager {
	private static StorageManager 			ourInstance = new StorageManager();
	public static final SimpleDateFormat	DATE_FORMAT	= new SimpleDateFormat("dd MM yyyy");
	public static final SimpleDateFormat	TIME_FORMAT	= new SimpleDateFormat("hh:mm");
	
	private StationsInBranchDataSource		stationsInBranchDS = null;
	
	public static StorageManager getInstance(){
		return ourInstance;
	}
	
	public void setContext( Context context ){
		synchronized (this) {
			if( stationsInBranchDS == null){
				stationsInBranchDS = new StationsInBranchDataSource(context);
			}
		}
	}
	
	public List<Integer> getStationsByBranchId( int branchId){
		return stationsInBranchDS.getStationsByBranch(branchId);
	}
}
