package com.aula.livros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class Controller {

    @Autowired
    private RepositoryLivro repositoryLivro;

    @GetMapping()
    public ResponseEntity<List<Livro>> getAll (){
        try{
            List<Livro> livros = repositoryLivro.findAll();
            if(livros.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(livros);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
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

    @PutMapping("/status/{id}")
    public Livro atualizaStatus(@PathVariable Integer id, @RequestBody Livro status){
        Livro livro = repositoryLivro.findById(id).get();
        livro.setStatus(status.getStatus());
        return repositoryLivro.save(livro);
    }

    @GetMapping("listar/{status}")
    public ResponseEntity<List<Livro>> listaStatus(@PathVariable Integer status){
        List<Livro> livros = repositoryLivro.findByStatus(Status.values()[status]);
        if(livros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(livros);
    }
}
