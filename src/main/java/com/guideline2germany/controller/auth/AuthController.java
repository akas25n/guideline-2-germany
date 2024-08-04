package com.guideline2germany.controller.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthenticationService authenticationService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(RegisterRequest request, Model model) {
        AuthenticationResponse response = authenticationService.register(request);
        model.addAttribute("token", response.getToken());
        return "redirect:/api/auth/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("authenticationRequest", new AuthenticationRequest());
        return "auth/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("authenticationRequest") AuthenticationRequest request,
                            HttpServletResponse response, HttpServletRequest httpRequest) {
        try {
            logger.info("Attempting login for user: {}", request.getEmail());
            AuthenticationResponse authResponse = authenticationService.login(request);

            // Set JWT token in a cookie
            Cookie jwtCookie = new Cookie("jwt", authResponse.getToken());
            jwtCookie.setHttpOnly(true);
            jwtCookie.setPath("/");
            jwtCookie.setMaxAge(24 * 60 * 60); // 24 hours
            response.addCookie(jwtCookie);

            logger.info("Login successful for user: {}", request.getEmail());
            return "redirect:/api/home";
        } catch (Exception e) {
            logger.error("Login failed for user: {}", request.getEmail(), e);
            return "redirect:/api/auth/login?error";
        }
    }
}