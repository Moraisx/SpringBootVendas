package io.github.moraisx.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private  Integer id;
    @Column(name = "DESCRICAO", length = 255)
    private String descricao;

    @Column(name = "PRECO_UNITARIO", length = 20, precision = 2)
    private BigDecimal preco;

    @OneToMany(mappedBy = "produto")
    private Collection<ItemPedido> itensPedido;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Collection<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(Collection<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
