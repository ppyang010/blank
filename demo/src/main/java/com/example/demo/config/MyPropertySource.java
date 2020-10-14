package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.springframework.core.env.MapPropertySource;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class MyPropertySource extends MapPropertySource {

    private static StringTemplateResourceLoader resourceLoader;
    private static Configuration cfg;
    private static GroupTemplate gt;

    static {
        //初始化代码
        resourceLoader = new StringTemplateResourceLoader();
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //修改占位符
        cfg.setPlaceholderStart("@{");
        cfg.setPlaceholderEnd("}@");
        gt = new GroupTemplate(resourceLoader, cfg);
    }


    public String doResolveStringValue(String strVal) throws IOException {

        //获取模板
        Template t = gt.getTemplate(strVal);
//        t.binding("name", "beetl");
        //渲染结果
        String str = t.render();
        log.info(str);
        return str;
    }

    /**
     * Create a new {@code MapPropertySource} with the given name and {@code Map}.
     *
     * @param name   the associated name
     * @param source the Map source (without {@code null} values in order to get
     *               consistent {@link #getProperty} and {@link #containsProperty} behavior)
     */
    public MyPropertySource(String name, Map<String, Object> source) {
        super(name, source);
    }


    @Override
    public Object getProperty(String name) {
        if (name.startsWith("beetl(") && name.endsWith(")")) {
            name = name.substring(6, name.length() - 1);
            try {
                return doResolveStringValue(name);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return null;
    }
}
