package io.github.moraisx;

import io.github.moraisx.domain.entity.Cliente;
import io.github.moraisx.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setNome("Cliente_01");
            clientes.save(cliente);

            Cliente cliente2 = new Cliente("Cliente_02");
            clientes.save(cliente2);

            clientes.save(new Cliente("Cliente_03"));

            List<Cliente> TodosClientes = clientes.findAll();
            TodosClientes.forEach(System.out::println);

            System.out.println("Atualizando Clientes:");
            TodosClientes.forEach(cli ->{
                cli.setNome(cli.getNome() + " atualizado");
                clientes.save(cli);
            });

            TodosClientes = clientes.findAll();
            TodosClientes.forEach(System.out::println);

            clientes.findByNomeLike("Cliente_01").forEach(System.out::println);

            String clienteTeste = "Cliente_01 atualizado";
            boolean existeCliente = clientes.existsByNome(clienteTeste);
            System.out.println("o cliente: "+clienteTeste+" existe na tabela? : " + existeCliente);
        };
    }
    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }
}

