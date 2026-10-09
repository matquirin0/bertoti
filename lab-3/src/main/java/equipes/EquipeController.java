package equipes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipes")
class EquipeController {

    private final EquipeDAO equipeDAO = new EquipeDAO();

    @GetMapping
    List<Equipe> getEquipes() {
        return equipeDAO.listar();
    }

    @GetMapping("/{id}")
    ResponseEntity<Equipe> getEquipeById(@PathVariable String id) {
        Equipe equipe = equipeDAO.buscarPorId(id);
        return (equipe != null) ? ResponseEntity.ok(equipe) : ResponseEntity.notFound().build();
    }

    @PostMapping
    ResponseEntity<Equipe> postEquipe(@RequestBody Equipe equipe) {
        // O servidor sempre gera o id; o cliente não escolhe
        equipe.setId(java.util.UUID.randomUUID().toString());
        equipeDAO.salvar(equipe);
        return new ResponseEntity<>(equipe, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Equipe> putEquipe(@PathVariable String id, @RequestBody Equipe equipe) {
        equipe.setId(id);
        if (equipeDAO.buscarPorId(id) != null) {
            equipeDAO.atualizar(id, equipe);
            return ResponseEntity.ok(equipe);
        }
        equipeDAO.salvar(equipe);
        return new ResponseEntity<>(equipe, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEquipe(@PathVariable String id) {
        equipeDAO.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
