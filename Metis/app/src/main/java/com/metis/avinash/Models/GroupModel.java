package com.metis.avinash.Models;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;

/**
 * Created by avinash on 6/5/16.
 */

@Table(name = "group")
public class GroupModel {

    @Expose
    @Column(name = "name")
    public String name;

    @Expose
    @Column(name = "owner")
    public String owner;


}
