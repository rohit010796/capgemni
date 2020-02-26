package capgemni.drinkanddelight.rawmaterial.dao;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import capgemni.drinkanddelight.rawmaterial.beans.RawMaterialData;
import capgemni.drinkanddelight.rawmaterial.beans.RawMaterialOrder;
import capgemni.drinkanddelight.rawmaterial.beans.RawMaterialStock;
import capgemni.drinkanddelight.rawmaterial.exception.RawMaterialException;

public class RawMaterialDaoImpl implements RawMaterialDaoIntf {
    
	RawMaterialData rmd= new RawMaterialData();
	 Map<String, RawMaterialStock> rawMaterialList = RawMaterialData.getRawMaterialStocklist();
	 Map<String,RawMaterialOrder> rawMaterialOrderList=RawMaterialData.getRawMaterialOrderList();
	 
	public RawMaterialStock trackRawMaterialOrder(String orderId) 
	{
		for(String keyId:rawMaterialList.keySet())
		{
			if(keyId.equalsIgnoreCase(orderId))
			{
				return rawMaterialList.get(keyId);
			}
		}
		return null;
	}

	public Date processDateCheck(String orderId) throws RawMaterialException
	{

		return new Date();
	}

	public String updateProcessDateinStock(String orderId, Date processDate) 
	{

		for (Entry<String,RawMaterialStock> mp:rawMaterialList.entrySet()) 
		 {
			 if (mp.getValue().getOrderId().equals(orderId))
			 {
	           mp.getValue().setProcessDate(processDate);      
            } 
		 }
		 return "ProcessDate is Successfully Updated";
	}

	public String updateRawMaterialStock(String orderId,Date manufacturingDate,Date expiryDate,String qualityCheck)
	{

		 for (Entry<String , RawMaterialStock> mp:rawMaterialList.entrySet()) 
		 {
			 if (mp.getValue().getOrderId().contentEquals(orderId))
			 {
	           mp.getValue().setManufacturingDate(manufacturingDate);
	           mp.getValue().setExpiryDate(expiryDate);
	           mp.getValue().setQualityCheck(qualityCheck);
			 }
		 }
		 return "Stock is successfully updated";
	}

	public void addToStock(RawMaterialOrder rmo)
	{
		RawMaterialStock rms=new RawMaterialStock();
		rms.setOrderId(rmo.getOrderId());
		rms.setName(rmo.getName());
		rms.setExpiryDate(rmo.getExpiryDate());
		rms.setManufacturingDate(rmo.getManufacturingDate());
		rms.setDeliveryDate(rmo.getDateOfDelivery());
		rms.setPricePerUnit(rmo.getPricePerUnit());
		rms.setPrice(rmo.getTotalPrice());
		rms.setQuantityUnit(rmo.getQuantityUnit());
		rms.setQuantityvalue(rmo.getQuantityValue());
		rawMaterialList.put(rms.getOrderId(),rms);
		rawMaterialOrderList.remove(rmo.getOrderId());
		
		
	}

	public RawMaterialOrder trackOrder(String orderId)
	{
		for(String keyId:rawMaterialOrderList.keySet())
		{
			if(keyId.equalsIgnoreCase(orderId))
			{
				return rawMaterialOrderList.get(keyId);
			}
		}
		return null;
	}
	
	public Set<String> doesRawMaterialOrderIdExist(String orderId)
	{
        return rawMaterialOrderList.keySet();
	}
	
	public Set<String> doesRawMaterialOrderIdExistInStock(String orderId) 
	{
          return rawMaterialList.keySet();
    }

}
