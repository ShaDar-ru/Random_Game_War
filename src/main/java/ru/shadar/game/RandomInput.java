package ru.shadar.game;

import java.util.Random;

public class RandomInput {
    private static final Random RANDOM = new Random();
    private static RandomInput instance = null;

    protected static RandomInput getInstance() {
        if (instance == null) {
            instance = new RandomInput();
        }
        return instance;
    }

    protected int nextInt(int x) {
        if (x > 1) {
            return RANDOM.nextInt(x);
        } else {
            return 0;
        }
    }
}