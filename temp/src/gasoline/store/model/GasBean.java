package gasoline.store.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GasBean {
	private String fuelType;
	private int lNum;
	private long credit;
	private double total;
	private double purAm;
	private double vat;
	private double ppLit;
	private String reg;
	private double unleaded = 44.00, diesel = 38.00, premium = 50.00;
	private String ccType;

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setLNum(int lNum) {
		this.lNum = lNum;
	}

	public int getlNum() {
		return lNum;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public void setPurAm(double purAm) {
		this.purAm = purAm;
	}

	public double getPurAm() {
		return purAm;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getVat() {
		return vat;
	}

	public void setPpLit(double ppLit) {
		this.ppLit = ppLit;
	}

	public double getPpLit() {
		return ppLit;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCredit(long cnum) {
		this.credit = cnum;
	}

	public long getCredit() {
		return credit;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getReg() {
		return reg;
	}

	public void computeTotal() {

		switch (fuelType) {
		case "Unleaded":
			ppLit = unleaded + 0;
			purAm = ppLit * lNum;
			vat = (purAm * lNum) * .12;
			total = purAm + vat;
			break;
		case "Diesel":
			ppLit = diesel + 0;
			purAm = ppLit * lNum;
			vat = (diesel * lNum) * .12;
			total = purAm + vat;
			break;
		case "Premium":
			ppLit = premium + 0;
			purAm = ppLit * lNum;
			vat = (premium * lNum) * .12;
			total = purAm + vat;
			break;
		}

	}

	public void insertRecord(Connection conn) {
		String que = "insert into customerpurchase(fuelType, lNum, ppLit, purAm, VatAm, TotalAm, creditType, creditNum) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(que);
			st.setString(1, fuelType);
			st.setInt(2, lNum);
			st.setDouble(3, ppLit);
			st.setDouble(4, purAm);
			st.setDouble(5, vat);
			st.setDouble(6, total);
			st.setString(7, ccType);
			st.setLong(8, credit);

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet viewRecord(Connection conn) {
		ResultSet res = null;
		String que = "select * from customerpurchase";

		try {

			PreparedStatement ps = conn.prepareStatement(que);
			res = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void convertTagalog() {
		String tot = Double.toString(total);
		String num[] = tot.split("\\.");
		int iNum[] = new int[2];

		iNum[0] = Integer.parseInt(num[0]);
		iNum[1] = Integer.parseInt(num[1]);

		int ones = iNum[0] % 10;
		int tens = (iNum[0] % 100) - ones;
		int hund = (iNum[0] % 1000) - tens - ones;
		int thou = iNum[0] - hund - tens - ones;

		reg="";

		switch (thou) {
		case 9000:
			reg = reg.concat("Siyam na libo");
			break;
		case 8000:
			reg = reg.concat("Walong libo");
			break;
		case 7000:
			reg = reg.concat("Pitong libo");
			break;
		case 6000:
			reg = reg.concat("Anim na libo");
			break;
		case 5000:
			reg = reg.concat("Limang libo");
			break;
		case 4000:
			reg = reg.concat("Apat na libo");
			break;
		case 3000:
			reg = reg.concat("Tatlong libo");
			break;
		case 2000:
			reg = reg.concat("Dalawang libo");
			break;
		case 1000:
			reg = reg.concat("Isang libo");
			break;
		}

		if (thou != 0 && hund != 0)
			reg = reg.concat("'t ");

		switch (hund) {
		case 900:
			reg = reg.concat("siyam na raan ");
			break;
		case 800:
			reg = reg.concat("walong daan ");
			break;
		case 700:
			reg = reg.concat("pitong daan ");
			break;
		case 600:
			reg = reg.concat("anim na raan ");
			break;
		case 500:
			reg = reg.concat("limang daan ");
			break;
		case 400:
			reg = reg.concat("apat na raan ");
			break;
		case 300:
			reg = reg.concat("tatlong daan ");
			break;
		case 200:
			reg = reg.concat("dalawang daan ");
			break;
		case 100:
			reg = reg.concat("isang daan ");
			break;
		}

		if (hund != 0 && tens != 0)
			reg = reg.concat("at ");

		switch (tens) {
		case 90:
			reg = reg.concat("siyam na pu");
			break;
		case 80:
			reg = reg.concat("walumpu");
			break;
		case 70:
			reg = reg.concat("pitong pu");
			break;
		case 60:
			reg = reg.concat("anim na pu");
			break;
		case 50:
			reg = reg.concat("limang pu");
			break;
		case 40:
			reg = reg.concat("apat na pu");
			break;
		case 30:
			reg = reg.concat("tatlong pu");
			break;
		case 20:
			reg = reg.concat("dalawam pu");
			break;
		case 10:
			reg = reg.concat("labing ");
			break;
		}

		if (tens != 0 && ones != 0 && tens != 10)
			reg = reg.concat("'t ");

		switch (ones) {
		case 9:
			reg = reg.concat("siyam");
			break;
		case 8:
			reg = reg.concat("walo");
			break;
		case 7:
			reg = reg.concat("pito");
			break;
		case 6:
			reg = reg.concat("anim");
			break;
		case 5:
			reg = reg.concat("lima");
			break;
		case 4:
			reg = reg.concat("apat");
			break;
		case 3:
			reg = reg.concat("tatlo");
			break;
		case 2:
			reg = reg.concat("dalawa");
			break;
		case 1:
			reg = reg.concat("isa");
			break;
		}
		
	System.out.println(reg);
	}
}
