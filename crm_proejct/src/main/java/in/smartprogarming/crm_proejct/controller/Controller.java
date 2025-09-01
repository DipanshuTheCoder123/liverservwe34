package in.smartprogarming.crm_proejct.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import in.smartprogarming.crm_proejct.User.Course;
import in.smartprogarming.crm_proejct.User.User;
import in.smartprogarming.crm_proejct.repository.User_Repository;
import in.smartprogarming.crm_proejct.service.Course_service;
import in.smartprogarming.crm_proejct.service.User_service;
import jakarta.servlet.http.HttpSession;







@org.springframework.stereotype.Controller
@SessionAttributes("session_user")
public class Controller {
    
   @Autowired
   private  User_service user_service;

   @Autowired
   private User_Repository User_Repository;

   @Autowired
  private Course_service course_service;

   @GetMapping({"/","/index"})
    public String openindxpage(Model model)
    {
      List<Course> getallcourse = course_service.getallcourse();

      model.addAttribute("allcource", getallcourse);
      
        return "index";
    }
      //-----login start --------------
    @GetMapping("/login")
    public String openLoginPage(Model model)
    {
         model.addAttribute("user_object",new User());
       return "login";
    }

    // @GetMapping("/user_profile")
    // public String getMethodName(@RequestParam String param) {
    //     return "user_profile";
    // }
    

    @PostMapping("/user_login1")
    public String postMethodName(@ModelAttribute("user_object") User user,Model model) {
        
      boolean  b=   user_service.CheckLoginUser(user.getEmail(), user.getPassword());

       if(b){
         User authanticaluser = User_Repository.findByEmail(user.getEmail());
        model.addAttribute("session_user", authanticaluser);
        return "user_profile";
       }
       model.addAttribute("error_show", "incorrect email and password");
       return  "login";

    } 
    

     // -----------login end --------------

     
     
     // ------------register start ----------
    @GetMapping("/Register")
    public String openRegisterpage(Model model)
    {
      
     model.addAttribute("user_obj", new User());
       return "Register";
    }

    @PostMapping("/Register_form")
    public String OpenRegisterForm(@ModelAttribute("user_obj") User user ,Model model) {
       
      user_service.saveRegistrPage(user);
       
      model.addAttribute("user_register", "Register sussfully");
      return "Register";
      
    }
    
   //-----------register end ------------------------- 



   @GetMapping("/logout")
   public String User_logout(HttpSession session) {
        session.invalidate();
       return  "login";
   }



   @GetMapping("/mycourse")
   public String opencoursepage() {
       return "my-corse";
   }
   
   
}
