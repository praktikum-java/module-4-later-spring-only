package ru.practicum.item;

import java.util.List;

interface ItemRepository {
    ItemDTO create(Item item);

    ItemDTO update(Item item);

    ItemDTO get(Long id);

    List<ItemDTO> searchItem(String search);

    List<ItemDTO> getAllFromUser(List<Long> keys);
}
