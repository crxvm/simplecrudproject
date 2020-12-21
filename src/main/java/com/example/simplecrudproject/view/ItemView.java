package com.example.simplecrudproject.view;

import javax.persistence.Version;

/**
 * Отображение товара
 */
public class ItemView {
    /**
     * Уникальный идентификатора
     */
    public Long id;

    /**
     * Название товара
     */
    public String name;
    /**
     * Описание товара
     */
    public String description;
    /**
     * Цена
     */
    public Long price;
    /**
     * Имеется ли в наличии
     */
    public Boolean isAvailable;
}
