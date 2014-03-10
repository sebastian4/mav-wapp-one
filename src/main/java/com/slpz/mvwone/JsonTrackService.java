package com.slpz.mvwone;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.slpz.mvjutlone.Track;
import javax.ws.rs.PathParam;
import org.apache.log4j.Logger;

@Path("/json/track")
public class JsonTrackService {
    
    Logger log = Logger.getLogger(JsonTrackService.class.getName());
    
    @PostConstruct
    public void initializing() {
        log.debug("initializing()");
    }
    
    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON(@PathParam("name") String name) {

            log.debug("getTrackInJSON("+name+")");
            
            Track track = new Track();
            track.setTitle("Enter Sandman");
            track.setSinger(name);

            return track;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track) {

            log.debug("createTrackInJSON("+track+")");
            
            String result = "Track saved : " + track;
            return Response.status(201).entity(result).build();
    }
    
    @PreDestroy
    public void cleanUp() throws Exception {
	  log.debug("cleanUp()");
    }
    
}
