package semana09.entidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="autores")
public class Autor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message="No puede estar en vacio")
	@Size(min=3, max=75, message="La longitud no es correcta")
	private String nombres;
	@NotBlank(message="No puede estar en blanco")
	@Size(min=3, max=75, message="La longitud no es correcta")
	private String apellidos;
	@Size(min=3, max=100, message="La longitud no es correcta")
	private String nacionalidad;
	
	@ManyToMany(mappedBy="autores")
	private List<Libro> libros;
	
	@Override
	public String toString() {
		return "Autor [nombres=" + nombres + ", apellidos=" + apellidos + "]";
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}
