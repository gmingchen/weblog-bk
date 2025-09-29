package com.slipper.weblog.modules.emoji.controller;

import com.slipper.weblog.common.pojo.Result;
import com.slipper.weblog.modules.emoji.model.EmojiDTO;
import com.slipper.weblog.modules.emoji.service.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emoji")
public class EmojiController {

    @Autowired
    private EmojiService emojiService;

    @GetMapping("/pass/list")
    public Result<List<EmojiDTO>> getList() {
        return Result.success(
                emojiService.queryList()
        );
    }
}
