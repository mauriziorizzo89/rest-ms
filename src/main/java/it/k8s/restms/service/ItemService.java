package it.k8s.restms.service;

import it.k8s.restms.model.Item;

public interface ItemService {

    /**
     *
     * @param id
     * @return
     */
    Item getItemById(int id);

    /**
     *
     * @param item
     */
    Item saveItem(Item item);

    /**
     * TODO:
     * @param id
     */
    void deleteItemById(int id);

}
