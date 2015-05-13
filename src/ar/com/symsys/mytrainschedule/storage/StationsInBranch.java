package ar.com.symsys.mytrainschedule.storage;

import java.sql.Time;

public class StationsInBranch {
	protected int 		branchId;
	protected int	 	stationId;
	protected int 		nextStationId;
	protected Time		nextStationTime;
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public int getNextStationId() {
		return nextStationId;
	}
	public void setNextStationId(int nextStationId) {
		this.nextStationId = nextStationId;
	}
	public Time getNextStationTime() {
		return nextStationTime;
	}
	public void setNextStationTime(Time nextStationTime) {
		this.nextStationTime = nextStationTime;
	}
}
