package com.slipper.weblog.modules.file.model.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author gumingchen
 */
@Data
public class FileUploadReqVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "文件不能为空")
    private MultipartFile file;
}
