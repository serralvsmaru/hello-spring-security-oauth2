package com.konosuba.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.konosuba.oauth2.domain.entity.Content;
import com.konosuba.oauth2.mapper.ContentMapper;
import com.konosuba.oauth2.service.ContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Resource
    private ContentMapper contentMapper;

    @Override
    public Content getById(Long id) {
        QueryWrapper<Content> qw = new QueryWrapper<>();
        qw.eq(Content.COL_ID, id);
        return contentMapper.selectOne(qw);
    }

    @Override
    public List<Content> selectAll() {
        QueryWrapper<Content> qw = new QueryWrapper<>();
        return contentMapper.selectList(qw);
    }

    @Override
    public int insert(Content content) {
        return contentMapper.insert(content);
    }

    @Override
    public int update(Content content) {
        return contentMapper.updateById(content);
    }

    @Override
    public int delete(Long id) {
        return contentMapper.deleteById(id);
    }
}
