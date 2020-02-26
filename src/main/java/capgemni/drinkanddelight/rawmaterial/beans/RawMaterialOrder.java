package capgemni.drinkanddelight.rawmaterial.beans;

import java.util.Date;

public class RawMaterialOrder {

	String name=null;
	String orderId=null;
	String supplierId=null;
	String deliveryStatus=null;
	String warehouseId=null;
	String quantityUnit=null;
	double pricePerUnit;
	double totalPrice;
	double quantityValue;
	Date dateOfDelivery=null;
	Date dateOfOrder=null;
	Date expiryDate=null;
	Date manufacturingDate=null;
	
	/**
	 * @param name
	 * @param orderId
	 * @param supplierId
	 * @param deliveryStatus
	 * @param warehouseId
	 * @param pricePerUnit
	 * @param totalPrice
	 * @param quantityValue
	 * @param dateOfDelivery
	 * @param dateOfOrder
	 */
	public RawMaterialOrder( String orderId,String name, String deliveryStatus, Date manufacturingDate,Date expiryDate, Date dateOfOrder,Date dateOfDelivery
			,double pricePerUnit,double quantityValue,String quantityUnit) {
		this.name = name;
		this.orderId = orderId;
		
		this.deliveryStatus = deliveryStatus;
		this.quantityUnit=quantityUnit;
		this.pricePerUnit = pricePerUnit;
		this.totalPrice =pricePerUnit*quantityValue ;
		this.quantityValue = quantityValue;
		this.dateOfDelivery = dateOfDelivery;
		this.dateOfOrder = dateOfOrder;
		this.expiryDate=expiryDate;
		this.manufacturingDate=manufacturingDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}
	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	
	
	
}
