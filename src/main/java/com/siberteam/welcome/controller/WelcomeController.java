package com.siberteam.welcome.controller;

import com.siberteam.welcome.dto.ErrorResponse;
import com.siberteam.welcome.dto.WelcomeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    private static final int FIRST_ERROR_REQUEST = 0;

    @GetMapping("/hello/valid")
    @ResponseBody
    public ResponseEntity<?> getWelcomeMessageValid(@Valid @ModelAttribute WelcomeDto welcomeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(new ErrorResponse(bindingResult.getFieldErrors().get(FIRST_ERROR_REQUEST).getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new WelcomeDto(welcomeDto.getUser(), welcomeDto.getWelcomeMessage()), HttpStatus.OK);
    }

    @GetMapping("/hello/page")
    public String getWelcomeMessage(@RequestParam(required = false) String user, String welcomeMessage, Model model,
                                    HttpServletResponse response) throws IOException {
        if (user == null || welcomeMessage == null) {
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
        model.addAttribute("user", user);
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "welcome";
    }

    @GetMapping("/hello")
    @ResponseBody
    public ResponseEntity<WelcomeDto> getWelcomeMessage(@RequestParam(required = false) String user, String welcomeMessage) {
        if (user == null || welcomeMessage == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new WelcomeDto(user, welcomeMessage), HttpStatus.OK);
    }

    @GetMapping("/")
    public String getIndexHtml() {
        return "index";
    }
}
