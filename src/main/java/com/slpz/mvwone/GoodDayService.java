package com.slpz.mvwone;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import com.slpz.mvjvutlone.dto.GoodDayApi;

@Path("/good")
public class GoodDayService {
    
    Logger log = Logger.getLogger(GoodDayService.class.getName());
    
    GoodDayApi goodDayApi = null;
    
//    @Context 
//    ServletContext sc; 

//    public GoodDayService() {
//        System.out.println("GoodDayService()");
//    }
    
    @PostConstruct
    public void initialize() {
        log.debug("initializing");
        goodDayApi = new GoodDayApi();
    }
    
    @GET
    @Path("/morning/{param}")
    public Response getMorning(@PathParam("param") String msg) {
            log.debug("input: "+msg);
            
            String output = goodDayApi.getMorning(msg);

            log.debug("output: "+output);
            return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/afternoon/{param}")
    public Response getAfternoon(@PathParam("param") String msg) {
            log.debug("input: "+msg);
            
            String output = goodDayApi.getAfternoon(msg);

            log.debug("output: "+output);
            return Response.status(200).entity(output).build();
    }
    
    @PreDestroy
    public void cleanUp() throws Exception {
	  log.debug("cleaning up");
    }
    
}
