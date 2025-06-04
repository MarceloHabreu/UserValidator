# 🛡️ Validação de Usuário com Cartão Eletrônico

Este projeto simula o processo de **validação de usuários via cartão eletrônico e senha**, baseado em um exercício de modelagem de casos de uso. A lógica inclui tentativas de senha, bloqueios temporários, cancelamento de operação e reentrada de dados.

---

## 📘 Contexto do Exercício

Este sistema permite que um cliente utilize um cartão eletrônico para se autenticar. O cliente insere o número do cartão e sua senha. O sistema possui funcionalidades para reintrodução de senha, cancelamento de operação, e bloqueio do cartão após múltiplas falhas.

---

## 🧾 Regras de Negócio

1. O cliente ativa o teclado e insere a senha.
2. O cliente pode limpar a senha e reintroduzi-la quantas vezes quiser **antes** de pressionar “Entrar”.
3. Ao pressionar “Entrar”, o sistema realiza a validação:
   - Verifica se o cartão existe.
   - Se **não existir**, informa: `Cartão inválido`.
   - Se existir, compara a senha digitada com a cadastrada.
4. Caso a senha esteja incorreta:
   - O cliente pode tentar novamente.
   - Após **3 tentativas incorretas**, o sistema bloqueia a entrada por **2 minutos**.
5. O cliente pode **cancelar** a operação a qualquer momento, encerrando o processo de autenticação.

---

## 🎯 Caso de Uso: Validar Usuário

### Ator Principal
- Cliente

### Fluxo Principal
1. Cliente insere o número do cartão e a senha.
2. O sistema valida se o cartão é válido.
3. O sistema verifica a senha:
   - Se correta, acesso concedido.
   - Se incorreta, o sistema contabiliza tentativas.

### Extensões (`<<extend>>`)
- **Operação cancelada**: o cliente opta por cancelar a operação.
- **Senha incorreta**: o sistema informa erro e aguarda nova tentativa.
- **Bloqueio de cartão**: após 3 falhas, o cartão é bloqueado por 2 minutos.

![Diagrama de Caso de Uso](https://github.com/MarceloHabreu/UserValidator/blob/master/diagramaDeCasoDeUso/CasoValidarUsu%C3%A1rio.png)


---

## 💻 Implementação

A lógica foi implementada em Java, utilizando `HashMap` para simulação dos cartões cadastrados. Veja uma prévia das funcionalidades implementadas:

- Cadastro de cartões simulados
- Verificação de senha
- Mensagens de erro específicas
- Bloqueio temporário após falhas
- Cancelamento de operação
- Exibição de cartões cadastrados (para fins de teste)

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- IDE de sua preferência (IntelliJ, Eclipse, VS Code)
- Execução via terminal ou console

---

## 🚀 Como Executar

1. Clone o repositório
2. Compile os arquivos `.java`
3. Execute a classe `Main`
4. Digite o número do cartão e senha conforme os dados simulados

---

## 📌 Exemplo de Cartão Cadastrado

- Cartão: `0124`
- Senha: `ma171`

---

## 📜 Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.


