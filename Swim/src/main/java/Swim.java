
import classes.*;
import java.time.LocalTime;
import java.util.HashMap;

public class Swim {

    public static void main(String[] args) {
         
        Member members[] = new Member[15];
        createMembers(members);
        addDisciplinesToMembers(members);
        addTrainingTimes(members);
        addCompetitionTimes(members);
        
        // udskriv alle medlemmer i restance
        System.out.println("Medlemmer der mangler at betale:");
        for (Member member : members) {
            if (!member.hasPaid()) {
            System.out.println(member.getName());
            } else {
               
            }
        }

     System.out.println("Top 5 i disciplinen Crawl:");  
     showTop5results(members, "Crawl");
     System.out.println("-------------------------------");
      System.out.println("Top 5 i disciplinen Butterfly:");  
     showTop5results(members, "Butterfly");
     System.out.println("-------------------------------");
        
    }
    
    public static void showTop5results(Member members[], String discipline) {
        HashMap<String, Member> top5 = new HashMap();
        LocalTime slowestMemberTime = null;
        Member slowestMember = null;
        for (Member member : members) {
            if(member.hasDisciplines()) {
                LocalTime time = member.getBestTime(discipline);
                if(time!= null) {
                    if(top5.size()<=5 ){
                        top5.put(member.getName(), member);

                    } else {
                        for (Member m : top5.values()) {
                            if(m.getBestTime(discipline).isAfter(slowestMemberTime)) {
                                slowestMember = m;
                                slowestMemberTime = m.getBestTime(discipline);
                            }
                                
                        }
                        if(time.isBefore(slowestMemberTime)) {
                            top5.remove(slowestMember.getName());
                            top5.put(member.getName(), member);
                        }
                    }
                }
            }
        }
        for (Member mem : top5.values()) {
            System.out.println("Member: " + mem.getName() + " Best time: " + mem.getBestTime(discipline));
        }
    }
    
    public static void addDisciplinesToMembers(Member members[]) {
       addDisciplineToMember(members[3], "Crawl");
       addDisciplineToMember(members[4], "Crawl");
       addDisciplineToMember(members[4], "Butterfly");
       addDisciplineToMember(members[8], "Butterfly");
    }
    
    private static void addTrainingTimes(Member[] members) {
        members[3].addTrainingTime("Crawl", "04-12-2024", "01:34:00");
        members[4].addTrainingTime("Crawl", "04-11-2024", "01:31:00");
        members[4].addTrainingTime("Butterfly", "10-11-2024", "02:31:00");
        members[8].addTrainingTime("Butterfly", "10-11-2024", "01:30:00");
        members[8].addTrainingTime("Butterfly", "10-11-2024", "01:29:00");
        
    }
    private static void addCompetitionTimes(Member[] members) {
        members[3].addCompetitionResult("Crawl", "Holte", "3", "01:30:00");
        members[3].addCompetitionResult("Crawl", "Farum", "2", "01:20:00");
        members[4].addCompetitionResult("Crawl", "Holte", "2", "01:27:00");
        members[4].addCompetitionResult("Butterfly", "Farum", "2", "01:54:00");
        members[8].addCompetitionResult("Butterfly", "Holte", "2", "01:14:10");
        members[8].addCompetitionResult("Butterfly", "Farum", "2", "01:54:21");
    }
  
    public static void addDisciplineToMember(Member member, String type) {
        member.addDiscipline(type);
    }
    
    
    public static void createMembers(Member members[]) {
        MemberType memberType[] = new MemberType[3];
        
        memberType[0] = new MemberType("Junior", 1000);
        memberType[1] = new MemberType("Senior", 1600);
        memberType[2] = new MemberType("Old", 1200);
        members[0] =new Member("Gitte", 10, memberType[0], false, true );
        members[1] =new Member("Per", 12, memberType[0], true, true );
        members[2] =new Member("Pernille", 16, memberType[0], true, true );
        members[3] =new Member("Hans", 15, memberType[0], true, false );
        members[4] =new Member("Ulla", 17, memberType[0], true, true );
        //Senior
        members[5] =new Member("Peter", 44, memberType[1], false, true );
        members[6] =new Member("Curt", 21, memberType[1], true, false );
        members[7] =new Member("Mohammed", 24, memberType[1], true, false );
        members[8] =new Member("Claus", 24, memberType[1], true, true );
        members[9] =new Member("Eske", 10, memberType[1], false, true );
        members[10] =new Member("Hans P", 10, memberType[1], true, true );
        members[11] =new Member("Anders", 10, memberType[1], true, true );
        members[12] =new Member("Christian", 10, memberType[1], true, true );
        
        //Old
        members[13] =new Member("Gert", 47, memberType[2], false, true );
        members[14] =new Member("Ursula", 45, memberType[2], true, true );

    }

}
