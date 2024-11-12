package com.example.demo.login.Entity;

import java.util.HashSet;
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
@Table(name = "roles")
public class Rol {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "rol_seq_gen", sequenceName = "rol_seq_gen", allocationSize = 1)
    private Long id;

    @Column(name = "rol", length = 30)
    private String rol;
    
    @Column(name = "estado", length = 30)
    private String estado;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Acceso> accesos = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();

}
