package lesson03;

import java.util.ArrayList;

public class FibSequence {

    public ArrayList<Integer> forNumber(int num) {

        ArrayList<Integer> fibList = new ArrayList<>();

        if (num < 1) {
            return null;
        }

        if (num == 1) {
            fibList.add(0);
            return fibList;
        }

        if (num == 2) {
            fibList.add(0);
            fibList.add(1);
            return fibList;
        }

        fibList.add(0);
        fibList.add(1);
        int count = 2;

        while (count < num) {
            fibList.add(fibList.get(count - 2) + fibList.get(count - 1));
            count++;
        }

        return fibList;
    }
}
