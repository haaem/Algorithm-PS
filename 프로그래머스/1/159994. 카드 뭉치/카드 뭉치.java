class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0, index2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            if (index1 >= cards1.length) {
                if (!goal[i].equals(cards2[index2]))
                    return "No";
                index2++;
            } else if (index2 >= cards2.length) {
                if (!goal[i].equals(cards1[index1]))
                    return "No";
                index1++;
            } else {
                if (goal[i].equals(cards1[index1])) {
                    index1++;
                } else if (goal[i].equals(cards2[index2])) {
                    index2++;
                } else {
                    return "No";
                }
            }
        }

        return "Yes";
    }
}