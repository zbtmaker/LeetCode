package Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\27 0027.
 */
public class merge56 {
    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args){
        List<Interval> list = new LinkedList<>();
        list.add(new Interval(1,4));
        list.add(new Interval(2,3));
        /*list.add(new Interval(8,10));
        list.add(new Interval(15,18));*/

        merge(list);
        for(Interval interval : list){
            System.out.println("["+interval.start+","+interval.end+"]");
        }
    }
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start > i2.start){
                    return 1;
                }

                if(i1.start < i2.start){
                    return -1;
                }
                return 0;
            }
        });
        for(int i = intervals.size()-2;i>=0;i--){
            if(intervals.get(i).end>=intervals.get(i+1).start){
                intervals.get(i).end = Math.max(intervals.get(i).end,intervals.get(i+1).end);
                intervals.remove(i+1);
            }
        }
        return intervals;
    }

}
