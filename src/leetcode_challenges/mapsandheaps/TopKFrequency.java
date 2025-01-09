package leetcode_challenges.mapsandheaps;

import java.util.*;

public class TopKFrequency {

    static int[] topKFrequent(int[] nums, int k) {

        if (nums.length == k) return nums;

        Map<Integer, Integer> numFreq = new HashMap<>();

        for (var num : nums) {
            int freq = numFreq.computeIfAbsent(num, key -> 0);
            numFreq.put(num, freq + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(numFreq::get)
        );

        numFreq.keySet().forEach(num -> {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        });

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }

    static int[] topKFrequency(int[] nums, int k) {
        if (nums.length == k) return nums;

        Map<Integer, Integer> freMap = new HashMap<>();

        for (int num : nums) {
            freMap.merge(num, 1, Integer::sum);
        }

        return freMap.entrySet().stream()
                .sorted(Comparator.<Map.Entry<Integer, Integer>>comparingInt(Map.Entry::getValue).reversed())
                .map(Map.Entry::getKey)
                .limit(k)
                .mapToInt(i -> i)
                .toArray();
    }
}
