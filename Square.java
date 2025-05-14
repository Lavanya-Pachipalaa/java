public class Square {

    private int side;

    public Square(int side) {
        this.side=side;
        // TODO: Initialize side with the passed value
    }

    public int calculateArea() {
        if(this.side<=0)
          return -1;
        else
          return this.side*this.side;
        // TODO: Calculate and return the area of the square
        
    }

    public int calculatePerimeter() {
        if(this.side<=0)
          return -1;
        else
          return 4*this.side;
    }

}