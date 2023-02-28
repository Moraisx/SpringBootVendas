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
            clientes.salvar(cliente);

            Cliente cliente2 = new Cliente("Cliente_02");
            clientes.salvar(cliente2);

            clientes.salvar(new Cliente("Cliente_03"));

            List<Cliente> obterTodosClientes = clientes.obterTodos();
            obterTodosClientes.forEach(System.out::println);

            List<Cliente> atualizarClientes = clientes.obterTodos();
            atualizarClientes.forEach(cli ->{
                cli.setNome(cli.getNome() + "atualizado");
            });

            atualizarClientes.forEach(System.out::println);

            clientes.obterCliente("Cliente_01").forEach(System.out::println);

            obterTodosClientes.forEach(clie ->{
                clientes.deletarCliente(clie);
            });

            obterTodosClientes = clientes.obterTodos();
            if(obterTodosClientes.isEmpty()){
                System.out.println("Tabela cliente está vazia");
            }else{
                obterTodosClientes.forEach(System.out::println);
            }
        };
    }
    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }
}

