package sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given hotel arrival and depart arrays and K rooms available.
 * Output if the booking is possible or not.
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 */
public class HotelBookings {
  public static boolean isBookingPossible(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    Collections.sort(arrive);
    Collections.sort(depart);
    int maxLen = arrive.size();
    int totalCounter = 0, maxCounter = Integer.MIN_VALUE;
    int leftPt = 0, rightPt = 0;
    while(leftPt < maxLen || rightPt < maxLen) {
      int leftVal = leftPt < maxLen ? arrive.get(leftPt) : Integer.MAX_VALUE;
      int rightVal = rightPt < maxLen ? depart.get(rightPt) : Integer.MAX_VALUE;
      if (leftVal == Integer.MAX_VALUE) {
        totalCounter--;
        rightPt++;
      }
      if (rightVal == Integer.MAX_VALUE) {
        totalCounter++;
        leftPt++;
      }
      if (leftVal < rightVal) {
        totalCounter++;
        leftPt++;
      } else {
        totalCounter--;
        rightPt++;
      }
      if (totalCounter >= maxCounter) {
        maxCounter = totalCounter;
      }
    }
    return maxCounter <= K;
  }

  public static void main(String... args) {
    ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1, 3, 5));
    ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(2, 6, 8));
    System.out.println(isBookingPossible(l1, l2, 1));
  }

}
