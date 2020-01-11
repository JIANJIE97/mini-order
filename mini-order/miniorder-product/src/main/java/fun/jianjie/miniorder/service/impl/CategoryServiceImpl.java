package fun.jianjie.miniorder.service.impl;

import fun.jianjie.miniorder.config.WxProperties;
import fun.jianjie.miniorder.dao.CategoryDao;
import fun.jianjie.miniorder.service.CategoryService;
import fun.jianjie.miniorder.vo.CategoryVo;
import fun.jianjie.miniorder.vo.ImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@EnableConfigurationProperties(WxProperties.class)
public class CategoryServiceImpl implements CategoryService {
    //private static final String IMG_URL_PREFIX = "http://localhost:8888/img";

    @Resource
    private CategoryDao categoryDao;

    @Autowired
    private WxProperties wxProperties;

    /**
     * 查询所有分类的信息包含图片链接http://localhost:8888/img/category/rice.png
      * @return
     */
    @Override
    public List<CategoryVo> findAll() {
        List<CategoryVo> categoryVos= categoryDao.findAll();
        for (CategoryVo categoryVo : categoryVos) {
            ImageVo imageVo = categoryVo.getImg();
            StringBuilder stringBuilder = new StringBuilder();
            String URL = stringBuilder.append(wxProperties.getImg_url_prefix()).append(imageVo.getUrl()).toString();
            imageVo.setUrl(URL);
        }
        return categoryVos;
    }
}
