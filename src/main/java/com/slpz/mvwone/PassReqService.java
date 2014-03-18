package com.slpz.mvwone;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import com.slpz.mvjvutlone.dto.PassReqApi;

@Path("/pass")
public class PassReqService {
    
    Logger log = Logger.getLogger(PassReqService.class.getName());
    
    PassReqApi reqApi = null;
    
    @PostConstruct
    public void initialize() {
        log.debug("initializing");
        reqApi = new PassReqApi();
    }
    
    @GET
    @Path("/passreq/{pid}")
    public Response getMorning(@PathParam("pid") String pid) {
            log.debug("input: "+pid);
            
            String output = reqApi.sendingPost(pid);

            log.debug("output: "+output);
            return Response.status(200).entity(output).build();
    }
    
    @PreDestroy
    public void cleanUp() throws Exception {
	  log.debug("cleaning up");
    }
    
}
