public class Selection {
  public static void main(String [] args) {
    int nums[] = {5,3,8,4,2};

    sort(nums);
  }

  static void sort(int nums[]) {
    int item = 0, tmp = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      item = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[item])
          item = j;
      }
      tmp = nums[i];
      nums[i] = nums[item];
      nums[item] = tmp;
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
