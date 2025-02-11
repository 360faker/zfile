package im.zhaojun.zfile.home.service.impl;

import cn.hutool.core.util.ObjectUtil;
import im.zhaojun.zfile.home.model.enums.StorageTypeEnum;
import im.zhaojun.zfile.admin.model.param.SharePointChinaParam;
import im.zhaojun.zfile.home.service.base.AbstractSharePointServiceBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author zhaojun
 */
@Service
@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SharePointChinaServiceImpl extends AbstractSharePointServiceBase<SharePointChinaParam> {

    @Value("${zfile.onedrive-china.clientId}")
    private String clientId;

    @Value("${zfile.onedrive-china.redirectUri}")
    private String redirectUri;

    @Value("${zfile.onedrive-china.clientSecret}")
    private String clientSecret;

    @Value("${zfile.onedrive-china.scope}")
    private String scope;

    @Override
    public StorageTypeEnum getStorageTypeEnum() {
        return StorageTypeEnum.SHAREPOINT_DRIVE_CHINA;
    }

    @Override
    public String getGraphEndPoint() {
        return "microsoftgraph.chinacloudapi.cn";
    }

    @Override
    public String getAuthenticateEndPoint() {
        return "login.partner.microsoftonline.cn";
    }
    
    @Override
    public String getClientId() {
        return ObjectUtil.defaultIfNull(param.getClientId(), clientId);
    }
    
    @Override
    public String getRedirectUri() {
        return ObjectUtil.defaultIfNull(param.getRedirectUri(), redirectUri);
    }
    
    @Override
    public String getClientSecret() {
        return ObjectUtil.defaultIfNull(param.getClientSecret(), clientSecret);
    }

    @Override
    public String getScope() {
        return scope;
    }

}