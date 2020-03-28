package ro.usv.rf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
	private static final String FileValuesSeparator = ",";
	
	protected static int FILE_LINE_READ;

	protected static ArrayList<Location> readLocationsFromFile(String filePath) {
		ArrayList<Location> locationSet = new ArrayList<Location>();
		
		FILE_LINE_READ = 0;
		try {
			locationSet = (ArrayList<Location>) Files.lines(Paths.get(filePath)).map(FileUtils::parseLocation).collect(Collectors.toList());
		} catch (Throwable thr) {
			thr.printStackTrace();
		}
		
		return locationSet;
	}

	private static Location parseLocation(String locationString) {
		String[] locationParameters = locationString.split(FileValuesSeparator);
		
		Location localitate = null;
		if (locationParameters.length <= 4 && FILE_LINE_READ != 0) {
			double xCoordinate = Double.parseDouble(locationParameters[0]);
			double yCoordinate = Double.parseDouble(locationParameters[1]);

			String nume = locationParameters[2];
			String judet = locationParameters[3];

			localitate = new Location(nume, judet, xCoordinate, yCoordinate);
			
		}
		FILE_LINE_READ++;

		return localitate;
	}
}
