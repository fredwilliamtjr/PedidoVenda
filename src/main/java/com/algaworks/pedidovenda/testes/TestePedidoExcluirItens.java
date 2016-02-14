package com.algaworks.pedidovenda.testes;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.EnderecoEntrega;
import com.algaworks.pedidovenda.model.FormaPagamento;
import com.algaworks.pedidovenda.model.ItemPedido;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.model.StatusPedido;
import com.algaworks.pedidovenda.model.Usuario;

public class TestePedidoExcluirItens {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction trx = manager.getTransaction();
        trx.begin();

        Pedido pedido = manager.find(Pedido.class, 6L);
        System.out.println("\nProduto a ser removido : " + pedido.getItens().get(0).getProduto().getNome() + "\n\n");
        ItemPedido remove = pedido.getItens().remove(0);
        System.out.println("Removendo : " + remove.getProduto().getNome()+"\n\n");
        manager.persist(pedido);
        trx.commit();
        System.out.println("\n\n" + remove.getProduto().getNome() + ", Removido com sucesso!");
        

//		Cliente cliente = manager.find(Cliente.class, 1L);
//		Produto produto1 = manager.find(Produto.class, 1L);
//                Produto produto2 = manager.find(Produto.class, 2L);
//		Usuario vendedor = manager.find(Usuario.class, 1L);
//		
//		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
//		enderecoEntrega.setLogradouro("Rua dos Mercados");
//		enderecoEntrega.setNumero("1000");
//		enderecoEntrega.setCidade("Uberlândia");
//		enderecoEntrega.setUf("MG");
//		enderecoEntrega.setCep("38400-123");
//		
//		Pedido pedido = new Pedido();
//		pedido.setCliente(cliente);
//		pedido.setDataCriacao(new Date());
//		pedido.setDataEntrega(new Date());
//		pedido.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
//		pedido.setObservacao("Aberto das 08 às 18h");
//		pedido.setStatus(StatusPedido.ORCAMENTO);
//		pedido.setValorDesconto(BigDecimal.ZERO);
//		pedido.setValorFrete(BigDecimal.ZERO);
//		pedido.setValorTotal(new BigDecimal(23.2));
//		pedido.setVendedor(vendedor);
//		pedido.setEnderecoEntrega(enderecoEntrega);
//		
//		ItemPedido item1 = new ItemPedido();
//		item1.setProduto(produto1);
//		item1.setQuantidade(10);
//		item1.setValorUnitario(new BigDecimal(2.32));
//		item1.setPedido(pedido);
//                
//                ItemPedido item2 = new ItemPedido();
//		item2.setProduto(produto2);
//		item2.setQuantidade(10);
//		item2.setValorUnitario(new BigDecimal(4.32));
//		item2.setPedido(pedido);
//		
//		pedido.getItens().add(item1);
//                pedido.getItens().add(item2);
//		
//		manager.persist(pedido);
//        trx.commit();
    }

}
