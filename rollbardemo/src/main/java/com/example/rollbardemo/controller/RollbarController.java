package com.example.rollbardemo.controller;

import com.rollbar.notifier.Rollbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RollbarController {

 @Autowired
 private Rollbar rollbar;


    @GetMapping("/info")
    public String getInfo(){
     rollbar.info("welcome to domain");
     return "created info in rollback";
    }

    @GetMapping("/errors")
    public String getError(){

     rollbar.error(new RuntimeException("run time exception"));
     return "created error in rollback";
    }

    @GetMapping("/log")
    public String getLog(){
     rollbar.log("this is just a log");
     return "created log in rollback";
    }

      @GetMapping("/debug")
      public String getDebug(){
       rollbar.debug("debugging... ");
       return "debug in rollback";
      }


      @GetMapping("/zero")
    public Integer getZero(){
          int a = 0;
//        rollbar.error(new ArithmeticException("by zero"));
         try{
           a  = 10/2;
             
         }catch (Exception e){
             rollbar.error(e.getMessage());
         }
         return a;
       
      }

      @GetMapping("/null")
    public String getNull(){

        try {
            String s = null;
            rollbar.log("created a String");
            s.length();
            s.charAt(0);
            rollbar.log(" performed opertion on string");

        }
        catch (Exception e){
            rollbar.error(e);
        }
        return "throw null point exception in rollbar";
      }




}
