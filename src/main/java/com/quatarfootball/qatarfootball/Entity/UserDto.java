package com.quatarfootball.qatarfootball.Entity;

public class UserDto {
    private String username;
    private String password;
    private String FamName;
    private String Name;
    private String Country;
    private Long Age;
    private String email;
    private String tel;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setFamName(String famName) {
        FamName = famName;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setAge(Long age) {
        Age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



    public String getFamName() {
        return FamName;
    }

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }

    public Long getAge() {
        return Age;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }
}
