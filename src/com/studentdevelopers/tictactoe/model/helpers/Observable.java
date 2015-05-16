package com.studentdevelopers.tictactoe.model.helpers;

import java.util.ArrayList;

public abstract class Observable {

    public ArrayList<Observer> observers = new ArrayList<>();

    public abstract void addObserver(Observer observer);
    public abstract void deleteObserver(Observer observer);
    public abstract void notifyObservers();

}
