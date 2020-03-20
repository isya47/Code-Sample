package F28DA_CW2;

public class Flight implements IFlight {
	
	private String[] flight;
	private String flightCode;
	private Airport departureAirport;
	private String departureTime;
	private Airport destinationAirport;
	private String arriveTime;
	private int cost;
	
	public Flight(String flightCode, Airport departureAirport, String departureTime, Airport destinationAirport, String arriveTime, int cost){
		
		this.flightCode = flightCode;
		this.departureAirport = departureAirport;
		this.departureTime = departureTime;
		this.destinationAirport = destinationAirport;
		this.arriveTime = arriveTime;
		this.cost = cost;
	}
	
	@Override
	public String getFlightCode() {
		return flightCode;
	}

	@Override
	public Airport getTo() {
		return destinationAirport;
	}

	@Override
	public Airport getFrom() {
		return departureAirport;
	}

	@Override
	public String getFromGMTime() {
		return departureTime;
	}

	@Override
	public String getToGMTime() {
		return arriveTime;
	}

	@Override
	public int getCost() {
		return cost;
	}


}
