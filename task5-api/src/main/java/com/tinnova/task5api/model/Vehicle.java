package com.tinnova.task5api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tinnova.task5api.enums.VehicleBrandsEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "veiculo")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String vehicleName;

	@Enumerated(EnumType.STRING)
	@Column(name = "marca", nullable = true)
	private VehicleBrandsEnum brand;

	@Column(name = "ano", nullable = false)
	private int year;

	@Column(name = "descricao", nullable = true)
	private String description;

	@Column(name = "vendido", nullable = false)
	private boolean sold;

	@Column(name = "created", nullable = true)
	private Date createdAt;

	@Column(name = "updated", nullable = true)
	private Date updatedAt;
}
