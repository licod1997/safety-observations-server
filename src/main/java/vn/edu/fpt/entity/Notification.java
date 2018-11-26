package vn.edu.fpt.entity;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity( name = "notification" )
public class Notification {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id" )
    private Long id;

    @Column( name = "image_url" )
    private String imageURL;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "time" )
    private Date time;

    @Column( name = "status" )
    private int status;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = CameraLocation.class )
    @JoinColumn( name = "camera_location", referencedColumnName = "id" )
    private CameraLocation cameraLocation;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = User.class )
    @JoinColumn( name = "user", referencedColumnName = "id" )
    private User user;

    @OneToOne( mappedBy = "notification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private NotificationFeedback notificationFeedback;

    public Notification() {
    }

    public Notification( String imageURL, Date time, CameraLocation cameraLocation ) {
        this.imageURL = imageURL;
        this.time = time;
        this.cameraLocation = cameraLocation;
        this.status = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL( String imageURL ) {
        this.imageURL = imageURL;
    }

    public Date getTime() {
        return time;
    }

    public void setTime( Date time ) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus( int status ) {
        this.status = status;
    }

    public CameraLocation getCameraLocation() {
        return cameraLocation;
    }

    public void setCameraLocation( CameraLocation cameraLocation ) {
        this.cameraLocation = cameraLocation;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user )    {
        this.user = user;
    }

    public NotificationFeedback getNotificationFeedback() {
        return notificationFeedback;
    }

    public void setNotificationFeedback( NotificationFeedback notificationFeedback ) {
        this.notificationFeedback = notificationFeedback;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", imageURL='" + imageURL + '\'' +
                ", time=" + time +
                ", status=" + status +
                '}';
    }
}
