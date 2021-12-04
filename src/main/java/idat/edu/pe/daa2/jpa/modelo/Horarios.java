package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="horario")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Horario.findAll",query="SELECT h FROM Horarios h"),
	@NamedQuery(name= "Horario.finByIdHorario", query="SELECT h FROM Horarios h WHERE h.idHorario=: idHorario"),
	@NamedQuery(name= "Horario.finByDia", query="SELECT h FROM Horarios h WHERE h.dia=: dia"),
	@NamedQuery(name= "Horario.findByHora", query="SELECT h FROM Horarios h WHERE h.hora=: hora")
	

})

public class Horarios implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name="idHorario")
	private Integer idHorario;
	@Basic(optional= false)
	@Column(name="dia")
	private Date dia;
	@Basic(optional= false)
	@Column(name="hora")
	private Time hora;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "horario",fetch=FetchType.LAZY)
    //@JsonBackReference(value="cartelera_funciones")
    private List<Funciones> funcionesList;
	
	public Horarios() {
		
	}
	public Horarios(Integer idHorario) {
		this.idHorario = idHorario;
	}
	
	public Horarios(Integer idHorario,Date dia,Time hora) {
		this.idHorario= idHorario;
		this.dia= dia;
		this.hora= hora;
	}
	public Integer getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	@XmlTransient
	public List<Funciones>getFuncionesList(){
		return funcionesList;
		
	}
	
	public void setFuncionesList(List<Funciones> funcionesList) {
		this.funcionesList= funcionesList;
	}
	
	@Override
	public int hashCode() {
		int hash=0;
		hash +=(idHorario!=null? idHorario.hashCode():0);
		return hash;
	}
	@Override
	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.idHorario == null && other.idHorario!= null) || (this.idHorario!= null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }
	@Override
    public String toString() {
        return "javaapplication1.Horarios[ idHorario=" + idHorario+ " ]";
    }
}
