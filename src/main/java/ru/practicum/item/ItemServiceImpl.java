package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.utility.UtilityValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UtilityValidator utilityValidator;

    @Override
    public ItemDTO create(Item item, Long userId) {
        item.setOwner(userId);
        utilityValidator.checkUserId(userId);
        return itemRepository.create(item);
    }

    @Override
    public ItemDTO update(Item item, Long userId) {
        utilityValidator.checkUserId(userId);
        item.setId(utilityValidator.getItemFromUser(userId));
        return itemRepository.update(item);
    }

    @Override
    public ItemDTO get(Long id) {
        return itemRepository.get(id);
    }

    @Override
    public List<ItemDTO> searchItem(String search) {
        return itemRepository.searchItem(search);
    }

    @Override
    public List<ItemDTO> getAllFromUser(Long id) {
        return itemRepository.getAllFromUser(utilityValidator.getKeys(id));
    }

}
