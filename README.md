[![Typing SVG](https://readme-typing-svg.demolab.com?font=Comfortaa&size=30&duration=2000&pause=1000&color=755683&background=57575700&random=true&width=435&lines=Unit+tests+example's.;With+JUnit+Jupiter.)](https://git.io/typing-svg)

# Sistema de Empréstimo de Biblioteca

Este repositório implementa um **Sistema de Empréstimo de Biblioteca** em Java, seguindo requisitos de controle de empréstimos, verificação de débitos, disponibilidade de livros, e cálculo de data de devolução. 

---

## 📂 Estrutura do Projeto

```plaintext
demo/
├── src/
│   ├── main/java/com/example/
│   │   ├── Aluno.java
│   │   ├── App.java
│   │   ├── Controle.java
│   │   ├── Debito.java
│   │   ├── Emprestimo.java
│   │   ├── Item.java
│   │   ├── Livro.java
│   │   └── Titulo.java
│   └── test/java/com/example/
│       ├── ControleTest.java
│       └── EmprestimoTest.java
├── target/
│   └── surefire-reports/    # Relatórios de testes
└── pom.xml
```
---

## 🔍 Funcionalidades

### Regras de Empréstimo

1. **Identificação**: Aluno deve apresentar uma identificação válida (RA) cadastrada no sistema.
2. **Verificação de Débitos**: O sistema bloqueia o empréstimo caso o aluno tenha pendências ou débitos.
3. **Disponibilidade de Livros**: Apenas livros disponíveis podem ser emprestados.
4. **Limite de Empréstimos**: Máximo de 5 livros por vez.
5. **Cálculo da Data de Devolução**: A data é calculada com base na quantidade de livros emprestados, aplicando um prazo adicional quando o número excede 2 livros.

---

## ✅ Testes Unitários

Os testes foram desenvolvidos utilizando **JUnit** e cobrem cenários chave do sistema, verificando cada regra e validação necessária. 

### Arquivos de Teste

- **ControleTest.java**: Testa a funcionalidade do controle de empréstimos, incluindo cenários de:
  - Empréstimo com aluno válido e livros disponíveis.
  - Bloqueio de empréstimo para aluno inválido ou com débitos.
  - Verificação da disponibilidade de livros.
- **EmprestimoTest.java**: Foca em validar as regras de empréstimo e cálculo de devolução, com cenários de:
  - Empréstimo com livros disponíveis.
  - Bloqueio para livros indisponíveis.
  - Verificação de débitos em alunos.

### Exemplos de Casos Testados

1. **Aluno válido, sem débitos, com livros disponíveis**: O sistema permite o empréstimo.
2. **Aluno inválido**: Empréstimo é bloqueado.
3. **Aluno com débitos**: Empréstimo é bloqueado, validando restrições financeiras.
4. **Livro indisponível**: Impede o empréstimo, garantindo integridade da biblioteca.
5. **Todos os livros disponíveis**: Empréstimo permitido quando não há restrições.

Os relatórios de teste estão disponíveis em `target/surefire-reports` e podem ser visualizados para verificar a cobertura dos testes executados.

---

## 🚀 Tecnologias e Ferramentas

- **Java**: Linguagem de programação principal.
- **JUnit**: Framework de testes para validação das funcionalidades.
- **Maven**: Gerenciador de dependências e automação de build.
- **EclEmma**: Plugin de cobertura de código, utilizado para garantir que todas as regras e condições foram testadas.

---

## 🛠 Como Executar

1. **Clone o repositório**:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd demo
Execute os testes com Maven:
```mvn test```
Verifique os relatórios de teste: Acesse target/surefire-reports para visualizar o resultado e cobertura dos testes realizados.

📈 Análise de Cobertura
Para validar a qualidade dos testes, foi utilizada a cobertura de código com o EclEmma. O objetivo foi alcançar uma cobertura que assegure a verificação de todas as funcionalidades e fluxos alternativos definidos no sistema.
