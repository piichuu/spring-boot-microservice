package com.example.microserviceexample;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParser;
import org.json.JSONObject;
import org.json.JSONString;

class User {
    //to improve: encrypt passwords instead of plaintext
    //to improve: store users in db and check if UUID or username has already been assigned, can use JPA repo?
    private String uuid;
    private String username;
    private String password;
    private String ip;
    private String city;

    User (String username, String password, String ip) throws IllegalArgumentException {
        this.city = "None"; //will be set while validating ip address
        //Validate parameters
        if(username == null || password == null || ip == null)
            throw new IllegalArgumentException("Invalid parameters: Please include Username, Password, and IP address.");
        if(!validPassword(password))
            throw new IllegalArgumentException("Invalid password: Requires >8 characters, 1 number, 1 capital letter, 1 special character in set ( _ # $ % . )");
        if(!validIpAddress(ip))
            throw new IllegalArgumentException("Invalid IP Address: Must be a well-formatted ipv4 in Canada.");
            this.username = username;
        this.password = password;
        this.ip = ip;
        this.uuid = UUID.randomUUID().toString();
        System.out.println("Welcome! " + this.toString());
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
        //Won't return password as plaintext here. Only UUID, username, IP address, city.
        return "Username: " + this.username + ", City: " + this.city + ", UUID: " + this.uuid;
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

    public boolean validIpAddress(String ip) {
        //must be properly formatted IP
        String regex = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        //must be from Canada according to IP-API.com - Geolocation API - Documentation - JSON
        String json = new RestTemplate().getForObject("http://ip-api.com/json/" + ip, String.class);
        JSONObject jsonObject = new JSONObject(json);
        String country = "None";
        try {
            country = jsonObject.getString("country");
            this.city = jsonObject.getString("city");
        }
        catch (Exception e) { //the IP address has no country/city (private IP address)
            return false;
        }

        return matcher.matches() && country.equalsIgnoreCase("Canada");
    }
}
