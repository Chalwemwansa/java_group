public class Quick {
  public static void main(String [] args) {
    int nums[] = {7,12,1,-2,0,15,4,11,9};

    printArray(nums, 0, nums.length - 1);
    sort(nums);
    printArray(nums, 0, nums.length - 1);
  }

  static void sort(int nums[]) {
    quicksort(nums, 0, nums.length - 1);
  }

  static void quicksort(int nums[], int left, int right) {
    int j;
    //System.out.printf("left=%d, right=%d\n", left, right);
    if (left >= right)
      return;
    j = partition(nums, left, right);
    quicksort(nums, left, j - 1);
    quicksort(nums, j + 1, right);
  }

  static int partition(int nums[], int left, int right) {
    int i = left;
    int j = right;
    int pivot = nums[left];
    int tmp = left;

    while(true) {
      //System.out.printf("left=%d, right=%d\n", i, j);
      while (i <= right && nums[i] <= pivot)
        i += 1;
      while (nums[j] > pivot)
        j -= 1;
      if (i >= j)
        break;
      tmp = nums[j];
      nums[j] = nums[i];
      nums[i] = tmp;
    }
    tmp = nums[j];
    nums[j] = nums[left];
    nums[left] = tmp;
    printArray(nums, left, right);
    return (j);
  }

	static void printArray(int nums[], int start, int end) {
    System.out.print("{");
    for (;start <= end; start++) {
      System.out.printf("%d", nums[start]);
      if (start != end) {
        System.out.print(" ,");
      }
    }
    System.out.println("}");
  }
}
