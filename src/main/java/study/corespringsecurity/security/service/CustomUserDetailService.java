package study.corespringsecurity.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import study.corespringsecurity.domain.Account;
import study.corespringsecurity.repository.UserRepository;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = userRepository.findByUsername(username);
        
        if (account == null) {
                throw new UsernameNotFoundException("No user found with username: " + username);            
        }

        // 권한
        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(account.getRole()));

        return new AccountContext(account, roles);

    }

}
