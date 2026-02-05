# Atividade Refatoração SRP (TechStore) 🖥️

👤 Melissa Rafaela Pereira - 81795

📖 Aprendizagem Industrial em Desenvolvimento de Sistemas - WEG - AI MIDS 77

Unidade Curricular: Arquitetura de Sistemas  
Professor: Lucas Santos

## Visão Geral 👀
Este repositório contém a proposta de refatoração de um exemplo didático em que a classe `ProcessadorDePedido` viola o Princípio da Responsabilidade Única (SRP). O objetivo da atividade é identificar responsabilidades misturadas e aplicar SRP separando-as em componentes especializados, melhorando manutenção, testabilidade e extensibilidade.

<br>

## Contexto da Atividade 📖

A classe ProcessadorDePedido da TechStore funciona como uma "Classe Deus", centralizando responsabilidades que deveriam ser independentes, como gestão de estoque, cálculos tributários e integrações logísticas. Essa estrutura sobrecarregada fere o Princípio da Responsabilidade Única, tornando o código extremamente instável e difícil de manter. Na prática, qualquer pequena atualização em uma regra de frete ou pagamento exige alterações nessa classe central, o que eleva drasticamente o risco de bugs em cascata e compromete a segurança de todo o fluxo operacional da empresa.

<br>

## Responsabilidades identificadas 🔎
- ValidadorDeEstoque: valida disponibilidade e regras de negócio relacionadas ao estoque.
- CalculadorDeFreteEImpostos: calcula frete e impostos e produz o valor final do pedido.
- RepositorioDePedido: responsabilidade de salvar/atualizar o pedido na persistência.
- NotificadorDeEmail: integra com provedores de e‑mail para enviar confirmações.
- ServicoDePedido (orquestrador): coordena o fluxo entre os componentes acima, mas não implementa lógica de negócio ou integração.

<br>

# Estrutura 🏠

````
GerenciamentoPedidos
└── assets
└── src
    └── TechStore
        └── CalculoFreteImpostos
        ├── EnviarEmail
        ├── Main
        ├── Pedido
        ├── PersistenciaPedido
        ├── ServicoPedido
        └── ValidacaoEstoque
````

<br>

## Visualização do ServicoPedido 👓

```java
public class ServicoPedido {

    private ValidacaoEstoque validacaoEstoque = new ValidacaoEstoque();
    private CalculoFreteImpostos calculoFreteImpostos = new CalculoFreteImpostos();
    private PersistenciaPedido persistenciaPedido = new PersistenciaPedido();
    private EnviarEmail enviarEmail = new EnviarEmail();

    public double processarPedido(Pedido pedido) throws Exception{

        validacaoEstoque.validarQuantidadeItens(pedido);

        double frete = calculoFreteImpostos.calculoFrete(pedido);
        double impostos = calculoFreteImpostos.calculoImpostos(pedido);
        double valorFinal = pedido.getValorTotal() + frete + impostos;

        pedido.setPago(true);

        persistenciaPedido.salvarBanco(pedido, valorFinal);
        enviarEmail.enviarConfirmacaoPorEmail(pedido.getEmailCliente(), pedido.getId());

        return valorFinal;
    }
}
```

<br>


## Por que essa separação é crucial para a manutenção de um sistema 👩‍💻

No início do desenvolvimento, toda a lógica do sistema estava concentrada em uma única classe, o que acabava sobrecarregando suas funções e indo contra o princípio da Responsabilidade Única (SRP).

Com a refatoração realizada, o código passou a ser dividido de forma mais organizada, em que cada classe ficou responsável por apenas uma tarefa específica. Dessa forma, a classe ServicoPedido não executa regras de negócio diretamente, mas atua como um ponto central que gerencia e orquestra o fluxo de execução do sistema.

As responsabilidades foram distribuídas entre classes especializadas: CalcularFreteImposto, responsável pelos cálculos; ValidaEstoque, encarregada das verificações de disponibilidade; SalvaBanco, que cuida da persistência dos dados; e EnviaEmail, destinada à comunicação com o cliente.

Essa separação reduz o acoplamento entre as partes do sistema, melhora a legibilidade do código e torna futuras manutenções ou alterações mais simples e seguras. Por fim, todo o processo é iniciado e finalizado a partir da classe Main, que apenas dispara a execução do fluxo.

<br>

## Observações finais 🔚
Separar responsabilidades seguindo o SRP não é apenas “bom design”: em plataformas de e‑commerce, mudanças de negócio (promoções, regras fiscais), mudanças de infraestrutura (provedores de e‑mail, banco de dados) e requisitos regulatórios ocorrem frequentemente. Uma arquitetura com responsabilidades bem delimitadas reduz o tempo de resposta a essas mudanças e diminui risco de bugs críticos no fluxo de pagamento.

<br>


## Como Rodar 📤


OPÇÃO 1️⃣: 

01) Baixando o projeto .ZIP: Baixe o arquivo do projeto no link mencionado anteriormente. Para isso, clique no botão <> Code (destacado em azul ou verde) e selecione a opção Download ZIP.

02) Extraindo o arquivo .ZIP: Após baixar o arquivo, localize-o na pasta "Downloads" e extraia o seu conteúdo.

03) Abrindo o projeto: Após a extração, abra a pasta em uma IDE para Java e execute o projeto através da classe Main.

<br>

OPÇÃO 2️⃣: Clonar com Git.
Se você não desejar baixar o arquivo, você pode fazer acessar via terminal (ou prompt) 🖥️
````
bash
git clone https://github.com/usuario/repositorio.git
````

<br>

