package site.metacoding.addressapitest.domain.addressuser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor


@Entity
@EntityListeners(AuditingEntityListener.class)
public class AddressUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=20, nullable= false, unique=true)
    private String username;
    //1234  ->sha256(hash) ->03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4
    //안그러면 security가 거부함
    @Column(length= 100, nullable= false)
    private String password;
    @Column(length= 60, nullable= false, unique=true)
    private String email;

    @Column(length=150,nullable = false)
    private String address;
    @Column(length = 655,nullable= true)
    private String restaddress;

    @CreatedDate // insert 할때만 동작
    private LocalDateTime createDate;
    @LastModifiedDate // update 할때만 동작
    private LocalDateTime updateDate;
}
