package com.GameShop.service.impl;

import com.GameShop.dao.TagDao;
import com.GameShop.entity.Tag;
import com.GameShop.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName TagServiceImpl
 * @Author KaoRouFan
 * @Date 2025/2/24 08:27
 * @Version 1.14.5.14
 */
@Service("TagService")
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;


    @Override
    public List<Tag> selectAllTags() {
        return tagDao.selectAllTags();
    }
}
