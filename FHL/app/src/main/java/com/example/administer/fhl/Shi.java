package com.example.administer.fhl;

import java.util.ArrayList;

/**
 * Created by Administer on 2018/3/27.
 */

public class Shi {
    String name;
    String author;
    ArrayList<String> Line;

    public Shi(){

    }

    public Shi(String name,String author,ArrayList<String> line){
        this.name = name;
        this.author = author ;
        this.Line = line;
    }

    public String getname()
    {
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public ArrayList<String> gwtLine(){
        return Line;
    }



}
