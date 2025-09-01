package in.smartprogarming.crm_proejct.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String description;
    private String orignalprice;
    private  String discountprice;
    private String image_url;
   private  String  updateon;
   public Long getId() {
    return id;
   }
   public void setId(Long id) {
    this.id = id;
   }
   public String getName() {
    return name;
   }
   public void setName(String name) {
    this.name = name;
   }
   public String getDescription() {
    return description;
   }
   public void setDescription(String description) {
    this.description = description;
   }
   public String getOrignalprice() {
    return orignalprice;
   }
   public void setOrignalprice(String orignalprice) {
    this.orignalprice = orignalprice;
   }
   public String getDiscountprice() {
    return discountprice;
   }
   public void setDiscountprice(String discountprice) {
    this.discountprice = discountprice;
   }
   public String getImage_url() {
    return image_url;
   }
   public void setImage_url(String image_url) {
    this.image_url = image_url;
   }
   public String getUpdateon() {
    return updateon;
   }
   public void setUpdateon(String updateon) {
    this.updateon = updateon;
   }

 


}
