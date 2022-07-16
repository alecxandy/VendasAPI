package APIvendas.API.de.vendas.repository;

import APIvendas.API.de.vendas.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

/*

    //conveção de query methods onde busca cliente por nome
    List<Cliente> findByNameLike(String nome);


    //usando query jpql onde busca cliente por nome
    @Query(value = "select c from cliente c where c.nome like :nome")
    List<Cliente> encontrarPorNomeJpql(@Param("nome") String nome);


    //usanso sql nativo(nativeQuery = true)
    @Query(value = "select * from cliente c where c.nome like '%:nome%'", nativeQuery = true)
    List<Cliente> encontrarPorNomeSql(@Param("nome") String nome);


    @Query(value = "delete from cliente c where c.nome =:nome")
    @Modifying
        //inserir Modyfying quando for transação de inserir , deletar ou update.
    void deleteByName(String nome);


    //selecionando todos os clientes ue tem pedidos
    @Query("select c from cliente c left join fetch c.pedido where c.id = :id ")
    Cliente findCLienteFetchePedidos(@Param("id") Long id);

*/

}
