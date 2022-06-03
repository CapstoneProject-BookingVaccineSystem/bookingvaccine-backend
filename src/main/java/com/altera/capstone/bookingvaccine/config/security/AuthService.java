//package com.altera.capstone.bookingvaccine.config.security;
//
//import com.altera.capstone.bookingvaccine.domain.dao.UserDao;
//import com.altera.capstone.bookingvaccine.domain.payload.TokenResponse;
//import com.altera.capstone.bookingvaccine.domain.payload.UsernamePassword;
//import com.altera.capstone.bookingvaccine.repository.UserRepository;
//import com.altera.capstone.bookingvaccine.util.BadRequestException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Log4j2
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//    private final UserRepository userRepository;
//    private final AuthenticationManager authenticationManager;
//    private final JwtTokenProvider jwtTokenProvider;
//    private final PasswordEncoder passwordEncoder;
//
//    public void validateUsernameAsNIK(@RequestBody UserDao req) throws BadRequestException {
//        // validasi input username as NIK harus 13 digit
//        if(req.getUsername().length() != 13) throw new BadRequestException("NIK kamu salah, mohon periksa kembali");
//        // validasi register harus angka
//        if(!req.getUsername().matches("[0-9]*")) throw new BadRequestException("NIK harus berupa angka");
//    }
//
//    public UserDao register(UserDao req){
//        UserDao user = new UserDao();
//        user.setUsername(req.getUsername()); //nik_as_username
//        user.setPassword(passwordEncoder.encode(req.getPassword()));
//        user.setFirstName(req.getFirstName());
//        user.setLastName(req.getLastName());
//        user.setBirthDate(req.getBirthDate());
//        user.setGender(req.getGender());
//        user.setEmail(req.getEmail());
//        user.setNoHandphone(req.getNoHandphone());
//        user.setRoles(req.getRoles());
//        return userRepository.save(user);
//    }
//
//    public TokenResponse generateToken(UsernamePassword req) {
//        try{
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            req.getUsername(),
//                            req.getPassword())
//            );
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            String jwt = jwtTokenProvider.generateToken(authentication);
//            TokenResponse tokenResponse = new TokenResponse();
//            tokenResponse.setToken(jwt);
//            return tokenResponse;
//        }catch (BadCredentialsException e){
//            log.error("Bad Credential", e);
//            throw new RuntimeException(e.getMessage(), e);
//        }catch (Exception e){
//            log.error(e.getMessage(), e);
//            throw new RuntimeException(e.getMessage(), e);
//        }
//    }
//
////    public TokenResponse generateToken2(String username, String password) {
////        try {
////            Authentication authentication = authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(
////                            username, password
////
////                    )
////            );
////            SecurityContextHolder.getContext().setAuthentication(authentication);
////            String jwt = jwtTokenProvider.generateToken(authentication);
////            TokenResponse tokenResponse = new TokenResponse();
////            tokenResponse.setToken(jwt);
////            return tokenResponse;
////
////        } catch (BadCredentialsException e) {
////
////            log.error("Bad credential", e);
////            throw new RuntimeException(e.getMessage(), e);
////        } catch (Exception e) {
////            log.error(e.getMessage(), e);
////            throw new RuntimeException(e.getMessage(), e);
////
////        }
////    }
//}