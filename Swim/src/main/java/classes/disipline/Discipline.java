
package classes.disipline;

import java.time.LocalTime;
import java.util.HashSet;

public class Discipline {
    String name;
    String bestDate;
    LocalTime bestTime;
    LocalTime bestCompTime;
    HashSet<CompetitionResult> competitionResults =  new HashSet();
    
    public Discipline(String name) {
        this.name = name;
    }
    
    /**
     * @param date in format dd-MM-yyyy
     * @param time in format minutes:seconds:milliseconds  MM:ss:mm
     */
    public void addTrainingSession(String date, String time) {
        LocalTime newTime = LocalTime.parse(time);
        if (bestTime == null || newTime.isBefore(bestTime)) {
            bestTime = newTime;
            bestDate = date;
        }
        
        
    }
    public void addCompetitionResult(String convention, String result, String time) {
        LocalTime newTime = LocalTime.parse(time);
        if (bestCompTime == null || newTime.isBefore(bestCompTime)) {
            bestCompTime = newTime;
            
        }
        competitionResults.add(new CompetitionResult(convention,result, time));
    }
    
    public LocalTime getBestTime() {
        /*
        Iterator i =  competitionResults.iterator();
        LocalTime newBestResult = bestTime;
        while(i.hasNext()) {
            CompetitionResult res = (CompetitionResult)i.next();
            
            if( res.getLocalTime().isBefore(newBestResult)) {
                newBestResult = res.getLocalTime();
            }
        }

        return newBestResult;
*/
        if(bestTime != null) {
            if(bestTime.isBefore(bestCompTime)) {
                return bestTime;
            }
            return bestCompTime;
        }
        return bestCompTime;
    }
    
    
}
