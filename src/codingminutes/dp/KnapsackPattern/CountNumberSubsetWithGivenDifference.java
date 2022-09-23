package codingminutes.dp.KnapsackPattern;

public class CountNumberSubsetWithGivenDifference {
	
	public int numberSubsetWithGivenDifference(int [] arr, int diff) {
		// we need to split the array into 2 subsets s1 and s2 such that s1-s2 = diff
		// let the sum of the elements in the array be sum.
		// So s1+s2 = sum => Eq1, also s1-s2=diff => Eq2
		// Eq1 + Eq2 = 2s1 = sum +diff => s1 = (sum + diff) / 2
		// So this problem reduces to finding the number of subsets in the array, whose sum is equal to (sum + diff) / 2
		// we can easily find that using the count subset sum solution
		int sum = 0;
		for (int num: arr) {
			sum += num;
		}
		
		int target_subset_sum = (sum + diff)/2;
		
		return CountSubsetsSumWithGivenSum.countSubsetSum(arr, target_subset_sum);
	}
	

	public static void main(String[] args) {
		CountNumberSubsetWithGivenDifference cnss = new CountNumberSubsetWithGivenDifference();
		int [] nums = {1,1,2,3};
		System.out.println(cnss.numberSubsetWithGivenDifference(nums, 1));

	}

}
