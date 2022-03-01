package com.childcare.healthsafety.controller;

import com.childcare.healthsafety.model.Category;
import com.childcare.healthsafety.model.Activity;
import com.childcare.healthsafety.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")// means http://localhost:9092/api/categories/
public class CategoryController {

//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    public void setCategoryRepository(CategoryRepository categoryRepository){
//        this.categoryRepository = categoryRepository;
//    }

    // request ->controller -> service -> repository
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;

    }

    @GetMapping(path = "/hello-world/")
    public String getHelloWorld() {
        return "hello world";
    }

    @GetMapping(path = "/categories/")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();

    }

    @PostMapping("/categories/")
    public Category createCategory(@RequestBody Category categoryObject) {
//        System.out.println("calling createCategory");
        //    return "creating a category " + body;

        return categoryService.createCategory(categoryObject);

    }


    @GetMapping("/categories/{categoryId}/")
    public Optional<Category> getCategory(@PathVariable(value = "categoryId") Long categoryId){
//        Optional<Category> category = categoryRepository.findById(categoryId);
//        if(category.isPresent()){
//            return category;
//       }else{
//        throw new InformationNotFoundException("category with Id " + categoryId + " not found");
//       }
        return categoryService.getCategory(categoryId);

    }
    //
//
    @PutMapping("/categories/{categoryId}/")
    public String updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody String body){

        return "updating the category with ID of " + categoryId + body;
//        Optional<Category> category = categoryRepository.findById(categoryId);
//        if(category.isPresent()){
//            Category updateCategory = categoryRepository.findById(categoryId).get();
//            updateCategory.setName(categoryObject.getName());
//            updateCategory.setDescription(categoryObject.getDescription());
//            return categoryRepository.save(updateCategory);
//        }else {
//            throw new InformationNotFoundException("category with Id " + categoryId + " not found");
//
//        }
//        return categoryService.updateCategory(categoryId, categoryObject);
    }
//    @DeleteMapping("/categories/{categoryId}")
//    public String deleteCategory(@PathVariable(value = "categoryId") Long categoryId) {
//        System.out.println("calling deleteCategory ==>");
//        return categoryService.deleteCategory(categoryId);
//    }

    @PostMapping("/categories/{categoryId}/activities/")
    public Activity createCategoryActivity(@PathVariable(value="categoryId") Long categoryId, @RequestBody Activity activityObject){
        return categoryService.createCategoryActivity(categoryId, activityObject);
    }

    @GetMapping("/categories/{categoryId}/activities/")
    public List<Activity> getCategoryActivities(@PathVariable(value="categoryId") Long categoryId){
        return categoryService.getCategoryActivities(categoryId);
    }

    @GetMapping("/categories/{categoryId}/activities/{activityId}/")
    public String getCategoryActivity(@PathVariable(value="categoryId") Long categoryId, @PathVariable(value = "activityId") Long activityId){
        return categoryService.getCategoryActivity(categoryId, activityId);
    }

    @PutMapping("/categories/{categoryId}/activities/{activityId}/")
    public String updateCategoryActivity(
            @PathVariable(value = "categoryId") Long categoryId,
            @PathVariable(value = "activityId") Long activityId,
            @RequestBody Activity activityObject){
        return categoryService.updateCategoryActivity(categoryId, activityId, activityObject);
    }

    @DeleteMapping("/categories/{categoryId}/activities/{activityId}/")
    public String deleteCategoryActivity(
            @PathVariable(value = "categoryId") Long categoryId,
            @PathVariable(value = "activityId") Long activityId){
        return categoryService.deleteCategoryActivity(categoryId, activityId);
    }

}

