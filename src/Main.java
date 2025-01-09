import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deque<String> queue = new LinkedList<>();

        queue.offerLast("hello");

        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());

        System.out.println(14/10);
        System.out.println(14%10);
    }

    public static List<CostArray> transformToCostArray(List<DistanceCost> distanceCosts) {
        List<CostArray> costArray = new ArrayList<>();

        for (int i = 0; i < distanceCosts.size(); i++) {
            DistanceCost current = distanceCosts.get(i);

            // Add the initial tiny range for the current cost bracket
            if (i == 0) {
                costArray.add(new CostArray(0, 0.001, current.cost * 1000));
                costArray.add(new CostArray(0.001, current.maxDistance, 0));
            } else {
                var lastUpper = distanceCosts.get(i - 1);
                var cost = current.cost - lastUpper.cost;
                costArray.add(new CostArray(lastUpper.maxDistance, lastUpper.maxDistance + 0.001, cost * 1000));
                costArray.add(new CostArray(lastUpper.maxDistance + 0.001, current.maxDistance, 0));
            }
        }

        return costArray;
    }

    static class CostArray {
        double lowerBound;
        double upperBound;
        int cost;

        public CostArray(double lowerBound, double upperBound, int cost) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"lower_bound\": " + lowerBound +
                    ", \"upper_bound\": " + upperBound +
                    ", \"cost\": " + cost +
                    "}";
        }
    }


    static class DistanceCost {
        int minDistance;
        int maxDistance;
        int cost;

        public DistanceCost(int minDistance, int maxDistance, int cost) {
            this.minDistance = minDistance;
            this.maxDistance = maxDistance;
            this.cost = cost;
        }
    }

}