package utils;//package com.ingo.utils;
//
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.http.MethodType;
//import com.aliyuncs.http.ProtocolType;
//import com.aliyuncs.profile.DefaultProfile;
//import com.aliyuncs.profile.IClientProfile;
//import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
//import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
//import net.sf.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.*;
//import java.net.URL;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * Created by tw on 2017/8/5.
// */
//public class AliyunOssUtil {
//   private static final Logger logger= LoggerFactory.getLogger(AliyunOssUtil.class);
//
//    public static final String REGION_CN_HANGZHOU = "cn-hangzhou";
//    public static final String STS_API_VERSION = "2015-04-01";
//
//    public static final String ALIYUNBUCKTE = "zhuniu-prod";
//
//    public static final String ALIYENDPOINT = "https://img.zhuniupay.com";
//
//    protected static AssumeRoleResponse assumeRole(String accessKeyId, String accessKeySecret, String roleArn, String roleSessionName, String policy, ProtocolType protocolType, long durationSeconds) throws ClientException {
//        try {
//            // 创建一个 Aliyun Acs Client, 用于发起 OpenAPI 请求
//            IClientProfile profile = DefaultProfile.getProfile(REGION_CN_HANGZHOU, accessKeyId, accessKeySecret);
//            DefaultAcsClient client = new DefaultAcsClient(profile);
//
//            // 创建一个 AssumeRoleRequest 并设置请求参数
//            final AssumeRoleRequest request = new AssumeRoleRequest();
//            request.setVersion(STS_API_VERSION);
//            request.setMethod(MethodType.POST);
//            request.setProtocol(protocolType);
//
//            request.setRoleArn(roleArn);
//            request.setRoleSessionName(roleSessionName);
//            request.setPolicy(policy);
//            request.setDurationSeconds(durationSeconds);
//
//            // 发起请求，并得到response
//            final AssumeRoleResponse response = client.getAcsResponse(request);
//            return response;
//        } catch (ClientException e) {
//            logger.info("AssumeRoleResponse - "+e.getMessage());
//            throw e;
//        }
//    }
//
//    public static String ReadJson(String fileName) {
//        ClassLoader classLoader = AliyunOssUtil.class.getClassLoader();
//        URL resource = classLoader.getResource("alioss/"+fileName);
//        String path = resource.getPath();
//        //从给定位置获取文件
//        File file = new File(path);
//        BufferedReader reader = null;
//        //返回值,使用StringBuffer
//        StringBuffer data = new StringBuffer();
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            //每次读取文件的缓存
//            String temp = null;
//            while ((temp = reader.readLine()) != null) {
//                data.append(temp);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            logger.info("ReadJson - "+e.getMessage());
//        } catch (IOException e) {
//            e.printStackTrace();
//            logger.info("ReadJson - "+e.getMessage());
//        } finally {
//            //关闭文件流
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    logger.info("ReadJson - "+e.getMessage());
//                }
//            }
//        }
//        return data.toString();
//    }
//
//    public static JSONObject getAliOSSToken() {
//        logger.info("getAliOSSToken - 开始获取配置");
//        String data = ReadJson("config.json");
//        System.out.println("getAliOSSToken - 用户输入url:" + data);
//        if (data.equals("")) {
//            logger.info("getAliOSSToken - 没有获取到配置");
//            return null;
//        }
//        logger.info("getAliOSSToken - 获取到配置"+data);
//        JSONObject jsonObj = JSONObject.fromObject(data);
//        // 只有 RAM用户（子账号）才能调用 AssumeRole 接口
//        // 阿里云主账号的AccessKeys不能用于发起AssumeRole请求
//        // 请首先在RAM控制台创建一个RAM用户，并为这个用户创建AccessKeys
//        String accessKeyId = jsonObj.getString("AccessKeyID");
//        String accessKeySecret = jsonObj.getString("AccessKeySecret");
//
//        // RoleArn 需要在 RAM 控制台上获取
//        String roleArn = jsonObj.getString("RoleArn");
//        long durationSeconds = jsonObj.getLong("TokenExpireTime");
//        String policy = ReadJson(jsonObj.getString("PolicyFile"));
//        // RoleSessionName 是临时Token的会话名称，自己指定用于标识你的用户，主要用于审计，或者用于区分Token颁发给谁
//        // 但是注意RoleSessionName的长度和规则，不要有空格，只能有'-' '_' 字母和数字等字符
//        // 具体规则请参考API文档中的格式要求
//        String roleSessionName = "alice-001";
//        // 此处必须为 HTTPS
//        ProtocolType protocolType = ProtocolType.HTTPS;
//        try {
//             AssumeRoleResponse stsResponse = assumeRole(accessKeyId, accessKeySecret, roleArn, roleSessionName, policy, protocolType, durationSeconds);
//            Map<String, String> respMap = new LinkedHashMap<String, String>();
//            respMap.put("status", "200");
//            respMap.put("AccessKeyId", stsResponse.getCredentials().getAccessKeyId());
//            respMap.put("AccessKeySecret", stsResponse.getCredentials().getAccessKeySecret());
//            respMap.put("SecurityToken", stsResponse.getCredentials().getSecurityToken());
//            respMap.put("Expiration", stsResponse.getCredentials().getExpiration());
//            respMap.put("bucket_name",ALIYUNBUCKTE);
//            respMap.put("endpoint", ALIYENDPOINT);
//            JSONObject ja1 = JSONObject.fromObject(respMap);
//            logger.info("getAliOSSToken - 获取到阿里OSS的数据"+ja1.toString());
//            return ja1;
//        } catch (ClientException e) {
//            Map<String, String> respMap = new LinkedHashMap<String, String>();
//            respMap.put("status", e.getErrCode());
//            respMap.put("AccessKeyId", "");
//            respMap.put("AccessKeySecret", "");
//            respMap.put("SecurityToken", "");
//            respMap.put("Expiration", "");
//            respMap.put("bucket_name", ALIYUNBUCKTE);
//            respMap.put("endpoint", ALIYENDPOINT);
//            JSONObject ja1 = JSONObject.fromObject(respMap);
//            logger.info("getAliOSSToken - 获取到阿里OSS的数据"+ja1.toString());
//            return ja1;
//        }
//    }
//
//}
