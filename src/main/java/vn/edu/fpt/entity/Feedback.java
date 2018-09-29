package vn.edu.fpt.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Entity( name = "feedback" )
public class Feedback {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id" )
    private Long id;
    @Column( name = "feedback_description" )
    private String feedbackDescription;
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "time" )
    private Date time;
    @OneToMany( mappedBy = "feedback", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = FeedbackPhoto.class )
    private List<FeedbackPhoto> feedbackPhotoList;

    public Feedback() {
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    public void setFeedbackDescription( String feedbackDescription ) {
        this.feedbackDescription = feedbackDescription;
    }

    public Date getTime() {
        return time;
    }

    public void setTime( Date time ) {
        this.time = time;
    }

    public List<FeedbackPhoto> getFeedbackPhotoList() {
        return feedbackPhotoList;
    }

    public void setFeedbackPhotoList( List<FeedbackPhoto> feedbackPhotoList ) {
        this.feedbackPhotoList = feedbackPhotoList;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", feedbackDescription='" + feedbackDescription + '\'' +
                ", time=" + time +
                ", feedbackPhotoList=" + feedbackPhotoList +
                '}';
    }
}