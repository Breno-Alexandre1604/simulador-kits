# Simulador de kits de automação

Projeto de Análise e Projeto de Sistemas II do Unipê. Breno Alexandre e Lucas demonstram o padrão criacional **Abstract Factory** em Java 21 com Spring Boot e Maven. A página oferece duas famílias de equipamentos simulados.

| Ambiente | Sensor | Regra do exercício | Leitura inicial | Atuador e estado |
| --- | --- | --- | --- | --- |
| Estufa | Umidade do solo | Aciona abaixo de 40% | 25% | Bomba de irrigação ligada |
| Câmara fria | Temperatura | Aciona acima de 8 °C | 12 °C | Compressor ligado |

## Executar no Windows

Extraia a pasta, instale o JDK 21 e abra o PowerShell no diretório do pom.xml. Na primeira execução, a conexão com a internet permite ao Maven Wrapper obter as dependências.

```powershell
.\mvnw.cmd test
.\mvnw.cmd spring-boot:run
```

Abra [localhost:8080](http://localhost:8080). Escolha um ambiente e clique em **Executar simulação**. Use Ctrl+C para encerrar. Em Linux ou macOS, use `./mvnw` no lugar de `.\mvnw.cmd`.

## Estrutura

- `src/main/java/br/edu/unipe/kits` reúne o domínio e o controller.
- `src/main/resources/static/index.html` contém o formulário e apresenta o resultado.
- `src/test/java/br/edu/unipe/kits/SimuladorTest.java` verifica a leitura, o atuador e o estado de cada família.

O controller escolhe uma fábrica conforme a URL. O cliente do padrão, Simulador, recebe a interface FabricaDeAutomacao e pede criarSensor() e criarAtuador(). Cada fábrica concreta fornece os dois componentes do ambiente. O sensor produz uma Leitura e o atuador recebe a decisão de ligar ou desligar. O Spring serializa o Resultado em JSON para a interface.

## API da base

| Requisição GET | Resposta esperada |
| --- | --- |
| /api/simulacoes/estufa | 200 com umidade de 25% e bomba ligada |
| /api/simulacoes/camara-fria | 200 com temperatura de 12 °C e compressor ligado |
| /api/simulacoes/desconhecido | 404 |

Exemplo de resposta para estufa:

```json
{"leitura":{"sensor":"Sensor de umidade","valor":25,"unidade":"%","requerAcao":true},"atuador":"Bomba de irrigação","estado":"Ligada"}
```

## Quests da dupla

O primeiro commit importa esta base. Cada linha abaixo corresponde a uma mudança posterior, com seu próprio commit.

| Quest | Responsável | Entrega | Critério de conclusão |
| --- | --- | --- | --- |
| Q1 | Breno | Modelar os cenários ALERTA e NORMAL nas fábricas e nos sensores | A condição normal usa 55% e 4 °C, e os testes iniciais continuam passando |
| Q2 | Breno | Permitir a escolha do cenário na API | O parâmetro cenario aceita normal e alerta, usa alerta por padrão e devolve HTTP 400 para opção desconhecida |
| Q3 | Breno | Ampliar os testes do domínio | Cobrir os dois kits normais e os limites de 40% e 8 °C |
| Q4 | Lucas | Criar docs/demonstracao.md | Documentar o procedimento e os resultados observados nos dois kits |
| Q5 | Lucas | Adicionar seletor de condição na tela | Enviar cenario na URL e conferir as quatro combinações de ambiente e condição |

Q1 antecede Q2 e Q3. Q4 pode começar em paralelo com Q1. Q5 usa o contrato HTTP de Q2.

## Gerar o executável

```powershell
.\mvnw.cmd clean package
java -jar target/simulador-kits-0.1.0.jar
```

O JAR empacotado executa com Java 21 e inclui as dependências. Gere outro após integrar as quests para apresentar o trabalho atualizado.
