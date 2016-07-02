package com.metis.avinash.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;

/** Created "V Avinash" 6/1/2016 **/

@Table(name = "header")
public class LoginModel {

    @Expose
    @Column(name = "token")
    public String token;

    public LoginModel(){super();}

    public LoginModel(String token){
        this.token = token;
    }
}
