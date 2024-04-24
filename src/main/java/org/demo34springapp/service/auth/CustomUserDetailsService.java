package org.demo34springapp.service.auth;

import org.demo34springapp.repository.ManagerRepository;
import org.demo34springapp.security.ManagerUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ManagerRepository managerRepository;

    @Autowired
    public CustomUserDetailsService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return managerRepository.findByManagerName(username)
                .map(ManagerUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Manager not found with name: " + username));
    }
}

