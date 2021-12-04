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
@Table(name="rol")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Rol.finAll",query="SELECT r FROM Rol r"),
	@NamedQuery(name="Rol.findByIdRol",query="SELECT r FROM Rol r WHERE r. idRol=:idRol"),
	@NamedQuery(name="Rol.findByRol", query="SELECT r FROM Rol r WHERE r.rol=:rol")
})

public class Rol implements Serializable {
	
	private static final long serialVersionUID= 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idRol")
	private Integer idRol;
	@Basic(optional=false)
	@Column(name="rol")
	private String rol;
	@OneToMany(cascade= CascadeType.ALL, mappedBy="rol")
	
	private List<Usuario> usuarioList;
	
	public Rol() {
		
	}
	
	public Rol(Integer idRol) {
		this.idRol= idRol;
	}
	
	public Rol(Integer idRol,String rol) {
		this.idRol=idRol;
		this.rol= rol;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@XmlTransient
	public List<Usuario> getUsuarioList(){
		return usuarioList;
	}
	
	public void setUsuarioList(List<Usuario>usuarioList) {
		this.usuarioList= usuarioList;
	}
	
	@Override
	public int hashCode() {
		int hash=0;
		hash += (idRol!=null?idRol.hashCode():0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Rol)) {
			return false;
		}
		Rol other=(Rol)object;
		if((this.idRol==null && other.idRol !=null)||(this.idRol != null && !this.idRol.equals(other.idRol))){
			return false;
		}
		return true;	
	}
	
	@Override
	public String toString() {
		return "javaapplication1.Rol[idRol=" + idRol +"]";
	}

}
