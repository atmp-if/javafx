package atmp.javafx;

import java.time.LocalDate;

public class Vehicle {
	//ПОЛЯ КЛАСУ 
	public String name;//поле видиме для всіх
	protected Route route;//поле видиме для підкласів та класів в пакеті
	private boolean working; //поле доступне тільки для класу Vehicle
	//змінна fuelConsumptionValue зберігає значення витрати пального за 100 км
	private double fuelConsumptionValue;//поле доступне тільки для класу Vehicle
	//КОНСТРУКТОРИ КЛАСУ
	Vehicle (){}
	Vehicle (String nameLocal,Route routeLocal, boolean isWorkingLocal, double fuelConsumptionValueLocal){
		name=nameLocal;
		route=routeLocal;
		working= isWorkingLocal;
		fuelConsumptionValue=fuelConsumptionValueLocal;
	}
	Vehicle (String nameLocal,String departure, String destination,
			LocalDate dateDeparture, LocalDate dateDestinatione, boolean isWorcingLocal,
			double fuelConsumptionValueLocal, int distance){
		name=nameLocal;
		route=new Route (departure,  destination, dateDeparture,  dateDestinatione, distance);
		working= isWorcingLocal;
		fuelConsumptionValue=fuelConsumptionValueLocal;
	}
	/*МЕТОДИ КЛАСУ
	 * 	Методи set... типу void призначені для передавання даних в код,
	 * 	зміни значень полів тощо
	 * 	Три методи setRoute є перевантаженими*/
	public void setRoute(String departure, String destination,
			LocalDate dateDeparture, LocalDate dateDestinatione,int distance){
		route=new Route (departure,  destination, dateDeparture,  dateDestinatione, distance);
	}
	public void setRoute(Route routeLocal){
		route=routeLocal;
	}
	public void setRoute(Vehicle vehicle){
		route=vehicle.route;
	}
	public void setDistance(int distance){
		route.distance=distance;
	}
	public void setWorking(boolean workingLocal){
		working=workingLocal; 
	}
	public void setFuelConsumptionValue(double fuelConsumptionValueLocal){
		fuelConsumptionValue=fuelConsumptionValueLocal; 
	}
	/* Методи get... , методи що повертають значення 
	 * призначені для повернення деяких даних */
	//метод getTransportationCost() повертає вартість замовлення за маршрутом
	public double getTransportationCost(){
		double costOfFuel=(fuelConsumptionValue*2*route.distance/100)*30;
		int transportationCost= (int)(costOfFuel*1.8);
		return transportationCost;
	}
	public String getRouteDeparture(){
		return route.departure;
	}
	public String getRouteDestination(){
		return route.destination;
	}
	public LocalDate getDateDeparture(){
		return route.dateDeparture;
	}
	public LocalDate getDateDestinatione(){
		return route.dateDestinatione;
	}
	public int getDistance(){
		return route.distance;
	}
	public double getFuelConsumptionValue(){
		return this.fuelConsumptionValue;
	}
	/*Методи is... ,методи які перевіряють якусь умову, 
	 * і повертають значення типу boolean */
	public boolean isWorking(){
		return working;
	}
	public boolean isFree(){
		boolean b= false;
		if (route.departure==null && route.destination==null) b=true;
		return b;
	}
	//Mетод toString перевизначений оскільки є в батьківському класі Object
	public String toString(){
		return name+ " : "+route.toString();
	}
}

class Route {
	//змінна departure зберігає місце відпралення
	String departure;//поля без модифікатора доступні для всіх класів всередені пакету
	String destination;// місце прибуття
	LocalDate dateDeparture;//дата відправлення
	LocalDate dateDestinatione;//дата прибуття
	int distance;//шлях в км
	Route (String departureLocal, String destinationLocal,
			LocalDate dateDepartureLocal, LocalDate dateDestinationeLocal, int distanceLocal){
		departure=departureLocal;
		destination=destinationLocal;
		dateDeparture=dateDepartureLocal;
		dateDestinatione=dateDestinationeLocal;
		distance=distanceLocal;
	}
	Route (){}
	public String toString(){
		String str = "Маршрут - з "+ departure+ " до "+	destination+
				". Відправлення - "+dateDeparture+ ". Прибуття - "+ dateDestinatione;
		return str;
	}

}
class Bus extends Vehicle{

	int numberOfPassengers;
	boolean isToilet;
	boolean isConditioner;
	static Bus [] bus = new Bus[4];
	//ініціалізуємо значення елментів масиву у статичному блоці
	static {bus[0] = new Bus("Neoplan",new Route(), true, 28, 40,true,true);
			bus[1] = new Bus("Mersedes",new Route(), true, 14, 17,false,true);
			bus[2] = new Bus("Bohdan",new Route(), false, 15, 27,true,true);
			bus[3] = new Bus("Mersedes",new Route("Яремче","Київ",
			LocalDate.now(), //встановлюємо сьогоднішню дату
			//встановлюємо дату на один тиждень пізнішу ніж сьогодні
			LocalDate.now().plusWeeks(1), 602),
			true, 25,40,true,true);
	}
	Bus(){}
	Bus (String nameLocal, Route routeLocal, boolean workingLocal,double fuelConsumptionValueLocal, 
			int numberOfPassengersLocal,boolean isToiletLocal,boolean isConditionerLocal){
		name=nameLocal;
		route=routeLocal;
		/*Оскільки поля  working і fuelConsumptionValue в класі Vehicle є приватні
		 * то змінити їх можна тільки за допомогою відкритих методів setWorking та 
		 setFuelConsumptionValue */
		setWorking(workingLocal);
		setFuelConsumptionValue(fuelConsumptionValueLocal);
		numberOfPassengers=numberOfPassengersLocal;
		isToilet=isToiletLocal;
		isConditioner=isConditionerLocal;
	}
	//Mетод toString перевизначається
	public String toString(){
		String str = name+ " з кількістю місць - "+	numberOfPassengers;
		if(isToilet) str+=" з туалетом, ";
		if(isConditioner) str+=" з кондиціонером";
		return str;
	}
}

class Car extends Vehicle{
	int numberOfPassengers;
	boolean isConditioner;
	static Car [] car = new Car[4];
	static{	car[0] = new Car("Mersedes GLK",new Route(), true, 6, 4,true);
			car[1] = new Car("VolksWagen Trensporter",new Route(), true, 9, 8,false);
			car[2] = new Car("ZAZ Lanos",new Route(), false, 7, 4,true);
			car[3] = new Car("Ford",new Route("Івано-Франківськ","Гданськ, Польща",
			LocalDate.now(), //встановлюємо сьогоднішню дату
			//встановлюємо дату на один тиждень пізнішу ніж сьогодні
			LocalDate.now().plusWeeks(1), 931),
			true, 8,8,true);
	}
	Car(){}
	Car(String nameLocal, Route routeLocal, boolean workingLocal, 
			double fuelConsumptionValueLocal, int numberOfPassengersLocal,
			boolean isConditionerLocal){
		name=nameLocal;
		route=routeLocal;
		setWorking(workingLocal);
		setFuelConsumptionValue(fuelConsumptionValueLocal);
		numberOfPassengers=numberOfPassengersLocal;
		isConditioner=isConditionerLocal;
	}
	public String toString(){
		String str = name+ " з кількістю місць - "+	numberOfPassengers;
		if(isConditioner) str+=" з кондиціонером";
		return str;
	}
}

class Truck extends Vehicle{
	int maxiWeight;
	static Truck [] truck = new Truck[4];
	static{	truck[0] = new Truck("Scania",new Route(), true, 20, 4000);
			truck[1] = new Truck("Mersedes",new Route(), true, 21, 5000);
			truck[2] = new Truck("MAZ",new Route(), true, 14,3000 );
			truck[3] = new Truck("KRAZ",new Route(), true, 25, 7000 );
	}
	Truck(){}
	Truck(String nameLocal, Route routeLocal, boolean workingLocal, 
			double fuelConsumptionValueLocal, int maxiWeightLocal){
		name=nameLocal;
		route=routeLocal;
		setWorking(workingLocal);
		setFuelConsumptionValue(fuelConsumptionValueLocal);
		maxiWeight=maxiWeightLocal;
	}
	public String toString(){
		String str = name+ " з максимальною вантажопідйомністю - "+	maxiWeight;
		return str;
	}
}
