package capgemni.drinkanddelight.rawmaterial.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import capgemni.drinkanddelight.rawmaterial.beans.RawMaterialOrder;
import capgemni.drinkanddelight.rawmaterial.beans.RawMaterialStock;
import capgemni.drinkanddelight.rawmaterial.dao.RawMaterialDaoImpl;
import capgemni.drinkanddelight.rawmaterial.exception.InvalidDateException;
import capgemni.drinkanddelight.rawmaterial.exception.RawMaterialException;

public class RawMaterialServiceImpl implements RawMaterialServiceIntf {

	
	RawMaterialDaoImpl rawMaterialDaoRef=new RawMaterialDaoImpl();
	
	public boolean doesRawMaterialOrderIdExist(String orderId)
	{
		
		  Set<String> orderIds=rawMaterialDaoRef.doesRawMaterialOrderIdExist(orderId);
	       for(String id:orderIds)
		     {
			       if(id.equalsIgnoreCase(orderId))
			       {
			    	   return true;
			    	   
			       }
		     }
			
		   return false;
		
	}
	public boolean doesRawMaterialOrderIdExistInStock(String orderId)
	{
		 Set<String> orderIds=rawMaterialDaoRef.doesRawMaterialOrderIdExistInStock(orderId);
	       for(String id:orderIds)
		     {
			       if(id.equalsIgnoreCase(orderId))
			       {
			    	   return true;
			    	   
			       }
		     }
			
		   return false;
	}
	
	public String addToStock(String orderId)
	{
		RawMaterialOrder orderObject=rawMaterialDaoRef.trackOrder(orderId);
		if(orderObject.getDeliveryStatus().equalsIgnoreCase("delivered"))
		{
			rawMaterialDaoRef.addToStock(orderObject);
			return "Order Add To Stock Successfully";
		}
		return "Order is not delivered yet\nCannot add to stock";
		
	}
	
	public String trackRawMaterialOrder(String orderId) 
	{     
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    	try
	    	{
	    	  if(doesRawMaterialOrderIdExistInStock(orderId))
	    	  {   
	    		  RawMaterialStock stockObj= rawMaterialDaoRef.trackRawMaterialOrder(orderId);
	    		  return "Order id:"+stockObj.getOrderId()+"\nName:"+stockObj.getName()+"\nPrice Per Unit:"+stockObj.getPricePerUnit()+
	    				  "\nQuantity:"+stockObj.getQuantityvalue()+stockObj.getQuantityUnit()+"\nTotal Price:"+stockObj.getPrice()+
	    				  "\nExpiry Date:"+stockObj.getExpiryDate()+"\nManufacturing date:"+sdf.format(stockObj.getManufacturingDate())+
	    				  "\nDelivery date:"+sdf.format(stockObj.getDeliveryDate())+"\nProcess Date:"+sdf.format(stockObj.getProcessDate())+
	    				  "\nQuality check:"+stockObj.getQualityCheck()+"\nWarehouse id:"+stockObj.getWarehouseId();
	    	  }
	    	  else {
	    		 throw new RawMaterialException("No OrderId Exist");
	    	  }
	      }
	      catch(RawMaterialException e)
		    {
		    	return e.getMessage();
		    }
        
	}
	
	
	public String updateProcessDateinStock(String orderId, Date processDate) 
	{
		if(doesRawMaterialOrderIdExistInStock(orderId))
		{
			return rawMaterialDaoRef.updateProcessDateinStock(orderId, processDate);
		}
		else
		{
			return "OrderId is not valid try to enter the correct OrderId";
		}
		
	}


	public boolean validateManufacturingDate(Date manufacturingDate) 
	{
        if(manufacturingDate==null)
			return false;
		else
		{   Date mnfDate;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		      String Date=sdf.format(manufacturingDate);
		      sdf.setLenient(false);
		      try {
					
					 mnfDate = sdf.parse(Date);
				
				} 
		      catch (ParseException e) 
		      {
					 e.getMessage();
					
					return false;
			  }	
			
			Date currentDate=new Date();
			long differenceInDates=currentDate.getTime()-mnfDate.getTime();
			int daysBetween = (int)TimeUnit.DAYS.convert(differenceInDates, TimeUnit.MILLISECONDS);
			if(daysBetween>0)
				return true;
			
		}
		return false;
	}

	public boolean validateExpiryDate(Date expiryDate) 
	{
		if(expiryDate==null)
			return false;
		else
		{
			 Date expDate;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			      String Date=sdf.format(expiryDate);
			      sdf.setLenient(false);
			      try {
						
						 expDate = sdf.parse(Date);
					
					} 
			      catch (ParseException e) 
			      {
						 e.getMessage();
						
						return false;
				  }	
				
			
			Date currentDate=new Date();
			long differenceInDates=expDate.getTime()-currentDate.getTime();
			int daysBetween = (int)TimeUnit.DAYS.convert(differenceInDates, TimeUnit.MILLISECONDS);
			if(daysBetween>0)
				return true;	
		}
		return false;
	}

	public String updateRawMaterialStock(String orderId,Date manufacturingDate,Date expiryDate,String qualityCheck)
	{	String msg;
		try
	    {	if(doesRawMaterialOrderIdExistInStock(orderId))
			{
	    	    if(validateManufacturingDate(manufacturingDate))
		        {
		        	if(validateExpiryDate(expiryDate))
		        	{
		        		return rawMaterialDaoRef.updateRawMaterialStock(orderId,manufacturingDate, expiryDate, qualityCheck);	
		        	}
		        	else
		        	{
		        		throw new InvalidDateException("Invalid expiry date");
		        	}
		        }
	    	    else
	    	    {
	    	    	throw new InvalidDateException("Invalid manufacturing date");
	    	    }
				
			}
			else
			{
				throw new RawMaterialException("Invalid id");
			}
	       
	    }
	   catch(RawMaterialException e)
	   {
		   msg=e.getMessage();
	   }
	   catch(InvalidDateException e)
	   {
		   msg=e.getMessage();
	   }
	  
		return msg;
	   
	}
	
	public boolean processDateCheck(String processDate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	      Date date;
	      Date currentDate;
		 if(processDate==null)
		 { 
			 return false;
		 }
		  
	      try
	      {
	    	  date=sdf.parse(processDate);
	    	  currentDate=sdf.parse(sdf.format(new Date()));
	      }
	      catch(ParseException e)
	      {
	    	  return false;
	      }
	      
	      if(date.compareTo(currentDate)<0)
	      {
	    	  return true;
	      }
	      else
	    	  return false;
	      
	}
	
	
	public boolean validateProcessDate(Date manufacturingDate, Date expiryDate) 
	{
		  if(manufacturingDate==null || expiryDate==null)
	      {
			return false;
	      }
	      if(expiryDate.compareTo(manufacturingDate)>0)
		  {
				return true;
		  }
   	      return false;
		
	} 


}