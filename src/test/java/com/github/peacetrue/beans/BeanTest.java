package com.github.peacetrue.beans;

import com.github.peacetrue.beans.create.Create;
import com.github.peacetrue.beans.createmodify.CreateModify;
import com.github.peacetrue.beans.modify.Modify;
import com.github.peacetrue.beans.operator.Operator;
import com.github.peacetrue.beans.operator.OperatorImpl;
import com.github.peacetrue.beans.properties.id.IdCapable;
import com.github.peacetrue.beans.properties.operator.OperatorAware;
import com.github.peacetrue.beans.properties.operator.OperatorCapable;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author peace
 **/
@Slf4j
class BeanTest {

    private static final EasyRandom EASY_RANDOM = new EasyRandom(
            new EasyRandomParameters().randomize(Long.class, () -> 1L)
    );

    /** 总共 23 个属性 */
    @Test
    void propertyCount() {
        String prefix = "com.github.peacetrue.beans.properties";
        Reflections reflections = new Reflections(prefix, new SubTypesScanner(false));
        Set<String> allTypes = reflections.getAllTypes();
        Assertions.assertEquals(24 * 3 + 1, allTypes.size());
    }


    private void invoke(Set<String> allTypes) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, InvocationTargetException {
        for (String allType : allTypes) {
            Class<?> aClass = Class.forName(allType);
            if (!aClass.isInterface()) continue;

            Object instance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{aClass}, new InvocationHandler() {

                private final Map<String, Object> fields = new HashMap<>(1);

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().startsWith("set")) {
                        fields.put(method.getName(), args[0]);
                        return null;
                    } else if (method.getName().startsWith("get")) {
                        return fields.get(method.getName());
                    } else {
                        return method.invoke(proxy, args);
                    }
                }
            });
            log.info("instance: {}", Arrays.toString(instance.getClass().getInterfaces()));

            BeanInfo beanInfo = Introspector.getBeanInfo(instance.getClass(), Introspector.IGNORE_ALL_BEANINFO);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            log.info("propertyDescriptors: {}", propertyDescriptors.length);
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                log.info("propertyDescriptor: {}", propertyDescriptor);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                if (writeMethod != null) {
                    writeMethod.invoke(instance, EASY_RANDOM.nextObject(propertyDescriptor.getPropertyType()));
                }
                Method readMethod = propertyDescriptor.getReadMethod();
                if (readMethod != null) {
                    readMethod.invoke(instance);
                }
            }
        }
    }

    /** 总共 4 个 Bean */
    @Test
    void beanCount() {
        String prefix = "com.github.peacetrue.beans";
        Reflections reflections = new Reflections(prefix, new SubTypesScanner(false));
        Set<String> allTypes = reflections.getAllTypes().stream()
                .filter(name -> !name.startsWith(BeanTest.class.getName()))
                .filter(name -> !name.startsWith(TestBean.class.getName()))
                .collect(Collectors.toSet());

        int fromIndex = (prefix + ".?").length();
        allTypes = allTypes.stream()
                .map(name -> name.substring(0, name.indexOf('.', fromIndex)))
                .filter(name -> !name.endsWith("properties") && !name.endsWith("annotations"))
                .collect(Collectors.toSet());
        Assertions.assertEquals(4, allTypes.size());
        log.info("allTypes: \n{}", String.join("\n", allTypes));
    }

    @Test
    void operator() {
        OperatorImpl<Long> source = new OperatorImpl<>(1L, "admin");
        OperatorImpl<Long> target = new OperatorImpl<>();
        Operator.setOperator(target, source);
        Assertions.assertEquals(source.toString(), target.toString());
    }

    @Test
    void setCreate() {
        OperatorImpl<Long> operator = new OperatorImpl<>(1L, "admin");
        LocalDateTime now = LocalDateTime.now();
        TestBean testBean = Create.setCreate(operator, new TestBean(), now);
        Assertions.assertEquals(testBean.getCreatorId(), operator.getId());
        Assertions.assertEquals(testBean.getCreatedTime(), now);
    }

    @Test
    void setModify() {
        OperatorImpl<Long> operator = new OperatorImpl<>(1L, "admin");
        LocalDateTime now = LocalDateTime.now();
        TestBean testBean = Modify.setModify(operator, new TestBean(), now);
        Assertions.assertEquals(testBean.getModifierId(), operator.getId());
        Assertions.assertEquals(testBean.getModifiedTime(), now);
    }

    @Test
    void setCreateModify() {
        OperatorImpl<Long> operator = new OperatorImpl<>(1L, "admin");
        LocalDateTime now = LocalDateTime.now();
        TestBean testBean = CreateModify.setCreateModify(operator, new TestBean(), now);
        Assertions.assertEquals(testBean.getCreatorId(), operator.getId());
        Assertions.assertEquals(testBean.getCreatedTime(), now);
        Assertions.assertEquals(testBean.getModifierId(), operator.getId());
        Assertions.assertEquals(testBean.getModifiedTime(), now);
    }

    @Test
    void setOperator() {
        OperatorImpl<Object> target = new OperatorImpl<>();
        OperatorImpl<Object> source = new OperatorImpl<>(1, "admin");
        Operator.setDefault(target, source);
        Assertions.assertEquals(target, source);

        source.setId(2);
        Operator.setDefault(target, source);
        Assertions.assertNotEquals(target, source);

        Operator.setOperator(target, source);
        Assertions.assertEquals(target, source);
    }

    static <S extends OperatorCapable<U>, T extends OperatorAware<U>, U> T setOperator(S source, T target) {
        target.setOperator(source.getOperator());
        return target;
    }

    @Test
    void equalsHashCode() {

        TestBean testBean = new TestBean();
        Assertions.assertTrue(IdCapable.equals(testBean, testBean));
        Assertions.assertFalse(IdCapable.equals(testBean, null));
        Assertions.assertFalse(IdCapable.equals(testBean, new Object()));
        Assertions.assertTrue(IdCapable.equals(new TestBean(), new TestBean()));

        TestBean self = new TestBean();
        TestBean equals = new TestBean();
        Assertions.assertEquals(self, equals);
        Assertions.assertNotEquals(self.hashCode(), equals.hashCode());

        self.setId(1L);
        Assertions.assertNotEquals(self, equals);
        Assertions.assertNotEquals(self.hashCode(), equals.hashCode());

        equals.setId(1L);
        Assertions.assertEquals(self, equals);
        Assertions.assertEquals(self.hashCode(), equals.hashCode());
    }

}
