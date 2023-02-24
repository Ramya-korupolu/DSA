Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward)
  for which the stock price was less than or equal to the price of that day.



Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6





class StockSpanner {

    Stack<Pair<Integer, Integer>> s = new Stack<>();
    int days = 0;

    public StockSpanner() {
        return;
    }
    
    public int next(int price) {
        days = 1;
        while(!s.isEmpty() && s.peek().getKey() <= price){
            days += s.pop().getValue();
        }
        Pair p = new Pair(price, days);
        s.add(p);
        return days;
    }
}
