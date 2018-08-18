package semana09.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="libros")
@NamedQueries({
	@NamedQuery(name="Libro.buscarPorGenero", 
					query="select a from Libro a where a.genero.id = ?1"),	
	@NamedQuery(name="Libro.buscarPorEditorial", 
					query="select a from Libro a where a.editorial.id = ?1"),
	@NamedQuery(
			name="Libro.buscarPorPrecio",
			query="select r from Libro r where r.precio = ?1"					),
})
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="Ingrese titulo")
	private String titulo;
	@Digits(integer=4,fraction=2)
	private double precio;
	@NotBlank(message="Ingrese isbn")
	private String isbn;
	@NotBlank(message="Ingrese sinopsis")
	private String sinopsis;
	
	@ManyToOne
	private Editorial editorial;
	
	@ManyToOne
	private Genero genero;
	
	@ManyToMany
	@JoinTable(name="libro_autor",
					joinColumns = @JoinColumn(name="libro_id"),
					inverseJoinColumns = @JoinColumn(name="autor_id")
				)
	private List<Autor> autores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	} 
}
