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

	protected static String[][] readLocationsFromFile(String filePath) throws USVInputFileCustomException {
		List<String[]> locationSet = new ArrayList<String[]>();

		FILE_LINE_READ = 0;
		try {
			locationSet = Files.lines(Paths.get(filePath)).map(FileUtils::convertStringToRow)
					.collect(Collectors.toList());
		} catch (FileNotFoundException fnfe) {
			throw new USVInputFileCustomException("We cannot find the scepicified file on USV computer");
		} catch (IOException ioe) {
			throw new USVInputFileCustomException(
					" We encountered some errors while trying to read the specified file: " + ioe.getMessage());
		} catch (Throwable thr) {
			throw new USVInputFileCustomException(" Other errors: " + thr.getMessage());
		}

		return convertToBidimensionalArray(locationSet);
	}

	private static String[] convertStringToRow(String locationStr) {
		return locationStr.split(FileValuesSeparator);
	}

	private static String[][] convertToBidimensionalArray(List<String[]> locationString) {
		String[][] parsedLocations = new String[locationString.size()][locationString.get(0).length];

		for (int i = 0; i < locationString.size(); ++i) {
			parsedLocations[i] = locationString.get(i);
		}

		return parsedLocations;
	}

	protected static void writeLearningSetToFile(String fileName, String[][] normalizedSet) {
		// first create the byte array to be written
		StringBuilder stringBuilder = new StringBuilder();
		for (int n = 0; n < normalizedSet.length; n++) // for each row
		{
			// for each column
			for (int p = 0; p < normalizedSet[n].length; p++) {
				// append to the output string
				stringBuilder.append(normalizedSet[n][p] + "");
				// if this is not the last row element
				if (p < normalizedSet[n].length - 1) {
					// then add separator
					stringBuilder.append(FileValuesSeparator);
				}
			}
			// append new line at the end of the row
			stringBuilder.append("\n");
		}
		try {
			Files.write(Paths.get(fileName), stringBuilder.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
