package com.slipper.weblog.modules.file.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.file.model.vo.FileUploadReqVO;
import com.slipper.weblog.modules.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gumingchen
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public Result<String> upload(@Validated FileUploadReqVO reqVO) {
        return Result.success(
                fileService.create(reqVO.getFile())
        );
    }
}
