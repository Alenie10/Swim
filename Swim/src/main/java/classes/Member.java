
package classes;

import classes.disipline.*;
import java.time.LocalTime;
import java.util.HashMap;

public class Member {
    private final String name;
    private final int age;
    private final boolean active;
    private final boolean paid;
    private final MemberType memberType;
    private HashMap<String,Discipline> disciplines = new HashMap();

    public Member(String name, int age, MemberType memberType, boolean active, boolean paid) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.paid = paid;
        this.memberType = memberType;
    }
    
    public boolean hasDisciplines() {
        return !disciplines.isEmpty();
    }
    
    public void addDiscipline(String type) {
        switch(type) {
            case "Crawl" -> disciplines.put("Crawl", new Crawl());
            case "Butterfly" -> disciplines.put("Butterfly", new Butterfly());
        }
        
    }
    
    public void addTrainingTime(String discipline, String date, String time) {
        System.out.println("Name: "+ name + " disciplines:" + disciplines.size());
        Discipline d = disciplines.get(discipline);
        d.addTrainingSession(date, time);
    }
    
    public void addCompetitionResult(String discipline, String convention, String result, String time) {
        Discipline d = disciplines.get(discipline);
        d.addCompetitionResult(convention, result, time);
    }
    
    public LocalTime getBestTime(String discipline) {
        Discipline d = disciplines.get(discipline);
        if(d == null)return null;
        return d.getBestTime();
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public boolean hasPaid() {
        return paid;
    }

    public double getSubscriptionPrice() {
        if(active) {
            return memberType.getPrice();
        }
        return 500;
    }
    
    
    
}
