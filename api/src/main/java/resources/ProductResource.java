package resources;

import assambler.ProductAssembler;
import dto.ProductDTO;
import exception.CsikiDeliveryApiException;
import model.Product;
import service.AuthenticationService;
import service.ProductService;
import service.ServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Path(value = "/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @EJB
    private ProductService productService;

    @EJB
    private ProductAssembler productAssembler;

    @EJB
    private AuthenticationService authService;

    @GET
    public Response getProducts(@Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            List<Product> products = productService.findAllProduct();
            List<ProductDTO> productDtos = products.stream().map(p -> productAssembler.modelToDto(p)).collect(Collectors.toList());
            return Response.ok(productDtos).build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }

    @GET
    @Path("/category/{categoryName}")
    public Response getProductsByCategory(@PathParam("categoryName") String categoryName, @Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            List<Product> products = productService.findAllProductOfCategory(categoryName);
            List<ProductDTO> productDtos = products.stream().map(p -> productAssembler.modelToDto(p)).collect(Collectors.toList());
            return Response.ok(productDtos).build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }
}

