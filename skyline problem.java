import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); 
            events.add(new int[]{b[1], b[2]});  
        }
        events.sort((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> heights = new PriorityQueue<>(Collections.reverseOrder());
        heights.add(0); 
        int prevMaxHeight = 0;

        for (int[] event : events) {
            int x = event[0], h = event[1];

            if (h < 0) {
                heights.add(-h);
            } else {
                heights.remove(h);
            }

            int currMaxHeight = heights.peek();

            if (currMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }

        return result;
    }
}
