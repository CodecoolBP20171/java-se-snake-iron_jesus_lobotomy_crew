package com.codecool.snake;

public class Timer {
    private int count;
    private boolean isCounterOn;
    private int limit;
    private int start;

    Timer() {
        count = 0;
        isCounterOn = false;
    }

    public void tickCount() {
        count++;
    }

    public int getActualValue() {
        return count;
    }

    public boolean isTimeOut(int actual) {
        if (count == actual + limit) {
            return true;
        } else {
            return false;
        }
    }

    public void setCounter(boolean bool) {
        isCounterOn = bool;
    }

    public boolean getCounterStatus() {
        return isCounterOn;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
    }
}
