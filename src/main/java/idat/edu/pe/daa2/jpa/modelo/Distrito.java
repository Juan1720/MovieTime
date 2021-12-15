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
@Table(name="distrito")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Distrito.findAll", query="SELECT d FROM Distrito d"),
	@NamedQuery(name="Distrito.findByIdDistrito",query="SELECT d FROM Distrito d WHERE d.idDistrito =:idDistrio"),
	@NamedQuery(name="Distrito.findByDistrito", query="SELECT d FROM Distrito d WHERE d.distrito=:distrito")
		
})

public class Distrito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idDistrito")
	private Integer idDistrito;
	@Basic(optional=false)
	@Column(name="distrito")
	private String distrito;
	@OneToMany(cascade = CascadeType.ALL,mappedBy= "distrito")
	private List<Cine> cineList;
	
	public Distrito() {
		
	}
	
	public Distrito(Integer idDistrito) {
		this.idDistrito= idDistrito;
	}
	
	public Distrito(Integer idDistrito,String distrito) {
		this.idDistrito= idDistrito;
		this.distrito= distrito;
	}

	public Integer getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	@XmlTransient
	public List<Cine> getCineList(){
		return cineList;
	}
	public void setCineList(List<Cine>cineList) {
		this.cineList= cineList;
	}
	
	@Override
	public int hashCode() {
		int hash=0;
		hash +=(idDistrito!=null?idDistrito.hashCode():0);
		return hash;
	}
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof Distrito)) {
			return false;
		}
		Distrito other =(Distrito)object;
		if((this.idDistrito==null && other.idDistrito !=null)||(this.idDistrito!=null && !this.idDistrito.equals(other.idDistrito))) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "javaapplication1.Distrito[idDistrito=" + idDistrito+"]";
	}

}
