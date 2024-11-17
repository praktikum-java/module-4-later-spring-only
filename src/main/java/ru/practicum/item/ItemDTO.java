package ru.practicum.item;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDTO {
    private Long id;
    private String name;
    private String description;
    private boolean available;
    private Long owner;
    private Long request;
}
