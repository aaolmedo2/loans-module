package com.banquito.core.cuentas.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "servicios_asociados", schema = "public")
public class ServiciosAsociados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @OneToMany(mappedBy = "idServicio")
    private Set<ComisionesCargos> comisionesCargos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idServicio")
    private Set<com.banquito.core.cuentas.modelo.ServiciosAsociadosCuentas> serviciosAsociadosCuentas = new LinkedHashSet<>();

    public ServiciosAsociados() {}

    public ServiciosAsociados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Set<ComisionesCargos> getComisionesCargos() {
        return comisionesCargos;
    }

    public void setComisionesCargos(Set<ComisionesCargos> comisionesCargos) {
        this.comisionesCargos = comisionesCargos;
    }

    public Set<com.banquito.core.cuentas.modelo.ServiciosAsociadosCuentas> getServiciosAsociadosCuentas() {
        return serviciosAsociadosCuentas;
    }

    public void setServiciosAsociadosCuentas(Set<com.banquito.core.cuentas.modelo.ServiciosAsociadosCuentas> serviciosAsociadosCuentas) {
        this.serviciosAsociadosCuentas = serviciosAsociadosCuentas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ServiciosAsociados other = (ServiciosAsociados) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}