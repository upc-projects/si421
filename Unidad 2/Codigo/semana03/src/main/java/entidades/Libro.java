package entidades;

public class Libro {
	int id;
	String titulo;
	double precio;
	String isbn;
	String descripcion;
	int generoID;
	int editorialID;
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getGeneroID() {
		return generoID;
	}
	public void setGeneroID(int generoID) {
		this.generoID = generoID;
	}
	public int getEditorialID() {
		return editorialID;
	}
	public void setEditorialID(int editorialID) {
		this.editorialID = editorialID;
	}
}
