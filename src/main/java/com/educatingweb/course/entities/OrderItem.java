package com.educatingweb.course.entities;

import java.io.Serializable;

import com.educatingweb.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK orderItemPK = new OrderItemPK();

	private Integer quantity;
	private Double price;

	public OrderItem() {

	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		orderItemPK.setProduct(product);
		orderItemPK.setOrder(order);
		this.quantity = quantity;
		this.price = price;
	}

	public Product getProduct() {
		return orderItemPK.getProduct();
	}

	public void setProduct(Product product) {
		orderItemPK.setProduct(product);
	}

	@JsonIgnore
	public Order getOrder() {
		return orderItemPK.getOrder();
	}

	public void setOrder(Order order) {
		orderItemPK.setOrder(order);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubTotal() {
		return price * quantity;
	}

}
