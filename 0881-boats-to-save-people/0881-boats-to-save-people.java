import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int l = 1;
        int h = people.length;
        int ans = people.length;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (possible(people, limit, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private boolean possible(int[] people, int limit, int boats) {

        int left = 0;
        int right = people.length - 1;
        int used = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            used++;
        }

        return used <= boats;
    }
}