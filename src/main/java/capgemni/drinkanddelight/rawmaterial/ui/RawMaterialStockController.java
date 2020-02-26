package capgemni.drinkanddelight.rawmaterial.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import capgemni.drinkanddelight.rawmaterial.exception.InvalidDateException;
import capgemni.drinkanddelight.rawmaterial.exception.RawMaterialException;
import capgemni.drinkanddelight.rawmaterial.services.RawMaterialServiceImpl;

public class RawMaterialStockController
{
	  
	    Scanner sc =new Scanner(System.in);
	    RawMaterialServiceImpl rawMaterialServiceRef=new RawMaterialServiceImpl();
	    
	    
    public static void main(String[] args)
	{
    	//object of controller class
    	RawMaterialStockController controllerRef=new RawMaterialStockController();
    	
    	int choice;
		
	    while(true) 
	    {	    
	    	System.out.println("1->Track Raw Material Order\n2->Update Process Date\n3->Update Raw Material Stock Details\n4->Add Order To Stock\n5->Exit");
		    System.out.println("===================================");
		    System.out.println("Enter the choice");
		    try
		    {
		      choice = Integer.parseInt(controllerRef.sc.next());
		    }
		    catch(NumberFormatException e)
		    {
		    	System.out.println("Bravoo !!!!Too Smart!!! --->Entered choice is invalid");
		    	System.out.println("=================================================");
		    	continue;
		    }
		    switch(choice)
		    {
		    case 1: 
		    {
		    	 controllerRef.trackOrder();
		    	 break;
		    }
		    
		    case 2:
		    {    controllerRef.setProcessDate();
		    	 break; 
		    } 
		    
		    
		    case 3:
		    {
                controllerRef.updateRawMaterialStockDetails();
		    	break;
		    } 
		    case 4:
		    {   
		    	controllerRef.addOrderToStock();
		        break;
		    }
		    case 5:
		    {   
		    	System.exit(0);
		        break;
		    }
		    default:
		    {
		    	System.out.println("Bravoo !!!!Too Smart!!! --->Entered choice is invalid");
		    	System.out.println("=================================================");
		    	break;
		    }
		    }
	   	}
	    
		}
    
    public void trackOrder()
    {  
    	try {
    	 String orderDetails;
    	 System.out.println("Enter RawMaterial Tracking orderId");
	   	 String orderId=sc.next();
	   	 if(rawMaterialServiceRef.doesRawMaterialOrderIdExist(orderId))
	   	 { orderDetails=rawMaterialServiceRef.trackRawMaterialOrder(orderId);
	   	 System.out.println(orderDetails);
	   	 System.out.println("===================================");
	   	 }
	   	 else
	   		 throw new RawMaterialException("This order Id does not exist");
    	}
    	catch(RawMaterialException e)
    	{
    		System.out.println(e.getMessage());
    		trackOrder();
    	}
    	
    	}
    

    public void setProcessDate()
    {
    	 
	    	 
	    	 System.out.println("Enter order Id ");
	    	 String id=sc.next();
	    	 
	    	try 
	    	{	 if(rawMaterialServiceRef.doesRawMaterialOrderIdExist(id))
	    		 {  
		    		System.out.println("Enter the  process date(dd/MM/yyyy) ");
			         String date=sc.next();
	    		       
	    		   
		    		     if(rawMaterialServiceRef.processDateCheck(date))
		    		     { 
		    			    Date dateObj=null;
		    			    try
		    			    {
		    		    	  dateObj=new SimpleDateFormat("dd/MM/yyyy").parse(date);//converting from string to Date object
		    			    }
		    		        catch(ParseException e)
		    		        {
		    		        	throw new InvalidDateException("Invalid date entered");
		    		        
		    		        }
		    			     rawMaterialServiceRef.updateProcessDateinStock(id,dateObj);    		     
					    	 System.out.println(rawMaterialServiceRef.updateProcessDateinStock(id,dateObj));
					         System.out.println("===================================");
				          }
	    		          else throw new InvalidDateException("Invalid Date entered");

	    		 
	    		  
	    		 }
	    		  else throw new RawMaterialException("Order Id does not exist");

		    	 
	    	 }
	    	catch(RawMaterialException e)
	    	{
	    		System.out.println(e.getMessage());
	    	   
	    	}
	    	catch(InvalidDateException e)
	    	{
	    		System.out.println(e.getMessage());
	    	}
	    	finally
	    	{
	    		 setProcessDate();
	    	}
	    		
	    	
           
    	 
    }
        
    
   public void updateRawMaterialStockDetails()
   {
	       System.out.println("Enter order id ");
		   String id=sc.next();
		   System.out.println("Enter Manufacturing date(dd/MM/yyyy)");
		   String mnf = sc.next();
		   System.out.println("Enter expiry date(dd/MM/yyyy");
		   String exp=sc.next();
		   System.out.println("Enter Quality Check");
	       String qualityCheck=sc.next();	 
		   	
		   	 try
		   	 {  
		   		  if(rawMaterialServiceRef.doesRawMaterialOrderIdExist(id))
		   	      {	   
		   		       
				        Date manufacturingDate=new SimpleDateFormat("dd/MM/yyyy").parse(mnf); 
				        Date expiryDate=new SimpleDateFormat("dd/MM/yyyy").parse(exp);
				        if( rawMaterialServiceRef.validateManufacturingDate(manufacturingDate)&&rawMaterialServiceRef.validateExpiryDate(expiryDate)&&
				        		rawMaterialServiceRef.validateProcessDate(manufacturingDate, expiryDate))
				        {   System.out.println("Old details");
				            String oldDetail=rawMaterialServiceRef.trackRawMaterialOrder(id);
				            System.out.println(oldDetail);
					        System.out.println(rawMaterialServiceRef.updateRawMaterialStock(id,manufacturingDate, expiryDate, qualityCheck));
					        System.out.println("Updated details");
					        System.out.println( rawMaterialServiceRef.trackRawMaterialOrder(id));
					        System.out.println("===================================");
				        }
				        else 
				        	throw new InvalidDateException("Invalid Date");
				       
				        
		   	      }
		   	      else 
		   	    	  throw new RawMaterialException("Order Id does not exist");
		       }
		   	 catch(ParseException e )
		   	 {
		   		 System.out.println("Invali date entered");
		   	 }
		   	 catch(RawMaterialException e)
		   	 {
		   		 System.out.println(e.getMessage());
		   	 }
		   	 catch(InvalidDateException e)
		   	 {
		   		System.out.println(e.getMessage());
		   	 }
		   	 finally
		   	 {
		   		updateRawMaterialStockDetails(); 
		   	 }
   	   
   }
   public void addOrderToStock()
   {
	   System.out.println("Enter order id");
	   String id=sc.next();
	   try
	   {
		   if(rawMaterialServiceRef.doesRawMaterialOrderIdExistInStock(id))
		   {
			   throw new RawMaterialException("This order already exist in stock\n\n");
		   }
		   else if(rawMaterialServiceRef.doesRawMaterialOrderIdExist(id))
		   {
			   String msg=rawMaterialServiceRef.addToStock(id);
			   System.out.println(msg+"\n\n");
		   }
		   else throw new RawMaterialException("Invalid order id \nThis order does not exist\n\n");
	   }
	   catch(RawMaterialException e)
	   {
		   System.out.println(e.getMessage());
	   }
   }
   
}


