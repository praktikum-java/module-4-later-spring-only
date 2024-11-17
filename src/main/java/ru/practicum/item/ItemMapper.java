package ru.practicum.item;

import lombok.Data;

@Data
public class ItemMapper {

    public static ItemDTO toItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setAvailable(item.getAvailable());
        itemDTO.setOwner(item.getOwner());
        itemDTO.setRequest(item.getRequest());
        return itemDTO;
    }

}
