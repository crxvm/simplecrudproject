package com.example.simplecrudproject.model;

import lombok.Data;
import javax.persistence.*;

/**
 * Модель для сущности товаров
 */
@Entity(name = "Item")
@Data
public class Item {
    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * Название товара
     */
    @Column(name = "name")
    private String name;
    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;
    /**
     * Описание товара
     */
    @Column(name = "description")
    private String description;

    /**
     * Цена товара
     */
    @Column(name = "price")
    private Long price;

    /**
     * Имеется ли в наличии
     */
    @Column(name = "is_Available")
    private Boolean isAvailable;
}
