package capgemni.drinkanddelight.rawmaterial.dao;

import java.util.Date;
import java.util.Set;

import capgemni.drinkanddelight.rawmaterial.beans.RawMaterialStock;
import capgemni.drinkanddelight.rawmaterial.exception.RawMaterialException;

public interface RawMaterialDaoIntf {

	 public RawMaterialStock trackRawMaterialOrder(String orderId)throws RawMaterialException;
	//public boolean processDateCheck(RawMaterialStock rmsbObject );
	 public String updateProcessDateinStock(String orderId, Date processDate);
	public String updateRawMaterialStock(String orderId,Date manufacturingDate,Date expiryDate,String qualityCheck);
//	public boolean doesRawMaterialOrderIdExistInStock(String orderId);
	public Set<String> doesRawMaterialOrderIdExist(String orderId);

}
