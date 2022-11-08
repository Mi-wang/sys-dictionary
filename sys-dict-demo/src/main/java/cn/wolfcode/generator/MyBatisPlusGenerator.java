package cn.wolfcode.generator;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * @author 20463
 */
public class MyBatisPlusGenerator {

    private static final String URL = "jdbc:mysql:///sys_dict_demo?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static final String BASE_PACKAGE = "cn.wolfcode";
    private static final String MODULE_NAME = null;

    public static final String PROJECT_PATH = "E:\\workspace-idea\\sys-dict-demo";
    public static final String JAVA_OUTPUT_PATH = PROJECT_PATH + "/src/main/java";
    public static final String RESOURCES_OUTPUT_PATH = PROJECT_PATH + "/src/main/resources";

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("wang") // 设置作者
                            .outputDir(JAVA_OUTPUT_PATH); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(BASE_PACKAGE) // 设置父包名
                            .moduleName(MODULE_NAME) // 设置模块
                            .pathInfo(Collections.singletonMap(OutputFile.xml, RESOURCES_OUTPUT_PATH)); // 设置 mapperXml 生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_customer") // 设置需要生成的表名
                            .addTablePrefix("t_")
                            // controller 相关配置
                            .controllerBuilder()
                            .enableRestStyle().build()
                            // 实体对象相关配置
                            .entityBuilder()
                            .enableLombok()
                            .build(); // 设置 lombok 模式
                })
                .execute();

    }
}
