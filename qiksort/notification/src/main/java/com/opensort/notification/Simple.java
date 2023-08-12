import java.util.PriorityQueue;

public class Simple {

    public static void main(String[] args) {
        int n = 3;
        int[] a = {2, 1, 1};
        int[] b = {1, 2, 3};
        int m = 4;

        System.out.println(minimumCost(n, a, b, m)); // Output: 7
    }

    public static long minimumCost(int n, int[] a, int[] b, int m) {
        PriorityQueue<Item> pq = new PriorityQueue<>((item1, item2) -> {
            long diff = item1.cost - item2.cost;
            if (diff < 0) return -1;
            if (diff > 0) return 1;
            return 0;
        });

        for (int i = 0; i < n; i++) {
            pq.add(new Item(a[i], b[i]));
        }

        long totalCost = 0;
        for (int i = 0; i < m; i++) {
            Item item = pq.poll();
            totalCost += item.cost;
            item.cost += item.increment;
            pq.add(item);
        }

        return totalCost;
    }

    static class Item {
        long cost;
        int increment;

        Item(int cost, int increment) {
            this.cost = cost;
            this.increment = increment;
        }
    }



}
