package me.alsesn.alsostore.controller;

import lombok.RequiredArgsConstructor;
import me.alsesn.alsostore.entity.Category;
import me.alsesn.alsostore.repository.CategoryRepository;
import me.alsesn.alsostore.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}