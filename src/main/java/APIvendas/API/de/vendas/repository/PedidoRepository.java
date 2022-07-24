package APIvendas.API.de.vendas.repository;

import APIvendas.API.de.vendas.entity.Cliente;
import APIvendas.API.de.vendas.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Cliente> findByCliente(Cliente cliente);

}
