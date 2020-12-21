package com.example.simplecrudproject.service;

import com.example.simplecrudproject.dao.ItemDao;
import com.example.simplecrudproject.model.Item;
import com.example.simplecrudproject.model.mapper.MapperFacade;
import com.example.simplecrudproject.view.ItemCreateView;
import com.example.simplecrudproject.view.ItemView;
import com.example.simplecrudproject.view.ResultView;
import com.example.simplecrudproject.view.UpdateDescriptionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public ItemServiceImpl(ItemDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView updateDescription(UpdateDescriptionView view) {
        dao.updateDescription(view.name, view.description);
        ResultView resultView = new ResultView();
        resultView.result = "description has been successfully updated";
        return resultView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView create(ItemCreateView view) {
        dao.create(mapperFacade.map(view, Item.class));
        ResultView resultView = new ResultView();
        resultView.result = "item has been successfully created";
        return resultView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ItemView getItemByName(String name) {
        return mapperFacade.map(dao.getItemByName(name), ItemView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView delete(String name) {
        dao.delete(name);
        ResultView resultView = new ResultView();
        resultView.result = "item has been successfully deleted";
        return resultView;
    }
}
