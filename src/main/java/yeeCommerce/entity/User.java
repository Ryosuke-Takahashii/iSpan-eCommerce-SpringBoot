package yeeCommerce.entity;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Integer memberId;
    
    private String username;
    
    private String email;
    
    private String password;
    
    private String fullName;
    
    private String phone;
    
    @Lob
    private byte[] userPhoto;  // varbinary(max) 對應 byte[]

    private String address;
}

