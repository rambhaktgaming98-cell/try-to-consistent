class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        char_map = {}

        for c in range(ord("a"), ord("z") + 1):
            char_map[chr(c)] = 0

        for i in range(len(s)):
            char_s = s[i]
            char_t = t[i]

            char_map[char_s] = char_map[char_s] + 1
            char_map[char_t] = char_map[char_t] - 1

        for count in char_map.values():
            if count != 0:
                return False

        return True
