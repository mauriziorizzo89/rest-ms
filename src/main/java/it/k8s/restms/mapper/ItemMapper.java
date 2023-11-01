package it.k8s.restms.mapper;

import it.k8s.restms.dto.ItemDTO;
import it.k8s.restms.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDTO itemToItemDTO(Item item);

    Item itemDTOToItem(ItemDTO itemDTO);

}
