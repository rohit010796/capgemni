package capgemni.drinkanddelight.rawmaterial.beans;

import java.util.Date;

public class RawMaterialStock {
	

	String orderId=null;
	String warehouseId=null;
	String name=null;
	String qualityCheck=null;
	Date processDate=null;
	Date manufacturingDate=null;
	Date expiryDate=null;
	Date deliveryDate=null;
	double pricePerUnit;
	double price;
	String quantityUnit;
	double quantityvalue;
	
	
	/**
	 * @param orderId
	 * @param warehouseId
	 * @param name
	 * @param qualityCheck
	 * @param processDate
	 * @param manufacturingDate
	 * @param expiryDate
	 * @param deliveryDate
	 * @param pricePerUnit
	 * @param price
	 * @param quantityUnit
	 * @param quantityvalue
	 */
	//default constructor
	public RawMaterialStock() {
		// TODO Auto-generated constructor stub
	}
	public RawMaterialStock(String orderId, String warehouseId, String name, String qualityCheck, Date processDate,
			Date manufacturingDate, Date expiryDate, Date deliveryDate, double pricePerUnit,String quantityUnit, double quantityvalue) 
	{
		this.orderId = orderId;
		this.warehouseId = warehouseId;
		this.name = name;
		this.qualityCheck = qualityCheck;
		this.processDate = processDate;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.deliveryDate = deliveryDate;
		this.pricePerUnit = pricePerUnit;
		this.price = pricePerUnit*quantityvalue;
		this.quantityUnit = quantityUnit;
		this.quantityvalue = quantityvalue;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double price_per_unit) {
		this.pricePerUnit = price_per_unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public double getQuantityvalue() {
		return quantityvalue;
	}
	public void setQuantityvalue(double quantityvalue) {
		this.quantityvalue = quantityvalue;
	}
	

}
