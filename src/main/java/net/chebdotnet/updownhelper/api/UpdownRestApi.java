package net.chebdotnet.updownhelper.api;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface UpdownRestApi {

    @GET
    @Path("/api/checks")
    @Produces(APPLICATION_JSON)
    List<UpdownBean> fetchStatuses();

}
