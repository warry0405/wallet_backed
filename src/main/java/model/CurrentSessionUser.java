package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class CurrentSessionUser {
    @Id
    private Integer id;

    @NotNull
    private String mobileNo;

    @NotNull
    @Column(unique = true, nullable = false)
    private String Uuid;

    @ManyToOne
    private User user;

    private LocalDateTime localDateTime;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getUuid() {
        return Uuid;
    }
    public void setUuid(String Uuid) {
        this.Uuid = Uuid;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public CurrentSessionUser(Integer id, String mobileNo, String Uuid, User user, LocalDateTime localDateTime) {
        this.id = id;
        this.mobileNo = mobileNo;
        this.Uuid = Uuid;
        this.user = user;
        this.localDateTime = localDateTime;
    }

    public CurrentSessionUser() {
        super();
    }
}
