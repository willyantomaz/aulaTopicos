package com.aula.livros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class controller {

    @Autowired
    private RepositoryLivro repositoryLivro;

    @GetMapping()
    public List<Livro> getAll (){
        return repositoryLivro.findAll();
    }

    @PostMapping()
    public Livro criaLivro (@RequestBody Livro livro) {
        return repositoryLivro.saveAndFlush(livro);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
         repositoryLivro.deleteById(id);
         return "deletado";
    }

    @PutMapping()
    public Livro atualiza(@RequestBody Livro livro){
        return repositoryLivro.save(livro);
    }
}
