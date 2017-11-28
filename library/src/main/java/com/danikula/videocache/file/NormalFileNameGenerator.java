package com.danikula.videocache.file;

import com.danikula.videocache.ProxyCacheUtils;

/**
 * Created by jileilei on 2017/11/28.
 */

public class NormalFileNameGenerator implements FileNameGenerator {

    @Override
    public String generate(String url) {
        String resourceFileName = getFileNameByUrl(url);
        String pathFilename = ProxyCacheUtils.computeMD5(url);
        return pathFilename + '/' + resourceFileName;
    }

    private String getFileNameByUrl(String url){
        url = url.substring(0, url.indexOf("?") + 1);
        String resourceName = url.substring(url.lastIndexOf("c"), url.length()+1);
        return resourceName;
    }
}
