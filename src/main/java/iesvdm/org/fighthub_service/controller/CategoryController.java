package iesvdm.org.fighthub_service.controller;

import iesvdm.org.fighthub_service.schema.Category;
import iesvdm.org.fighthub_service.service.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/v1/fighthub-service/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"", "/"})
    public List<Category> getCategories() {
        log.info("CategoryController: getCategories");
        return categoryService.getCategories();
    }
    @GetMapping(value = {"/{id}"})
    public Category getCategory(@PathVariable Long id) {
        log.info("CategoryController: getCategory - id: " + id);
        return categoryService.getCategory(id);
    }
    @PostMapping(value = {"", "/"})
    public Category saveCategory(@Valid @RequestBody Category category) {
        log.info("CategoryController: saveCategory - id: " + category.getId());
        return categoryService.saveCategory(category);
    }
    @PutMapping(value = {"/{id}"})
    public Category updateCategory(@PathVariable Long id, @Valid @RequestBody Category category) {
        log.info("CategoryController: updateCategory - id: " + id);
        return categoryService.updateCategory(id, category);
    }
    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteCategory(@PathVariable Long id) {
        log.info("CategoryController: deleteCategory - id: " + id);
        categoryService.deleteCategory(id);
    }
}
