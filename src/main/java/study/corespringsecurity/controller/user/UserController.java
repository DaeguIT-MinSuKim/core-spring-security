package study.corespringsecurity.controller.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import study.corespringsecurity.domain.Account;
import study.corespringsecurity.domain.AccountDto;
import study.corespringsecurity.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping(value="/mypage")
    public String myPage() throws Exception{
        return "user/mypage";
    }
    
    @GetMapping("/users")
    public String createUser() {
        return "user/login/register";
    }
    
    @PostMapping("/users")
    public String createUser(AccountDto accountDto) {
        
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class); //AccountDto -> Account로 매핑
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userService.createUser(account);
        
        return "redirect:/";
    }
}
