package fr.ulille1.fil.odeva;

public class IncompatibleClassException extends RuntimeException {
    IncompatibleClassException() {
        super("You cannot use this type. Use appropiate objet type!");
    }
}
