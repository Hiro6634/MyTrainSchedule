package ar.com.symsys.mytrainschedule.storage;

import java.sql.Time;
import java.util.HashMap;


public class ScheduleFilter {
	protected int endStationId;
	protected Time time;
	protected int scheduleId;
	protected HashMap<String, Object> filter = new HashMap<String, Object>();
	
	public ScheduleFilter(){
	}
	
	public ScheduleFilter( Time time, int scheduleId, int endStationId){
		this.time 			= time;
		this.scheduleId 	= scheduleId;
		this.endStationId	= endStationId;
		
	}
	
	public Integer getEndStationId() {
		return ( !filter.containsKey(ScheduleTableSchema.END_STATION_ID))?null:(Integer)filter.get(ScheduleTableSchema.END_STATION_ID);
	}
	public void setEndStationId(Integer endStationId) {
		filter.put(ScheduleTableSchema.END_STATION_ID, endStationId);
	}

	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
}
