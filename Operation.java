interface Operation {
    int perform(int x, int y);
}

// Complete the classes below by implementing the Operation interface and providing your own implementation of the perform method.
class Add implements Operation {
    @Override
    public int perform(int x, int y) {
        // Write your code here
        return x+y;
    }
}

class Subtract implements Operation {
    @Override
    public int perform(int x, int y) {
        // Write your code here
        return x-y;
    }
}

class Divide implements Operation {
    @Override
    public int perform(int x, int y) {
        // Write your code here
        if(y==0)
        {
            return -1;
        }
        else
        {
            return x/y;
        }
    }
}