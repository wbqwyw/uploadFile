package com.wbq.upload.fileUtils;

import java.io.File;
import java.util.UUID;

/**
 * @ClassName FileUtils
 * @Description 文件工具类
 * @Author Administrator
 * @Date 2020/12/16 16:05
 * @Version 1.0
 */
public class FileUtils {

    public static String getNewFileName(String fileName) {
        return UUID.randomUUID() + "_" + fileName;
    }

    public static String newFilePath(String realPath, String fileName) {
        int fileHash = fileName.hashCode();
        //二级目录
        int twoFileHash = fileHash & 15;
        //三级目录
        int threeFileHash = (twoFileHash >> 4) & 15;
        String newPath = realPath + "\\" + twoFileHash + "\\" + threeFileHash;
        File file = new File(newPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return newPath;
    }

}
