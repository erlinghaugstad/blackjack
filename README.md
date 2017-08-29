# blackjack
Start a random game by invoking:
```
gradle run
```

To start a game with a specific deck, create a file on the following format:
```
CA, D4, H7, SJ,..., S5, S9, D10
```
And start the game by invoking:
```
gradle run -PappArgs="['yourFileName.txt']"
```
