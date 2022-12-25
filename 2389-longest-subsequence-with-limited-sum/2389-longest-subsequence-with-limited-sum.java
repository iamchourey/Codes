class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length,
            n = nums.length;
        int[] res = new int[m];
        Arrays.sort(nums);
        long[] pref = new long[n];
        pref[0] = nums[0];
        for (int i = 1; i < n; i++)
            pref[i] = pref[i - 1] + nums[i];
        for (int i = 0; i < m; i++) {
            int l = 0, h = n - 1;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (pref[mid] <= queries[i]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
            res[i] = l;
        }
        return res;
    }
}