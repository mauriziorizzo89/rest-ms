package it.k8s.restms.service;

import it.k8s.restms.entity.ItemEntity;
import it.k8s.restms.mapper.ItemEntityMapper;
import it.k8s.restms.mapper.ItemMapper;
import it.k8s.restms.model.Item;
import it.k8s.restms.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /** {@inheritDoc} */
    @Override
    public Item getItemById(Integer id) {
        log.debug("IN: [{}]", id);
        Optional<ItemEntity> byId = itemRepository.findById(id);
        log.debug("Optional<ItemEntity>: [{}]", byId);
        ItemEntity item = byId.orElse(null);
        log.debug("ItemEntity: [{}]", item);
        return ItemEntityMapper.INSTANCE.itemEntityToItem(item);
    }

    /** {@inheritDoc} */
    @Override
    public Item saveItem(Item item) {
        ItemEntity itemEntity = ItemEntityMapper.INSTANCE.itemToItemEntity(item);
        ItemEntity saved = itemRepository.save(itemEntity);
        return ItemEntityMapper.INSTANCE.itemEntityToItem(saved);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteItemById(int id) {
        itemRepository.deleteById(id);
    }

}
