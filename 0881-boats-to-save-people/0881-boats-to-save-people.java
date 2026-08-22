import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {

            // Try to put lightest + heaviest together
            if (people[left] + people[right] <= limit) {
                left++;
            }

            // Heaviest person gets a boat

                right--;
                boats++;

        }

        return boats;
    }
}