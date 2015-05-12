package ar.com.symsys.mytrainschedule.storage;

public class Branch {
	protected int 		branchId;
	protected String 	name;
	protected int		start_station;
	protected int		end_station;
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStart_station() {
		return start_station;
	}
	public void setStart_station(int start_station) {
		this.start_station = start_station;
	}
	public int getEnd_station() {
		return end_station;
	}
	public void setEnd_station(int end_station) {
		this.end_station = end_station;
	}
}
