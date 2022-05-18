package site.metacoding.addressapitest.service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.addressapitest.domain.addressuser.AddressUser;
import site.metacoding.addressapitest.domain.addressuser.AddressUserRepository;

@RequiredArgsConstructor
@Service
public class AddressUserService {
    private final AddressUserRepository addressUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void 회원가입(AddressUser addressUser){
        String rawPassword = addressUser.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        addressUser.setPassword(encPassword);

        addressUserRepository.save(addressUser);
    
    }
}