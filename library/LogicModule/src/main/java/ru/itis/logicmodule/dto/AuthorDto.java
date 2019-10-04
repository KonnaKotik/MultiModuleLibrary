package ru.itis.logicmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class AuthorDto {

    private Long id;

    private String name;

    private String description;

    private String urlImg;

    private List<BookDto> books;
}
