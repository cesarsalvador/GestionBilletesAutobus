/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario0316
 */
@Entity
@Table(name = "autobus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autobus.findAll", query = "SELECT a FROM Autobus a"),
    @NamedQuery(name = "Autobus.findByIdAutobus", query = "SELECT a FROM Autobus a WHERE a.idAutobus = :idAutobus"),
    @NamedQuery(name = "Autobus.findByMatricula", query = "SELECT a FROM Autobus a WHERE a.matricula = :matricula"),
    @NamedQuery(name = "Autobus.findByMarca", query = "SELECT a FROM Autobus a WHERE a.marca = :marca"),
    @NamedQuery(name = "Autobus.findByPlazas", query = "SELECT a FROM Autobus a WHERE a.plazas = :plazas")})
public class Autobus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAutobus")
    private Integer idAutobus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plazas")
    private int plazas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutobus")
    private Collection<Ruta> rutaCollection;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleados idEmpleado;

    public Autobus() {
    }

    public Autobus(Integer idAutobus) {
        this.idAutobus = idAutobus;
    }

    public Autobus(Integer idAutobus, String matricula, String marca, int plazas) {
        this.idAutobus = idAutobus;
        this.matricula = matricula;
        this.marca = marca;
        this.plazas = plazas;
    }

    public Integer getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(Integer idAutobus) {
        this.idAutobus = idAutobus;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @XmlTransient
    public Collection<Ruta> getRutaCollection() {
        return rutaCollection;
    }

    public void setRutaCollection(Collection<Ruta> rutaCollection) {
        this.rutaCollection = rutaCollection;
    }

    public Empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleados idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutobus != null ? idAutobus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autobus)) {
            return false;
        }
        Autobus other = (Autobus) object;
        if ((this.idAutobus == null && other.idAutobus != null) || (this.idAutobus != null && !this.idAutobus.equals(other.idAutobus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Autobus[ idAutobus=" + idAutobus + " ]";
    }
    
}
