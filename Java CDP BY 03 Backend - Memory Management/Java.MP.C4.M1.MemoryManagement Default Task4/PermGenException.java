
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PermGenException
{
    public static void main(String[] args) throws Exception
    {

        Class<?> clazz = PermGenException.class;
        byte[] buffer = loadByteCode(clazz, clazz.getName());

        List<Object> list = new ArrayList<Object>();
        
        MyClassLoader loader = new MyClassLoader();
        for (long index = 0; index < Long.MAX_VALUE; index++)
        {
            String newClassName = "_" + String.format("%0" + (clazz.getSimpleName().length() - 1) 
            		+ "d", index);
            byte[] newClassData = new String(buffer, "latin1")
                    .replaceAll(clazz.getSimpleName(), newClassName)
                    .getBytes("latin1");
                loader = new MyClassLoader();
            Object newClass = loader._defineClass(clazz.getName()
            		.replace(clazz.getSimpleName(), newClassName),newClassData);
            
            list.add(newClass);
        }
    }
    
    public static byte[] loadByteCode(Class loader, String className)
            throws IOException {
        String fileName = "/"
                + className.replaceAll("\\.", "/") + ".class";
        InputStream is = loader.getResourceAsStream(fileName);
        ByteArrayOutputStream buffer
                = new ByteArrayOutputStream(4096);
        byte[] buff = new byte[1024];
        int i;
        while ((i = is.read(buff)) >= 0) {
            buffer.write(buff, 0, i);
        }

        return buffer.toByteArray();
    }
}

class MyClassLoader extends ClassLoader {
    public MyClassLoader() {
        super();
    }

    public Class<?> _defineClass(String name, byte[] byteCodes)
    {
        return super.defineClass(name, byteCodes, 0, byteCodes.length);
    }
}