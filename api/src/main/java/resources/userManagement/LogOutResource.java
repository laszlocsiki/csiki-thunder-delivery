package resources.userManagement;


import assambler.UserAssembler;
import service.AuthenticationService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = "/logout")
@Produces(MediaType.TEXT_PLAIN)
public class LogOutResource {

    @EJB
    private AuthenticationService authService;

    @EJB
    private UserAssembler userAssembler;

    @GET
    public Response logout(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("username", null);
        return Response.ok("Successful logout!").build();
    }

}
