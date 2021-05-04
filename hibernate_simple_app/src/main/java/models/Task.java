package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hibernate_developer_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id")
    private Developer developer_id;

    @Column(name = "date_of_task")
    private Date task_date;


    public Task() {
    }

    public Task(Date task_date) {
        this.task_date = task_date;
    }

    public int getTask_id() {
        return task_id;
    }

    public Developer getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(Developer developer_id) {
        this.developer_id = developer_id;
    }

    public Date getTask_date() {
        return task_date;
    }

    public void setTask_date(Date task_date) {
        this.task_date = task_date;
    }

}
