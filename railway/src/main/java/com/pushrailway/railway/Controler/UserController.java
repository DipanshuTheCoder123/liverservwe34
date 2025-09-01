package com.pushrailway.railway.Controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @GetMapping({"/","/index"})
   public String printmessageonpage()
   {
    return "hello i am dipanshu ";
   }

}
