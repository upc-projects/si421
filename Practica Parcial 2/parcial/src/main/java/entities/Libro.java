package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titulo,ISBN,sinopsis;
	private double precio;
	
	@ManyToOne
	private Editorial editorial;
	
	@ManyToOne
	private Genero genero;
	
	@ManyToMany
	@JoinTable(name="libro_autor", joinColumns = @JoinColumn(name="libro_id"), inverseJoinColumns = @JoinColumn(name="autor_id"))
	private List<Autor> autores; 
	
	
	
	
	
}
