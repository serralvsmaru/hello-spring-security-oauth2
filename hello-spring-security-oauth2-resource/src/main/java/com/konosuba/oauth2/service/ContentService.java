package com.konosuba.oauth2.service;

import com.konosuba.oauth2.domain.entity.Content;

import java.util.List;

public interface ContentService {

    /**
     * 根据 ID 获取
     *
     * @param id ID
     * @return {@link Content}
     */
    default Content getById(Long id) {
        return null;
    }

    /**
     * 获取全部数据
     *
     * @return {@link List<Content>}
     */
    default List<Content> selectAll() {
        return null;
    }

    /**
     * 新增
     *
     * @param Content {@link Content}
     * @return int 数据库受影响行数
     */
    default int insert(Content tbContent) {
        return 0;
    }

    /**
     * 编辑
     *
     * @param Content {@link Content}
     * @return int 数据库受影响行数
     */
    default int update(Content tbContent) {
        return 0;
    }

    /**
     * 删除
     *
     * @param id ID
     * @return int 数据库受影响行数
     */
    default int delete(Long id) {
        return 0;
    }


}
