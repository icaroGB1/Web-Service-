package com.icaroweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.icaroweb.course.entities.Categoria;
import com.icaroweb.course.entities.ItemPedido;
import com.icaroweb.course.entities.Pagamento;
import com.icaroweb.course.entities.Pedido;
import com.icaroweb.course.entities.Produto;
import com.icaroweb.course.entities.Usuario;
import com.icaroweb.course.entities.enums.OrderStatus;
import com.icaroweb.course.repository.CategoriaRepository;
import com.icaroweb.course.repository.ItemPedidoRepository;
import com.icaroweb.course.repository.PedidoRepository;
import com.icaroweb.course.repository.ProdutoRepository;
import com.icaroweb.course.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository UsuarioRepository;

	@Autowired
	private PedidoRepository PedidoRepository;

	@Autowired
	private CategoriaRepository CategoriaRepository;

	@Autowired
	private ProdutoRepository ProdutoRepository;

	@Autowired
	private ItemPedidoRepository ItemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");

		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		CategoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		ProdutoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);

		ProdutoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido o1 = new Pedido(null, Instant.now(), OrderStatus.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.now(), OrderStatus.AGUARDANDO_PAGAMENTO, u2);
		Pedido o3 = new Pedido(null, Instant.now(), OrderStatus.AGUARDANDO_PAGAMENTO, u1);

		UsuarioRepository.saveAll(Arrays.asList(u1, u2));
		PedidoRepository.saveAll(Arrays.asList(o1, o2, o3));

		ItemPedido oi1 = new ItemPedido(o1, p1, 2, p1.getPreco());
		ItemPedido oi2 = new ItemPedido(o1, p3, 1, p3.getPreco());
		ItemPedido oi3 = new ItemPedido(o2, p3, 2, p3.getPreco());
		ItemPedido oi4 = new ItemPedido(o3, p5, 2, p5.getPreco());

		ItemPedidoRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Pagamento pay1 = new Pagamento(null, Instant.now(), o1);
		o1.setPagmento(pay1);
		PedidoRepository.save(o1);

	}
}
