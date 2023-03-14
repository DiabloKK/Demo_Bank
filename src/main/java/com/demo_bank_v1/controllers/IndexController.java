package com.demo_bank_v1.controllers;

import com.demo_bank_v1.repository.UserRepository;
import com.demo_bank_v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        System.out.println("In Index Page Controller");
        return getIndexPage;
    }


    @GetMapping("/error")
    public ModelAndView getError() {
        ModelAndView getErrorPage = new ModelAndView("error");
        System.out.println("In Error Page Controller");
        getErrorPage.addObject("PageTitle", "Errors");
        return getErrorPage;
    }

    @GetMapping("/verify")
    public ModelAndView getVerify(@RequestParam("token")String token, @RequestParam("code")String code) {

        ModelAndView getVerifyPage;

        if(!userService.checkToken(token)) {
            getVerifyPage = new ModelAndView("error");
            getVerifyPage.addObject("error", "This Session Has Expired!");
            return getVerifyPage;
        }

        userService.verifyAccount(token, code);

        getVerifyPage = new ModelAndView("login");

        getVerifyPage.addObject("success", "Account Verified Successfully, Please proceed to Log In!");

        System.out.println("In Verify Account Controller");

        return getVerifyPage;
    }

}
