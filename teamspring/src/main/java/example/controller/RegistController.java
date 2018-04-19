package example.controller;

import example.logic.RegistCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


    @Controller
    @RequestMapping("admin")
    public class RegistController {
        @RequestMapping(value="regist",method=RequestMethod.GET)
        public String regist(){
            return "regist";
        }

        @RequestMapping(value="registSuccess",method=RequestMethod.POST)
        public String registSuccess(HttpServletRequest request, Model model){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String age = request.getParameter("age");

            if(RegistCheck.registCheck(username, password,age)){
                model.addAttribute("username", username);
                return "registsuccess";
            }else{
                return "login";
            }
        }
    }
