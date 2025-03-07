package com.aula.livros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryLivro extends JpaRepository<Livro,Integer> {

    List<Livro> findByStatus(Status status);
}
