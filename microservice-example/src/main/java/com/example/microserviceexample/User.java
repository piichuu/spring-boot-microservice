package com.example.microserviceexample;

import java.util.Objects;
import java.util.UUID;

class User {
    //TO DO: get user's city based on IP address
    //TO DO: verify user's ip address is in Canada
    //to improve: encrypt passwords instead of plaintext
    //to improve: store users and check if UUID or username has already been assigned, can use JPA repo
    private UUID uuid;
    private String username;
    private String password;
    private String ip;

    User (String username, String password, String ip) {
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.uuid = UUID.randomUUID();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getIp() {
        return this.ip;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUsername(String newName) {
        this.username = newName;
    }

    public void setPassword(String newPass) {
        this.password = newPass;
    }

    public void setIp(String newIp) {
        this.ip = newIp;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        User user = (User) o;
        return Objects.equals(this.username, user.username) && Objects.equals(this.password, user.password) 
            && Objects.equals(this.ip, user.ip) && Objects.equals(this.uuid, user.uuid);
    }

    @Override
    public String toString() {
        //Won't return password as plaintext here. Only UUID, username and IP address.
        return "User{" + "uuid=" + this.uuid + ", username=" + this.username + ", ip=" + this.ip + "}";
    }
}
