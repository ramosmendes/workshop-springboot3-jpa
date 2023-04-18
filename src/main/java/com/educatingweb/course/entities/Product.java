package com.educatingweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = { "name", "description", "price", "imgUrl", "categories", "items" })
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;

	@NonNull
	private String name;

	@NonNull
	private String description;

	@NonNull
	private Double price;

	@NonNull
	private String imgUrl;

	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	@Setter(value = AccessLevel.NONE)
	private Set<Category> categories = new HashSet<>();

	@OneToMany(mappedBy = "orderItemPK.product")
	@Setter(value = AccessLevel.NONE)
	private Set<OrderItem> items = new HashSet<>();

	@JsonIgnore
	public Set<Order> getOrders() {
		Set<Order> order = new HashSet<>();
		for (OrderItem orderItem : items) {
			items.add(orderItem);
		}
		return order;
	}

}
