package homework;

class Employee {

	private static final int MAX_WORKING_HOURS_PER_DAY = 8;

	static private AllWork allWork;

	private String name;
	private Task currentTask;
	private int hoursLeft;

	Employee(String name) {

		if (name != null && !name.equals("")) {
			this.name = name;
		}

	}

	static void setAllWord(AllWork allWork) {
		if (allWork != null) {
			Employee.allWork = allWork;
		}
	}
	
	void work() {

		if (this.getCurrentTask() != null) {
			int taskWorkingHours = getCurrentTask().getWorkingHours();

			if (this.getHoursLeft() > 0) {

				this.calculateWorkedHours(taskWorkingHours);
			}
		} else {
			
			this.setCurrentTask(Employee.allWork.getNextTask());
			if (this.getCurrentTask() != null) {
				System.out.println("The new task for " + this.name + " is " + this.getCurrentTask().getName());
			}else {
				System.out.println("  for " + this.getName());
			}
		}

		// this.showReport();
	}

	private void calculateWorkedHours(int taskWorkingHours) {

		if (taskWorkingHours > this.getHoursLeft()) {

			this.getCurrentTask().setWorkingHours(taskWorkingHours - this.getHoursLeft());
			this.setHoursLeft(0);
			System.out.println(this.name + "'s hours are over for today. His/Her current task remains "
					+ getCurrentTask().getName() + ". Remaining working hours for today: " + this.getHoursLeft()
					+ ". Remaining hours for the task:  " + this.currentTask.getWorkingHours());

		} else {
			if (taskWorkingHours <= this.getHoursLeft()) {
				this.getCurrentTask().setWorkingHours(0);
				this.setHoursLeft(this.getHoursLeft() - taskWorkingHours);
				System.out.println(this.name + " finished his/her current task: " + getCurrentTask().getName()
						+ ". Remaining working hours for today: " + this.getHoursLeft()
						+ ". Remaining hours for the task:  " + this.currentTask.getWorkingHours());
				this.setCurrentTask(null);
			}
		}
	}

	private void showReport() {

		if (this.getName() != null) {
			System.out.println("Worker Name: " + this.getName());
		} else {
			System.out.println("Invalid name");
		}
		if (this.currentTask != null) {
			String taskName = this.currentTask.getName();
			if (taskName != null) {
				System.out.println("Task: " + taskName);
			} else {
				System.out.println("Invalid taskName");
			}
		} else {
			System.out.println("No currnet task");
		}

		System.out.println("Working hours left: " + this.getHoursLeft());
		if (getCurrentTask() != null) {
			System.out.println("Hours left to finish the task: " + getCurrentTask().getWorkingHours());
		}

		System.out.println("-----------------------------------");
	}

	private String getName() {
		return this.name;
	}

	Task getCurrentTask() {
		return this.currentTask;
	}

	void setCurrentTask(Task currentTask) {
		if (currentTask != null) {
			this.currentTask = currentTask;
		} else {
			// System.out.println("No task!");
			this.currentTask = null;
		}
	}

	int getHoursLeft() {
		return this.hoursLeft;
	}

	void setHoursLeft(int hoursLeft) {
		if (hoursLeft >= 0 && hoursLeft <= MAX_WORKING_HOURS_PER_DAY) {
			this.hoursLeft = hoursLeft;
		} else {
			System.out.println("Invalid working hours are set");
		}
	}

	void startWorkingDay() {
		setHoursLeft(MAX_WORKING_HOURS_PER_DAY);
	}
}
