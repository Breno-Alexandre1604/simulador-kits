package br.edu.unipe.kits;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SimulacaoController {
    private final Simulador simulador = new Simulador();
    private final Map<String, Function<Cenario, FabricaDeAutomacao>> fabricas = Map.of(
        "estufa", FabricaEstufa::new,
        "camara-fria", FabricaCamaraFria::new
    );

    @GetMapping("/api/simulacoes/{ambiente}")
    public Resultado simular(@PathVariable String ambiente, @RequestParam("cenario") Optional<String> cenario) {
        var criarFabrica = fabricas.get(ambiente);
        if (criarFabrica == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ambiente desconhecido");
        }
        Cenario cenarioDoKit = switch (cenario.orElse("alerta")) {
            case "normal" -> Cenario.NORMAL;
            case "alerta" -> Cenario.ALERTA;
            default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cenário inválido");
        };
        return simulador.executar(criarFabrica.apply(cenarioDoKit));
    }
}
