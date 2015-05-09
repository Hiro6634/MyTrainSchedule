package ar.com.symsys.mytrainschedule.storage;

import java.sql.Time;

public class Schedule {
	protected int 		trainId;
	protected Time 		departureTime;
	protected int		endStationId;
	protected int		scheduleTypeId;
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public int getEndStationId() {
		return endStationId;
	}
	public void setEndStationId(int endStationId) {
		this.endStationId = endStationId;
	}
	public int getScheduleTypeId() {
		return scheduleTypeId;
	}
	public void setScheduleTypeId(int scheduleTypeId) {
		this.scheduleTypeId = scheduleTypeId;
	}
	

}
