package com.siberteam.welcome.dto;

public class WelcomeDto {
    private String user;
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
