package fr.ulille1.fil.odeva;

import static org.junit.Assert.*;
import org.junit.*;

public class MoneyEqualsTest {

    private Money f12EUR,  f14EUR;
    private MoneyFactory mf;

    @Before
    public void init() throws UnexistingCurrencyException
    {
        mf=MoneyFactory.getDefaultFactory();
        f12EUR=mf.createMoney(12, "EUR");
        f14EUR=mf.createMoney(14, "EUR");
    }

    @Test(expected = NullPointerException.class)
    public void TestMoneyVsMoneyNull() throws UnexistingCurrencyException{
        Money m=mf.createMoney(26, "EUR");
        m.equals(null);
    }

    @Test(expected = IncompatibleClassException.class)
    public void TestMoneyVsNoValidType() throws UnexistingCurrencyException{
        Money m=mf.createMoney(26, "EUR");
        m.equals(new String());
    }

    @Test(expected = IncompatibleCurrencyException.class)
    public void TestMoneyVsMoneyWithDifferentCurrency() throws UnexistingCurrencyException{
        Money m=mf.createMoney(26, "EUR");
        Money m2=mf.createMoney(26, "DOL");
        m.equals(m2);
    }

    @Test(expected = IncompatibleCurrencyException.class)
    public void TestMoneyVsMoneyWithDifferentCurrencyInMinuscule() throws UnexistingCurrencyException{
        Money m=mf.createMoney(26, "EUR");
        Money m2=mf.createMoney(26, "eur");
        m.equals(m2);
    }

    @Test
    public void TestMoneyVsMoneyWithDifferentValue() throws UnexistingCurrencyException{
        Money m=mf.createMoney(26, "EUR");
        Money m2=mf.createMoney(12, "EUR");
        assertFalse(m.equals(m2));
    }

    @Test
    public void TestMoneyVsMoneyWithSameValue() throws UnexistingCurrencyException{
        Money m=mf.createMoney(26, "EUR");
        Money m2=mf.createMoney(26, "EUR");
        assertTrue(m.equals(m2));
    }
}
