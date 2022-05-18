package site.metacoding.addressapitest.web.dto.addressuser;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import site.metacoding.addressapitest.domain.addressuser.AddressUser;

public class JoinReqDto {
    @Pattern(regexp = "[a-zA-Z0-9]{4,20}", message = "유저네임은 한글이 들어갈 수 없습니다.")
    @Size(min = 4, max = 20)
    @NotBlank
    private String username;

    @Size(min = 4, max = 20)
    @NotBlank
    private String password;

    @Size(min = 8, max = 60)
    @NotBlank // @NotNull, @NotEmpty 두개의 조합
     private String address;


     @Size(min = 8, max = 60)
     @NotBlank // @NotNull, @NotEmpty 두개의 조합
      private String restaddress;

    public AddressUser toEntity() {
        AddressUser addressUser = new AddressUser();
        addressUser.setUsername(username);
        addressUser.setPassword(password);
        addressUser.setAddress(address);
        addressUser.setRestAddress(restaddress);
        
        return addressUser;
    }

}
