package in.smartprogarming.crm_proejct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.smartprogarming.crm_proejct.User.UserOrderentity;
import in.smartprogarming.crm_proejct.repository.UserOrder;

@Service
public class UserOrderservice {
    
      @Autowired
     private UserOrder userOrder;


     public void      storeUserOrders(UserOrderentity userOrderentity )
     {

          userOrder.save(userOrderentity);

     }

    
 


}
