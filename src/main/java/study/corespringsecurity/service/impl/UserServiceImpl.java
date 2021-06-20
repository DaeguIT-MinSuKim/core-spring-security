package study.corespringsecurity.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.corespringsecurity.domain.Account;
import study.corespringsecurity.repository.UserRepository;
import study.corespringsecurity.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    @Override
    public void createUser(Account account) {
        userRepository.save(account);
    }

}
