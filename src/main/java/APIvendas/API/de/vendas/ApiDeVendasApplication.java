package APIvendas.API.de.vendas;

import APIvendas.API.de.vendas.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiDeVendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepositoryJDBC clienteRepositoryJDBC){
return args -> {
    Cliente cliente = new Cliente();
    cliente.setNome("Alexandre");
    clienteRepositoryJDBC.salvar(cliente);
};
    }


    public static void main(String[] args) {
        SpringApplication.run(ApiDeVendasApplication.class, args);
    }

}
