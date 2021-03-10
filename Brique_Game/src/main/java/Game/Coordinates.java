package Game;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){ return this.x; }

    public int getY(){ return this.y; }

    public Coordinates getUp() { return new Coordinates(this.x, this.y+1); }

    public Coordinates getDown() { return new Coordinates(this.x, this.y-1); }

    public Coordinates getLeft() { return new Coordinates(this.x-1, this.y); }

    public Coordinates getRight() { return new Coordinates(this.x+1, this.y); }

    public Coordinates getDiagUp() { return new Coordinates(this.x+1, this.y+1); }

    public Coordinates getDiagDown() { return new Coordinates(this.x-1, this.y-1); }
}
