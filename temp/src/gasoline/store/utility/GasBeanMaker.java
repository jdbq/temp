package gasoline.store.utility;

import java.sql.Connection;

import gasoline.store.model.GasBean;

public interface GasBeanMaker {
	public static GasBean getInstance(String fuelType, int lNum, String ccType, long cNum, Connection conn){
		GasBean gas = new GasBean();
		gas.setFuelType(fuelType);
		gas.setLNum(lNum);
		gas.setCcType(ccType);
		gas.setCredit(cNum);
		gas.computeTotal();
		gas.convertTagalog();
		gas.insertRecord(conn);
		
		return gas; 
	}
}
