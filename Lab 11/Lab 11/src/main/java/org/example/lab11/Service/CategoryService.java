package org.example.lab11.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab11.API.ApiException;
import org.example.lab11.Model.Category;
import org.example.lab11.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id, Category category){

        Category category1=categoryRepository.findCategoriesByCategoryId(id);
        if (category1==null){
            throw new ApiException("ID not found");
        }
       category1.setName(category.getName());
        categoryRepository.save(category1);
    }

    public void deleteCategory(Integer id){
        Category category=categoryRepository.findCategoriesByCategoryId(id);

        if (category==null){
            throw new ApiException("ID cannot found");
        }
        categoryRepository.delete(category);
    }
}
