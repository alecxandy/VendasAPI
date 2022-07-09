package APIvendas.API.de.vendas.repository.auternatives;

import APIvendas.API.de.vendas.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ClienteRepositoryEntityManager {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente) {
        return entityManager.merge(cliente);
    }

    @Transactional
    public void deletar(Cliente cliente) {
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletarPorId(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);//recupera por id
        deletar(cliente);
    }

    @Transactional(readOnly = true)//informa que é uma transação só de leitura
    public List<Cliente> buscarPorNome(String nome) {
        String jpql = "select c from cliente c where c.nome like = :nome";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    public List<Cliente> opterTodos() {
        return entityManager.createQuery("from cliente", Cliente.class).getResultList();
    }

}
