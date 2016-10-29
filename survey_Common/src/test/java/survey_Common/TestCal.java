package survey_Common;

import com.fire.survey.utils.DataProcess;

public class TestCal {
	public static void main(String[] args) {
		for (int j = 0; j < 100; j++) {
			System.out.println(DataProcess.generateTableName(j));
		}
	}
}
