package com.metis.avinash.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;

/**
 * Created by avinash on 7/2/16.
 */

@Table(name = "posts")
public class PostModel {

//    @Expose
//    @Column(name = "id")
//    public long id;

    @Expose
    @Column(name = "user")
    public String user;

    @Expose
    @Column(name = "institute")
    public String institute;

    @Expose
    @Column(name = "title")
    public String title;

    @Expose
    @Column(name = "content")
    public String content;

    @Expose
    @Column(name = "image")
    public String image;

//    public PostModel(){
//        super();
//    }
//
//    public PostModel(long id, String user, String institute, String title, String content, String image){
//        this.id = id;
//        this.user = user;
//        this.institute = institute;
//        this.title = title;
//        this.content = content;
//        this.image = image;
//    }
}
