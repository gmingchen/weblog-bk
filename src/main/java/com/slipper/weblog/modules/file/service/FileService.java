package com.slipper.weblog.modules.file.service;

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
