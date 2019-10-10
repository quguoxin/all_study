package com.qgx.www.action;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class FileAction extends BaseAction {
    private File myfile;//上传的文件
    //文件类型：文件对象名+ContentType
    private String myfileContentType;
    //文件名：文件对象名+FileName
    private String myfileFileName;
    private String file_desc;//文件描述
    //上传
    public String upload(){
        System.out.println(myfile);
        System.out.println(myfileContentType);
        System.out.println(myfileFileName);
        String destFilePath="c:\\1\\"+myfileFileName;//目标文件地址
        File destFile =new File(destFilePath);//目标文件
        try {
            FileUtils.copyFile(myfile,destFile);//struts2提供的文件复制工具方法
            session.put("filename",myfileFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    //下载
    private String filename2;//需要下载的文件名称
    private InputStream is;
    public InputStream getIs() {
        //读取本地文件至内存
        File file=new File("c:\\1\\"+filename2);
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
    public String download(){
        //读取本地文件至内存中
        //将内存中的文件输出到对方电脑
        return "down";
    }

////////////////////////////get or set////////////////////////////////////////////////

    public void setIs(InputStream is) {
        this.is = is;
    }

    public String getFilename2() {
        return filename2;
    }

    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    public File getMyfile() {
        return myfile;
    }

    public void setMyfile(File myfile) {
        this.myfile = myfile;
    }

    public String getMyfileContentType() {
        return myfileContentType;
    }

    public void setMyfileContentType(String myfileContentType) {
        this.myfileContentType = myfileContentType;
    }

    public String getMyfileFileName() {
        return myfileFileName;
    }

    public void setMyfileFileName(String myfileFileName) {
        this.myfileFileName = myfileFileName;
    }

    public String getFile_desc() {
        return file_desc;
    }

    public void setFile_desc(String file_desc) {
        this.file_desc = file_desc;
    }
}
