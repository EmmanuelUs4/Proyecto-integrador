package com.example.MensajeriaExpress.Repository;

import com.example.MensajeriaExpress.DTO.EmpleadoDTO.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleado, Integer> {

}
