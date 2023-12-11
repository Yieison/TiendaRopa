package com.pw.TiendaRopa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pw.TiendaRopa.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
