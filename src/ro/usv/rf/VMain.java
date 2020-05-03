package ro.usv.rf;

public class VMain {
	public static void main(String[] args) {
		try {
			String[][] locations = FileUtils.readLocationsFromFile("data.csv");
			String[][] evalSet = FileUtils.readLocationsFromFile("eval.txt");

			// calculate distances
			double[][] distances = new double[evalSet.length][locations.length];
			for (int i = 0; i < evalSet.length; i++) {
				for (int j = 0; j < locations.length; j++) {
					distances[i][j] = DistanceUtils.euclidianDistance(evalSet[i], locations[j], 2);
				}
			}

			// add the class pattern to the eval set
			String[][] newEvalSet = new String[evalSet.length][evalSet[0].length + 1];

			for (int i = 0; i < evalSet.length; i++) {
				for (int j = 0; j < evalSet[0].length; j++) {
					newEvalSet[i][j] = evalSet[i][j];
				}
				newEvalSet[i][newEvalSet.length - 1] = Classificators.performKNNClassification(evalSet[i], locations,
						distances[i], 9);
			}

			FileUtils.writeLearningSetToFile("calcEvalSet.csv", newEvalSet);
		} catch (USVInputFileCustomException ifce) {
			System.err.println(ifce.getMessage());
		} finally {
			System.out.println("Operations finished SUCCESSFULLY");
		}
	}
}
