package ru.practicum.item;

import lombok.Data;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
@Data
public class ItemRepositoryImpl implements ItemRepository {
    private Long id = 0L;
    private Map<Long, Item> items = new HashMap<>();

    @Override
    public ItemDTO create(Item item) {
        item.setId(id);
        items.put(id++,item);
        return ItemMapper.toItemDTO(item);
    }

    @Override
    public ItemDTO update(Item item) {
        Item updatedItem = items.get(item.getId());
        Optional.ofNullable(item.getName()).ifPresent(updatedItem::setName);
        Optional.ofNullable(item.getDescription()).ifPresent(updatedItem::setDescription);
        Optional.ofNullable(item.getAvailable()).ifPresent(updatedItem::setAvailable);
        Optional.ofNullable(item.getOwner()).ifPresent(updatedItem::setOwner);
        Optional.ofNullable(item.getRequest()).ifPresent(updatedItem::setRequest);
        items.put(item.getId(),updatedItem);
        return ItemMapper.toItemDTO(updatedItem);
    }

    @Override
    public ItemDTO get(Long id) {
        Item item = items.get(id);
        return ItemMapper.toItemDTO(item);
    }

    @Override
    public List<ItemDTO> searchItem(String search) {
        List<ItemDTO> itemList = new ArrayList<>();
        String searchTrimmed = search.trim().toLowerCase();
        for (Item item : items.values()) {
            if (item.getName().trim().toLowerCase().equals(searchTrimmed) && item.getAvailable()) {
                itemList.add(ItemMapper.toItemDTO(item));
            }
        }
        return itemList;
    }

    @Override
    public List<ItemDTO> getAllFromUser(List<Long> keys) {
        List<ItemDTO> itemsDTO = new ArrayList<>();
        for (Long key : keys) {
            Item item = items.get(key);
            if (item != null) {
                itemsDTO.add(ItemMapper.toItemDTO(item));
            }
        }
        return itemsDTO;
    }


}
