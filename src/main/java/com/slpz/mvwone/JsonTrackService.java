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
import javax.ws.rs.PathParam;
import org.apache.log4j.Logger;
import com.slpz.mvjvutlone.model.Track;
import com.slpz.mvjvutlone.dto.TrackDto;

@Path("/track")
public class JsonTrackService {
    
    Logger log = Logger.getLogger(JsonTrackService.class.getName());
    TrackDto trackDto = null;
    
    @PostConstruct
    public void initialize() {
        log.debug("initializing");
        trackDto = new TrackDto();
    }
    
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON(@PathParam("name") String name) {
            log.debug("input:"+name);
            
            Track track = trackDto.getTrackInJSON(name);

            log.debug("output: "+track);
            return track;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track) {
            log.debug("input: "+track);
            
            String result = trackDto.createTrackInJSON(track);
            
            log.debug("output: "+result);
            return Response.status(201).entity(result).build();
    }
    
    @PreDestroy
    public void cleanUp() throws Exception {
	  log.debug("cleaning up");
    }
    
}
