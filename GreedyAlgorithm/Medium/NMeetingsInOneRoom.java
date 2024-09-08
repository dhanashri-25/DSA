import java.util.*;

class Meeting {
  int start;
  int end;

  Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

public class NMeetingsInOneRoom {
  public static void maxMeetings(int start[], int end[], int n) {

    Meeting[] meet = new Meeting[n];
    for (int i = 0; i < n; i++) {
      meet[i] = new Meeting(start[i], end[i]);
    }
    Arrays.sort(meet, (a, b) -> a.end - b.end);
    int count = 1;
    int endtime = meet[0].end;
    for (int i = 1; i < n; i++) {
      if (meet[i].start > endtime) {
        count++;
        endtime = meet[i].end;
      }
    }
    System.out.println(count);

  }

  public static void main(String args[]) {
    int n = 6;
    int start[] = { 1, 3, 0, 5, 8, 5 };
    int end[] = { 2, 4, 5, 7, 9, 9 };
    maxMeetings(start, end, n);

  }
}
