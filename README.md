# POO-Java-Lista-02

Estácio Unimeta, 2025 – Sistemas de Informação

Professor: Érick Fernandes

## Alunos

João Victor Rodrigues

João Gabriel

## Sistema Bibliotecário
Nosso domínio de aplicação escolhido foi o sistema bibliotecário.

### 1. Main
No main está nossos testes do projeto, como o ID das instâncias são aleatórios a cada vez que o programa roda, criamos Setters de ID apenas para fins de teste.

### 2. Classe Abstrata ItemBiblioteca
Esta classe abstrata representa um item da biblioteca, neste projeto é apenas utilizado pela classe Livro, podendo se extender pelos demais objetos de uma biblioteca real.

### 3. Classe Livro
Esta classe contém o nome, autor e id, além de extender a classe ItemBiblioteca, indicando que o livro é um objeto da biblioteca, temos o método construtor, setters e getters, além de métodos protegidos que serão utilizados na classe Biblioteca.

### 4. Interface Emprestável
Esta interface é implementada por objetos que a biblioteca pode emprestar, no caso deste projeto, o livro é o item emprestável.

### 5. Classe Usuário
Esta classe usuário contém o nome, id e uma lista de livros que foram emprestados, esta classe tambem possui getters e setters, além de método construtor e métodos protegidos.

### 6. Exceptions
O projeto possui tratamento de exceções personalizadas dentro da classe Biblioteca.

### 7. Biblioteca
A classe biblioteca é a principal, no main se cria uma instancia de biblioteca, nela é armazenada listas de usuários e livros, também é ela que pode gerenciar tudo, adição e remoção de livros e usuários, visualização destas listas e busca individual.
