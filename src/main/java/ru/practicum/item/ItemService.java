package ru.practicum.item;


import java.util.List;

interface ItemService {
    ItemDTO create(Item item, Long userId);

    ItemDTO update(Item item, Long userId);

    ItemDTO get(Long id);

    List<ItemDTO> searchItem(String search);

    List<ItemDTO> getAllFromUser(Long id);

}
