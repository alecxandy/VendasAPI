package APIvendas.API.de.vendas.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pedido {

    @Id
    private Long id;
    private LocalDate dataPedido;
    private BigDecimal total;

    //LAZY = a consulta não traz os pedidos como padrão
    //EAGER = a consulta traz os pedidos junto com a consulta do cliente
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
    List<ItemPedido> itemPedidoList;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pedido pedido = (Pedido) o;
        return id != null && Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
