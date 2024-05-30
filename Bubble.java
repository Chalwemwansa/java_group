public class Bubble {
  public static void main(String [] args) {
    int nums[] = {3, -5, 6, 12, 21, -7, 45, 72};

    sort(nums);
  }

  static void sort(int nums[]) {
    boolean flag = true;

    while (flag) {
      flag = false;
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1]) {
          int tmp = nums[i];
          nums[i] = nums[i + 1];
          nums[i + 1] = tmp;
          flag = true;
          printArray(nums);
        }
      }
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
