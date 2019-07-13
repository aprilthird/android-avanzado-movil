package pe.com.fdne.fdneandroid.models;

import java.util.Date;
import java.util.List;

public class Event {
    private String title;
    private Date startDate;
    private Date endDate;
    private List<EventContest> eventContests;

    public Event() {
    }

    public Event(String title, Date startDate, Date endDate, List<EventContest> eventContests) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventContests = eventContests;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<EventContest> getEventContests() {
        return eventContests;
    }

    public void setEventContests(List<EventContest> eventContests) {
        this.eventContests = eventContests;
    }
}
