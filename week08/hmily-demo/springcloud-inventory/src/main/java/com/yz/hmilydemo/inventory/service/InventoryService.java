package com.yz.hmilydemo.inventory.service;

import com.yz.hmilydemo.common.inventory.dto.InventoryDTO;

/**
 * 库存操作接口
 * @author liquan
 * date: 2020/12/09 22:39
 * version: 1.0
 */
public interface InventoryService {

    /**
     * 减库存
     *
     * @param inventoryDTO 库存实体DTO
     * @return boolean
     */
    Boolean decrease(InventoryDTO inventoryDTO);

    /**
     * mock 库存扣减try阶段异常.
     *
     * @param inventoryDTO dto
     * @return true boolean
     */
    Boolean mockWithTryException(InventoryDTO inventoryDTO);
}
