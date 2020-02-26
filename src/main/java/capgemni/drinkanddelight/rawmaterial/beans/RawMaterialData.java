package capgemni.drinkanddelight.rawmaterial.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RawMaterialData {

	//public Map<String,ArrayList<RawMaterialStock>> rawMaterialStocks=new HashMap<String,ArrayList<RawMaterialStock>>();
	 public static Map<String, RawMaterialStock> rawMaterialStockList=new HashMap<String,RawMaterialStock>();
	 public static Map<String, RawMaterialOrder> rawMaterialOrderList=new HashMap<String,RawMaterialOrder>();
	 
		 public static void setRawMaterialStocklist(Map<String, RawMaterialStock> rawMaterialStockList)
		 {
		 	RawMaterialData.rawMaterialStockList = rawMaterialStockList;
		 }

	 	public static Map<String,RawMaterialStock> getRawMaterialStocklist() 
	 	{
	 		return rawMaterialStockList;
	 	}
	 	
	 	public static void setRawMaterialOrderList(Map<String, RawMaterialOrder> rawMaterialOrderList)
	 	{
	 		RawMaterialData.rawMaterialOrderList=rawMaterialOrderList;
	 	}
	 	
	 	public static Map<String, RawMaterialOrder> getRawMaterialOrderList()
	 	{
	 		return rawMaterialOrderList;
	 	}

	 public RawMaterialData()
	 {
		 rawMaterialStockList.put("RawId11606974",new RawMaterialStock("RawId11606974","war1","Flavouring agent","Pass",new Date(),new Date(12/10/2019),new Date(),new Date(),1000.00,"unit",1000));
		 rawMaterialStockList.put("RawId11606975",new RawMaterialStock("RawId11606975","war2","Hops","Pass",new Date(),new Date(),new Date(),new Date(),40,"box",21000));
		 rawMaterialStockList.put("RawId11606976",new RawMaterialStock("RawId11606976","war3","Sugar","Pass",new Date(),new Date(),new Date(),new Date(),120,"kg",10000));
		 rawMaterialStockList.put("RawId11606977",new RawMaterialStock("RawId11606977","war4","Barley","Pass",new Date(),new Date(),new Date(),new Date(),100,"kg",100000));
		 rawMaterialStockList.put("RawId11606978",new RawMaterialStock("RawId11606978","war5","Yeast","Pass",new Date(),new Date(),new Date(),new Date(),60,"kg",21000));
		 rawMaterialStockList.put("RawId11606979",new RawMaterialStock("RawId11606979","war6","Carbonic acid","Pass",new Date(),new Date(),new Date(),new Date(),50000,"kg",1000));
	 
		 rawMaterialOrderList.put("RawId11606971", new RawMaterialOrder("RawId11606971","sugar","delivered",new Date(),new Date(),new Date(),new Date(),100,1020,"kg"));
		 rawMaterialOrderList.put("RawId11606972", new RawMaterialOrder("RawId11606972","Barley","pending",new Date(),new Date(),new Date(),new Date(),130,10000,"kg"));
		 rawMaterialOrderList.put("RawId11606973", new RawMaterialOrder("RawId11606973","yeast","delivered",new Date(),new Date(),new Date(),new Date(),70,500,"kg"));
		 rawMaterialOrderList.put("RawId11606970", new RawMaterialOrder("RawId11606970","caffein","delivered",new Date(),new Date(),new Date(),new Date(),1000,100,"kg"));
	 }
}


