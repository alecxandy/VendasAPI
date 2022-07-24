package APIvendas.API.de.vendas.repository.auternatives;

import APIvendas.API.de.vendas.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void salvar(Cliente cliente) {
        String INSERT = "INSERT INTO cliente (nome) VALUES (?)";
        jdbcTemplate.update(INSERT, cliente.getNome());
    }

    public List<Cliente> listar() {
        String SELECT_ALL = "SELECT * FROM cliente";
        return jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Cliente>(Cliente.class));
    }

}
