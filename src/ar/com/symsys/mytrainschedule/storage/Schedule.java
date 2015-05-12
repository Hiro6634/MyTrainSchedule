package ar.com.symsys.mytrainschedule.storage;

import java.sql.Time;

public class Schedule {
	public static final String TIME_FORMAT = "HH:mm";
	protected int 		trainId;
	protected Time 		time;
	protected int		StationId;
	protected int 		NextStationId;
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getStationId() {
		return StationId;
	}
	public void setStationId(int stationId) {
		StationId = stationId;
	}
	public int getNextStationId() {
		return NextStationId;
	}
	public void setNextStationId(int nextStationId) {
		NextStationId = nextStationId;
	}
}
