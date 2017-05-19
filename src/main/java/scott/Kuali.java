package scott;

/**
 * Created by ssoward on 5/17/17.
 */
public class Kuali {
    public static void main(String args){
        System.out.println(getString());
    }

    public static String getString() {
        return "Hello World";
    }


    public static String getClass(Class clazz) {
        if (clazz != null ){
            try {
                if (clazz == String.class){
                    return "STRING";
                }
                else if (clazz == Boolean.class){
                    return "BOOLEAN";
                }
            } catch (NullPointerException n){ }
        }
        return null;
    }
}
