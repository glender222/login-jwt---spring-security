package com.example.demo.login.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
@Table(name = "accesos")
public class Acceso {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "acceso_seq_gen", sequenceName = "acceso_seq_gen", allocationSize = 1)
    private Long id;

    @Column(name="tipo_vista")
	private String tipo_vista;
	@Column(name="icono")
	private String icono;
	@Column(name="url")
	private String url;
	@Column(name="estado",length = 1)
	private char estado;
    
    @ManyToMany
	@JoinTable(
			name="Rol_Acceso",
			joinColumns = @JoinColumn(name="id_acceso", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="id_rol", referencedColumnName = "id")
			)
    @JsonIgnore
	private Set<Rol> roles;
}
