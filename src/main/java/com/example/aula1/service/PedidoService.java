package com.example.aula1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula1.dto.PedidoCreateDTO;
import com.example.aula1.dto.PedidoDTO;
import com.example.aula1.model.PedidoModel;
import com.example.aula1.model.UsuarioModel;
import com.example.aula1.repository.PedidoRepository;
import com.example.aula1.repository.UsuarioRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private UsuarioRepository usuRepository;


    public String criarPedido(Long usuarioId, PedidoModel pedido) {
        
         Optional<UsuarioModel> usuario = usuRepository.findById(usuarioId);

            if (usuario.isPresent()) {
                 pedido.setUsuario(usuario.get());
                 repository.save(pedido);
                 return "Pedido criado com sucesso";
            } else {
                    return "Usuario nao encontrado";
        }
    }

    public List<PedidoModel> listarPedidos() {
        return repository.findAll();
    }


    public List<PedidoModel> listarPedidosPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }



    public List<PedidoDTO> listarPedidosDTO(){
        return repository.findAll() // busca todos os pedidos no banco
        .stream() // transforma em um stream para percorrer
        .map(pedido -> new PedidoDTO(   // para cada pedido, cria um pedidoDTO
            pedido.getDescricao(),  
            pedido.getValor(),
            pedido.getUsuario().getNome()))
            .toList();  // retorna a lista
    }


    public PedidoDTO criarPedidoDTO( Long usuarioid,PedidoCreateDTO dto) {
        
        Optional<UsuarioModel> usuario = usuRepository.findById(usuarioid);
        if (usuario.isPresent()) {

            PedidoModel pedido = new PedidoModel();
            pedido.setDescricao(dto.getDescricao());
            pedido.setValor(dto.getValor());
            pedido.setUsuario(usuario.get());
            PedidoModel pedidoSalvo = repository.save(pedido);
            PedidoDTO pedidoDTO = new PedidoDTO(pedidoSalvo.getId(), pedidoSalvo.getDescricao(), pedidoSalvo.getValor(), pedidoSalvo.getUsuario().getNome());
            return pedidoDTO;
        } else {
            throw new RuntimeException("Usuario nao encontrado");
        }
        
    }


    public PedidoDTO atualizarPedidoDTO(Long id, PedidoCreateDTO dto){

        Optional<PedidoModel> pedido = repository.findById(id);

        if (pedido.isPresent()) {
            PedidoModel pedidoAtualizado = pedido.get();
            if (dto.getDescricao() != null) {
                    pedidoAtualizado.setDescricao(dto.getDescricao());
            }
            if (dto.getValor() != null) {
                pedidoAtualizado.setValor(dto.getValor());
            }
            

            repository.save(pedidoAtualizado);

            PedidoDTO pedidoDTO = new PedidoDTO(pedidoAtualizado.getId(), pedidoAtualizado.getDescricao(), pedidoAtualizado.getValor(), pedidoAtualizado.getUsuario().getNome());
            return pedidoDTO;
        } else {
            throw new RuntimeException("Pedido nao encontrado");
        }


    }


    public String removerPedido(Long id) {
        Optional<PedidoModel> pedido = repository.findById(id);
        if (pedido.isPresent()) {
            repository.delete(pedido.get());
            return "Pedido removido com sucesso";
        } else {
            return "Pedido nao encontrado";
        }
    }

}