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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Path(value = "/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @EJB
    private AuthenticationService authService;

    @EJB
    private UserAssembler userAssembler;

    @GET
    public Response getUsers(@Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if ((username != null) && (authService.findByUsername(username) != null)) {
                List<User> users = authService.findAllUsers();
                List<UserDTO> userDtos = users.stream().map(p -> userAssembler.modelToDto(p)).collect(Collectors.toList());
                return Response.ok(userDtos).build();
            } else {
                throw new CsikiDeliveryApiException("Please login first!");
            }
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }

    }
}