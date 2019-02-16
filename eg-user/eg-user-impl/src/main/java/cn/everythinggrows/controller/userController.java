package cn.everythinggrows.controller;


import cn.everythinggrows.Utils.egResponse;
import cn.everythinggrows.model.egUser;
import cn.everythinggrows.service.userService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;


@Controller
public class userController {

    @Autowired
    private userService userService;


    private Logger logger = LoggerFactory.getLogger(userController.class);

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public egResponse Register(@Context HttpServletRequest request){
       String email = request.getParameter("email");
       String password = request.getParameter("password");
       String verify = request.getParameter("verify");
       egUser user = new egUser();
       user.setEmail(email);
       user.setPassword(password);
       egResponse ret = userService.createUser(user,verify);
       return ret;
       }
}
