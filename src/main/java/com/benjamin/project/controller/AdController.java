package com.benjamin.project.controller;

import com.benjamin.project.model.Ad;
import com.benjamin.project.service.AdService;
import com.le.bigdata.core.dto.CommonResponseDTO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by benjamin on 2017/3/9.
 */
@RestController
@RequestMapping("ad")
public class AdController {

    @Autowired
    private AdService adService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public CommonResponseDTO getAllByPage(@RequestParam int page,
                                          @RequestParam int size){
        RowBounds rowBounds = new RowBounds(page, size);
        List<Ad> list = adService.selectAllPage(rowBounds);
        return new CommonResponseDTO(true, list);
    }
}
