package com.example.demo.repositorio;

import com.example.demo.entidades.Software;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISoftwareRepository extends JpaRepository<Software,Integer> {

}
