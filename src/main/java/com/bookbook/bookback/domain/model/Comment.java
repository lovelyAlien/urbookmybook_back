package com.bookbook.bookback.domain.model;


import com.bookbook.bookback.domain.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable= false)
    private String username;

    @Column(columnDefinition = "TEXT",nullable=false)
    private String contents;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

//    @ManyToOne
//    @JoinColumn(name="town_book_id", nullable=false)
//    private TownBook townBook;

    @Column(name="town_book_id", nullable=false)
    private Long townBookId;


    public Comment(CommentDto commentDto){
        this.username=commentDto.getUser().getUsername();
        this.contents=commentDto.getContents();
        this.user=commentDto.getUser();
        this.townBookId=commentDto.getTownBook().getId();
    }
    public void update(CommentDto commentDto){
        this.contents=commentDto.getContents();
    }
}
