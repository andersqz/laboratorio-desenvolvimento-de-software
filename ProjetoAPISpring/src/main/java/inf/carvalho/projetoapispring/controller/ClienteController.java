package inf.carvalho.projetoapispring.controller;

import inf.carvalho.projetoapispring.model.Cliente;
import inf.carvalho.projetoapispring.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        if (!clienteRepository.existsById(id)){
            return notFound().build();
        }

        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id,
                                             @RequestBody Cliente clienteAtualizado){

        if (!clienteRepository.existsById(id)) {
            return notFound().build();
        }

        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

        if (clienteExistente != null) {
            clienteExistente.setNome(clienteAtualizado.getNome());
            Cliente clienteAtualizadoNoBanco = clienteRepository.save(clienteExistente);
            return ResponseEntity.ok(clienteAtualizadoNoBanco);
        } else {
            return notFound().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }


    }
}
