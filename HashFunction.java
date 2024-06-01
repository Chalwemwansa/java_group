import java.util.*;

class Hashing {
  Integer listSize = 0;
  List<Integer> mainlist[];
  private static final int DEFAULT_SIZE = 101;

  Hashing() {
    this(DEFAULT_SIZE);
  }

  @SuppressWarnings("unchecked")
  Hashing(Integer size) {
    this.mainlist = new LinkedList[nextPrime(size)];
    // initialise all the array fields
    for (int i = 0; i < mainlist.length; i++) {
      mainlist[i] = new LinkedList<>();
    }
  }

  void insert(Integer value) {
    List<Integer> sublist = mainlist[hash(value)];

    if (!(sublist.contains(value))) {
      sublist.add(value);

      if (++listSize > mainlist.length) {
        increaseSize();
      }
    }
  }

  void remove(Integer value) {
    List<Integer> sublist = mainlist[hash(value)];

    if (sublist.contains(value)) {
      sublist.remove(value);
      listSize -= 1;
    }
  }

  boolean contains(Integer value) {
    return mainlist[hash(value)].contains(value);
  }

  void clear() {
    for (List<Integer> sublist : mainlist) {
      sublist.clear();
    }
    listSize = 0;
  }

  @SuppressWarnings("unchecked")
  private void increaseSize() {
    List<Integer> tmp[] = mainlist;
    
    mainlist = new LinkedList[nextPrime(mainlist.length * 2)];

    for (int i = 0; i < mainlist.length; i++)
      mainlist[i] = new LinkedList<>();

    // copy all into the expanded linked List
    for (List<Integer> tmpSublist : tmp)
      for (Integer data : tmpSublist)
        insert(data);
  }

  Integer hash(Integer value) {
    Integer hashedVar = value.hashCode();
    hashedVar %= (mainlist.length - 1);
    if (hashedVar < 0)
      hashedVar += mainlist.length;
    return hashedVar;
  }

  Integer nextPrime(Integer value) {
    if (value % 2 == 0)
      value += 1;
    while (!(isPrime(value)))
      value += 2;
    return value;
  }

  private boolean isPrime(Integer value) {
    if (value == 2 || value == 3)
      return true;
    if (value == 1 || value % 2 == 0)
      return false;
    for (int i = 3; i * i <= value; i += 2)
      if (value % i == 0)
        return false;
    return true;
  }
}

public class HashFunction {
    public static void main(String [] args) {
      Hashing myMap = new Hashing(2);

      System.out.println("creating a hash map with size 2:");
      System.out.println("inserting 34 and 56:");
      myMap.insert(34);
      myMap.insert(56);
      System.out.printf("contains 34: %b\n", myMap.contains(34));
      System.out.printf("contains 56: %b\n", myMap.contains(56));
      System.out.println("removing 56:");
      myMap.remove(56);
      System.out.printf("contains 56: %b\n", myMap.contains(56));
      System.out.println("clearing the map:");
      myMap.clear();
      System.out.printf("contains 34: %b\n", myMap.contains(34));

      System.out.println("\ncreating a hash map with default size:");
      myMap = new Hashing();
      System.out.println("inserting 34 and 56:");
      myMap.insert(34);
      myMap.insert(56);
      System.out.printf("contains 34: %b\n", myMap.contains(34));
      System.out.printf("contains 56: %b\n", myMap.contains(56));
      System.out.println("removing 56:");
      myMap.remove(56);
      System.out.printf("contains 56: %b\n", myMap.contains(56));
      System.out.println("clearing the map:");
      myMap.clear();
      System.out.printf("contains 34: %b\n", myMap.contains(34));
    }
}
