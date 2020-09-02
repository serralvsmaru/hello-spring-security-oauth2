package com.konosuba.oauth2.service.impl;

import com.konosuba.oauth2.mapper.ContentCategoryMapper;
import com.konosuba.oauth2.service.ContentCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Resource
    private ContentCategoryMapper contentCategoryMapper;
}
