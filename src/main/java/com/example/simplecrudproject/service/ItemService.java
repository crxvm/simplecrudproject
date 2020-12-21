package com.example.simplecrudproject.service;

import com.example.simplecrudproject.view.ItemCreateView;
import com.example.simplecrudproject.view.ItemView;
import com.example.simplecrudproject.view.ResultView;
import com.example.simplecrudproject.view.UpdateDescriptionView;

/**
 * Сервис для управления товарами
 */
public interface ItemService {
    /**
     * Обновляет описание товара
     * @param view {@link UpdateDescriptionView}
     * @return {@link ResultView}
     */
    ResultView updateDescription(UpdateDescriptionView view);

    /**
     * Добавляет новый товар
     * @param view
     * @return {@link ResultView}
     */
    ResultView create(ItemCreateView view);

    /**
     * Получить товар по названию
     * @param name название
     * @return {@link ItemView}
     */
    ItemView getItemByName(String name);

    /**
     * Удалить товар
     * @param name название товара
     * @return {@link ResultView}
     */
    ResultView delete(String name);
}
