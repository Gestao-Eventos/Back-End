package controller;

import com.api.gestaoeventos.services.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping("/eventos/{idEvento}/participantes/{idParticipante}")
    public ResponseEntity<String> realizarInscricao(
            @PathVariable Long idEvento,
            @PathVariable Long idParticipante) {
        String mensagem = inscricaoService.inscrever(idParticipante, idEvento);
        return ResponseEntity.ok(mensagem);
      }
    }
