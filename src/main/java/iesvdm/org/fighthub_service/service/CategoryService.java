package iesvdm.org.fighthub_service.service;

import iesvdm.org.fighthub_service.exception.EntityNotFoundException;
import iesvdm.org.fighthub_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iesvdm.org.fighthub_service.schema.Category;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Category.class));
    }
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Category updateCategory(Long id, Category category) {
        Category categoryToUpdate = this.getCategory(id);
        categoryToUpdate.setName(category.getName());
        return categoryRepository.save(categoryToUpdate);
    }
    public void deleteCategory(Long id) {
        Category categoryToDelete = this.getCategory(id);
        categoryRepository.delete(categoryToDelete);
    }
}
