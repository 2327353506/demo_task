package demo.util;

/**
 * 驼峰法-下划线转驼峰
 * @author wangmt
 * @date 2017/11/22
 */
public class Underline2Camel {

    public static String toCamel(String str){
        if(str == null || "".equals(str.trim())){
            return "";
        }
        if (str.indexOf("_") >= 0){
            String[] arr = str.split("_");
            StringBuilder builder = new StringBuilder(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                builder.append(Character.toUpperCase(arr[i].charAt(0)));
                if(arr[i].length()>1){
                    builder.append(arr[i].substring(1).toLowerCase());
                }
            }
            str = builder.toString();
        }
        return str;
    }


}
