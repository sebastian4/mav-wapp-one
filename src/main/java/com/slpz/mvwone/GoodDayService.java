package com.slpz.mvwone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/good")
public class GoodDayService {
    
    @GET
    @Path("/morning/{param}")
    public Response getMorning(@PathParam("param") String msg) {

            String output = "Good Morning " + msg;

            return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/afternoon/{param}")
    public Response getAfternoon(@PathParam("param") String msg) {

            String output = "Good Afternoon " + msg;

            return Response.status(200).entity(output).build();
    }
    
}
