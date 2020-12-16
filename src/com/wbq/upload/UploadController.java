package com.wbq.upload;

import com.wbq.upload.fileUtils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 100, maxRequestSize = 1024 * 1024 * 200)
@WebServlet(name = "UploadController", value = "/uploadFile")
public class UploadController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String realPath = request.getServletContext().getRealPath("WEB-INF/upload");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Map<String, String> fileMap = new HashMap<>();
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            String fileName = part.getSubmittedFileName();
            if (fileName.trim().equals("")) {
                continue;
            }
            String newFileName = FileUtils.getNewFileName(fileName);
            String filePath = FileUtils.newFilePath(realPath, newFileName);
            part.write(filePath + "\\" + newFileName);
            fileMap.put(newFileName, fileName);
            response.getWriter().println(fileName + "上传成功！");
        }
        request.setAttribute("mapList", fileMap);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
