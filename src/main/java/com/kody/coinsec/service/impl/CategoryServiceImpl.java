package com.kody.coinsec.service.impl;

import com.kody.coinsec.entity.Category;
import com.kody.coinsec.mapper.CategoryMapper;
import com.kody.coinsec.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消费类别表 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
