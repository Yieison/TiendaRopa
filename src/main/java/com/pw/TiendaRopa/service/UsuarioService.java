package com.pw.TiendaRopa.service;

import com.pw.TiendaRopa.model.Usuario;
import com.pw.TiendaRopa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

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
                    usuario.setContrasena(usuarioActualizado.getContrasena());
                    usuario.setDireccion(usuarioActualizado.getDireccion());
                    usuario.setNumeroCelular(usuarioActualizado.getNumeroCelular());
                    return usuarioRepository.save(usuario);
                }).orElseGet(() -> {
                    usuarioActualizado.setId(id);
                    return usuarioRepository.save(usuarioActualizado);
                });
    }
}
