package me.alsesn.alsostore.service;

import lombok.RequiredArgsConstructor;
import me.alsesn.alsostore.entity.Category;
import me.alsesn.alsostore.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}