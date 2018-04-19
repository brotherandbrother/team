package example.controller;

import example.logic.LoginCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class LoginController {


    @RequestMapping(value="/",method = RequestMethod.GET)
    public String sayhello(){
        return "login";
    }
    @RequestMapping(value="login",method=RequestMethod.POST)
    public String login(Model model, // 向前台页面传的值放入model中
                        HttpServletRequest request){ // 从前台页面取得的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String user_name = LoginCheck.check(username, password);
        if(user_name != null && user_name != ""){
            model.addAttribute("msg", user_name);
            return "success";
        }else{
            return "login";
        }

    }

}
