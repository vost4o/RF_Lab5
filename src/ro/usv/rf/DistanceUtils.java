package ro.usv.rf;

public class DistanceUtils {

	public static double euclidianDistanceGeneralized(Location l1, Location l2) {
		double distance = 0;
		
		// Calculate the distance between two patterns
		double x1 = l1.getxCoordinate();
		double y1 = l1.getyCoordinate();
		
		double x2 = l2.getxCoordinate();
		double y2 = l2.getyCoordinate();
		
		distance += Math.pow(x1 - y1, 2);
		distance += Math.pow(x2 - y2, 2);
		
		// Get the square root
		distance = Math.sqrt(distance);
		
		return distance;
	}
}
