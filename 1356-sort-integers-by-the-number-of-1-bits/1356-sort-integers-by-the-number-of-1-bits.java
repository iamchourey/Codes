class Solution {
    public int[] sortByBits(int[] arr) {
       return Arrays.stream(arr)
                     .boxed()
                     .sorted((i, j) -> Integer.bitCount(i) != Integer.bitCount(j) ? Integer.bitCount(i) - Integer.bitCount(j) : i - j)
                     .mapToInt(i -> i)
                     .toArray();
    }
}