import java.util.*;

class NMeetingInOneRoom {
    static class Meeting {
        int start, end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int maxMeetings(int[] start, int[] end, int n) {
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }
        meetings.sort(Comparator.comparingInt(m -> m.end));

        int count = 1;
        int lastEnd = meetings.get(0).end;

        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start >= lastEnd) {
                count++;
                lastEnd = meetings.get(i).end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println(maxMeetings(start, end, start.length));
    }
}
