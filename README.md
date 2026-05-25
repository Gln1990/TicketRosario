# 🎫 TicketPass - Sistema de Venda de Ingressos

O **TicketPass** é uma aplicação web completa desenvolvida para listagem, gerenciamento e visualização de detalhes de eventos e ingressos (como shows, peças de teatro e partidas de futebol). O sistema conta com uma interface moderna, totalmente responsiva e integrada a um banco de dados relacional para persistência de dados.

---

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando as melhores práticas de desenvolvimento de software e as seguintes tecnologias:

* **Java 17**: Linguagem de programação principal do sistema.
* **Spring Boot 3**: Framework utilizado para estruturar a aplicação, injeção de dependências e gerenciamento de rotas.
    * *Spring Data JPA*: Para mapeamento objeto-relacional (ORM) e manipulação do banco de dados de forma simplificada.
    * *Spring Web*: Para criação do padrão MVC (Model-View-Controller).
* **Thymeleaf**: Mecanismo de template Java para renderização dinâmica de dados do back-end diretamente nas páginas HTML.
* **MySQL**: Banco de dados relacional utilizado para armazenar de forma segura as informações dos eventos.
* **HTML5 & CSS3**: Estruturação visual focada em design moderno, componentes encapsulados em arquivos separados e grid layouts fluidos.

---

## 🎨 Funcionalidades Principais

* **Painel Inicial Responsivo**: Listagem de eventos disponíveis no formato de *cards modernizados*, adaptáveis para computadores e dispositivos móveis.
* **Filtros Avançados de Grid**: Exibição fluida lado a lado aproveitando o espaço total de visualização dos navegadores.
* **Página de Detalhes Dinâmica**: Ao selecionar um evento, o sistema carrega informações exclusivas do banco de dados, como artistas, músicas de sucesso, setores disponíveis e quantidade de ingressos.
* **Integração com Google Maps**: Incorporação em tempo real (via tags `<iframe>` oficiais do Google) da localização exata do evento de forma interativa.
* **Carga de Dados Automática (Seeding)**: Inicialização inteligente do banco de dados usando `CommandLineRunner` para povoar o sistema com 6 eventos comerciais reais no primeiro login.
* **Identidade Visual Unificada**: Layout com cabeçalho (`<nav>`) estilizado em degradê premium e rodapé (`<footer>`) com canais de suporte ao cliente.

---

## 🛠️ Como Executar o Projeto Localmente

### Pré-requisitos
* Java JDK 17 ou superior instalado.
* IDE de sua preferência (Eclipse, IntelliJ, VS Code).
* MySQL Server ativo em sua máquina.

### Passo a Passo
1.  Clone este repositório para a sua máquina local:
    ```bash
    git clone [https://github.com/SEU_USUARIO_DO_GITHUB/ticketpass.git](https://github.com/SEU_USUARIO_DO_GITHUB/ticketpass.git)
    ```
2.  Abra o seu MySQL Workbench (ou terminal) e crie o banco de dados do sistema:
    ```sql
    CREATE DATABASE db_ticket;
    ```
3.  Abra o arquivo `src/main/resources/application.properties` e insira suas credenciais locais do MySQL se houver:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/db_ticket
    spring.datasource.username=root
    spring.datasource.password=SUA_SENHA
    ```
4.  Execute a aplicação através da classe principal `TicketApplication.java` (botão direito -> *Run As -> Spring Boot App*).
5.  Abra o seu navegador e acesse a URL:
    ```text
    http://localhost:8080/eventos
    ```

---

## 📂 Estrutura do Projeto

* `src/main/java`: Contém toda a lógica de negócio em Java (Controllers, Repositories, Models).
* `src/main/resources/templates`: Arquivos HTML dinâmicos estruturados com Thymeleaf (`lista-eventos.html`, `detalhes-evento.html`).
* `src/main/resources/static`: Arquivos estáticos da aplicação separados organizadamente em subpastas (`/css/estilo.css` e `/imagens/`).

---

## 👤 Desenvolvedor

* **Seu Nome Completo**
    * [LinkedIn](https://linkedin.com/in/gleyson-rosario/)
    * [GitHub](https://github.com/Gln1990)
