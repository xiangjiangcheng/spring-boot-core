package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author YuanSongMing
 */
public class ObjectUtils {
    private final static Logger logger = LoggerFactory.getLogger(ObjectUtils.class);

    /**
     * change objects to map.
     *
     * @param objects
     * @return
     */
    public static HashMap<String, String> objects2Map(Object... objects) {
        return objects2Map(Arrays.asList(objects));
    }

    /**
     * change objects to map
     *
     * @param objects
     * @return
     */
    public static HashMap<String, String> objects2Map(List<Object> objects) {
        HashMap<String, String> paramas = new HashMap<String, String>();
        try {
            for (Iterator<Object> iterator = objects.iterator(); iterator.hasNext(); ) {
                Object object = iterator.next();
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldValue = field.get(object) == null ? null : String.valueOf(field.get(object));
                    String fieldName = field.getName();
                    if (!StringUtils.isEmpty(fieldValue)) {
                        paramas.put(fieldName, fieldValue);
                    }
                }
            }
        } catch (Exception e) {
            logger.equals(e.getMessage());
        }
        return paramas;
    }

    /**
     * change object to map
     *
     * @param object
     * @return
     */
    public static HashMap<String, String> object2Map(Object object) {
        HashMap<String, String> paramas = new HashMap<String, String>();
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                String fieldValue = field.get(object) == null ? null : String.valueOf(field.get(object));
                if (!StringUtils.isEmpty(fieldValue)) {
                    paramas.put(fieldName, fieldValue);
                }
            }
        } catch (Exception e) {
            logger.equals(e.getMessage());
        }
        return paramas;
    }

    /**
     * change objects fileds to string
     *
     * @param connection
     * @param split
     * @param objects
     * @return
     */
    public static String objectFieldToString(String connection, String split, List<Object> objects) {
        StringBuffer sb = new StringBuffer();
        try {

            HashMap<String, String> fieldValueMap = objects2Map(objects);
            Set<String> keySet = fieldValueMap.keySet();
            for (String key : keySet) {
                sb.append(split + key + "=" + fieldValueMap.get(key));
            }
        } catch (Exception e) {
            logger.equals(e.getMessage());
        }
        if (sb.length() > 1) {
            return connection + sb.substring(split.length());
        }
        return "";

    }

    /**
     * change objects fileds to string
     *
     * @param connection
     * @param split
     * @param objects
     * @return
     */
    public static String objectFieldToString(String connection, String split, Object... objects) {
        return objectFieldToString(connection, split, Arrays.asList(objects));
    }

    /**
     * build objects to query parameters
     *
     * @param objects
     * @return "?a=b&c=d" or ""
     */
    public static String buildQueryParameter(Object... objects) {
        return objectFieldToString("?", "&", Arrays.asList(objects));
    }

    /**
     * build objects to query parameters
     *
     * @param objects
     * @return "&a=b&c=d" or ""
     */
    public static String buildPathParameters(Object... objects) {
        return objectFieldToString("&", "&", Arrays.asList(objects));
    }
}
