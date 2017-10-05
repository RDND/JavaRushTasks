package com.javarush.task.task35.task3513;

import java.util.*;

/**/
public class Model{

    protected int score = 0;
    protected int maxTile = 2;

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    private boolean isSaveNeeded = true;
    private Stack previousStates = new Stack();
    private Stack previousScores = new Stack();

    public Model() {
        resetGameTiles();
    }
    private List<Tile> getEmptyTiles(){
        List<Tile> emptyList = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty())
                    emptyList.add(gameTiles[i][j]);
            }
        }
        return emptyList;
    }
    public void addTile(){List<Tile> emptyTiles = getEmptyTiles();
        emptyTiles.get((int) (Math.random() * emptyTiles.size())).value =
                (Math.random() < 0.9 ? 2 : 4);

    }
    public void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                gameTiles[i][j] = new Tile();
        addTile();
        addTile();
    }
    private boolean compressTiles(Tile[] tiles){boolean isChanged=false;
        int number = 0;
        for (int i=0;i<tiles.length-1;i++){
            if (tiles[i].value==0&&tiles[i+1].value!=0){
                isChanged=true;
                int temp;
                temp=tiles[i].value;
                tiles[i].value=tiles[i+1].value;
                tiles[i+1].value=temp;
                i=-1;
            }
        }

        return isChanged;}
    private boolean mergeTiles(Tile[] tiles){
        boolean isChanged=false;
        for (int i=0;i<tiles.length-1;i++){
            if (tiles[i].value==tiles[i+1].value&&tiles[i].value!=0){
                tiles[i].value = tiles[i].value + tiles[i + 1].value;
                tiles[i+1].value=0;
                if (tiles[i].value>maxTile){
                    maxTile=tiles[i].value;
                }
                score+=tiles[i].value;
                isChanged=true;
            }
        }
        compressTiles(tiles);
        return isChanged;
    }
    private void saveState(Tile[][] tiles){
        Tile[][] savedTiles = new Tile[gameTiles.length][gameTiles[0].length];
        for (int i=0;i<savedTiles.length;i++){
            for (int j=0;j<savedTiles[0].length;j++){
                savedTiles[i][j]=new Tile(gameTiles[i][j].value);
            }
        }
        previousStates.push(savedTiles);
        previousScores.push(score);
        isSaveNeeded=false;
    }
    void left(){
        if (isSaveNeeded){
            saveState(gameTiles);
        }
        boolean isCompressed=false;
        boolean isMerged=false;
        int counter=0;
        for (int i=0;i<gameTiles.length;i++){
            isCompressed=compressTiles(gameTiles[i]);
            isMerged=mergeTiles(gameTiles[i]);
            if (isCompressed||isMerged){
                counter++;
            }
        }
        if (counter>0){
            addTile();
        }
        isSaveNeeded=true;
    }
    private void rotateCW(Tile[][] matrix) {
        int len = matrix.length;
        Tile temp = null;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - 1 - i ; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[len -1 - j][len-1-i];
                matrix[len -1 - j][len-1-i] = temp;
            }
        }
        for(int i = 0; i < len/2; i++){
            for(int j = 0;j < len; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[len-1 -i][j];
                matrix[len -1 -i][j] = temp;
            }
        }
    }
    /**/
    public void right(){
        saveState(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        left();
        rotateCW(gameTiles);
        rotateCW(gameTiles);
    }
    public void down(){
        saveState(gameTiles);
        rotateCW(gameTiles);
        left();
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
    }
    public void up(){
        saveState(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        left();
        rotateCW(gameTiles);
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if(!getEmptyTiles().isEmpty())
            return true;
        for(int i = 0; i < gameTiles.length; i++) {
            for(int j = 1; j < gameTiles.length; j++) {
                if(gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        }
        for(int j = 0; j < gameTiles.length; j++) {
            for(int i = 1; i < gameTiles.length; i++) {
                if(gameTiles[i][j].value == gameTiles[i-1][j].value)
                    return true;
            }
        }
        return false;
    }
    public void rollback(){
        if (!previousStates.empty())
            gameTiles = (Tile[][]) previousStates.pop();
        if (!previousScores.empty())
            score = (int) previousScores.pop();
    }
    /*1) boolean hasBoardChanged — будет возвращать true, в случае,
    если вес плиток в массиве gameTiles отличается от веса плиток в верхнем массиве стека previousStates.
    Обрати внимание на то, что мы не должны удалять из стека верхний элемент, используй метод peek.
2) MoveEfficiency getMoveEfficiency(Move move) — принимает один параметр типа move, и возвращает объект типа MoveEfficiency описывающий эффективность переданного хода. Несколько советов:
а) не забудь вызывать метод rollback, чтобы восстановить корректное игровое состояние;
б) в случае, если ход не меняет состояние игрового поля, количество пустых плиток и счет у объекта MoveEfficiency сделай равными -1 и 0 соответственно;
в) выполнить ход можно вызвав метод move на объекте полученном в качестве параметра.*/
    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
        }
    }
    public boolean hasBoardChanged(){
        int sum1=0;
        int sum2=0;
        if (!previousStates.isEmpty()){
            Tile[][] previouseGameTiles = (Tile[][]) previousStates.peek();
            for (int i=0;i<gameTiles.length;i++){
                for (int j=0;j<gameTiles[0].length;j++){
                    sum1+=previouseGameTiles[i][j].value;
                    sum2+=gameTiles[i][j].value;
                }
            }}
        return sum1!=sum2;
    }
    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()){
            moveEfficiency=new MoveEfficiency(getEmptyTiles().size(),score,move);
        }
        else {
            moveEfficiency=new MoveEfficiency(-1,0,move);
        }
        rollback();
        return moveEfficiency;
    }
    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.add(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                left();
            }
        }));
        priorityQueue.add(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                right();
            }
        }));
        priorityQueue.add(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                up();
            }
        }));
        priorityQueue.add(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                down();
            }
        }));

        priorityQueue.poll().getMove().move();
    }
}