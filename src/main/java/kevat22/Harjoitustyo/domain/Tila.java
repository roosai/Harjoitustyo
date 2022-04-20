package kevat22.Harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tila {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tilaId;
	private String tila;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy ="tila")
	@JsonIgnore
	private List<Elokuva> elokuvat;

	public Long getTilaId() {
		return tilaId;
	}

	public void setTilaId(Long tilaId) {
		this.tilaId = tilaId;
	}

	public String getTila() {
		return tila;
	}

	public void setTila(String tila) {
		this.tila = tila;
	}

	public List<Elokuva> getElokuvat() {
		return elokuvat;
	}

	public void setElokuvat(List<Elokuva> elokuvat) {
		this.elokuvat = elokuvat;
	}

	public Tila( String tila) {
		super();
		this.tila = tila;
	}

	public Tila() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tila [tilaId=" + tilaId + ", tila=" + tila + "]";
	}
	
	
}
