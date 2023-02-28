package io.github.moraisx.domain.repositorio;

import io.github.moraisx.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static String INSERT = "insert into cliente (nome) values (?)";
    private  static String SELECT_ALL = "SELECT * FROM CLIENTE";
    private  static String SELECT_CLIENTE = "SELECT * FROM CLIENTE";
    private  static String UPDATE = "UPDATE FROM CLIENTE SET NOME = ? WHERE ID = ?";
    private  static String DELETE = "DELETE FROM CLIENTE WHERE ID = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }
    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Integer id = rs.getInt("id");
//                String nome = rs.getString("nome");
                  return new Cliente(rs.getInt("id"), rs.getString("nome"));
            }
        });
    }
    public List<Cliente> obterCliente(String nome){
        return jdbcTemplate.query(SELECT_CLIENTE.concat(" where nome like ? "),
                new Object[]{"%" + nome + "%"},
                        new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Cliente(rs.getInt("id"), rs.getString("nome"));
            }
        });
    }
    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }
    public void deletarCliente(Cliente cliente){
        deletar(cliente.getId());
    }
    public void deletar(Integer id){
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

}
