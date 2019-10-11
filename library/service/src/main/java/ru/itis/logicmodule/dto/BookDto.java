package ru.itis.logicmodule.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class BookDto {

    private Long id;

    private String title;

    private String description;

    private String authorName;

    private Long authorId;

    private String urlImg;

}
