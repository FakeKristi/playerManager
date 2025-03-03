package com.kristian.d2025021701;

import java.time.LocalDate;

public class Player {
    private String username;
    private int level;
    private PlayerClass playerClass;
    private String email;
    private LocalDate registered;

    public Player(String username, int level, PlayerClass playerClass, String email, LocalDate registered) {
        this.username = username;
        this.level = level;
        this.playerClass = playerClass;
        this.email = email;
        this.registered = registered;
    }
    public Player(String username, String email) {
        this.username = username;
        this.email = email;
        this.registered = LocalDate.now();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    @Override
    public String toString() {

        return username + (registered.getYear() + 1 >= LocalDate.now().getYear() ? "" : "*");
    }
}
