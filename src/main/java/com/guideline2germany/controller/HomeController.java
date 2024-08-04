package com.guideline2germany.controller;

import com.guideline2germany.config.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken);
        model.addAttribute("isAuthenticated", isAuthenticated);

        if (isAuthenticated) {
            logger.info("User authenticated: {}", authentication.getName());
            if (authentication.getPrincipal() instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
                String firstName = userDetails.getFirstName();
                String lastName = userDetails.getLastName();
                logger.info("User details: firstName={}, lastName={}", firstName, lastName);

                model.addAttribute("firstName", firstName);
                model.addAttribute("lastName", lastName);
                model.addAttribute("welcomeMessage", "Welcome to the G2G Application, " + firstName + " " + lastName + "!");
            } else if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String username = userDetails.getUsername();
                logger.info("User details: username={}", username);

                model.addAttribute("firstName", username);
                model.addAttribute("lastName", "");
                model.addAttribute("welcomeMessage", "Welcome to the G2G Application, " + username + "!");
            } else {
                logger.warn("Authentication principal is not an instance of CustomUserDetails or UserDetails");
                model.addAttribute("welcomeMessage", "Welcome to the G2G Application!");
            }
        } else {
            logger.info("User not authenticated");
            model.addAttribute("welcomeMessage", "Welcome to the G2G Application!");
        }
        return "index";
    }
}