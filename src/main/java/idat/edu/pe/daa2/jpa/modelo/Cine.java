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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.NamedQueries;

@Entity
@Table(name="cine")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name ="Cine.findAll", query="SELECT c FROM Cine c"),
	@NamedQuery(name="Cine.findByIdCine", query="SELECT c FROM Cine c WHERE c.idCine=:idCine"),
	@NamedQuery(name="Curso.findByCine", query="SELECT c FROM Cine c WHERE c.cine=: cine"),
	@NamedQuery(name="Cine.findByTelefono", query="SELECT c FROM Cine c WHERE c.telefono=:telefono"),
	@NamedQuery(name="Curso.findByDireccion", query="SELECT c FROM Cine c WHERE c.direccion=: direccion"),
	@NamedQuery(name="Cine.findByImagen", query="SELECT c FROM Cine c WHERE c.imagen=:imagen"),
	@NamedQuery(name="Curso.findByEstado", query="SELECT c FROM Cine c WHERE c.estado=: estado")
})

public class Cine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idCine")
	private Integer idCine;
	@Basic(optional=false)
	@Column(name="cine")
	private String cine;
	@Basic(optional=false)
	@Column(name="telefono")
	private String telefono;
	@Basic(optional=false)
	@Column(name="direccion")
	private String direccion;
	@Basic(optional=false)
	@Column(name="imagen")
	private String imagen;
	@Basic(optional=false)
	@Column(name="estado")
	private Boolean estado;
	@OneToMany(cascade= CascadeType.ALL,mappedBy ="cine")
	 //@JsonBackReference(value="curso_notas")
	private List<Funciones> funcionesList;
	@JoinColumn(name="distrito", referencedColumnName = "idDistrito")
	@ManyToOne(optional= false)
	private Distrito distrito;
	
	public Cine() {
		
	}
	
	public Cine(Integer idCine) {
		this.idCine= idCine;
	}
	
	public Cine(Integer idCine,String cine,String telefono,String direccion,String imagen,Boolean estado) {
		this.idCine= idCine;
		this.cine= cine;
		this.telefono= telefono;
		this.direccion= direccion;
		this.imagen= imagen;
		this.estado= estado;
	}

	public Integer getIdCine() {
		return idCine;
	}

	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}

	public String getCine() {
		return cine;
	}

	public void setCine(String cine) {
		this.cine = cine;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	@XmlTransient
	public List<Funciones> getFuncionesList() {
		 return funcionesList;
	}

	public void setFuncionesList(List<Funciones> funcionesList) {
		this.funcionesList = funcionesList;
	}
	
	@Override
	public int hashCode() {
	int hash = 0;
	hash += (idCine != null ? idCine.hashCode() : 0);
	return hash;
	}

	
	@Override
	public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Cine)) {
	return false;
	}
	Cine other = (Cine) object;
	if ((this.idCine== null && other.idCine!= null) || (this.idCine!= null && !this.idCine.equals(other.idCine))) {
	return false;
	}
	return true;
	}



	@Override
	public String toString() {
		return "javaapplication1.Cine[ idCine=" + idCine+ " ]";
	}
	
	
	
	
	
}
