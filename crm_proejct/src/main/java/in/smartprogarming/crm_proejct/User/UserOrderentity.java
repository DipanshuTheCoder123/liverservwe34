package in.smartprogarming.crm_proejct.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserOrderentity {
    
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private  String courseName;
  
  private  String Useremail;

  private String  dateofpurches;

  private String rzpPaymentId;
  
  private String courseId;

  private  int  courseAmout;


  public String getCourseId() {
    return courseId;
}

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }




  
  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUseremail() {
        return Useremail;
    }

    public void setUseremail(String Useremail) {
        this.Useremail = Useremail;
    }

    public String getDateofpurches() {
        return dateofpurches;
    }

    public void setDateofpurches(String dateofpurches) {
        this.dateofpurches = dateofpurches;
    }

    public String getRzpPaymentId() {
        return rzpPaymentId;
    }

    public void setRzpPaymentId(String rzpPaymentId) {
        this.rzpPaymentId = rzpPaymentId;
    }

    public int getCourseAmout() {
        return courseAmout;
    }

    public void setCourseAmout(int courseAmout) {
        this.courseAmout = courseAmout;
    }


}
