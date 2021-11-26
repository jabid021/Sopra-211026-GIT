package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Coordonnees implements Serializable{

	@Column(nullable = false)
	private int x;
	@Column(nullable = false)
	private int y;
	@Column(nullable = false)
	private int z;
	
	public Coordonnees(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Coordonnees() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Coordonnees [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	
}
