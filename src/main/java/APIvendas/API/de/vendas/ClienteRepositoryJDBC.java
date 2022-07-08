package APIvendas.API.de.vendas;

import APIvendas.API.de.vendas.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void salvar(Cliente cliente) {
        String INSERT = "INSERT INTO cliente (nome) VALUES (?)";
        jdbcTemplate.update(INSERT, cliente.getNome());
    }
}
