package com.xy1m.playground.guava.basicutilities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import java.util.Arrays;

/**
 * Created by gzhenpeng on 2019/3/15
 */
public class CommonObjectUtilitiesExplained {
    public static void main(String[] args) {
        System.out.println(Objects.equal(1, null));
        System.out.println(Objects.equal(1, 1));
        System.out.println(Objects.equal(null, 1));
        System.out.println(Objects.equal(null, null));

        System.out.println(Objects.hashCode("a", "b", "c"));
        System.out.println(Objects.hashCode("a", "b", "c"));

        System.out.println(MoreObjects.toStringHelper("MyObject").add("x", 1).toString());

        System.out.println(new Person("tom", 20, 180));
        System.out.println(new Person("tom", 20, 180));
        System.out.println(new Person("tom", 20, 180).hashCode());
        System.out.println(new Person("tom", 20, 180).hashCode());

        System.out.println(
                Ordering.natural().isOrdered(Arrays.asList(
                        new Person("tom", 20, 180),
                        new Person("tom", 21, 180),
                        new Person("tom", 21, 182)
                ))
        );

        System.out.println(Integer.valueOf(MoreObjects.firstNonNull("2", "0")));
        System.out.println(Integer.valueOf(MoreObjects.firstNonNull(null, "0")));
    }

    private static class Person implements Comparable<Person> {
        public String name;
        public int age;
        public int height;

        public Person(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        @Override
        public int compareTo(Person o) {
            return ComparisonChain.start()
                    .compare(this.name, o.name)
                    .compare(this.age, o.age)
                    .compare(this.height, o.height)
                    .result();
        }

        public int hashCode() {
            return Objects.hashCode(name, age, height);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("name", name)
                    .add("age", age)
                    .add("height", height)
                    .toString();
        }
    }

}
