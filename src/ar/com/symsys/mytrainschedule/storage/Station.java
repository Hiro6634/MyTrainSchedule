package ar.com.symsys.mytrainschedule.storage;

public class Station {
	protected int 		stationId;
	protected String 	name;
	protected float		gps_latitude;
	protected float		gps_longitude;
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getGps_latitude() {
		return gps_latitude;
	}
	public void setGps_latitude(float gps_latitude) {
		this.gps_latitude = gps_latitude;
	}
	public float getGps_longitude() {
		return gps_longitude;
	}
	public void setGps_longitude(float gps_longitude) {
		this.gps_longitude = gps_longitude;
	}
	
}
