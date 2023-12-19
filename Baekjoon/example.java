package Baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class example {
    public static class Rectangle {
        int height;
        int width;

        public Rectangle(int height, int width) {
            this.height = height;
            this.width = width;
        }

        @Override
        public int hashCode() {
            return height + width;
        }

        @Override
        public boolean equals(Object obj) {
            Rectangle other = (Rectangle) obj;
            return height == other.height && width == other.width;
        }
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        treeSet.add(6);
        treeSet.add(0);
        treeSet.add(2);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(0);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(7);

        System.out.println(treeSet.subSet(2, 6));

        treeSet.descendingSet();

        System.out.println(treeSet);
    }
}
