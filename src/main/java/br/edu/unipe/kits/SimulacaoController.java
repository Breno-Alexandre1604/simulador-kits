package br.edu.unipe.kits;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SimulacaoController {
    private final Simulador simulador = new Simulador();
    private final Map<String, FabricaDeAutomacao> fabricas = Map.of(
        "estufa", new FabricaEstufa(),
        "camara-fria", new FabricaCamaraFria()
    );

    @GetMapping("/api/simulacoes/{ambiente}")
    public Resultado simular(@PathVariable String ambiente) {
        FabricaDeAutomacao fabrica = fabricas.get(ambiente);
        if (fabrica == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ambiente desconhecido");
        }
        return simulador.executar(fabrica);
    }
}
