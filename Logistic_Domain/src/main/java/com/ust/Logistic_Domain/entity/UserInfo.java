package com.ust.Logistic_Domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Table(name="user")
@Entity
public class UserInfo {

    @Id
    @JsonProperty("userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @JsonProperty("name")
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name;

    @JsonProperty("password")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @JsonProperty("email")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @JsonProperty("contact")
    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Contact number should be valid and contain 10 to 15 digits")
    private String contact;

    @JsonProperty("role")
    @NotBlank(message = "Roles cannot be blank")
    @Pattern(regexp = "^(ROLE_ADMIN|ROLE_USER)$", message = "Role must be one of ROLE_ADMIN or ROLE_USER")
    private String role;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public @NotBlank(message = "Roles cannot be blank") @Pattern(regexp = "^(ROLE_ADMIN|ROLE_USER)$", message = "Role must be one of ROLE_ADMIN or ROLE_USER") String getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "Roles cannot be blank") @Pattern(regexp = "^(ROLE_ADMIN|ROLE_USER)$", message = "Role must be one of ROLE_ADMIN or ROLE_USER") String role) {
        this.role = role;
    }

    public UserInfo(Long userId, String name,String password, String email, String contact, String role) {
        this.userId = userId;
        this.name = name;
        this.password=password;
        this.email = email;
        this.contact = contact;
        this.role = role;
    }

    public UserInfo() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
