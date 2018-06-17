package dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO extends AbstractDTO {

    private long id;
    private String username;
    private String fullName;
    private String password;

    public UserDTO() {
    }

    public UserDTO(long id, String username, String fullName, String password) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

