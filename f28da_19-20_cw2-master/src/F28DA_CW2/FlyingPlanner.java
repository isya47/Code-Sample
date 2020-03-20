package F28DA_CW2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;



public class FlyingPlanner implements IFlyingPlannerPartB<Airport,Flight>, IFlyingPlannerPartC<Airport,Flight> {
	ArrayList<Airport> airportArray = new ArrayList<Airport>();
	ArrayList<Flight> FlightArray = new ArrayList<Flight>();
	SimpleDirectedWeightedGraph<Airport, Flight > graph = new SimpleDirectedWeightedGraph<Airport, Flight>(Flight.class);
	
	@Override
	
	public boolean populate(FlightsReader fr) {
		
		HashSet<String[]> airportCodes = fr.getAirports();
		HashSet<String[]> flightCodes = fr.getFlights();
		populate(airportCodes, flightCodes);
		return true;
		
	}

	@Override
	public boolean populate(HashSet<String[]> airports, HashSet<String[]> flights) {
		
		//Create arrays of type Airport and Flight with the size of HashSets
		Airport[] airportCase = new Airport[airports.size()];
		Flight[] flightsCase = new Flight[flights.size()];
		
		int i = 0;
		int j = 0;
		Airport airportInstance = null;
		Flight flightInstance = null;
		
		//loop to populate graph with Vertexes (i.e. Airports' names and their codes)
		//Also, added airport object to array for the further use in airport method below
		for(String[] airport : airports) {
		airportInstance = new Airport(airport[0],airport[2]);
		graph.addVertex(airportInstance);
		airportArray.add(airportInstance);
		airportCase[i] = airportInstance;
		i++;
		
		}
		//Loop to create new instance of flight class with every iteration
		for(String[] flight : flights) {
			//create variables of type Airport
			Airport departureAirport=null;
			Airport destinationAirport = null;
			//Creating new instance of Flight and populate it with content of a singe flight row
			flightInstance = new Flight(flight[0], airport(flight[1]),flight[2], airport(flight[3]), flight[4],Integer.parseInt(flight[5]));
		
		//assign departure and destination airports with array's contents	
		for(Airport x : airportCase) {
			if(x.getCode() == flight[1]) {
				departureAirport = x;
			}
			if(x.getCode() == flight[3]) {
				destinationAirport = x;
			}
		}
		//populate graph edges (i.e. flights with other information) and set weight(i.e. cost)
		flightsCase[j] = flightInstance;
		FlightArray.add(flightInstance);
		graph.addEdge(departureAirport, destinationAirport, flightInstance);
		graph.setEdgeWeight(flightInstance, flightInstance.getCost());
		j++;
		}
		
		return true;
	}

	
	
	@Override
	//method to return Aiport as a instance of a class, using only airports code as a string.
	public Airport airport(String code) {
		//Create an instance, which will return null if airport does not exist
		Airport ap = null;
		//iterate through arrayList of Airport Objects
		for (int i = 0; i <airportArray.size(); i++) {
			// if code code in the airport table matches the one was passed
			if(airportArray.get(i).getCode() == code){
				//assign airport object and return it
				ap = airportArray.get(i);
				return ap;
			}
		
		}
		return ap;
		
	}
	//method to return Flight as instance of a class using only flight code
	@Override
	public Flight flight(String code) {
		//Create an instance, which will return null if airport does not exist
		Flight fl = null;
		//iterate through arrayList of Flight Objects
		for (int i = 0; i <FlightArray.size(); i++) {
			// if code code in the flight table matches the one was passed
			if(FlightArray.get(i).getFlightCode() == code){
				//assign flight object and return it
				fl = FlightArray.get(i);
				return fl;
			}
		
		}
		return fl;
		
	

	}

	@Override
	public Journey leastCost(String from, String to) throws FlyingPlannerException {
		
		System.out.print("Got here");
		GraphPath<Airport, Flight> cheapestRoute = DijkstraShortestPath.findPathBetween(graph,airport(from),airport(to));
		
		System.out.print(cheapestRoute.getWeight());
		return null;
	
		
		
		}

	@Override
	public Journey leastHop(String from, String to) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Journey leastCost(String from, String to, List<String> excluding)
			throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Journey leastHop(String from, String to, List<String> excluding)
			throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<Airport> directlyConnected(Airport airport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setDirectlyConnected() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDirectlyConnectedOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Airport> getBetterConnectedInOrder(Airport airport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leastCostMeetUp(String at1, String at2) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leastHopMeetUp(String at1, String at2) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leastTimeMeetUp(String at1, String at2, String startTime) throws FlyingPlannerException {
		// TODO Auto-generated method stub
		return null;
	}


}
