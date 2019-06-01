package com.sellnbuy.payment;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("payments")
public class PaymentResource {
	
	PaymentRepository repo = new PaymentRepository();  

@GET   
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

public List<Payment> getPayments() {
		
	    System.out.println("getPayment called...");
		
	    return repo.getPayments();
}


@GET  
@Path("payment/{id}")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

public Payment getPayment(@PathParam("id") int id)
{
	return repo.getPayment(id);
	
}

	@POST
	@Path("payment") 
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String createPayment(Payment p1)
	{
		Payment p = repo.getPayment(p1.getId());
		
	if(p.getId()==0) {
		System.out.println(p1);
		repo.create(p1);
		return "Successfully added the payment!";
	}
	else {
		
       return "Payment have already done!"; 
	}
	
	}

	@PUT
	@Path("payment") 
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String updatePayment(Payment p1)
	{
		Payment p = repo.getPayment(p1.getId());
		
		if(p.getId()==0) {
			System.out.println(p1);
		
			return "Payment does not exist!";
		}
		else {
			
			repo.update(p1);
			return "Successfully updated!"; 
		}
}
	@DELETE
	@Path("payment/{id}") 
	public String deletePayment(@PathParam("id") int id) {
		
		Payment p = repo.getPayment(id);
		
		if(p.getId()==0) {
			
		
			return "Payment does not exist!";
		}
		else {
			
			repo.delete(id);
			return "Successfully deleted!"; 
		}
		
	}
}