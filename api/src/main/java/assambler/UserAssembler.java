package assambler;

import dto.UserDTO;
import exception.CsikiDeliveryApiException;
import model.User;

import javax.ejb.Stateless;

@Stateless
public class UserAssembler extends EntityAssembler<User, UserDTO> {

    @Override
    public UserDTO createDto() {
        return new UserDTO();
    }

    @Override
    public User createModel() {
        return new User();
    }

    @Override
    public UserDTO modelToDto(User model) throws CsikiDeliveryApiException {
        final UserDTO userDTO = createDto();
        userDTO.setId(model.getId());
        userDTO.setUsername(model.getUsername());
        userDTO.setPassword(model.getPassword());
        userDTO.setFullName(model.getFullName());
        return userDTO;
    }

    @Override
    public User dtoToModel(UserDTO dto) throws CsikiDeliveryApiException {
        final User user = createModel();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFullName(dto.getFullName());
        return user;
    }

}
