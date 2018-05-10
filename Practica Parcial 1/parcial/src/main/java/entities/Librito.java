package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="librito")
public class Librito {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idlibrito;
	
	private String titulo;
	private double precio;
	private String isbn;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getIdlibrito() {
		return idlibrito;
	}
	public void setIdlibrito(int idlibrito) {
		this.idlibrito = idlibrito;
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
	
	
}
