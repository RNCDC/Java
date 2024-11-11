package assign1.prob3;

import java.util.*;

public class prob3_methods {
  static Scanner scan = new Scanner(System.in);
  static int start, end;
  
  // Problem 3
  // A
  public static void nicomachusInput() {
    System.out.print("Start number: ");
    start = scan.nextInt();
    System.out.print("End number: ");
    end = scan.nextInt();
  }

  // B
  public static void nicomachusSearch(int startRange, int endRange) {
    int y = endRange + 1;
    int nicomachus = 0;
    int power = 0;
    ArrayList<Integer> nicomachusArr = new ArrayList<>();
    try {
      if (startRange > endRange) {
        throw new Exception("!!!Start number should be less than the end number!!!");
      }
      if (startRange < 100 || startRange > 999) {
        throw new Exception("!!!Invalid!!! Start number should be 3-digit number");
      }
      if (endRange < 100 || endRange > 999) {
        throw new Exception("!!!Invalid!!! End number should be 3-digit number");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      nicomachusInput();
    }

    for (int x = startRange; x < y; x++) {
      String num = Integer.toString(x);
      int[] arrNum = new int[num.length()];
      for (int i = 0; i < arrNum.length; i++) {
        arrNum[i] = Character.getNumericValue(num.charAt(i));
        power = (int) Math.pow(arrNum[i], 3);
        nicomachus += power;
      }
      if (nicomachus == x) {
        nicomachusArr.add(x);
      }
      nicomachus = 0;
    }
    nicomachusOutput(nicomachusArr);
  }

  // C
  public static void nicomachusOutput(ArrayList<Integer> nicomachusArr) {
    int index = nicomachusArr.size();
    ArrayList<Integer> reverse = new ArrayList<>();
    int[] rev = new int[3];
    int reverseNum;
    int count = 0;
    if (index != 0) {
      for (int i = 0; i < index; i++) {
        int arrNum = nicomachusArr.get(i);
        reverseNum = 0;
        for (int j = 0; j < rev.length; j++) {
          rev[j] = arrNum % 10;
          arrNum /= 10;
          reverseNum = reverseNum * 10 + rev[j];
        }
        reverse.add(reverseNum);
      }
      System.out.print("Nicomachus number/s: ");
      for (int nicoOut : nicomachusArr) {
        if (nicomachusArr.size() - 1 == count) {
          System.out.printf("%03d", nicoOut);
        } else {
          System.out.printf("%03d ", nicoOut);
        }
        count++;
      }
      count = 0;
      System.out.print("\nReversed number/s:   ");
      for (int revOut : reverse) {
        if (reverse.size() - 1 == count) {
          System.out.printf("%03d\n", revOut);
        } else {
          System.out.printf("%03d ", revOut);
        }
        count++;
      }
    } else {
      System.out.println("There are no Nicomachus number/s");
    }
  }
}
