# Guia rápido do simulador de kits de automação

1. Com o JDK 21 instalado, abra o PowerShell na pasta do `pom.xml` e rode `.\mvnw.cmd spring-boot:run`.
2. Quando o simulador iniciar, abra [http://localhost:8080](http://localhost:8080).
3. Escolha um ambiente, deixe a condição em **Alerta** e clique em **Executar simulação**. Observe a leitura do sensor e o estado do atuador.
4. Selecione **Normal**, execute de novo e compare os resultados.
5. Escolha o outro ambiente e repita o teste, primeiro em **Alerta** e depois em **Normal**.

Troque a condição para ver como o atuador reage. Depois troque o ambiente para ver outro par de sensor e atuador funcionando no mesmo simulador.

## Resultados esperados

| Ambiente | Condição | Sensor | Leitura simulada | Atuador | Estado |
| --- | --- | --- | --- | --- | --- |
| Estufa | Alerta | Sensor de umidade | 25 % | Bomba de irrigação | Ligada |
| Estufa | Normal | Sensor de umidade | 55 % | Bomba de irrigação | Desligada |
| Câmara fria | Alerta | Sensor de temperatura | 12 °C | Compressor | Ligado |
| Câmara fria | Normal | Sensor de temperatura | 4 °C | Compressor | Desligado |