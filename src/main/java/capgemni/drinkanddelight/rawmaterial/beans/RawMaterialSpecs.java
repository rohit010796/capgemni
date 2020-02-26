package capgemni.drinkanddelight.rawmaterial.beans;

public class RawMaterialSpecs {

	String rmsId;
	String name;
	double pricePerUnit;
	int duration;
	
	/**
	 * @param rmsId
	 * @param name
	 * @param pricePerUnit
	 * @param duration
	 */
	public RawMaterialSpecs(String rmsId, String name, double pricePerUnit, int duration) {
		
		this.rmsId = rmsId;
		this.name = name;
		this.pricePerUnit = pricePerUnit;
		this.duration = duration;
	}
	public String getRmsId() {
		return rmsId;
	}
	public void setRmsId(String rmsId) {
		this.rmsId = rmsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
