package com.example.simplecrudproject.controller;

import com.example.simplecrudproject.service.ItemService;
import com.example.simplecrudproject.view.ItemCreateView;
import com.example.simplecrudproject.view.ItemView;
import com.example.simplecrudproject.view.ResultView;
import com.example.simplecrudproject.view.UpdateDescriptionView;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для управления данными о товарах
 */
@RestController
@RequestMapping(value = "item")
public class  ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * Добавляет новый товар в базу данных
     * @param itemCreateView {@link ItemCreateView}
     * @return {@link ResultView}
     */
    @PostMapping(value = "/create")
    public ResultView createItem(@RequestBody ItemCreateView itemCreateView) {
        return itemService.create(itemCreateView);
    }

    /**
     * Обновляет описание товара по его названию
     * @param updateDescriptionView {@link UpdateDescriptionView}
     * @return {@link ResultView}
     */
    @PostMapping(value = "/update")
    public ResultView updateDescription(@RequestBody UpdateDescriptionView updateDescriptionView){
        return itemService.updateDescription(updateDescriptionView);
    }

    /**
     * Удаляет товар из базы данных по названию
     * @param name название товара
     * @return {@link ResultView}
     */
    @DeleteMapping(value = "/delete/{name}")
    public ResultView deleteItem(@PathVariable String name) {
        return itemService.delete(name);
    }

    /**
     * Поиск товара по названию
     * @param name название товара
     * @return {@link ItemView}
     */
    @GetMapping(value = "/getItem/{name}")
    public ItemView getItem(@PathVariable String name ) {
        return itemService.getItemByName(name);
    }
}
