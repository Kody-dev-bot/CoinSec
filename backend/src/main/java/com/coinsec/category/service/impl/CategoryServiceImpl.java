package com.coinsec.category.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinsec.category.entity.Category;
import com.coinsec.category.mapper.CategoryMapper;
import com.coinsec.category.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 记账分类表 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
