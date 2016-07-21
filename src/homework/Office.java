package homework;

public class Office {

	private static final int NUMBER_OF_EMPLOYEES = 4;

	public static void main(String[] args) {

		AllWork allWork = new AllWork();
		Employee.setAllWord(allWork);

		Task swordForging = new Task("Forging a sword", -9);
		Task shipBuildinbg = new Task("Build a war ship", 1);
		Task brewingRakia = new Task("Rakia Rakia", 1);

		Task digGold = new Task("Find Gold", 11);
		Task growPotat = new Task("Grow some potatoes", 13);
		Task buildHouse = new Task("Build a house", 1);
		Task repairCar = new Task("Repair begackata", 14);
		Task cleanOffice = new Task("Clean the office", 1);
		Task makeWine = new Task("Make some wine", 51);
		Task drinkWine = new Task("Drink all the wine", 1);
		Task drinkRakia = new Task("Drink all the Rakia", 10);
		Task goToSleep = new Task("Go to sleep", 39);

		Employee baiIvan = new Employee("Ivan");
		Employee kiro = new Employee("Kiro");
		Employee baiStoyan = new Employee("Stoyan");
		Employee pesho = new Employee("Pesho");

		Employee[] employees = new Employee[NUMBER_OF_EMPLOYEES];
		employees[0] = baiIvan;
		employees[1] = kiro;
		employees[2] = baiStoyan;
		employees[3] = pesho;


		allWork.addTask(swordForging);
		allWork.addTask(shipBuildinbg);
		allWork.addTask(brewingRakia);
		allWork.addTask(digGold);
		allWork.addTask(growPotat);
		allWork.addTask(buildHouse);
		allWork.addTask(repairCar);
		allWork.addTask(cleanOffice);
		allWork.addTask(makeWine);
		allWork.addTask(null);
		allWork.addTask(drinkRakia);
		allWork.addTask(goToSleep);
		//

		int day = 1;
		System.out.println("Day " + day + " ---------------------------------------------------------");

		while (true) {

			for (Employee employee : employees) {
				employee.work();
			}

			if (allWork.isAllWorkDone()) {
				break;
			}
			int curDay = day;
			day = dayCount(employees, day);

			if (day == curDay) { // Всяка итерация на цикъла е 1 ден в офиса
				continue;
			}

			System.out.println("Day " + day + " ---------------------------------------------------------");
		}

	}

	private static int dayCount(Employee[] employees, int day) {

		boolean isNewDay = (employees[0].getHoursLeft() == 0) || ((employees[0].getCurrentTask() == null
				&& Employee.getAllWork().getCurrentUnassignedTask() >= AllWork.MAX_NUMBER_OF_TASKS));

		for (int employee = 0; employee < employees.length; employee++) {
			isNewDay &= (employees[employee].getHoursLeft() == 0) || ((employees[employee].getCurrentTask() == null
					&& Employee.getAllWork().getCurrentUnassignedTask() >= AllWork.MAX_NUMBER_OF_TASKS));
		}

		if (isNewDay) {
			for (Employee employee : employees) {
				employee.startWorkingDay();
			}

			day++;

		}
		return day;
	}

}
