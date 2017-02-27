package com.example;

import com.example.db.DBOperations;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("short")
public class Shortner {

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public UrlMapper postAndReturnIt(@FormParam("url") String url) throws Exception {

        System.out.println(url);
        DBOperations dbOperations = new DBOperations();
        String shortURL;
        if (dbOperations.isUrlPresent(url)) {
            shortURL =  dbOperations.getShortUrl(url);
        } else {
            final int lastKey = dbOperations.getLastKey();
            System.out.println(lastKey);
            shortURL = Utils.base62(lastKey);
            System.out.println("before save" + shortURL);
            dbOperations.saveUrl(url, shortURL);
            System.out.println("after save");
        }

        UrlMapper mapper = new UrlMapper();

        mapper.setShorturl(shortURL);
        mapper.setUrl(url);
        return mapper;
    }



}
