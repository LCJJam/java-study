package com.study.java.ch06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex08HashMap {
    public static void main(String[] args) {

        Employee e1 = new Employee("A");
        e1.addSkill(new Skill("자바",3));
        e1.addSkill(new Skill("C언어",2));
        e1.addSkill(new Skill("파이썬",1));

        Employee e2 = new Employee("B");
        e2.addSkill(new Skill("디비",3));
        e2.addSkill(new Skill("한글",2));
        e2.addSkill(new Skill("파이썬",1));

        List<Employee> team = new ArrayList<>();
        team.add(e1);
        team.add(e2);

        Company comp = new Company();
        comp.addTeam("빅데이터",team);

        comp.printTeamAll();
        /*
         *빅데이터팀
            A 사원
            자바 : 3
            C언어 : 2
            파이썬 : 1
            ---
            B 사원
            디비 : 3
            한글 : 2
            파이썬 : 1
            ---
         */
    }
}

class Skill {
    private String name;
    private int level;

    public Skill (String name, int level) {
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


}

class Employee {
    private String name;
    private List<Skill> skills;

    public Employee (String name) {
        this.name = name;
        skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkill(Skill skill){
        skills.add(skill);
    }
}

class Company {
    Map<String, List<Employee>> teamMap;
    public Company() {
        teamMap = new HashMap<>();
    }
    public void addTeam(String teamName, List<Employee> team) {
        teamMap.put(teamName, team);
    }
    public void printTeamAll() {
        for(Map.Entry<String,List<Employee>> entry : teamMap.entrySet()) {
            System.out.println("* "+ entry.getKey() + "팀");
            for(Employee emp : entry.getValue()) {
                System.out.println(emp.getName() + " 사원");
                for(Skill s : emp.getSkills()) {
                    System.out.println(s.getName() + " : " + s.getLevel());
                }
                System.out.println("---");
            }
        }
    }
}