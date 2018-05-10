package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesores")
public class Profesor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprofesores;
	
	public int getIdprofesores() {
		return idprofesores;
	}

	public void setIdprofesores(int idprofesores) {
		this.idprofesores = idprofesores;
	}

	private String nombre,codigo;

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
