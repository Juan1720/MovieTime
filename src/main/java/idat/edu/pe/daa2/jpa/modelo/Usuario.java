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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="usuario")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Usuario.finAll",query="SELECT u FROM Usuario u"),
	@NamedQuery(name="Usuario.findByIdUsuario",query="SELECT u FROM Usuario u WHERE u. idUsuario=:idUsuario"),
	@NamedQuery(name="Usuario.findByUsuario", query="SELECT u FROM Usuario u WHERE u.usuario=:usuario"),
	@NamedQuery(name="Usuario.findByContrasena",query="SELECT u FROM Usuario u WHERE u. contrasena=:contrasena"),
	@NamedQuery(name="Usuario.findByNombres", query="SELECT u FROM Usuario u WHERE u.nombres=:nombres"),
	@NamedQuery(name="Usuario.findByApellidos",query="SELECT u FROM Usuario u WHERE u. apellidos=:apellidos"),
	@NamedQuery(name="Usuario.findByDni", query="SELECT u FROM Usuario u WHERE u.dni=:dni"),
	@NamedQuery(name="Usuario.findByDireccion",query="SELECT u FROM Usuario u WHERE u. Direccion=:Direccion"),
	@NamedQuery(name="Usuario.findByTelefono", query="SELECT u FROM Usuario u WHERE u.telefono=:telefono"),
	@NamedQuery(name="Usuario.findByCorreo", query="SELECT u FROM Usuario u WHERE u.correo=:correo")
})

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idUsuario")
	private Integer idUsuario;
	@Basic(optional=false)
	@Column(name="usuario")
	private String usuario;
	@Basic(optional=false)
	@Column(name="contrasena")
	private String contrasena;
	@Basic(optional=false)
	@Column(name="nombres")
	private String nombres;
	@Basic(optional=false)
	@Column(name="apellidos")
	private String apellidos;
	@Basic(optional=false)
	@Column(name="dni")
	private String dni;
	@Basic(optional=false)
	@Column(name="Direccion")
	private String Direccion;
	@Basic(optional=false)
	@Column(name="telefono")
	private String telefono;
	@Basic(optional=false)
	@Column(name="correo")
	private String correo;
	@OneToMany(cascade= CascadeType.ALL,mappedBy="usuario")
	private List<VentaEntrada>ventaentradaList;
	@JoinColumn(name="rol", referencedColumnName= "idRol")
	@ManyToOne(optional = false)
	private Rol rol;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer idUsuario) {
		this.idUsuario= idUsuario;
	}
	
	public Usuario(Integer idUsuario,String usuario,String contrasena,String nombres,String apellidos,
					String dni,String Direccion, String telefono, String correo) {
		
		this.idUsuario= idUsuario;
		this.usuario= usuario;
		this.contrasena= contrasena;
		this.nombres= nombres;
		this.apellidos= apellidos;
		this.dni= dni;
		this.Direccion= Direccion;
		this.telefono= telefono;
		this.correo= correo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	@XmlTransient
	public List<VentaEntrada> getVentaEntradasList(){
		return ventaentradaList;
	}
	
	public void setVentaEntradaList(List<VentaEntrada> ventaentradaList) {
		this.ventaentradaList= ventaentradaList;
	}
	
	@Override
	public int hashCode() {
	int hash = 0;
	hash += (idUsuario != null ? idUsuario.hashCode() : 0);
	return hash;
	}
	
	@Override
	public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Usuario)) {
	return false;
	}
	Usuario other = (Usuario) object;
	if ((this.idUsuario == null && other.idUsuario!= null) || (this.idUsuario!= null && !this.idUsuario.equals(other.idUsuario))) {
	return false;
	}
	return true;
	}



	@Override
	public String toString() {
		return "javaapplication1.Usuario[ idUsuario=" + idUsuario+ " ]";
	}
	

}
