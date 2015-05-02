package com.studentdevelopers.tictactoe.model.board;

import com.studentdevelopers.tictactoe.model.Observable;
import com.studentdevelopers.tictactoe.model.Observer;
import com.studentdevelopers.tictactoe.model.player.Figure;

public class Cell extends Observable implements Markable {

    private CellState state;

    public Cell() {
        this.state = CellState.EMPTY;
    }

    @Override
    public void markWith(Figure figure) {
        this.state = figure.equals(Figure.CIRCLE) ? CellState.CIRCLE : CellState.CROSS;
        notifyObservers();
    }

    @Override
    public String toString() {
        return state.toString();
    }

    public CellState state() {
        return this.state;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
