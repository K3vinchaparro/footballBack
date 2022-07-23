package computo.distrital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="equipo")
public class Equipo {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_equipo")
	private Long idEquipo;
	@Column (name = "nombre_equipo")
	private String nombreEquipo;
	private int puntos;
	private int goles;
	
	public Equipo() {}
	
	public Equipo(String nombreEquipo, int puntos, int goles) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.puntos = puntos;
		this.goles = goles;
	}
	
	public Long getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getGoles() {
		return goles;
	}
	public void setGoles(int goles) {
		this.goles = goles;
	}
	
	
	
}
