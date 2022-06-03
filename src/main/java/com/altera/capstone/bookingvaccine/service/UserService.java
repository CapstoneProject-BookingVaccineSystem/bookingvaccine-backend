package com.altera.capstone.bookingvaccine.service;

import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
import com.altera.capstone.bookingvaccine.domain.payload.UsernamePassword;
import com.altera.capstone.bookingvaccine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
// implements UserDetailsService
public class UserService {
    private final UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDao user = userRepository.getDistinctTopByUsername(username);
//        if(user == null)
//            throw new UsernameNotFoundException("Username not found");
//
//        return user;
//    }
        public UserDao register(UsernamePassword req){
        UserDao user = new UserDao();
        if(req.getRoles() == null){
            req.setRoles("USER");
        }
        user.setUsername(req.getUsername());
//        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setPassword((req.getPassword()));
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setBirthDate(req.getBirthDate());
        user.setGender(req.getGender());
        user.setEmail(req.getEmail());
        user.setNoHandphone(req.getNoHandphone());
        user.setRoles(req.getRoles());
        return userRepository.save(user);
    }
}
