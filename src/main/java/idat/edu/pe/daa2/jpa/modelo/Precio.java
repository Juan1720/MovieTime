package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="precio")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Precio.findAll", query="SELECT p FROM Precio p"),
	@NamedQuery(name="Precio.findByidPrecio",query="SELECT p FROM Precio p WHERE p.idPrecio =:idPrecio"),
	@NamedQuery(name="Precio.findByPrecio", query="SELECT p FROM Precio p WHERE p.precio=:precio"),
	@NamedQuery(name="Precio.findByDescripPrecio", query="SELECT p FROM Precio p WHERE p.DescripPrecio=:DescripPrecio")	
})

public class Precio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idPrecio")
	private Integer idPrecio;
	@Basic(optional=false)
	@Column(name="precio")
	private Float precio;
	@Basic(optional=false)
	
	@Column(name="DescripPrecio")
	private String DescripPrecio;
	@Basic(optional=false)
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy= "precio")
	private List<VentaEntrada> ventaEntradaList;
	
	public Precio() {
		
	}
	
	public Precio(Integer idPrecio) {
		this.idPrecio= idPrecio;
	}
	
	public Precio(Integer idPrecio,Float precio,String descripPrecio) {
		this.idPrecio= idPrecio;
		this.precio= precio;
		this.DescripPrecio=descripPrecio;
	}
	
	
	public Integer getIdPrecio() {
		return idPrecio;
	}

	public void setIdPrecio(Integer idPrecio) {
		this.idPrecio = idPrecio;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getDescripPrecio() {
		return DescripPrecio;
	}

	public void setDescripPrecio(String descripPrecio) {
		DescripPrecio = descripPrecio;
	}

	@XmlTransient
	public List<VentaEntrada> getVentaEntradaList(){
		return ventaEntradaList;
	}
	public void setVentaEntradaList(List<VentaEntrada>ventaEntradaList) {
		this.ventaEntradaList= ventaEntradaList;
	}
	
	@Override
	public int hashCode() {
		int hash=0;
		hash +=(idPrecio!=null?idPrecio.hashCode():0);
		return hash;
	}
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof Precio)) {
			return false;
		}
		Precio other =(Precio)object;
		if((this.idPrecio==null && other.idPrecio !=null)||(this.idPrecio!=null && !this.idPrecio.equals(other.idPrecio))) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "javaapplication1.Precio[idPrecio=" + idPrecio+"]";
	}
	
}
