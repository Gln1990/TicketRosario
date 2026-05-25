package com.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Pronto! Toda a lógica de CRUD (Salvar, Ler, Alterar, Deletar) já está herdada aqui.
}
/*extends JpaRepository<Evento, Long>: Estamos usando herança! 
 * A nossa interface está herdando tudo de uma interface gigante do Spring chamada JpaRepository.*/

/*Os Parâmetros <Evento, Long>: Avisamos ao Spring que este repositório serve 
 * para cuidar da classe Evento e que o tipo da Chave Primária (@Id) dela é um Long.*/

/*Com essa única linha de herança, você acabou de ganhar os seguintes métodos prontos para usar mais para frente no código:
 * save(evento) -> Insere um novo evento no banco (faz o INSERT).
 * findAll() -> Busca todos os eventos cadastrados (faz o SELECT * FROM eventos).
 * findById(id) -> Busca um evento específico pelo número do ID.
 * deleteById(id) -> Remove um evento do banco de dados.*/
