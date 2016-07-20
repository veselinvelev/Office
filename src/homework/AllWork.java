package homework;

class AllWork {

	private static final int MAX_NUMBER_OF_TASKS = 10;
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	// private int addTaskAtPosition;

	public AllWork() {
		this.freePlacesForTasks = MAX_NUMBER_OF_TASKS;
		this.currentUnassignedTask = 0;
		// this.addTaskAtPosition = 0;
		this.tasks = new Task[this.freePlacesForTasks];
	}

	void addTask(Task task) {

		if (task == null && task.getWorkingHours() > 0) {
			System.out.println("Invalid task!");
			return;
		}

		if (freePlacesForTasks == 0) {
			System.out.println("No place for new tasks!");
			return;
		}

		this.tasks[this.tasks.length - this.freePlacesForTasks] = task;
		this.freePlacesForTasks--;

	}

	Task getNextTask() {
		if (currentUnassignedTask < MAX_NUMBER_OF_TASKS - this.freePlacesForTasks) {
			return this.tasks[currentUnassignedTask++];
		}else {
			System.out.print("There is no work ");
			return null;
		}
		
	}

	boolean isAllWorkDone() {

		for (int task = 0; task < tasks.length; task++) {

			if (this.tasks[task] != null && this.tasks[task].getWorkingHours() > 0) {
				return false;
			}
		}

		return true;
	}
}
