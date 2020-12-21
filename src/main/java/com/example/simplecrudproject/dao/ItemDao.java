package com.example.simplecrudproject.dao;


import com.example.simplecrudproject.model.Item;

/**
 * DAO для управления сущностями товаров
 */
public interface ItemDao {
    /**
     * Обновляет описание товара
     * @param name название товара
     * @param description описание товара
     */
    void updateDescription(String name, String description);

    /**
     * Создает новый товар
     * @param item
     */
    void create(Item item);

    /**
     * Получить товар по названию
     * @param name название
     * @return {@link Item}
     */
    Item getItemByName(String name);

    /**
     * Удалить товар по названию
     * @param name название товара
     */
    void delete(String name);
}
