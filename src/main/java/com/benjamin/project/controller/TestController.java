package com.benjamin.project.controller;

import com.benjamin.project.model.Ad;
import com.benjamin.project.model.IndexAd;
import com.benjamin.project.service.IADService;
import com.benjamin.project.service.IIndexAdService;
import net.shmin.common.util.PageUtil;
import net.shmin.core.dto.CommonPageDTO;
import net.shmin.core.dto.CommonResponseDTO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by benjamin on 2017/3/9.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private IADService adService;

    @Autowired
    private IIndexAdService indexAdService;

    /**
     * 通用service方法测试
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public CommonResponseDTO getAllByPage(@RequestParam int page,
                                          @RequestParam int size){
//        RowBounds rowBounds = new RowBounds(page, size);
        List<Ad> list = adService.selectAllPage(page, size);
        CommonPageDTO commonPageDTO = PageUtil.convertList2Page(list, page, size);
        return CommonResponseDTO.success(commonPageDTO);
    }

    /**
     * 通用service方法测试
     * @param id
     * @return
     */
    @RequestMapping(value = "ad/{id}", method = RequestMethod.GET)
    public CommonResponseDTO getAllByPage(@PathVariable Integer id){
        Ad ad = adService.selectById(id);
        return CommonResponseDTO.success(ad);
    }

    /**
     * 通用service方法测试
     * @param ad
     * @return
     */
    @RequestMapping(value = "ad", method = RequestMethod.POST)
    public CommonResponseDTO update(@RequestBody Ad ad){
        boolean result = adService.update(ad);
        return CommonResponseDTO.status(result);
    }

    /**
     * 通用service方法测试
     * @param ad
     * @return
     */
    @RequestMapping(value = "ad", method = RequestMethod.PUT)
    public CommonResponseDTO insert(@RequestBody Ad ad){
        boolean result = adService.insert(ad);
        return CommonResponseDTO.status(result);
    }

    /**
     * 通用service方法测试
     * @param id
     * @return
     */
    @RequestMapping(value = "ad/{id}", method = RequestMethod.DELETE)
    public CommonResponseDTO delete(@PathVariable Integer id){
        boolean result = adService.deleteByPrimaryKey(id);
        return CommonResponseDTO.status(result);
    }

    /**
     * 1.通用service方法测试
     * 2.数据源动态切换测试
     * @return
     */
    @RequestMapping(value = "index_ad", method = RequestMethod.GET)
    public CommonResponseDTO getAll(){
        List<IndexAd> list = indexAdService.selectAll();
        return CommonResponseDTO.success(list);
    }
}
