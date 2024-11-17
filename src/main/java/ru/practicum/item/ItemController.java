package ru.practicum.item;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ItemDTO create(@RequestBody @Valid Item item, @RequestHeader("X-Sharer-User-Id") Long id) {
        log.info("Создан предмет ={} принадлежащий пользователю ={}", item.getName(), id);
        return itemService.create(item, id);
    }

    @PatchMapping("/{id}")
    public ItemDTO update(@RequestBody Item item, @RequestHeader("X-Sharer-User-Id") Long id) {
        return itemService.update(item,id);
    }

    @GetMapping
    public List<ItemDTO> getAll(@RequestHeader("X-Sharer-User-Id") Long userId) {
        return itemService.getAllFromUser(userId);
    }

    @GetMapping("/{id}")
    public ItemDTO get(@PathVariable Long id) {
        return itemService.get(id);
    }

    @GetMapping("/search")
    public List<ItemDTO> searchItem(@RequestParam("text") String search) {
        return itemService.searchItem(search);
    }

}
