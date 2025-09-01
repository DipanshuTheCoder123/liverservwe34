package  in.smartprogarming.crm_proejct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import in.smartprogarming.crm_proejct.User.Course;
import in.smartprogarming.crm_proejct.service.Course_service;



@Controller

public class AdminController {
    @Autowired
   private Course_service Course_service;

   
    @GetMapping("/adminlogin")
      public String openAdminlogin()
      {
        return "/Admin/admin-login";
      }


      @GetMapping("/Course-management")
      public String openCoursemangent(Model model) {
      List<Course> getallcourse = Course_service.getallcourse();
         model.addAttribute("allcourse",getallcourse);

        return  "/Admin/Course-management";
      }
      
    
       @PostMapping("/adminprofile")
       public String openAdminProfile(@RequestParam("adminemail") String email ,@RequestParam("adminpass") String password,Model model ) 
       {
           if(email.equals("admin@123")&&password.equals("admin@123")){
                 return "/Admin/admin-profil";
           }else
           {         model.addAttribute("error", "email id is not match ");
                  return "/Admin/admin-login";
           }
       }
     
       @GetMapping("/addcourse")
       public String openAddCoursePaGE(Model model) {
           model.addAttribute("course", new Course());
           return  "/Admin/add-course";
       }

       @PostMapping("/addformdata")
       public String postMethodName( @ModelAttribute("course") Course course , @RequestParam("file1") MultipartFile couseImg ,Model model) {
        
              try {
                    Course_service.addCourse(course,couseImg);  
                    model.addAttribute("success","it add succesfully");
              } catch(Exception e) {
                  e.printStackTrace();
                 model.addAttribute("fail","course not add due to some error");
              }
           return "/Admin/add-course";
       }
       
        
       @GetMapping("/edit-course")
       public String openeditepage() {
           return"/Admin/edit-course";
       }
       @GetMapping("/delete-course")
       public String openDeletPage() {
           return "/Admin/delete-course";
       }
       

    
    
}
