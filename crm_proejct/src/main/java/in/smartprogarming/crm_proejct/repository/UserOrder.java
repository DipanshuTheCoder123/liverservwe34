package in.smartprogarming.crm_proejct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.smartprogarming.crm_proejct.User.UserOrderentity;

public interface  UserOrder  extends  JpaRepository< UserOrderentity, Long>
 {

    
    
}
