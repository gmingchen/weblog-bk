package com.slipper.weblog.modules.file.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.slipper.weblog.common.enums.ResultCodeEnum;
import com.slipper.weblog.common.enums.SettingEnum;
import com.slipper.weblog.exception.RunException;
import com.slipper.weblog.modules.setting.config.FileConfig;
import com.slipper.weblog.modules.file.service.FileService;
import com.slipper.weblog.modules.setting.model.dto.FileLocalSetting;
import com.slipper.weblog.modules.setting.service.SettingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author gumingchen
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

    @Autowired
    private SettingService settingService;

    @Override
    public String create(MultipartFile file) {
        String name = file.getOriginalFilename();
        String extension = name.substring(name.lastIndexOf("."));
        String filename = UUID.randomUUID() + extension;

        FileLocalSetting fileLocalSetting = settingService.queryFileLocal();

        String path = fileLocalSetting.getPath() + File.separator + filename;
        try {
            FileUtil.writeBytes(IoUtil.readBytes(file.getInputStream()), path);
        } catch (IOException e) {
            throw new RunException(ResultCodeEnum.FILE_SAVE_ERROR);
        }

        return fileLocalSetting.getDomain() + fileLocalSetting.getUrl() + "/" + filename;
    }
}
