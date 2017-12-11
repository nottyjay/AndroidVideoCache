package com.danikula.videocache.file;

import android.text.TextUtils;

import com.danikula.videocache.ProxyCacheUtils;
import com.danikula.videocache.bean.WebResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jileilei on 2017/11/28.
 */

public class NormalFileNameGenerator implements FileNameGenerator {

    private static final Logger LOG = LoggerFactory.getLogger("NormalFileNameGenerator");

    @Override
    public String generate(String url) {
        if(LOG.isDebugEnabled()){
            LOG.debug("Resource url is: {}", url);
        }
        WebResource resource = WebResource.analysis(url);
        String host = resource.getHostName();
        String pathFilename = resource.getPathName();
        String resourceFileName = resource.getFileName();
        String file = ProxyCacheUtils.computeMD5(host) + pathFilename + '/' + resourceFileName;
        return TextUtils.isEmpty(resource.getExtension()) ? file : file + '.' + resource.getExtension();
    }

}
