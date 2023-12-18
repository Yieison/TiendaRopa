package com.pw.TiendaRopa.service;

import java.util.List;
import java.util.Optional;

import com.pw.TiendaRopa.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pw.TiendaRopa.model.Usuario;
import com.pw.TiendaRopa.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    
    public Usuario guardarUsuario(Usuario usuario) {
    	usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setDocumentoIdentidad(usuarioActualizado.getDocumentoIdentidad());
                    usuario.setNombre(usuarioActualizado.getNombre());
                    usuario.setCorreo(usuarioActualizado.getCorreo());
                    usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
                    usuario.setDireccion(usuarioActualizado.getDireccion());
                    usuario.setNumeroCelular(usuarioActualizado.getNumeroCelular());
                    return usuarioRepository.save(usuario);
                }).orElseGet(() -> {
                    usuarioActualizado.setId(id);
                    return usuarioRepository.save(usuarioActualizado);
                });
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontró usuario con correo: " + correo));
        return new CustomUserDetails(usuario);
    }
}
