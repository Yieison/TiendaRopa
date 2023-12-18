package com.pw.TiendaRopa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pw.TiendaRopa.model.Usuario;
import com.pw.TiendaRopa.service.UsuarioService;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String procesarRegistro(Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/login"; // Redirige al login tras un registro exitoso
    }
}
