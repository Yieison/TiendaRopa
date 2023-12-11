package com.pw.TiendaRopa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pw.TiendaRopa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}
