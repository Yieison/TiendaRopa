package com.pw.TiendaRopa.repository;

import com.pw.TiendaRopa.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
