package capgemni.drinkanddelight.rawmaterial.services;

import java.util.Date;

public interface RawMaterialServiceIntf {

	public String trackRawMaterialOrder(String orderId);
	public boolean doesRawMaterialOrderIdExist(String orderId);
    public String updateProcessDateinStock(String orderId, Date processDate);
	public boolean validateManufacturingDate(Date manufacturingDate);
	public boolean validateExpiryDate(Date expiryDate);
	public String updateRawMaterialStock(String orderId,Date manufacturingDate,Date expiryDate,String qualityCheck);
	//public boolean doesRawMaterialOrderIdExistInStock(String orderId);
	//public String validateProcessDate(int day, int month, int year) throws InvalidDateException;
	public boolean processDateCheck(String processDate);
}
