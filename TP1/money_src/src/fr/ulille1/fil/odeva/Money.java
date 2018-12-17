package  fr.ulille1.fil.odeva;

import java.util.HashMap;
import java.util.Map;

public class Money {
	private int value;
	private String currency;
	

	Money(int value, String currency)
	{
		this.value=value;
		this.currency=currency;
	}

	public int getValue()
	{
		return this.value;
	}

	public String getCurrency()
	{
		return this.currency;
	}

    public String toString() {
     	return this.getValue()+" ("+this.getCurrency()+")";
    }
    
    
    public boolean equals(Object o) {
		if(o instanceof Money){
			Money money = (Money)o;
			return this.getValue() == money.getValue() && this.getCurrency() == money.getCurrency();
		}
		else
    	return false;
    }

}
