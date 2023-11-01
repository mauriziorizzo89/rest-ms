package it.k8s.restms.mapper;

import it.k8s.restms.dto.ItemDTO;
import it.k8s.restms.entity.ItemEntity;
import it.k8s.restms.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemEntityMapper {

    ItemEntityMapper INSTANCE = Mappers.getMapper(ItemEntityMapper.class);

    ItemEntity itemToItemEntity(Item item);

    Item itemEntityToItem(ItemEntity itemEntity);

}
