package com.nocountry.c1424mjava.service;

import com.nocountry.c1424mjava.dto.UserDto;
import com.nocountry.c1424mjava.model.User;
import com.nocountry.c1424mjava.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Secured("ROLE_ADMIN")
public class AdminService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /*
    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
     */

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByEmail(email);
        if (optional.isPresent()){
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_ADMIN");
            permisos.add(p);
            return new org.springframework.security.core.userdetails.User(optional.get().getEmail(), optional.get().getPassword(), permisos);
        }
        else{

            throw new InternalAuthenticationServiceException("Usuario o contraseña incorrectos. Por favor, intenta nuevamente");
        }
    }

    /*
    public List<UserDto> getAll(){
        return userRepository.findAll()
                .stream()
                .filter(User::getActive)
                .map(UserMapper::convertEntityToDTO)
                .collect(Collectors.toList());

    }

    public List<UserDto> getAllDisabled(){
        return userRepository.findAll()
                .stream()
                .filter(Admin-> !Admin.getActive())
                .map(UserMapper::convertEntityToDTO)
                .collect(Collectors.toList());

    }
    public UserDto getAdminById(Long id){
        Optional<User>optionalAdmin= userRepository.findById(id);
        if (optionalAdmin.isPresent()&&optionalAdmin.get().getActive()){
            return UserMapper.convertEntityToDTO(optionalAdmin.get());
        }else {
            throw new ExceptionRequest("INGRESA UN ID VALIDO POR FAVOR");

        }
    }
    @Transactional
    public UserDto save(UserDto userDTO){
        if (userDTO.getId() == null && userDTO.getName() != null && userDTO.getMail() != null && userDTO.getPassword() != null )  {
            // Validar el campo de la contraseña
            userDTO.setPassword(new BCryptPasswordEncoder().encode( userDTO.getPassword()));
            userDTO.setRol(Rol.ADMIN);
            userDTO.setActive(true);
            User user = UserMapper.convertDTOToEntity(userDTO);
            userRepository.save(user);
            return userDTO ;
        }else {
            throw new ExceptionRequest("POR FAVOR INGRESA TODOS LOS DATOS PARA PODER REGISTRARSE");

        }
    }

    @Transactional
    public UserDto update(Long id, UserDto userDTO) {
        if (userDTO.getId() != null && userDTO.getId() != 0){
            Optional<User> optionalAdmin = userRepository.findById(id);
            if (optionalAdmin.isPresent()) {
                User user = optionalAdmin.get();

                if (userDTO.getName() != null) {
                    user.setName(userDTO.getName());
                }
                if (userDTO.getMail() != null) {
                    user.setMail(userDTO.getMail());
                }
                if (userDTO.getPassword() != null) {
                    user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
                }
                if (userDTO.getRol() != null) {
                    user.setRol(userDTO.getRol());
                }
                if (userDTO.getActive() != null) {
                    user.setActive(userDTO.getActive());
                }
                userRepository.save(user);
                return UserMapper.convertEntityToDTO(user);
            } else {
                throw new ExceptionRequest("LO SENTIMOS DATOS INSUFICIENTES");
            }
        }else {
            throw new ExceptionRequest("LO SENTIMOS ID NO ES VALIDO");
        }

    }
    @Transactional
    public void   deleteById(Long id){
        Optional<User>optionalAdmin= userRepository.findById(id);
        if (optionalAdmin.isPresent()){
            optionalAdmin.get().setActive(false);
            userRepository.save(optionalAdmin.get());
        }else {
            throw new ExceptionRequest("EL ID NO ES VALIDO");
        }

    }
    @Transactional
    public void activeById(Long id){
        Optional<User>optionalAdmin= userRepository.findById(id);
        if (optionalAdmin.isPresent()){
            optionalAdmin.get().setActive(true);
            userRepository.save(optionalAdmin.get());
        }else {
            throw new ExceptionRequest("EL ID NO ES VALIDO");
        }

    }


//  public User addUser(UserDTO adminDTO){
//        adminDTO.setPassword(new BCryptPasswordEncoder().encode(adminDTO.getPassword()));
//        User admin = UserMapper.convertDTOToEntity(adminDTO);
//        return adminRepository.save(admin);
//
//  }

    public boolean login(String mail, Long password) {
        Optional<User> optional = userRepository.findByMail(mail);
        if (optional.isPresent() && optional.get().getPassword().equals(password))
            return true;
        return false;
    }

    public User findByName(String name) {
        return userRepository.findByName(name);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByMail(email);
        if (optional.isPresent()){
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_ADMIN");
            permisos.add(p);
            return new org.springframework.security.core.userdetails.User(optional.get().getMail(), optional.get().getPassword(), permisos);
        }
        else{

            throw new InternalAuthenticationServiceException("Usuario o contraseña incorrectos. Por favor, intenta nuevamente");
        }
    }

     */
}
