package io.github.moraisx.domain.repositorio;

import io.github.moraisx.domain.entity.Cliente;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Clientes extends JpaRepository<Cliente, Integer> {

    //@Query( value = "select c from Cliente c Like c.nome = :nome")
    //List<Cliente> findByNomeLike( @Param("nome") String nome);

    //Metodo de convenção findByNomeLike => find Nome Like => select c from Cliente c Like c.nome = :nome
    List<Cliente> findByNomeLike(String nome);
    boolean existsByNome(String nome);
}
