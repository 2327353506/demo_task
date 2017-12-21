package demo.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangmt
 * @date 2017/11/20
 */
public class YmlUtil {


    public static Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

    /**
     * 读取Yml文件
     * @param file 文件
     * @return
     */
    public static Object readYml(File file){
        try {
            Yaml yaml = new Yaml();
            Object obj =yaml.load(new FileInputStream(file));
            return obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 读取Yml文件
     * @param in 文件
     * @return
     */
    public static Object readYml(InputStream in){
        Yaml yaml = new Yaml();
        Object obj =yaml.load(in);
        return obj;
    }

    /**
     * 加入配置缓存
     * @param key
     * @param o
     */
    public static void addCache(String key ,Object o){
        cache.put(key,o);
    }

    public static void main(String[] args) throws IOException {
        ClassPathResource path = new ClassPathResource("yml");
        File[] files = path.getFile().listFiles();
        for (File file: files) {
            if(file.getName().indexOf("yml")>0){
                Object o = YmlUtil.readYml(file);
                YmlUtil.addCache(file.getName().replace(".yml",""),o);
            }
        }
        System.out.println(JSONObject.toJSONString(cache));
    }
}
