package com.study.java.ch06;

import java.util.*;

public class Ex11Comparator {
    public static void main(String[] args) {
        List<Skill3> list2 = new ArrayList<>();
        Collections.addAll(list2,
                new Skill3("자바",3),
                new Skill3("C언어",2),
                new Skill3("C언어 1",1),
                new Skill3("C언어 3",3),
                new Skill3("자바 언어", 3));

        // comparator 을 구현하여, 커스터마이징
        Collections.sort(list2, new AscendingNo());
        System.out.println(list2);

        // 일회성 오버라이딩
        /*
        Collections.sort(list2, new Comparator<Skill3>() {
            @Override
            public int compare(Skill3 s1, Skill3 s2) {
                int result = Integer.valueOf(s1.getLevel()).compareTo(s2.getLevel()) * -1;
                if(result == 0) result = s1.getName().compareTo(s2.getName());
                return result;
            }
        });
         */
        // 람다 변경
        Collections.sort(list2, (s1, s2) -> {
            int result = Integer.valueOf(s1.getLevel()).compareTo(s2.getLevel()) * -1;
            if(result == 0) result = s1.getName().compareTo(s2.getName());
            return result;
        });
        System.out.println(list2);

        // 기본 방식 Overriding (compareTo)
        Collections.sort(list2);
        System.out.println(list2);
    }
}

// Compartor : 정렬 방식.
class AscendingNo implements Comparator<Skill3> {

    @Override
    public int compare(Skill3 s1, Skill3 s2) {
        int result = Integer.valueOf(s1.getLevel()).compareTo(s2.getLevel());
        if(result == 0) result = s1.getName().compareTo(s2.getName());
        return result;
    }
}

class Skill3 implements Comparable<Skill3>{
    private String name;
    private int level;

    public Skill3 (String name, int level) {
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
    public int compareTo(Skill3 skill) {
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