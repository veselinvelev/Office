
package homework;

class Task {

	private String name;
	private int workingHours;

	Task(String name, int workingHours) {

		if (name != null && !name.equals("")) {
			this.name = name;
		} else {
			System.out.println("Invalid name");
		}
		this.setWorkingHours(workingHours);

	}

	int getWorkingHours() {
		return workingHours;
	}

	String getName() {
		return name;
	}

	void setWorkingHours(int workingHours) {
		if (workingHours >= 0) {
			this.workingHours = workingHours;
		} else {
			System.out.println("Invalid workitg hours");
		}
	}

}
