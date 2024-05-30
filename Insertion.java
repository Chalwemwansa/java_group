public class Insertion {
  public static void main(String [] args) {
    int nums[] = {5,3,8,4,2};

    sort(nums);
  }

  static void sort(int nums[]) {
    int i, j, item = 0;

    for (i = 1; i < nums.length; i++) {
      item = nums[i];
      for (j = i - 1; (j >= 0) && (nums[j] > item); j--) {
        nums[j + 1] = nums[j];
      }
      nums[j + 1] = item;
      printArray(nums);
    }
  }

  static void printArray(int nums[]) {
    System.out.print("{");
    for (int num : nums) {
      System.out.printf("%d,", num);
    }
    System.out.println("}");
  }
}
