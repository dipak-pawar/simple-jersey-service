package com.example;


import com.example.db.DBOperations;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/{id}")
public class Expander {

    @GET
    @Produces("text/html")
    public Response getUrl(@PathParam("id") String id) throws Exception {
        DBOperations dbOperations = new DBOperations();
        final String url = dbOperations.getUrl(id);
        System.out.println("url" + url);
        return Response.temporaryRedirect(new URI(url)).build();
    }
}
