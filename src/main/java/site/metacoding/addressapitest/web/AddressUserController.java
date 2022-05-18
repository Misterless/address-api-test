package site.metacoding.addressapitest.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import site.metacoding.addressapitest.handler.ex.CustomException;
import site.metacoding.addressapitest.service.AddressUserService;

public class AddressUserController {
    
    private final AddressUserService addressUserService;

    @GetMapping("/login-form")
    public String loginForm() {
        return "/user/loginForm";
    }
    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/joinForm";
    }
    @PostMapping("/join")
    public String join(@Valid JoinReqDto joinReqDto, BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();    
        
            for (FieldError fe :bindingResult.getFieldErrors()) {
                System.out.println(fe.getField());
                System.out.println(fe.getDefaultMessage());
            }
            throw new CustomException(errorMap.toString());       
            }
            // core logic
            addressUserService.회원가입(joinReqDto.toEntity());

        return "redirect:/login-form";
        }
}
