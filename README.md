### Magical Arena Game - Low-Level Code

Welcome to the Magical Arena Game! This game is a simple simulation where players fight in an arena using defined attributes like health, strength, and attack. The game logic determines the winner based on a series of dice rolls influencing the damage dealt and defended.

---

## Table of Contents

1. [Overview](#overview)
2. [Assumptions](#assumptions)
3. [Folder Structure](#folder-structure)
4. [Class and Interface Information](#class-and-interface-information)
5. [How to Run](#how-to-run)
6. [Running Tests](#running-tests)

---

## Overview

In the Magical Arena Game, two players battle each other until one player's health reaches zero. Each player has attributes that affect their combat effectiveness. The players attack each other in turns, and the outcome of each attack is influenced by the roll of dice. The game is designed to provide a simple yet engaging battle simulation.

---

## Assumptions

- **Player Attributes**: Players have positive integer attributes for health, strength, and attack.
- **Dice Mechanics**: Dice rolls determine the magnitude of attack and defense in each turn.
- **Match Setup**: A match requires exactly two players.
- **Turn Logic**: The player with lower health attacks first at the start of a match.
- **Game End**: The game ends when one player's health reaches zero.

---

## Folder Structure

```
MagicalArenaGame/
│
├── src/
│   ├── main/
│   │   ├── model/
│   │   │   ├── Arena.java
│   │   │   ├── Player.java
│   │   │   ├── Match.java
│   │   │   └── TwoPlayerMatch.java
│   │   ├── service/
│   │   │   ├── Dice.java
│   │   │   ├── SixSidedDice.java
│   │   │   ├── PlayerFactory.java
│   │   │   ├── RandomPlayerFactory.java
│   │   │   └── UserInputPlayerFactory.java
│   │   └── App.java
│   │
│   └── test/
│       ├── model/
│       │   ├── ArenaTest.java
│       │   ├── PlayerTest.java
│       │   └── TwoPlayerMatchTest.java
│       ├── service/
│       │   ├── RandomPlayerFactoryTest.java
│       │   ├── SixSidedDiceTest.java
│       │   └── UserInputPlayerFactoryTest.java
│       ├── utils/
│       │   └── TestUtils.java
│       └── TestRunner.java
│ 
└── README.md
```

---

## Class and Interface Information

### Classes:

- **Arena**: Manages the battle logic between two players, handling the turn-based fighting and determining the winner.
- **Player**: Represents a player with attributes like health, strength, and attack.
- **Match**: Abstract class which can be extended for different types of matches.
- **TwoPlayerMatch**: Extends `Match` to handle matches specifically between two players.
- **App**: Main entry point for running the game.

### Interfaces:

- **Dice**: Defines the contract for dice rolling mechanisms.
- **PlayerFactory**: Defines the contract for creating `Player` instances.

### Implementations:

- **SixSidedDice**: Implementation of `Dice` that simulates a standard six-sided die.
- **RandomPlayerFactory**: Generates players with random attributes within defined ranges.
- **UserInputPlayerFactory**: Creates players based on user input for attributes.

### Utilities:

- **TestUtils**: Contains helper methods for running tests and handling common test logic.

---

## How to Run

### Running the Game

1. **Compile the Code**:
   Navigate to the root directory and compile the Java source files:

   ```bash
   javac src/main/*.java src/main/model/*.java src/main/service/*.java
   ```

2. **Run the Game**:
   Execute the compiled `App` class:

   ```bash
   java src.main.App 
   ```

### Running Tests

1. **Compile the Tests**:
   Compile all the unit test files:

   ```bash
   javac src/test/*.java src/test/model/*.java src/test/service/*.java src/test/utils/*.java
   ```

2. **Run the Tests**:
   Execute the test files individually:

   ```bash
   java src.test.model.PlayerTest 
   java src.test.model.ArenaTest
   java src.test.model.TwoPlayerMatchTest 
   java src.test.model.RandomPlayerFactoryTest 
   java src.test.model.SixSidedDiceTest 
   java src.test.model.UserInputPlayerFactoryTest

   ```

2. **Run all the Tests together**:
   Execute all unit tests files in one go:

   ```bash
   java src.test.TestRunner
   ```

---

## Future Improvements

- We can extend Match to implement multi-player, tournament-style matches or free-for-all battles without needing to edit the code.
- Configuration Files: Load player configurations from a file to simplify setup for large numbers of players.