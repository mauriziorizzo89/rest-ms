package it.k8s.restms.controller;

import it.k8s.restms.dto.ItemDTO;
import it.k8s.restms.mapper.ItemMapper;
import it.k8s.restms.model.Item;
import it.k8s.restms.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/item/v1")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable int id) {
        Item itemById = itemService.getItemById(id);
        ItemDTO itemDTO = ItemMapper.INSTANCE.itemToItemDTO(itemById);
        return ResponseEntity.ok(itemDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<ItemDTO> saveItem(@RequestBody ItemDTO itemDTO) {
        Item item = ItemMapper.INSTANCE.itemDTOToItem(itemDTO);
        Item result = itemService.saveItem(item);
        itemDTO.setId(result.getId());
        return ResponseEntity.ok(itemDTO);
    }

}
