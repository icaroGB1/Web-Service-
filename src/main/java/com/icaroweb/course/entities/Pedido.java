package com.icaroweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.icaroweb.course.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'", timezone = "GMT")
	private Instant momento;

	private Integer orderStatus;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();

	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagmento;

	public Pedido() {

	}

	public Pedido(Long id, Instant momento, OrderStatus orderStatus, Usuario cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setOrderStatus(orderStatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public Pagamento getPagmento() {
		return pagmento;
	}

	public void setPagmento(Pagamento pagmento) {
		this.pagmento = pagmento;
	}

	public double getTotal() {
		double soma = 0.0;
		for (ItemPedido x : itens) {
			soma += x.getSubTotal();
		}
		return soma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valor(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}

	}

}
