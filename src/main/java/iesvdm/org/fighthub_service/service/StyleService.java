package iesvdm.org.fighthub_service.service;

import iesvdm.org.fighthub_service.exception.EntityNotFoundException;
import iesvdm.org.fighthub_service.repository.StyleRepository;
import iesvdm.org.fighthub_service.schema.Style;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleService {
    @Autowired
    private StyleRepository styleRepository;

    public List<Style> getStyles() {
        return styleRepository.findAll();
    }
    public Style getStyle(Long id) {
        return styleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Style.class));
    }
    public Style saveStyle(Style style) {
        return styleRepository.save(style);
    }
    public Style updateStyle(Long id, Style style) {
        Style styleToUpdate = this.getStyle(id);
        BeanUtils.copyProperties(style, styleToUpdate, "id");
        return styleRepository.save(styleToUpdate);
    }
    public void deleteStyle(Long id) {
        Style styleToDelete = this.getStyle(id);
        styleRepository.delete(styleToDelete);
    }
}
