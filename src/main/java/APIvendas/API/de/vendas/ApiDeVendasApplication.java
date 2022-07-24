package APIvendas.API.de.vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiDeVendasApplication {

/*
    @Bean
    public CommandLineRunner init(@Autowired ClienteRepositoryJDBC clienteRepositoryJDBC) {
        return args -> {
            */
/*//*
/salvando
            Cliente cliente = new Cliente();
            cliente.setNome("Alexandre");
            clienteRepositoryJDBC.salvar(cliente);

            //listando
            List<Cliente> clienteList = clienteRepositoryJDBC.listar();
            for (Cliente l : clienteList) {
                System.out.println(l.getNome());
            }*//*
        };
    }
*/

    public static void main(String[] args) {
        SpringApplication.run(ApiDeVendasApplication.class, args);

    }

}
