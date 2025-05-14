public class TriangleValidatorRight {
    public boolean isRightAngled(int side1, int side2, int side3) {
        if(side1<=0||side2<=0||side3<=0)
          return false;
        else
        {
            if((side1*side1)==(side2*side2+side3*side3)||(side2*side2)==(side3*side3+side1*side1)||(side3*side3)==(side2*side2+side1*side1))
              return true;
            else
            return false;
            
        }
    }
}