package assambler;

import dto.ProductDTO;
import exception.CsikiDeliveryApiException;
import model.Product;

import javax.ejb.Stateless;

@Stateless
public class ProductAssembler extends EntityAssembler<Product, ProductDTO> {

    @Override
    public ProductDTO createDto() {
        return new ProductDTO();
    }

    @Override
    public Product createModel() {
        return new Product();
    }

    @Override
    public ProductDTO modelToDto(Product model) throws CsikiDeliveryApiException {
        final ProductDTO productDto = createDto();
        productDto.setId(model.getId());
        productDto.setName(model.getName());
        productDto.setPrice(model.getPrice());
        productDto.setCategory(model.getCategory());
        productDto.setCode(model.getCode());
        productDto.setAlcoholFree(model.isAlcoholFree());
        return productDto;
    }

    @Override
    public Product dtoToModel(ProductDTO dto) throws CsikiDeliveryApiException {
        final Product product = createModel();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setCode(dto.getCode());
        product.setAlcoholFree(dto.isAlcoholFree());
        return product;
    }

}
