package APIvendas.API.de.vendas.repository;

import APIvendas.API.de.vendas.domain.Cliente;
import APIvendas.API.de.vendas.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Cliente> findByCliente(Cliente cliente);

}
