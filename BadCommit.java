
import java.util.*;
public class FindBadCommits
{
    private static int[] commits = {0, 0, 0, 1, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 6, 6, 6};

    public static void main(String[] args) {
        FindBadCommits fbc = new FindBadCommits();
        System.out.println(fbc.findBadCommits(commits.length));
    }

    public List<Integer> findBadCommits(int n) {
        List<Integer> result = new LinkedList<>();
        binarySearch(0, n - 1, result);
        return result;
    }

    private void binarySearch(int l, int r, List<Integer> result)
    {
        if (l == r) {
            return;
        }
        if (l == r - 1){
            if (isWorse(l, r)) {
                result.add(r);
            }
            return;

        }
        int m = l + (r - l) / 2;
        if (isWorse(l, m)) {
            binarySearch(l, m, result);
        }

        binarySearch(m, r, result);
    }

    private boolean isWorse(int i, int j) { 
        //assert i, j < commits.length         return commits[j] > commits[i];     } }
