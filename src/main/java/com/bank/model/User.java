package com.bank.model;

public class User {

    private  String name;
    private  String nationalId;


    public  User(String name, String nationalId){
        this.name = name;
        this.nationalId = nationalId;

    }

    public String getName(){
        return  name;
    }

    public  String getNationalId(){
        return nationalId;
    }
}
