package com.danikula.videocache.bean;

/**
 * Created by jileilei on 2017/11/29.
 */

public class WebResource {

    private static final int MAX_EXTENSION_LENGTH = 4;

    private String url;
    private String hostName;
    private String pathName;
    private String fileName;
    private String extension;
    private String schema;

    private WebResource(String url){
        this.url = url;
    }

    public static WebResource analysis(String url){
        WebResource resource = new WebResource(url);
        resource.setHostName(resource.getHostNameByUrl());
        resource.setFileName(resource.getFileNameByUrl());
        resource.setPathName(resource.getPathNameByUrl());
        resource.setExtension(resource.getExtensionByUrl());
        resource.setSchema(resource.getSchemaByUrl());
        return resource;
    }

    public String getHostName() {
        return hostName;
    }

    public String getPathName() {
        return pathName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getUrl() {
        return url;
    }

    public String getExtension() {
        return extension;
    }

    public String getSchema() {
        return schema;
    }

    private void setHostName(String hostName) {
        this.hostName = hostName;
    }

    private void setPathName(String pathName) {
        this.pathName = pathName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private void setExtension(String extension) {
        this.extension = extension;
    }

    private void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     * 通过url提取schema信息
     * 读取不到schema时默认为http://
     * @return
     */
    private String getSchemaByUrl(){
        if(url.indexOf("://") != -1) {
            String schema = url.substring(0, url.indexOf("://") + 3);
            return schema;
        }
        return "http://";
    }

    /**
     * 通过url提取host信息
     * @return
     */
    private String getHostNameByUrl(){
        String tmpUrl = url.substring(url.indexOf("//") + 2, url.length());
        String host = tmpUrl.substring(0, tmpUrl.indexOf("/"));
        return host;
    }

    /**
     * 通过url提取文件名称
     * @return
     */
    private String getFileNameByUrl(){
        int index = url.indexOf("?");
        String tmpUrl = index == -1 ? url : url.substring(0, index++);
        String resourceName = tmpUrl.substring(tmpUrl.lastIndexOf("/") + 1, tmpUrl.lastIndexOf('.'));
        return resourceName;
    }

    /**
     * 通过url提取path信息
     * @return
     */
    private String getPathNameByUrl(){
        return url.substring(url.indexOf(hostName) + hostName.length(), url.indexOf(fileName) -1);
    }

    /**
     * 通过url提取文件扩展名
     * @return
     */
    private String getExtensionByUrl() {
        int dotIndex = url.lastIndexOf('.');
        int slashIndex = url.lastIndexOf('/');
        return dotIndex != -1 && dotIndex > slashIndex && dotIndex + 2 + MAX_EXTENSION_LENGTH > url.length() ?
                url.substring(dotIndex + 1, url.length()) : "";
    }
}
