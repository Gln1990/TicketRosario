package com.ticket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class TicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketApplication.class, args);
        System.out.println("----------------------------------------------");
        System.out.println(" O Spring Boot inicializou com sucesso!");
        System.out.println("----------------------------------------------");
    }

    // Esse bloco vai rodar logo apos a inicializacao do sistema
    @Bean
    public CommandLineRunner carregarDados(EventoRepository repository) {
        return args -> {
            // Verifica se o banco ja tem eventos para nao ficar duplicando toda vez que rodar
        	if (repository.count() == 0) {
                // Link fictício ou real do embed do Google Maps para o Allianz Parque
                String mapaAllianz = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3657.9472714092476!2d-46.68112102377317!3d-23.534346860579607!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce57e3f89063cf%3A0xe546b38461719a86!2sAllianz%20Parque!5e0!3m2!1spt-BR!2sbr!4v1716656400000!5m2!1spt-BR!2sbr";
                String mapaMunicipal = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3657.5103442751433!2d-46.64141672376111!3d-23.549214761226065!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce584c3113545b%3A0xc6222b467ec8e40d!2sTheatro%20Municipal%20De%20S%C3%A3o%20Paulo!5e0!3m2!1spt-BR!2sbr!4v1716654100000!5m2!1spt-BR!2sbr";
                String mapaMorumbis = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3656.0494435639683!2d-46.722699823759695!3d-23.6007419631976!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce513360ebc857%3A0x92f96024976451e0!2sEst%C3%A1dio%20C%C3%ADcero%20Pompeu%20de%20Toledo%20(MorumBIS)!5e0!3m2!1spt-BR!2sbr!4v1716654200000!5m2!1spt-BR!2sbr";
                String mapaEspacoUnimed = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3658.11874418612!2d-46.669862323761664!3d-23.530026260173264!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce58032d9f109b%3A0x4bb515a452ef76e4!2sEspa%C3%A7o%20Unimed!5e0!3m2!1spt-BR!2sbr!4v1716654300000!5m2!1spt-BR!2sbr";
                String mapaComedians = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3657.4093952771587!2d-46.652156823761!3d-23.552827761361956!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce59ccb26804d5%3A0x247545ca8d338de2!2sRua%20Augusta%2C%20S%C3%A3o%20Paulo%20-%20SP!5e0!3m2!1spt-BR!2sbr!4v1716654400000!5m2!1spt-BR!2sbr";
                
             // 1. Coldplay (Música)
                Evento ev1 = new Evento("Show do Coldplay", LocalDateTime.of(2026, 11, 15, 21, 0), "Allianz Parque", 250.0, 100, 
                        "coldplay.jpg", "Chris Martin, Jonny Buckland, Guy Berryman, Will Champion", 
                        "Yellow, Fix You, Viva La Vida, Paradise, A Sky Full of Stars", mapaAllianz, 12, "Pista, Pista Premium, Cadeira Inferior, VIP Lounge");
                
             // 2. Jazz (Música)
                Evento ev2 = new Evento("Festival de Jazz", LocalDateTime.of(2026, 8, 22, 18, 30), "Teatro Municipal", 80.0, 50, 
                        "jazz.jpg", "Miles Davis Tribute Band, John Coltrane Experience", 
                        "So What, Take Five, Autumn Leaves", mapaMunicipal, 4, "Platea, Balcão Nobre, Frisa");

                // 3. O Auto da Compadecida (Teatro) - NOVO!
                Evento ev3 = new Evento("Peça: O Auto da Compadecida", LocalDateTime.of(2026, 06, 10, 20, 0), "Teatro Municipal", 60.0, 80, 
                        "teatro.jpg", "Grupo de Teatro Nordestino, Elenco Convidado", 
                        "Adaptação da obra prima de Ariano Suassuna", mapaMunicipal, 15, "Platea VIP, Balcão Superior");

                // 4. São Paulo vs Corinthians (Futebol) - NOVO!
                Evento ev4 = new Evento("São Paulo x Corinthians - Brasileirão", LocalDateTime.of(2026, 07, 05, 16, 0), "Estádio do MorumBIS", 50.0, 500, 
                        "futebol.jpg", "Elenco Principal SPFC e SCCP Corinthians", 
                        "O Majestoso do estado valendo a liderança", mapaMorumbis, 150, "Arquibancada, Cadeira Cativa, Camarote Premium");

                // 5. Festival Rock Nacional (Música) - NOVO!
                Evento ev5 = new Evento("Festival Rock Brasil", LocalDateTime.of(2026, 9, 12, 17, 0), "Espaço Unimed", 120.0, 300, 
                        "rock.jpg", "Capital Inicial, Paralamas do Sucesso, CPM 22", 
                        "Primeiros Erros, Lanterna dos Afogados, Um Minuto para o Fim do Mundo", mapaEspacoUnimed, 8, "Pista Comum, Pista Premium, Mezanino");

                // 6. Noite do Stand-up Comedy (Teatro/Comédia) - NOVO!
                Evento ev6 = new Evento("Noite da Comédia Stand-up", LocalDateTime.of(2026, 06, 18, 22, 30), "Comedians Club", 45.0, 60, 
                        "standup.jpg", "Grandes nomes do humor nacional e convidados", 
                        "Textos 100% autorais e muita improvisação com a plateia", mapaComedians, 24, "Mesa Setor A, Mesa Setor B, Balcão Lateral");

                // Salvando todos os 6 no banco MySQL
                repository.save(ev1); repository.save(ev2); repository.save(ev3);
                repository.save(ev4); repository.save(ev5); repository.save(ev6);
                
                System.out.println(">>> 6 Eventos inseridos com sucesso no MySQL! <<<");
            }
        };
    }
}

/*O que essa classe faz?*/
/*@SpringBootApplication: Essa anotações avisa ao Java que este é um projeto Spring Boot. Ela faz uma varredura automática (component scan) 
 * no pacote com.ticket para achar a nossa classe Evento e a nossa interface EventoRepository que criamos nos passos anteriores.*/
/*SpringApplication.run(...): É a linha que liga o servidor embutido, carrega o Hibernate e faz a mágica acontecer de verdade.*/
