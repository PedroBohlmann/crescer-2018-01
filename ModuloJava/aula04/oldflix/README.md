# Documentação

+ Cliente
    | URL      | Método | Ação | Envia |
    |----------|-------:|-----:|-------:|
    | /cliente | GET | Listar clientes|Nada|
    | /cliente/{id} | GET | Busca cliente com esse id|Nada|
    | /cliente/{id} | PUT | Atualiza cliente |ClienteRequest|
    |/cliente|POST|Cria novo cliente|ClienteRequest|
    |/cliente/{id}|DELETE|Deleta cliente|Nada|
    + ClienteRequest
        | Campo    | Dado   |
        |----------|-------:|
        |cpf       |  String|
        |nome      |  String|
+ Filme
    | URL      | Método | Ação | Envia |
    |----------|-------:|-----:|-------:|
    |/filme|GET|Carrega todos os filmes|Nada|
    |/filme/{id}|GET|Busca o filme pelo id|Nada|
    |/filme/{id}|DELETE|Deleta o filme|Nada|
    |/filme|POST|Cria o filme|FilmeRequest|
    |/filme|PUT|Atualiza filme|FilmeRequest|
    + FilmeRequest
        | Campo    | Dado   |
        |----------|-------:|
        |titulo       |  String|
        |categoria      |  Categoria|
        + Categoria
            + DOURADA
            + PRATA
            + BRONZE
+ Fita
    | URL      | Método | Ação | Envia |
    |----------|-------:|-----:|-------:|
    |/fita|GET| Lista todas as Fitas| Nada|
    |/fita/{id}|GET|Busca Fita com o id|Nada|
    |/fita/{id}|DELETE|Deleta fita com id|Nada|
    |/fita/{id}|PUT|Atualiza Fita com o id|Fita|
    |/fita/{id}|POST|Cria nova Fita|Fita|
    + Fita
        | Campo    | Dado   |Uso|
        |----------|-------:|--:|
        |id|Long|Não é utilizado em chamadas|
        |locado|boolean|Obrigatorio|
+ Pedido
    | URL      | Método | Ação | Envia |
    |----------|-------:|-----:|-------:|
    |/pedido/{id}|GET|Retorna Pedido com id|Nada|
    |/pedido|POST|Cria novo Pedido| PedidoRequest|
    |/pedido/devolve|POST|Devolve uma fita de um pedido|PedidoDevolveRequest|
    + PedidoRequest
        | Campo    | Dado   |
        |----------|-------:|
        |cpf|String|
        |filmes|List<String>|
    + PedidoDevolveRequest
        | Campo    | Dado   |
        |----------|-------:|
        |cpf|String|
        |idFita|Long|
