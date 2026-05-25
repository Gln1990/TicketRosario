package com.ticket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

/*Esse tipo de classe no Spring é chamado de Entidade (Entity) ou Model. 
 *O grande objetivo dela é ser uma ponte: ela representa um objeto na memória do Java e, 
 *ao mesmo tempo, diz ao banco de dados como criar e estruturar a tabela de eventos. */

/*As linhas que começam com @ são instruções para o Spring e para o JPA (o mecanismo que cuida do banco de dados). 
 * Elas evitam que você precise escrever comandos SQL como CREATE TABLE na mão*/

/*@Entity: Avisa ao Spring: 
 * "Olha, essa classe não é uma classe comum; ela representa uma tabela no banco de dados"*/
@Entity


/*@Table(name = "eventos"): Define explicitamente que o nome da tabela no banco de dados MySQL será eventos. Se não colocássemos isso, 
 * o banco criaria a tabela com o nome "Evento" (com a primeira letra maiúscula)*/
@Table(name = "eventos")

public class Evento {

	/*@Id: Indica qual dos atributos será a Chave Primária (Primary Key) da tabela.*/
    @Id
    
    /*@GeneratedValue(strategy = GenerationType.IDENTITY): Avisa ao banco de dados que o campo idEvento é um Auto-incremento (1, 2, 3, 4...). Você não precisa gerar esse número no Java, 
     * o próprio MySQL faz isso sozinho toda vez que um novo show for cadastrado.*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /*private Long idEvento; -> Usamos Long (um número inteiro grande) 
     * porque chaves primárias podem crescer muito.*/
    private Long idEvento;
    
    /*private String nome; -> O nome do show ou teatro.*/
    private String nome;
    
    /*private LocalDateTime dataEvento; -> O tipo LocalDateTime é o padrão moderno do Java 
     * para guardar data e hora juntas (ex: 22/05/2026 às 21:00).*/
    private LocalDateTime dataEvento;
    
    /*private String local; -> O estádio, teatro ou casa de shows.*/
    private String local;
    
    /*private Double precoBase; -> O valor do ingresso. 
     * Usamos Double por causa das casas decimais (centavos).*/
    private Double precoBase;
    
    private Integer quantidadeDisponivel;

 // ---- NOVOS CAMPOS PARA A TELA DE DETALHES ----
    private String nomeImagem;         // Ex: coldplay.jpg
    private String artistas;           // Ex: Chris Martin, Guy Berryman...
    @Column(length = 500)
    private String maioresSucessos;    // Ex: Yellow, Fix You, Viva la Vida
    @Column(length = 1000)
    private String linkMapa;           // URL do Google Maps para o iframe
    private Integer vezesEmSp;         // Quantidade de vezes que tocaram em SP
    private String tiposIngresso;      // Ex: Pista, Pista Premium, VIP
    
    
    // Construtor padrao (Obrigatorio para o Spring/JPA rodar por baixo dos panos)
    /*public Evento() { }: Este construtor vazio é obrigatório. Quando o Spring Boot busca os dados do MySQL e 
     * tenta converter as linhas da tabela de volta para objetos Java, 
     * ele faz isso chamando o construtor padrão, sem passar parâmetros, e depois preenche o objeto aos poucos.*/
    public Evento() {
    }
    
    

    // Construtor completo (Para nos ajudar a criar eventos nos testes)
    /*public Evento(String nome, ...): É o construtor completo. 
     * Nós vamos usar esse cara no código quando formos cadastrar um evento novo de forma rápida, 
     * passando todos os dados de uma vez só na criação do objeto (ex: new Evento("Show Interno", data, "Estádio", 150.0)).*/
    public Evento(String nome, LocalDateTime dataEvento, String local, Double precoBase, Integer quantidadeDisponivel, String nomeImagem, String artistas, 
            String maioresSucessos, String linkMapa, Integer vezesEmSp, String tiposIngresso) {
        this.nome = nome;
        this.dataEvento = dataEvento;
        this.local = local;
        this.precoBase = precoBase;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.nomeImagem = nomeImagem;
        this.artistas = artistas;
        this.maioresSucessos = maioresSucessos;
        this.linkMapa = linkMapa;
        this.vezesEmSp = vezesEmSp;
        this.tiposIngresso = tiposIngresso;
    }
    
    

    // --- GETTERS E SETTERS (Encapsulamento) ---
    /*Repare que todos os atributos lá no topo foram declarados como private. 
     * Isso protege os dados para que nenhuma outra classe do sistema consiga alterá-los diretamente de forma bagunçada.
      Para ler ou modificar esses valores de forma segura, usamos os métodos públicos:*/
    
    
    /*get (Pegar/Ler): Retorna o valor atual do atributo.*/
    public Long getIdEvento() {
        return idEvento;
    }
    
    /*set (Definir/Alterar): Recebe um novo valor por parâmetro e atualiza o 
     * atributo interno de forma controlada.*/
    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }
    
    public Integer getQuantidadeDisponivel() {
    	return quantidadeDisponivel;
    }
    
    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
    	this.quantidadeDisponivel = quantidadeDisponivel;
    }
    
    public String getNomeImagem() { 
    	return nomeImagem; 
    }
    
    public void setNomeImagem(String nomeImagem) { 
    	this.nomeImagem = nomeImagem; 
    }
    
    public String getArtistas() { 
    	return artistas; 
    }
    
    public void setArtistas(String artistas) { 
    	this.artistas = artistas; 
    }
    
    public String getMaioresSucessos() { 
    	return maioresSucessos; 
    }
    
    public void setMaioresSucessos(String maioresSucessos) { 
    	this.maioresSucessos = maioresSucessos; 
    }
    
    public String getLinkMapa() { 
    	return linkMapa; 
    }
    
    public void setLinkMapa(String linkMapa) { 
    	this.linkMapa = linkMapa; 
    }
    
    public Integer getVezesEmSp() { 
    	return vezesEmSp; 
    }
    
    public void setVezesEmSp(Integer vezesEmSp) { 
    	this.vezesEmSp = vezesEmSp; 
    }
    
    public String getTiposIngresso() { 
    	return tiposIngresso; 
    	}
    
    public void setTiposIngresso(String tiposIngresso) { 
    	this.tiposIngresso = tiposIngresso; 
    }
    
}
