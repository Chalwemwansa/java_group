public class Merge {
  public static void main(String [] args) {
    int nums[] = {7,12,1,-2,0,15,4,11,9};

    printArray(nums);
    sort(nums);
  }

  static void sort(int nums[]) {
    mergesort(nums, 0, nums.length - 1);
  }

  static void mergesort(int nums[], int left, int right) {
    if (left >= right)
      return;
    int mid = (left + right) / 2;

    mergesort(nums, left, mid);
    mergesort(nums, mid + 1, right);

    merge(nums, left, mid, mid + 1, right);
  }

  static void merge(int nums[], int start1, int stop1, int start2, int stop2) {
    int tmp[] = new int[50];

    int i = start1;
    int j = start2;
    int tmpIndex = 0;

    while (i <= stop1 && j <= stop2) {
      if (nums[i] < nums[j])
        tmp[tmpIndex++] = nums[i++];
      else
        tmp[tmpIndex++] = nums[j++];
    }
    while (i <= stop1)
      tmp[tmpIndex++] = nums[i++];
    while (j <= stop2)
      tmp[tmpIndex++] = nums[j++];
    for (i = start1, j = 0; i <= stop2; i++, j++)
      nums[i] = tmp[j];
		printArray(nums);
  }
	
	static void printArray(int nums[]) {
    System.out.print("{");
    for (int num : nums) {
      System.out.printf("%d,", num);
    }
    System.out.println("}");
  }
}
