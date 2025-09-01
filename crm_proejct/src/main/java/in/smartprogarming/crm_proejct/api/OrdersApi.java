package in.smartprogarming.crm_proejct.api;


import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.RazorpayClient;

import in.smartprogarming.crm_proejct.User.UserOrderentity;
import in.smartprogarming.crm_proejct.service.UserOrderservice;



@RestController
@RequestMapping("/api")
public class OrdersApi
{
	@Autowired
	private UserOrderservice userOrderservice;
	
	@PostMapping("/storeOrderDetails")
	public ResponseEntity<String> storeUserOrdersDetails(@RequestBody UserOrderentity orders)
	{
		 Date date = new Date();
	    orders.setCourseId(UUID.randomUUID().toString());
		
		userOrderservice.storeUserOrders(orders);
		return ResponseEntity.ok("Order details stored successfully");
	}
	
	
// 	@PostMapping("/storeOrderDetails")
// 	public ResponseEntity<String> storeUserOrdersDetails(@RequestBody Orders orders) throws RazorpayException
// 	{
// 		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_5MvmFPiJ6ZxL25", "6jNLcgGA06k4ICcgSjEaujjk");

// 		JSONObject orderRequest = new JSONObject();
// 		orderRequest.put("amount", orders.getCourseAmount());
// 		orderRequest.put("currency","INR");
// 		orderRequest.put("receipt", "rcpt_id_"+System.currentTimeMillis());

// 		Order order = razorpayClient.orders.create(orderRequest);
// //		System.out.println(order);
		
// 		String orderId = order.get("id");
// 		orders.setOrderId(orderId);
		
// 		orderService.storeUserOrders(orders);
// 		return ResponseEntity.ok("Order details stored successfully");
// 	}
}