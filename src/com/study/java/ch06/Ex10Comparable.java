package com.study.java.ch06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ex10Comparable {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "A","D","B","C","E");

        List<Skill2> list2 = new ArrayList<>();
        Collections.addAll(list2,
                new Skill2("자바",3),
                new Skill2("C언어",2),
                new Skill2("C언어 1",1),
                new Skill2("C언어 3",3),
                new Skill2("자바 언어", 3));

        // 기본 방식 Overriding (compareTo)
        Collections.sort(list2);

        System.out.println(list2.toString());

    }
}

class Skill2 implements Comparable<Skill2>{
    private String name;
    private int level;

    public Skill2 (String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void add (HashMap<String,Integer> map) {
        this.name = map.keySet().iterator().next();
        this.level = map.get("level");
    }

    @Override
    public int compareTo(Skill2 skill) {
        // 기본 오름차순  12345 , compareTo 음수 반환시 자리 변경
        int result = Integer.valueOf(level).compareTo(skill.getLevel()) * -1;
        if(result == 0) result = name.compareTo(skill.name) * -1;
        return result;
    }

    @Override
    public String toString() {
        return "(" + level + ", " + name + ")";
    }
}
