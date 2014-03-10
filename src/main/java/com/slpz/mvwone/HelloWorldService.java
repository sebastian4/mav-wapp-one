package com.slpz.mvwone;
 
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import com.slpz.mvjvutlone.Something;

@Path("/hello")
public class HelloWorldService {

    Logger log = Logger.getLogger(HelloWorldService.class.getName());
    
    @PostConstruct
    public void initializing() {
        log.debug("initializing()");
    }
    
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

            log.debug("getMsg("+msg+")");
            
            String output = "Jersey say : " + msg + " ... " + Something.saySomething();

            return Response.status(200).entity(output).build();
    }
 
    @PreDestroy
    public void cleanUp() throws Exception {
	  log.debug("cleanUp()");
    }
    
}