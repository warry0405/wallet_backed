package dto;

public class LoginResponse {
    private Integer userId;
    private String uuid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LoginResponse(Integer userId, String uuid) {
        this.userId = userId;
        this.uuid = uuid;
    }

    public LoginResponse() {
        super();
    }
}

