
package classes.disipline;

import java.time.LocalTime;


public class CompetitionResult {
    private final String convention;
    private final String result;
    
    private final String time;
    private final LocalTime localTime;
    public String getConvention() {
        return convention;
    }

    public String getResult() {
        return result;
    }

    public String getTime() {
        return time;
    }
   

    public CompetitionResult(String convention, String result, String time) {
        this.convention = convention;
        this.result = result;
        this.time = time;
        this.localTime = LocalTime.parse(time);
    }

    public LocalTime getLocalTime() {
        return localTime;
    }
    
    
    
}
