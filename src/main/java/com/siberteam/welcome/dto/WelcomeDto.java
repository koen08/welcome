package com.siberteam.welcome.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class WelcomeDto {
    @NotBlank(message = "Поле <user> не может быть пустым")
    @Size(min = 3, message = "Минимальная длина поля <user> 3 символа")
    private String user;
    @NotBlank(message = "Поле <welcomeMessage> не может быть пустым")
    @Size(min = 5, message = "Минимальная длина поля <welcomeMessage> 5 символа")
    private String welcomeMessage;

    public WelcomeDto(String user, String welcomeMessage) {
        this.user = user;
        this.welcomeMessage = welcomeMessage;
    }

    public WelcomeDto(){

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
}
