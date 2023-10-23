package countdown;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Dates {

	private LocalDate start = LocalDate.now();
    private LocalDate christmas = LocalDate.of(start.getYear(), 12, 23);
    private Period period = Period.between(start, christmas);
    private Duration duration = Duration.between(LocalTime.now(), LocalTime.of(23, 59, 59));
    
    public LocalDate getStart() {
		return start;
	}
    
	public void setStart(LocalDate start) {
		this.start = start;
	}
	
	public LocalDate getChristmas() {
		return christmas;
	}
	
	public void setChristmas(LocalDate christmas) {
		this.christmas = christmas;
	}
	
	public Period getPeriod() {
		return period;
	}
	
	public void setPeriod(Period period) {
		this.period = period;
	}
	
	public Duration getDuration() {
		return duration;
	}
	
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
}
