 class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstPos = -1;
        int prevPos = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        while (curr.next != null) {
            boolean isMaxima = curr.val > prev.val && curr.val > curr.next.val;
            boolean isMinima = curr.val < prev.val && curr.val < curr.next.val;

            if (isMaxima || isMinima) {
                if (firstPos == -1) {
                    firstPos = index;
                } else {
                    minDistance = Math.min(minDistance, index - prevPos);
                }
                prevPos = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (firstPos == -1 || firstPos == prevPos) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevPos - firstPos;
        return new int[]{minDistance, maxDistance};
    }
}