package com.wildcodeschool.projectWithSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class indexController {
    private static final String TEMPLATE_INDEX = "/index";
    private static final String TEMPLATE_CHAMPIONS = "/champions";
    private static final String TEMPLATE_DIRECTEUR = "/directeur";

    @GetMapping("/")
    public ModelAndView welcomeShield() {
        return new ModelAndView( TEMPLATE_INDEX );
    }

    @GetMapping("/avengers/assemble")
    public ModelAndView championsShield() {
        return new ModelAndView( TEMPLATE_CHAMPIONS );
    }

    @GetMapping("/secret-bases")
    public ModelAndView directeurShield() {
        return new ModelAndView( TEMPLATE_DIRECTEUR );
    }
}
