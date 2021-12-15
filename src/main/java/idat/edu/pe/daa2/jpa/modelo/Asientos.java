package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.NamedQueries;

@Entity
@Table(name="asientos")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Asientos.findAll",query="SELECT a FROM Asientos a"),
	@NamedQuery(name= "Asientos.finByIdAsiento", query="SELECT a FROM Asientos a WHERE a.idAsientos=: idAsientos"),
	@NamedQuery(name= "Asientos.finByAsiento", query="SELECT a FROM Asientos a WHERE a.asiento=: asiento"),
	@NamedQuery(name= "Asientos.findByEstado", query="SELECT a FROM Asientos a WHERE a.estado=: estado")
	

})

public class Asientos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idAsientos")
	private Integer idAsientos;
	@Basic(optional= false)
	@Column(name="asiento")
	private String asiento;
	@Basic(optional= false)
	@Column(name="estado")
	private Boolean estado;
	@JoinColumn(name = "sala", referencedColumnName = "idSala")
	@ManyToOne(optional = false)
	private Sala sala;
	
public Asientos(){
		
	}
	
	public Asientos(Integer idAsientos) {
		this.idAsientos= idAsientos;
	}
	
	public Asientos(Integer idAsientos,String asiento,Boolean estado) {
		this.idAsientos=idAsientos;
		this.asiento=asiento;
		this.estado=estado;
	}

	public Integer getIdAsientos() {
		return idAsientos;
	}

	public void setIdAsientos(Integer idAsientos) {
		this.idAsientos = idAsientos;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	@Override
	public int hashCode() {
	int hash = 0;
	hash += (idAsientos != null ? idAsientos.hashCode() : 0);
	return hash;
	}



	@Override
	public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Asientos)) {
	return false;
	}
	Asientos other = (Asientos) object;
	if ((this.idAsientos == null && other.idAsientos!= null) || (this.idAsientos!= null && !this.idAsientos.equals(other.idAsientos))) {
	return false;
	}
	return true;
	}



	@Override
	public String toString() {
		return "javaapplication1.Asientos[ idAsientos=" + idAsientos+ " ]";
	}
	


}
