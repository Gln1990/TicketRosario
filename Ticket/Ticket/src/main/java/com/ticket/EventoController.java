package com.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    // 1. Lista todos os eventos na Página Inicial
    @GetMapping("/eventos")
    public String listarEventos(Model model) {
        List<Evento> lista = eventoRepository.findAll();
        model.addAttribute("eventos", lista);
        return "lista-eventos";
    }
    
    // 2. Abre a página com o formulário de cadastro (O que estava faltando!)
    @GetMapping("/eventos/novo")
    public String exibirFormularioCadastro() {
        return "novo-evento";
    }

    // 3. Recebe os dados do formulário e salva o novo evento no MySQL
    @PostMapping("/eventos/salvar")
    public String salvarNovoEvento(
            @RequestParam("nome") String nome,
            @RequestParam("local") String local,
            @RequestParam("dataEvento") String dataTexto,
            @RequestParam("precoBase") Double precoBase,
            @RequestParam("quantidadeDisponivel") Integer quantidadeDisponivel,
            @RequestParam("nomeImagem") MultipartFile arquivoImagem,
            @RequestParam("artistas") String artistas,
            @RequestParam("maioresSucessos") String maioresSucessos,
            @RequestParam("linkMapa") String linkMapa,
            @RequestParam("vezesEmSp") Integer vezesEmSp,
            @RequestParam("tiposIngresso") String tiposIngresso) {
        
        // Converte a data de texto vinda do HTML para LocalDateTime do Java
        LocalDateTime dataConvertida = LocalDateTime.parse(dataTexto);
        
        // Lógica de captura e salvamento físico da imagem
        String nomeImagem = "default.jpg"; 
        if (arquivoImagem != null && !arquivoImagem.isEmpty()) {
            nomeImagem = arquivoImagem.getOriginalFilename();
            try {
                byte[] bytes = arquivoImagem.getBytes();
                Path caminho = Paths.get("src/main/resources/static/imagens/" + nomeImagem);
                Files.write(caminho, bytes);
            } catch (Exception e) {
                System.out.println("Erro ao salvar imagem fisicamente: " + e.getMessage());
            }
        }
        
        // Cria e salva o objeto no banco de dados
        Evento novoEvento = new Evento(nome, dataConvertida, local, precoBase, quantidadeDisponivel, 
                nomeImagem, artistas, maioresSucessos, linkMapa, vezesEmSp, tiposIngresso);
        
        eventoRepository.save(novoEvento);
        
        return "redirect:/eventos";
    }

    // 4. Abre a tela de Detalhes de um evento específico
    @GetMapping("/eventos/detalhes/{id}")
    public String exibirDetalhes(@PathVariable("id") Long id, Model model) {
        Evento evento = eventoRepository.findById(id).orElse(null);
        if (evento != null) {
            model.addAttribute("evento", evento);
            return "detalhes-evento"; 
        }
        return "redirect:/eventos";
    }

    // 5. Abre a tela de Checkout/Compra de ingressos
    @GetMapping("/eventos/comprar/{id}")
    public String abrirCheckout(@PathVariable("id") Long id, Model model) {
        Evento evento = eventoRepository.findById(id).orElse(null);
        if (evento != null) {
            model.addAttribute("evento", evento);
            return "checkout";
        }
        return "redirect:/eventos";
    }

    // 6. Processa a lógica de compra, valida estoque e calcula o valor total
    @PostMapping("/eventos/confirmar-compra")
    public String confirmarCompra(
            @RequestParam("idEvento") Long idEvento,
            @RequestParam("quantidade") Integer quantidade,
            Model model) {
        
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        
        if (evento != null) {
            // Validação de estoque disponível
            if (quantidade > evento.getQuantidadeDisponivel()) {
                model.addAttribute("evento", evento);
                model.addAttribute("erro", "Desculpe! Estoque insuficiente. Temos apenas " + evento.getQuantidadeDisponivel() + " disponíveis.");
                return "checkout"; 
            }
            
            // Abate a quantidade comprada do estoque e atualiza o banco
            evento.setQuantidadeDisponivel(evento.getQuantidadeDisponivel() - quantidade);
            eventoRepository.save(evento); 
            
            // Calcula o valor total a pagar
            Double valorTotal = evento.getPrecoBase() * quantidade;
            
            // Envia os dados consolidados para a tela de recibo de sucesso
            model.addAttribute("evento", evento);
            model.addAttribute("quantidadeComprada", quantidade);
            model.addAttribute("valorTotal", valorTotal);
            
            return "sucesso-compra";
        }
        
        return "redirect:/eventos";
    }
    
 // 7. Rota para excluir um evento pelo ID
    @GetMapping("/eventos/excluir/{id}")
    public String excluirEvento(@PathVariable("id") Long id) {
        // Verifica se o evento realmente existe no banco antes de tentar deletar
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
            System.out.println("Evento com ID " + id + " excluído com sucesso!");
        }
        
        // Redireciona de volta para a lista de eventos, que já vai aparecer atualizada
        return "redirect:/eventos";
    }
}
