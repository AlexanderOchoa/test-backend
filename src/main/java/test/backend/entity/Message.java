package test.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "chat_message")
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_from_id")
    private Long userIdFrom;

    @Column(name = "user_to_id")
    private Long userIdTo;

    @Column(name = "message_date")
    private Date messageDate;

    @Column(name = "message")
    private String message;

}
