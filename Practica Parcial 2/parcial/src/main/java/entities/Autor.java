package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="autores")   // NOMBRE DE LA TABLA EN LA BD
public class Autor{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombres;  			
	private String apellidos;			/* nombre de los atributos igual que en la base de datos */
	private String nacionalidad;
	
	@ManyToMany(mappedBy="autores")
	private List<Libro> libros;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Autor [nombre=" + nombres + ", apellido=" + apellidos + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombres;
	}

	public void setNombre(String nombre) {
		this.nombres = nombre;
	}

	public String getApellido() {
		return apellidos;
	}

	public void setApellido(String apellido) {
		this.apellidos = apellido;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
}