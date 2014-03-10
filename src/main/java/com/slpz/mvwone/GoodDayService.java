package com.slpz.mvwone;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

@Path("/good")
public class GoodDayService {
    
    Logger log = Logger.getLogger(GoodDayService.class.getName()); 
    
//    @Context 
//    ServletContext sc; 

//    public GoodDayService() {
//        System.out.println("GoodDayService()");
//    }
    
    @PostConstruct
    public void initializing() {
        log.debug("initializing()");
    }
    
    @GET
    @Path("/morning/{param}")
    public Response getMorning(@PathParam("param") String msg) {
            
            log.debug("getMorning("+msg+")");
            
            String output = "Good Morning " + msg;

            return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/afternoon/{param}")
    public Response getAfternoon(@PathParam("param") String msg) {

            log.debug("getAfternoon("+msg+")");
            
            String output = "Good Afternoon " + msg;

            return Response.status(200).entity(output).build();
    }
    
    @PreDestroy
    public void cleanUp() throws Exception {
	  log.debug("cleanUp()");
    }
    
}
