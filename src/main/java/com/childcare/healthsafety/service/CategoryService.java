package com.childcare.healthsafety.service;



import com.childcare.healthsafety.exceptions.InformationExistException;
import com.childcare.healthsafety.exceptions.InformationNotFoundException;
import com.childcare.healthsafety.model.Category;
import com.childcare.healthsafety.model.Activity;
import com.childcare.healthsafety.repository.CategoryRepository;
import com.childcare.healthsafety.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private ActivityRepository activityRepository;

    @Autowired
    public void setActivityRepository(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Category> getAllCategories() {
    }

    public Optional<Category> getCategory(Long categoryId) {

        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category;
        } else {
            throw new InformationNotFoundException("category with Id " + categoryId + " not found");
        }

        public Activity createCategoryactivity(Long categoryId, Activity activityObject) {
            Optional<Category> category = categoryRepository.findById(categoryId);
            activityObject.setCategory(category.get());
            return activityRepository.save(activityObject);
    }
        public List<Activity> getCategoryActivities(Long categoryId) {

            Optional<Category> category = categoryRepository.findById(categoryId);
            if (category.isPresent()) {
                return category.get().getActivityList();
            } else {
                throw new InformationNotFoundException("category with id " + categoryId + " not found");
            }
            
        public Activity getCategoryActivity(Long categoryId, Long activityId) {


                Optional<Category> category = categoryRepository.findById(categoryId);
                if (category.isPresent()) {
                    for (Activity activity : category.get().getActivityList()) {
                        if (activity.getId() == activityId) {
                            return activity;
                        }
                    }
                    throw new InformationNotFoundException("activity with id " + activityId + " not found");
                } else {
                    throw new InformationNotFoundException("category with id " + categoryId + " not found");
                }
            }

            public Activity updateCategoryActivity(Long categoryId, Long activityId, Activity activityObject) {
                //getting the category: potentially the category might not exist; and we also want to ensure we get the activity in the right location
                Optional<Category> category = categoryRepository.findById(categoryId);//possibility of a category. If it does exit, it'll be an object. If not null.
                if (category.isPresent()) {//category has to exist
                    /*
                     * If the category does exist this for loop runs.
                     * this loop iterates over List<Item>
                     * activities = { Activity, Activity, Activity, Activity,  }
                     * items[i]; i = 0, i = 1, i = 2 ...
                     *
                     * This special loop below. Skips over it
                     * so you could imagine it as a shorter for loop
                     * where activity is kind of like what would've been activities.get(i);
                     */
                    for (Activity activity : category.get().getActivityList()) {
                        // {id, number, name, etc...}
                        if (activity.getId() == activityId) {// compare id of activity at current iteration and id given by the client that they want to update
                            // if the id client gave and id of current iteration is same. Do this below.
                            activity.setNumber(activityObject.getNumber());//this stays the same
                            activity.setName(activityObject.getName());//this stays the same
                            return activityRepository.save(activity);
                        }
                    }
                    throw new InformationNotFoundException("activity with id " + activityId + " not found");
                } else {
                    throw new InformationNotFoundException("category with id " + categoryId + " not found");
                }
            }

            public Activity deleteCategoryActivity(Long categoryId, Long activityId) {
                Optional<Category> category = categoryRepository.findById(categoryId);
                if (category.isPresent()) {
                    for (Activity activity : category.get().getActivityList()) {
                        if (activity.getId() == activityId) {
                            activityRepository.deleteById(activityId);
                            return activity;
                        }
                    }
                    throw new InformationNotFoundException("activity with id " + activityId + " not found");
                } else {
                    throw new InformationNotFoundException("category with id " + categoryId + " not found");
                }
            }    


        }
