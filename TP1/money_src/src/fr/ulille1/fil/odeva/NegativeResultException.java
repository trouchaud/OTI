package fr.ulille1.fil.odeva;

public class NegativeResultException extends Exception {
    NegativeResultException(Money m1, Money m2)
    {
        super(m1.getValue() + "est plus petit que" + m2.getValue() + "Le résultat de la soustraction sera donc négatif");
    }
}
