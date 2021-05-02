# Bowling Game App

Basic bowling score calculator. The app's goal is to take a text file that contains the players' data -the data 
indicates how many pins were knocked down on each frame- and compute how many points each player made on the whole game.

## Requirements

- Docker v20

## Compiling the project

```bash
$ docker-compose run --rm maven mvn clean package
```

## Running the project

```bash
$ docker-compose run --rm maven java -cp target/BowlingGame-1.0-SNAPSHOT.jar jobsity.challenge.bowlingGameApp.BowlingGameApp
```