package com.wtychn.mydairy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Data
@Entity
@ApiModel(value = "日记")
@Table(name = "dairy")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Document(indexName = "my_dairy", type = "dairy")
public class Dairy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String time;

    private int time_consuming;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    private String content;

}
