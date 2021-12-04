package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ventaentrada")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="VentaEntrada.findAll",query="SELECT v FROM VentaEntrada v"),
	@NamedQuery(name="VentaEntrada.findByIdEntrada",query="SELECT v FROM VentaEntrada v WHERE v.idEntrada=:idEntrada"),
	@NamedQuery(name="VentaEntrada.findByEntradas",query="SELECT v FROM VentaEntrada v WHERE v.cantEntradas=:cantEntradas"),
	@NamedQuery(name="VentaEntrada.findByFecha",query="SELECT v FROM VentaEntrada v WHERE v.fecha=:fecha"),
	@NamedQuery(name="VentaEntrada.findByMontoTotal",query="SELECT v FROM VentaEntrada v WHERE v.montoTotal=:montoTotal")
	})
public class VentaEntrada implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntrada")
    private Integer idEntrada;
	@Basic(optional = false)
    @Column(name = "cantEntradas")
    private Float cantEntradas;
	@Basic(optional = false)
    @Column(name = "fecha")
    private Date fecha;
	@Basic(optional = false)
    @Column(name = "montoTotal")
    private Float montoTotal;
	@JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "funciones", referencedColumnName = "idFuncion")
    @ManyToOne(optional = false)
    private Funciones funciones;
    
    public VentaEntrada() {
    	
    }
    public VentaEntrada(Integer idEntrada) {
    	this.idEntrada=idEntrada;
    }
    public VentaEntrada(Integer idEntrada, Float cantEntradas, Date fecha,Float montoTotal) {
    	this.idEntrada=idEntrada;
    	this.cantEntradas=cantEntradas;
    	this.fecha=fecha;
    	this.montoTotal=montoTotal;
       	
    }
	public Integer getIdEntrada() {
		return idEntrada;
	}
	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
	}
	public Float getCantEntradas() {
		return cantEntradas;
	}
	public void setCantEntradas(Float cantEntradas) {
		this.cantEntradas = cantEntradas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Funciones getFunciones() {
		return funciones;
	}
	public void setFunciones(Funciones funciones) {
		this.funciones = funciones;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrada != null ? idEntrada.hashCode() : 0);
        return hash;
    }
	
	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaEntrada)) {
            return false;
        }
        VentaEntrada other = (VentaEntrada) object;
        if ((this.idEntrada == null && other.idEntrada != null) || (this.idEntrada != null && !this.idEntrada.equals(other.idEntrada))) {
            return false;
        }
        return true;
    }
	@Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.VentaEntrada[ idEntrada=" + idEntrada + " ]";
    }
}