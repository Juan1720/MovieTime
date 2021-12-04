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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="funciones")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name ="Funciones.findAll", query="SELECT f FROM Funciones f"),
	@NamedQuery(name="Funciones.findByIdFuncion", query="SELECT f FROM Funciones f WHERE f.idFuncion=:idFuncion"),
	@NamedQuery(name="Funciones.findByTipFuncion", query="SELECT f FROM Funciones f WHERE f.tipFuncion=:tipFuncion"),
	@NamedQuery(name="Funciones.findByPreciUnitario", query="SELECT f FROM Funciones f WHERE f.precUnitario=:precUnitario"),
	@NamedQuery(name="Funciones.findByEstado", query="SELECT f FROM Funciones f WHERE f.estado=:estado")
	
})
public class Funciones implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idFuncion")
	private Integer idFuncion;
	@Basic(optional=false)
	@Column(name="tipFuncion")
	private String tipFuncion;
	@Basic(optional=false)
	@Column(name="precUnitario")
	private Float precUnitario;
	@Basic(optional=false)
	@Column(name="estado")
	private Boolean estado;
	@JoinColumn(name = "cartelera", referencedColumnName = "idCartelera")
	@ManyToOne(optional = false)
	private Cartelera cartelera;
	@JoinColumn(name = "cine", referencedColumnName = "idCine")
	@ManyToOne(optional = false)
	private Cine cine;
	@JoinColumn(name = "horario", referencedColumnName = "idHorario")
	@ManyToOne(optional = false)
	private Horarios horario;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funciones",fetch=FetchType.LAZY)
    //@JsonBackReference(value="cartelera_funciones")
    private List<VentaEntrada> ventaentradaList;
	
	public Funciones() {
		
	}
	
	public Funciones(Integer idFuncion) {
		this.idFuncion= idFuncion;
	}
	
	public Funciones(Integer idFuncion,String tipFuncion,Float precUnitario,Boolean estado) {
		this.idFuncion= idFuncion;
		this.tipFuncion= tipFuncion;
		this.precUnitario= precUnitario;
		this.estado= estado;
	}

	public Integer getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(Integer idFuncion) {
		this.idFuncion = idFuncion;
	}

	public String getTipFuncion() {
		return tipFuncion;
	}

	public void setTipFuncion(String tipFuncion) {
		this.tipFuncion = tipFuncion;
	}

	public Float getPrecUnitario() {
		return precUnitario;
	}

	public void setPrecUnitario(Float precUnitario) {
		this.precUnitario = precUnitario;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Cartelera getCartelera() {
		return cartelera;
	}

	public void setCartelera(Cartelera cartelera) {
		this.cartelera = cartelera;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public Horarios getHorarios() {
		return horario;
	}

	public void setHorarios(Horarios horarios) {
		this.horario = horarios;
	}
	
	@XmlTransient
	public List<VentaEntrada> getVentaEntradaList(){
		return ventaentradaList;
	}
	
	public void setNotasList(List<VentaEntrada>ventaentradaList) {
		this.ventaentradaList=ventaentradaList;
	}
	
	@Override
	public int hashCode() {
	int hash = 0;
	hash += (idFuncion != null ? idFuncion .hashCode() : 0);
	return hash;
	}



	@Override
	public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Funciones)) {
		return false;
	}
	Funciones other = (Funciones) object;
	if ((this.idFuncion== null && other.idFuncion!= null) || (this.idFuncion!= null && !this.idFuncion.equals(other.idFuncion))) {
	return false;
	}
	return true;
	}

	 @Override
	  public String toString() {
	    return "javaapplication1.Funciones[ idFuncion=" + idFuncion+ " ]";
	}
	
}
