package com.slipper.weblog.modules.file.service;

import com.slipper.weblog.modules.setting.model.dto.EmailSetting;
import com.slipper.weblog.modules.setting.model.dto.FileLocalSetting;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author gumingchen
 */
public interface FileService {

    /**
     * 创建文件
     * @param file 文件
     * @return
     */
    String create(MultipartFile file);
}
