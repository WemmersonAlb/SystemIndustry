# API Endpoints


## Funcionário

### Criar Funcionário
- **Método:** POST
- **Rota:** `/api/funcionario/create`
- **Descrição:** Cria um novo funcionário no sistema.

### Buscar Funcionário por ID
- **Método:** GET
- **Rota:** `/api/funcionario/{id}`
- **Descrição:** Retorna os dados de um funcionário específico com base no ID fornecido.

### Listar Todos os Funcionários
- **Método:** GET
- **Rota:** `/api/funcionario/all`
- **Descrição:** Retorna uma lista com todos os funcionários cadastrados no sistema.

### Atualizar Funcionário
- **Método:** PUT
- **Rota:** `/api/funcionario/update/{id}`
- **Descrição:** Atualiza os dados de um funcionário existente com base no ID fornecido.

### Excluir Funcionário
- **Método:** DELETE
- **Rota:** `/api/funcionario/delete/{id}`
- **Descrição:** Remove um funcionário do sistema com base no ID fornecido.

## Ocorrências

### Criar Ocorrência
- **Método:** POST
- **Rota:** `/api/ocorrencias/create`
- **Descrição:** Registra uma nova ocorrência no sistema.

### Listar Todas as Ocorrências
- **Método:** GET
- **Rota:** `/api/ocorrencias/all`
- **Descrição:** Retorna uma lista com todas as ocorrências registradas no sistema.

## Setor

### Criar Setor
- **Método:** POST
- **Rota:** `/api/setor/create`
- **Descrição:** Cria um novo setor no sistema.

### Buscar Setor por ID
- **Método:** GET
- **Rota:** `/api/setor/{id}`
- **Descrição:** Retorna os dados de um setor específico com base no ID fornecido.

### Listar Todos os Setores
- **Método:** GET
- **Rota:** `/api/setor/all`
- **Descrição:** Retorna uma lista com todos os setores cadastrados no sistema.

### Atualizar Setor
- **Método:** PUT
- **Rota:** `/api/setor/update/{id}`
- **Descrição:** Atualiza os dados de um setor existente com base no ID fornecido.

### Excluir Setor
- **Método:** DELETE
- **Rota:** `/api/setor/delete/{id}`
- **Descrição:** Remove um setor do sistema com base no ID fornecido.

## Tipo de Falha

### Listar Todos os Tipos de Falha
- **Método:** GET
- **Rota:** `/api/tipo-falha/all`
- **Descrição:** Retorna uma lista com todos os tipos de falha cadastrados no sistema.
