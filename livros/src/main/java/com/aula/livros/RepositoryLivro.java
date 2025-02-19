package com.aula.livros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLivro extends JpaRepository<Livro,Integer> {
}
