package io.github.moraisx.domain.repository;

import io.github.moraisx.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemPedidos extends JpaRepository<ItemPedido, Integer> {
}
