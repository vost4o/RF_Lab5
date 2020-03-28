package ro.usv.rf;

import java.util.Collections;
import java.util.List;

public class VMain {
	public static void main(String[] args) {
		List<Location> locations = FileUtils.readLocationsFromFile("data.csv");
		locations.remove(0);
		
		Collections.sort(locations);
		
		double[] distances = new double[13];
		
		for(int i = 0; i < distances.length; ++i) {
			distances[i] = DistanceUtils.euclidianDistanceGeneralized(locations.get(i), locations.get(i + 1));
		}
		
		for(Double distance : distances) {
			System.err.println(distance);
		}
	}
}
