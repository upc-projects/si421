package source.open.pc02.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="curso_alumno")
public class CursoAlumno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int nota;
	private String tipoprueba;
	
	@Override
	public String toString() {
		return "CursoAlumno [id=" + id + ", nota=" + nota + ", tipoprueba=" + tipoprueba + ", sede=" + sede
				+ ", alumno=" + alumno + ", curso=" + curso + "]";
	}

	@ManyToOne
	private Sede sede;
	
	@ManyToOne
	private Alumno alumno;
	
	@ManyToOne
	private Curso curso;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getTipoprueba() {
		return tipoprueba;
	}

	public void setTipoprueba(String tipoprueba) {
		this.tipoprueba = tipoprueba;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
