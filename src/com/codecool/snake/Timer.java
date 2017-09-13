package com.codecool.snake;

public class Timer {
    int count;

    Timer() {
        count = 0;
    }

    public void tickCount() {
        count++;
    }

    public int getActualValue() {
        return count;
    }
}
