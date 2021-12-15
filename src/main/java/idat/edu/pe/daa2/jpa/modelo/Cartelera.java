package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="cartelera")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name ="Cartelera.findAll", query="SELECT c FROM Cartelera c"),
	@NamedQuery(name="Cartelera.findByIdGrado", query="SELECT c FROM Cartelera c WHERE c.idCartelera=:idCartelera"),
	@NamedQuery(name="Cartelera.findByTitulo", query="SELECT c FROM Cartelera c WHERE c.titulo=:titulo"),
	@NamedQuery(name="Cartelera.findByGenero", query="SELECT c FROM Cartelera c WHERE c.genero=:genero"),
	@NamedQuery(name="Cartelera.findByDuracion", query="SELECT c FROM Cartelera c WHERE c.duracion=:duracion"),
	@NamedQuery(name="Cartelera.findByDirector", query="SELECT c FROM Cartelera c WHERE c.director=:director"),
	@NamedQuery(name="Cartelera.findByClasificacion", query="SELECT c FROM Cartelera c WHERE c.clasificacion=:clasificacion"),
	@NamedQuery(name="Cartelera.findByImagen", query="SELECT c FROM Cartelera c WHERE c.imagen=:imagen")
	
})

public class Cartelera implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idCartelera")
	private Integer idCartelera;
	@Basic(optional=false)
	@Column(name="titulo")
	private String titulo;
	@Basic(optional=false)
	@Column(name="genero")
	private String genero;
	@Basic(optional=false)
	@Column(name="duracion")
	private String duracion;
	@Basic(optional=false)
	@Column(name="director")
	private String director;
	@Basic(optional=false)
	@Column(name="clasificacion")
	private String clasificacion;
	@Basic(optional=false)
	@Column(name="imagen")
	private String imagen;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cartelera",fetch=FetchType.LAZY)
    //@JsonBackReference(value="cartelera_funciones")
    private List<Funciones> funcionesList;
	
    
    public Cartelera() {
    	
    }
    public Cartelera(Integer idCartelera) {
    	this.idCartelera=idCartelera;
    }
    public Cartelera(Integer idCartelera,String titulo,String genero,String duracion,
    		String director,String clasificacion,String imagen) {
    	this.idCartelera=idCartelera;
    	this.titulo=titulo;
    	this.genero=genero;
    	this.duracion=duracion;
    	this.director=director;
    	this.clasificacion=clasificacion;
    	this.imagen=imagen;
    	
    }
	public Integer getIdCartelera() {
		return idCartelera;
	}
	public void setIdCartelera(Integer idCartelera) {
		this.idCartelera = idCartelera;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@XmlTransient
	public List<Funciones>getFuncionesList(){
		return funcionesList;
	}
	 public void setFuncionesList(List<Funciones> funcionesList) {
	        this.funcionesList = funcionesList;
	    }
	 @Override
	 public int hashCode() {
		 int hash=0;
		 hash +=(idCartelera !=null ? idCartelera.hashCode():0);
		 return hash;
	 }
	@Override
	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartelera)) {
            return false;
        }
        Cartelera other = (Cartelera) object;
        if ((this.idCartelera == null && other.idCartelera != null) || (this.idCartelera != null && !this.idCartelera.equals(other.idCartelera))) {
            return false;
        }
        return true;
    }
	@Override
    public String toString() {
        return "javaapplication1.Cartelera[ idCartelera=" + idCartelera + " ]";
    }
}
