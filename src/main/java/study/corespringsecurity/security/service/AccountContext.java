package study.corespringsecurity.security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import study.corespringsecurity.domain.Account;

@SuppressWarnings("serial")
public class AccountContext extends User {

    private final Account account;

    public AccountContext(Account account, Collection<? extends GrantedAuthority> authorities) {
        super(account.getUsername(), account.getPassword(), authorities);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

}
