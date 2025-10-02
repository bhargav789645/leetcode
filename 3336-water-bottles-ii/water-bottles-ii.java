class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            int exchanged = 1;
            empty -= numExchange;
            total += exchanged;
            empty += exchanged;
            numExchange += 1;
        }
        return total;
    }
}