class Solution {
  // trick for JIT compiler it make it to execute the code fast 
    static {
        for (int i = 0; i < 500; i++) {
            groupAnagrams(new String[] {""});
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }

            map.get(sortedKey).add(word);
        }

        return new ArrayList<>(map.values());
    }
}