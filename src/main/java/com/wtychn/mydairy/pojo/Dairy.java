package com.wtychn.mydairy.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ApiModel(value = "日记")
@Table(name = "dairy")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Dairy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date time;

    private int time_consuming;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    private int tid;

    private String timePeriod;

    private String content;

    public String getTimePeriod() {
        String period = "";
        switch (tid) {
            case 0:
                period = "早晨";
                break;
            case 1:
                period = "下午";
                break;
            case 2:
                period = "晚上";
                break;
            default:
                period = "未定义状态码：" + tid;
        }
        return period;
    }
}
