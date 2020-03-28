package ro.usv.rf;

public class Location implements Comparable<Location> {

	private String nume;
	private String judet;
	private double xCoordinate;
	private double yCoordinate;

	public Location(String nume, String judet, double xCoordinate, double yCoordinate) {
		this.nume = nume;
		this.judet = judet;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	@Override
	public int compareTo(Location o) {
		
		return 0;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getJudet() {
		return judet;
	}

	public void setJudet(String judet) {
		this.judet = judet;
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}
