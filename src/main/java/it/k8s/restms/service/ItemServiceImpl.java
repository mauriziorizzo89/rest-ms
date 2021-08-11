package it.k8s.restms.service;

import it.k8s.restms.model.Item;
import it.k8s.restms.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /** {@inheritDoc} */
    @Override
    public Item getItemById(int id) {
        Optional<Item> byId = itemRepository.findById(id);
        return byId.orElse(null);
    }

    /** {@inheritDoc} */
    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteItemById(int id) {
        itemRepository.deleteById(id);
    }

}
