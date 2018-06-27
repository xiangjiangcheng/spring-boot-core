package com.xiang.core.elasticsearch.rest;

import com.xiang.core.elasticsearch.entity.ItemDocument;
import com.xiang.core.elasticsearch.repository.ItemDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lijingyao on 2018/1/19 10:10.
 */
@RestController
@RequestMapping("/items")
public class SearchController {

    @Autowired
    private ItemDocumentRepository repository;


    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public ResponseEntity getItem(@PathVariable("id") String id) {
        ItemDocument com = repository.findById(id).get();
        return new ResponseEntity(com.toString(), HttpStatus.OK);
    }


    /**
     * 添加一行数据到es   如果里面没有配置的index  会自动创建
     */
    @RequestMapping(value = "/addItem", method = {RequestMethod.POST})
    public ResponseEntity createItem(@RequestBody ItemDocument document) {
        repository.save(document);

        return new ResponseEntity(document.toString(), HttpStatus.OK);
    }

}
