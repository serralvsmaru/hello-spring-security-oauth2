package com.konosuba.oauth2.controller;

import com.konosuba.oauth2.common.ResponseResult;
import com.konosuba.oauth2.domain.entity.Content;
import com.konosuba.oauth2.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ContentController {
    @Resource
    private ContentService contentService;

    /**
     * 获取全部资源
     *
     * @return 返回的结果集
     */
    @GetMapping("/")
    public ResponseResult<List<Content>> selectAll(){
        return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), contentService.selectAll());
    }

    /**
     * 获取资源详情
     * @param id 资源主键ID
     * @return 返回的结果集
     */
    @GetMapping("/view/{id}")
    public ResponseResult<Content> getById(@PathVariable Long id){
        return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), contentService.getById(id));
    }

    /**
     * 新增资源
     * @param content 新增对象
     * @return 结果集
     */
    @PostMapping("/insert")
    public ResponseResult<Integer> insert(@RequestBody Content content){
        int count = contentService.insert(content);

        if (count > 0){
            return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), count);
        }else {
            return new ResponseResult<>(Integer.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.toString());
        }
    }

    /**
     * 更新资源
     * @param content 传入的对象
     * @return 结果集
     */
    @PutMapping("/update")
    public ResponseResult<Integer> update(@RequestBody Content content) {
        int count = contentService.update(content);

        if (count > 0) {
            return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), count);
        } else {
            return new ResponseResult<>(Integer.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.toString());
        }
    }

    /**
     * 删除资源
     * @param id id
     * @return 结果集
     */
    @DeleteMapping("/delete/{id}")
    public ResponseResult<Integer> delete(@PathVariable Long id) {
        int count = contentService.delete(id);

        if (count > 0) {
            return new ResponseResult<>(Integer.valueOf(HttpStatus.OK.value()), HttpStatus.OK.toString(), count);
        } else {
            return new ResponseResult<>(Integer.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.toString());
        }
    }
}
