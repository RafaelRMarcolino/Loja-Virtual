package com.rafael.loja.virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.loja.virtual.models.Funcionario;

public interface FuncionarioRepositories  extends JpaRepository<Funcionario, Long> {

}
  