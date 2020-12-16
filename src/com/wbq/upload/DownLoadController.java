package com.wbq.upload;

import com.wbq.upload.fileUtils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author Administrator
 */
@WebServlet(name = "DownLoadController", value = "/downLoad")
public class DownLoadController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String realPath = request.getServletContext().getRealPath("WEB-INF/upload");
        String fileName = request.getParameter("filename");
        String name = fileName.substring(fileName.indexOf("_") + 1);
        String newFilePath = FileUtils.newFilePath(realPath, name);
        String filePath = newFilePath + "\\" + fileName;
        //设置下载响应头
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(name, "UTF-8"));
        FileInputStream inputStream = new FileInputStream(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buf = new byte[1024 * 1024 * 100];
        int len = 0;
        if ((len = inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
        }
        outputStream.close();
        inputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
