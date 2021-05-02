FROM --platform=linux/x86_64 maven:3.8-openjdk-8
COPY . /usr/src/BowlingGame
WORKDIR /usr/src/BowlingGame