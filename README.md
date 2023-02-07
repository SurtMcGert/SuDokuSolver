# SuDoku Solver

A simple SuDoku solver using a recursive backtracking algorithm implemented in java.

### Generate a board

```java
this.board = BoardHandler.readBoard(this.boardFile);
```

This will read the board stored in `this.boardFile` and load it into a Board object.

### Solve The Board

```java
backTrack(board)
```

This will apply the backtracking algorithm to the given board. It does not return a new object, it simply solves the current object.

### Save The Solution

```java
BoardHandler.wrightSolution(board, this.solutionFile);
```

This will save the given board to the given file.

## Formatting A Board File

a board is written in a txt file. The program can only handle traditional sized boards of 9x9. Blank cells are written as spaces.

### Example Board

board.txt

```
1 3 4 5
9  1    6
    5  8
     5
    7   2
 72  3 5
 1    2 3
2  8 6 7
     46
```

### Example Solution

solution.txt

```
183642597
957138426
426759381
341285769
569471832
872963154
618597243
234816975
795324618
```
