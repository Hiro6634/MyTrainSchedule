package ar.com.symsys.mytrainschedule.storage;

public class ScheduleFilter {
	protected int endStationId;
	protected int time;
	protected int scheduleId;
	
	public ScheduleFilter( ){
		
	}
	public int getEndStationId() {
		return endStationId;
	}
	public void setEndStationId(int endStationId) {
		this.endStationId = endStationId;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
}
