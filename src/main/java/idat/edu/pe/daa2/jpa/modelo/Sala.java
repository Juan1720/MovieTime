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
@Table(name="sala")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Sala.findAll",query="SELECT s FROM Sala s"),
	@NamedQuery(name= "Sala.finByIdSala", query="SELECT s FROM Sala s WHERE s.idSala=: idSala"),
	@NamedQuery(name= "Sala.finBySala", query="SELECT s FROM Sala s WHERE s.sala=: sala"),
	@NamedQuery(name= "Sala.findByCapacidad", query="SELECT s FROM Sala s WHERE s.capacidad=: capacidad")

})

public class Sala  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idSala")
	private Integer idSala;
	@Basic(optional= false)
	@Column(name="sala")
	private String sala;
	@Basic(optional= false)
	@Column(name="capacidad")
	private String capacidad;
	@OneToMany(cascade= CascadeType.ALL,mappedBy="sala")
	//@JsonBackReference(value="estudiante_Notas")
	private List<Asientos>asientosList;
	@JoinColumn(name = "cine", referencedColumnName = "idCine")
	@ManyToOne(optional = false)
	private Cine cine;
	
public Sala(){
		
	}
	
	public Sala(Integer idSala) {
		this.idSala= idSala;
	}
	
	public Sala(Integer idSala,String sala,String capacidad) {
		this.idSala= idSala;
		this.sala= sala;
		this.capacidad= capacidad;
	}

	public Integer getIdSala() {
		return idSala;
	}

	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}
	
	@XmlTransient
	public List<Asientos> getAsientosList() {
		 return asientosList;
	}

	public void setAsientosList(List<Asientos> asientosList) {
		this.asientosList = asientosList;
	}
	
	@Override
	public int hashCode() {
	int hash = 0;
	hash += (idSala != null ? idSala.hashCode() : 0);
	return hash;
	}



	@Override
	public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Sala)) {
	return false;
	}
	Sala other = (Sala) object;
	if ((this.idSala== null && other.idSala!= null) || (this.idSala!= null && !this.idSala.equals(other.idSala))) {
	return false;
	}
	return true;
	}



	@Override
	public String toString() {
		return "javaapplication1.Sala[ idSala=" + idSala+ " ]";
	}
	
	

}
