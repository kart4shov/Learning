package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hibernate_developer_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", unique = true, nullable = false)
    private int task_id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @Column(name = "date_of_task")
    private Date task_date;
}
