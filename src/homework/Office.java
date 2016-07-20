package homework;

public class Office {

	public static void main(String[] args) {

		AllWork allWork = new AllWork();
		Employee.setAllWord(allWork);

		Task swordForging = new Task("Forging a sword", 5);
		Task shipBuildinbg = new Task("Build a war ship", 8);
		Task brewingRakia = new Task("Rakia Rakia", 12);
		Task digGold = new Task("Find Gold", 8);
		Task growPotat = new Task("Grow some potatoes", 38);
		Task buildHouse = new Task("Build a house", 3218);
		Task repairCar = new Task("Repair begackata", 8132);
		Task cleanOffice = new Task("Clean the office", 28);
		Task makeWine = new Task("Make some wine", 8);
		Task drinkWine = new Task("Drink all the wine", 28);

		Employee baiIvan = new Employee("Ivan");
		Employee kiro = new Employee("Kiro");
		Employee baiStoyan = new Employee("Stoyan");

		baiIvan.startWorkingDay();
		kiro.startWorkingDay();
		baiStoyan.startWorkingDay();

		Employee[] employees = new Employee[3];
		employees[0] = baiIvan;
		employees[1] = kiro;
		employees[2] = baiStoyan;

		allWork.addTask(swordForging);
		 allWork.addTask(shipBuildinbg);
		 allWork.addTask(brewingRakia);
		 allWork.addTask(digGold);
		 allWork.addTask(growPotat);
		 allWork.addTask(buildHouse);
		 allWork.addTask(repairCar);
		 allWork.addTask(cleanOffice);
		 allWork.addTask(makeWine);
		 allWork.addTask(drinkWine);
		//

		int day = 1;
		System.out.println("Day " + day + " ---------------------------------------------------------");
		while (true) {

			baiIvan.work();
			kiro.work();
			baiStoyan.work();

			if (allWork.isAllWorkDone()) {
				break;
			}

			day = dayCount(employees, day);
			
			
		}
	}

	private static int dayCount(Employee[] employees, int day) {

		boolean isNewDay = (employees[0].getHoursLeft()) == 0 || (employees[0].getCurrentTask() == null);
		
		for (int employee = 0; employee < employees.length; employee++) {
			isNewDay &= (employees[employee].getHoursLeft()) == 0 || (employees[employee].getCurrentTask() == null);
		}

		if (isNewDay) {
			for (Employee employee : employees) {
				employee.startWorkingDay();
			}

			day++;
			System.out.println("Day " + day + " ---------------------------------------------------------");
		}
		return day;
	}

}
