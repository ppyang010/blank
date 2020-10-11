package com.example.demo.resolver;

import lombok.extern.slf4j.Slf4j;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.springframework.util.StringValueResolver;

import java.io.IOException;

@Slf4j
public class MyStringValueResolver implements StringValueResolver {
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

    @Override
    public String resolveStringValue(String strVal) {
        try {
            return doResolveStringValue(strVal);
        } catch (IOException e) {
            e.printStackTrace();
            return strVal;
        }
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
}
