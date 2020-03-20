package F28DA_CW2;

import java.util.HashSet;
import java.util.Set;

public class Airport implements IAirportPartB, IAirportPartC {
	

	private String airportName;
	private String code;

	public Airport(String code, String airportName) {
		
		this.code = code;
		this.airportName = airportName;
		
	}
	
	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getName() {
		return airportName;
	}

	@Override
	public void setDicrectlyConnected(Set<Airport> dicrectlyConnected) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Airport> getDicrectlyConnected() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setDicrectlyConnectedOrder(int order) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDirectlyConnectedOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
