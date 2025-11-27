# TPPE - Campeonato Brasileiro

Este repositório contém uma implementação em Java de um concurso/esquema de campeonato (TPPE). O projeto usa Maven e Java 21.

**GRUPO**

<div align = "center">
<table>
  <tr>
    <td align="center"><a href="https://github.com/Diogo-Barboza"><img style="border-radius: 50%;" src="https://github.com/Diogo-Barboza.png" width="190px;" alt=""/><br /><sub><b>Diogo Barboza </b></sub></a><br />
    <td align="center"><a href="https://github.com/LeanArs"><img style="border-radius: 50%;" src="https://github.com/LeanArs.png" width="190px" alt=""/><br /><sub><b>Leandro Almeida</b></sub></a><br /><a href="Link git" title="Rocketseat"></a></td>
    <td align="center"><a href="https://github.com/martinsglucas"><img style="border-radius: 50%;" src="https://github.com/martinsglucas.png" width="190px" alt=""/><br /><sub><b>Lucas Martins</b></sub></a><br /><a href="Link git" title="Rocketseat"></a></td>
    <td align="center"><a href="https://github.com/MilenaFRocha"><img style="border-radius: 50%;" src="https://github.com/MilenaFRocha.png" width="190px" alt=""/><br /><sub><b>Milena Rocha</b></sub></a><br /><a href="Link git" title="Rocketseat"></a></td>
  </tr>
</table>

| Matrícula   | Aluno                             |
| ----------- | ----------------------------------|
| 22/2006660  | Diogo Rodrigues Barboza           |
| 21/1062080  | Leandro Almeida Rocha Santos      |
| 22/1022088  | Lucas Martins Gabriel             |
| 22/2022000 | Milena Fernandes Rocha             |
</div>


**Resumo:**
- **Linguagem:** Java 21
- **Build:** Maven
- **Classe principal:** `tppe.campeonato.App`

**Pré-requisitos**
- Java JDK 21 instalado e configurado. Verifique com:

```bash
java -version
```

- Maven instalado. Verifique com:

```bash
mvn -v
```

**Build do projeto**

1. No diretório raiz do repositório (onde está o `pom.xml`), compile o projeto:

```bash
mvn compile
```

2. Para empacotar (gera classes em `target/` e um JAR simples):

```bash
mvn package
```

> Observação: o pacote gerado não é um "fat jar" (sem dependências empacotadas), mas neste projeto não há dependências de tempo de execução além da JDK.

**Executar a aplicação**

Após compilar, você pode executar a classe principal diretamente a partir do diretório do projeto:

```bash
# executa usando classes compiladas em target/classes
java -cp target/classes tppe.campeonato.App

# ou (após 'mvn package')
java -cp target/classes:target/*.jar tppe.campeonato.App
```

Se preferir rodar a partir de uma IDE (IntelliJ IDEA, Eclipse), importe como um projeto Maven e execute a classe `tppe.campeonato.App`.

**Testes**

Os testes estão escritos com JUnit e ficam em `src/test/java`.

Para executar a suíte de testes:

```bash
mvn test
```

Para executar um teste específico (ex.: `TestCompetition`):

```bash
mvn -Dtest=TestCompetition test
```

**Estrutura do projeto**

- `src/main/java/tppe/campeonato/` : código-fonte principal (classes como `App`, `Competition`, `Team`, `Round`, etc.)
- `src/test/java/tppe/campeonato/` : casos de teste (JUnit)
- `pom.xml` : configuração do Maven (Java 21)

---
