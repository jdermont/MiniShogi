package com.codingame.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    public static final int FIRST_PLAYER = 0;
    public static final int SECOND_PLAYER = 1;
    public static final int NONE = -1;

    public final GameState gameState;
    private final Map<String,Integer> repetitions = new HashMap<>();
    private Move lastMove;

    public Game() {
        gameState = new GameState();
        gameState.init();
        addRepetitionCounter(gameState.toKey());
    }

    public void makeMove(Move move) {
        gameState.makeMove(move);
        addRepetitionCounter(gameState.toKey());
        lastMove = move;
    }

    public boolean isGameOver() {
        if (gameState.rounds >= 300) {
            return true;
        }
        if (repeatedFor4thTime()) {
            return true;
        }
        return gameState.generateMoves().isEmpty();
    }

    public int getWinner() {
        List<Move> moves = gameState.generateMoves();
        if (moves.isEmpty()) { // either checkmated or stalemated player loses
            return gameState.currentPlayer^1;
        }
        if (repeatedFor4thTime()) {
            if (gameState.isKingInCheck()) { // checking side loses
                return gameState.currentPlayer^1;
            }
            return Game.SECOND_PLAYER; // first player loses
        }
        return NONE;
    }

    public Move getLastMove() {
        return lastMove;
    }

    public List<Move> getAvailableMoves() {
        return gameState.generateMoves();
    }

    public boolean repeatedFor4thTime() {
        return repetitions.getOrDefault(gameState.toKey(),0) >= 4;
    }

    private void addRepetitionCounter(String key) {
        repetitions.put(key, repetitions.getOrDefault(key,0)+1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(gameState);
        return sb.toString();
    }
}
