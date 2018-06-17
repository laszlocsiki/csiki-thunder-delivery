package resources.userManagement;

import assambler.UserAssembler;
import dto.UserDTO;
import exception.CsikiDeliveryApiException;
import model.User;
import service.AuthenticationService;
import service.ServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = "/signIn")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class SignInResource {

    @EJB
    private AuthenticationService authService;

    @EJB
    private UserAssembler userAssembler;

    @POST
    public Response signin(UserDTO userDto, @Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            final User user = userAssembler.dtoToModel(userDto);
            authService.register(user);

            HttpSession session = request.getSession();
            session.setAttribute("username", userDto.getUsername());

            return Response.ok("User registered successfully!").build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage());
        }
    }
}
