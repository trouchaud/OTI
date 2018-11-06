package fr.ulille1.fil.odeva;

import java.io.InvalidClassException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

	public boolean equals(Object m){
		if(m == null)
			throw new NullPointerException();

		if(!(m instanceof Money))
            throw new IncompatibleClassException();

        Money m2 = (Money) m;
		if(!(this.getCurrency()).equals(m2.getCurrency()))
		    throw new IncompatibleCurrencyException(this.getCurrency(), m2.getCurrency());

        if(this.getCurrency() != m2.getCurrency())
            return false;

        if(this.getValue() != m2.getValue())
		    return false;

		return true;
	}
}
