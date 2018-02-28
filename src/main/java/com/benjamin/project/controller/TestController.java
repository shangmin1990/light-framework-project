package com.benjamin.project.controller;

import com.benjamin.project.model.Ad;
import com.benjamin.project.model.IndexAd;
import com.benjamin.project.model.TestModel;
import com.benjamin.project.service.IADService;
import com.benjamin.project.service.IIndexAdService;
import com.fengjr.sauron.agent.bootstrap.Agent;
import com.fengjr.sauron.agent.bootstrap.ClassFileTransformerImpl;
import net.shmin.common.util.PageUtil;
import net.shmin.core.dto.CommonPageDTO;
import net.shmin.core.dto.CommonResponseDTO;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by benjamin on 2017/3/9.
 */
@RestController
@RequestMapping("test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    private ExecutorService executorService = Executors.newCachedThreadPool();

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
    public CommonResponseDTO getAllByPage(@RequestParam final int page,
                                          @RequestParam final int size) throws InterruptedException {
//        RowBounds rowBounds = new RowBounds(page, size);
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println("System ClassLoader: "+ loader);
        ClassLoader loader1 = TestController.class.getClassLoader();
        System.out.println("TestController classLoader: "+ loader1);
        ClassLoader classLoader3 = Agent.class.getClassLoader();
        System.out.println("TestController classLoader: "+classLoader3);
        ClassLoader classLoader4 = ClassFileTransformerImpl.class.getClassLoader();
        System.out.println("ClassFileTransformerImpl classLoader: "+ classLoader4);
        long begin = System.nanoTime();
        List<Ad> list = adService.selectAllPage(page, size);
        CommonPageDTO commonPageDTO = PageUtil.convertList2Page(list, page, size);
        Thread.sleep(1000);
        long end = System.nanoTime();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                adService.selectAllPage(page, size);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        executorService.execute(runnable);
        logger.info("此方法耗费:{}ms", TimeUnit.MILLISECONDS.convert(end - begin, TimeUnit.NANOSECONDS));
        return CommonResponseDTO.success(commonPageDTO);
    }

    @RequestMapping(value = "noAuth/ad", method = RequestMethod.GET)
    public CommonResponseDTO getAllByPageNoAuth(@RequestParam int page,
                                                @RequestParam int size) throws InterruptedException {
        return getAllByPage(page, size);
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

    @RequestMapping(value = "noAuth/ad/{id}", method = RequestMethod.GET)
    public CommonResponseDTO getAllByPage1(@PathVariable Integer id){
        return getAllByPage(id);
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

    @RequestMapping(value = "noAuth/testArray", method = RequestMethod.POST)
    public CommonResponseDTO update1(@RequestBody List<TestModel> ad){
        for (TestModel testModel: ad){
            System.out.println(testModel);
        }
        return CommonResponseDTO.status(true);
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

    @RequestMapping(value = "noAuth/test", method = RequestMethod.GET)
    public CommonResponseDTO test(String a){
//        java.lang.ClassLoader classLoader2  = ClassLoader.getSystemClassLoader();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
//        System.out.println(classPool.toString());
        return CommonResponseDTO.success(a + "123");
    }

    public static void main(String[] args) {
        byte[] bytes = {49, 53, 49, 51, 57, 52, 48, 49, 49, 56, 54, 53, 54, 94, 50, 108, 106, 101, 53, 111, 108, 54, 107, 52, 55, 98, 54};
        String a = new java.lang.String(bytes);
        System.out.println(a);
//        new TestController().test();
    }
}
