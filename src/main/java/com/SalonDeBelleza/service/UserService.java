package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    public IUsuarioService clienteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario cliente = this.clienteService.findByCorreo(username);
        Userprincipal userPrincipal = new Userprincipal(cliente);
        return userPrincipal;
    }
}
