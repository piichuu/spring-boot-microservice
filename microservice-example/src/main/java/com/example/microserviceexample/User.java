package com.example.microserviceexample;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
//import javax.persistence.Entity;
//import javax.persistence.Id;
import java.util.regex.Pattern;

//@Entity 
class User {
    //TO DO: get user's city based on IP address
    //TO DO: verify user's ip address is in Canada
    //to improve: encrypt passwords instead of plaintext
    //to improve: store users in db and check if UUID or username has already been assigned, can use JPA repo?
    private String uuid;
    private String username;
    private String password;
    private String ip;

    User (String username, String password, String ip) throws IllegalArgumentException {
        if(username == null || password == null || ip == null)
            throw new IllegalArgumentException("Invalid parameters: Please include Username, Password, and IP address.");
        if(!validPassword(password))
            throw new IllegalArgumentException("Invalid password: Requires >8 characters, 1 number, 1 capital letter, 1 special character in set ( _ # $ % . )");
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.uuid = UUID.randomUUID().toString();
        System.out.println("Testing API input: " + this.toString());
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

    public String getUuid() {
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

    public boolean validPassword(String password) {
        //Requires >8 chars, 1 number, 1 capital letter, 1 special character in set ( _ # $ % . )
        boolean hasLength = password.length() > 8;
        boolean hasNumber = false;
        boolean hasCapital = false;
        Pattern specials = Pattern.compile("[_#$%.]");
        Matcher hasSpecial = specials.matcher(password);
        for(int i = 0; i < password.length(); i++) {
            if(Character.isDigit(password.charAt(i)))
                hasNumber = true;
            else if(Character.isUpperCase(password.charAt(i)))
                hasCapital = true;
        }
        return hasNumber && hasCapital && hasSpecial.find() && hasLength;
    }
}
