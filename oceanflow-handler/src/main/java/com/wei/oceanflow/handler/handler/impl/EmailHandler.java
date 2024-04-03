package com.wei.oceanflow.handler.handler.impl;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;
import com.wei.oceanflow.common.domain.TaskInfo;
import com.wei.oceanflow.common.dto.model.ContentModel;
import com.wei.oceanflow.common.dto.model.EmailContentModel;
import com.wei.oceanflow.common.enums.ChannelType;
import com.wei.oceanflow.handler.handler.BaseHandler;
import com.wei.oceanflow.handler.handler.Handler;
import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 邮件消息处理器
 * @Author: Wei
 */
@Component
@Slf4j
public class EmailHandler extends BaseHandler implements Handler {

    public EmailHandler(){
        channelCode = ChannelType.EMAIL.getCode();
    }

    @Override
    public boolean handler(TaskInfo taskInfo) {
        EmailContentModel emailContentModel = (EmailContentModel) taskInfo.getContentModel();
        MailAccount mailAccount = getAccountConfig(taskInfo.getSendAccount());
        try {
            MailUtil.send(mailAccount, taskInfo.getReceiver(), emailContentModel.getTitle(), emailContentModel.getContent(), true);
        } catch (Exception e) {
            log.error("EmailHandler#handler fail!{},params:{}", Throwables.getStackTraceAsString(e), taskInfo);
            return false;
        }
        return true;
    }

    /**
     * 获取账号信息和配置
     *
     * @return
     */
    private MailAccount getAccountConfig(Integer sendAccount) {
        //MailAccount account = accountUtils.getAccountById(sendAccount, MailAccount.class);

        /**
         * 修改 user/from/pass
         */
        String defaultConfig = "{\"host\":\"smtp.163.com\",\"port\":465,\"user\":\"18706019630@163.com\",\"pass\":\"AAAGPZNQYNECDENG\",\"from\":\"18706019630@163.com\",\"starttlsEnable\":\"false\",\"auth\":true,\"sslEnable\":true}";
        MailAccount account = JSON.parseObject(defaultConfig, MailAccount.class);
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            account.setAuth(account.isAuth()).setStarttlsEnable(account.isStarttlsEnable()).setSslEnable(account.isSslEnable()).setCustomProperty("mail.smtp.ssl.socketFactory", sf);
            account.setTimeout(25000).setConnectionTimeout(25000);
        } catch (Exception e) {
            log.error("EmailHandler#getAccount fail!{}", Throwables.getStackTraceAsString(e));
        }
        return account;
    }
}
