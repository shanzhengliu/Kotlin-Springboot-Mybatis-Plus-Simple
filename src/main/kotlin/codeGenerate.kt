import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.core.metadata.TableInfo
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.InjectionConfig
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine


//代码生成模版
class CodeGenerate {

    fun main(args: Array<String>) {

        println("input the table name:")
        val tb = readLine()


        println("begin generating")

        val mpg = AutoGenerator()

        val globalConfig = GlobalConfig();
        globalConfig.isKotlin = true
        globalConfig.author = "sam"
        globalConfig.isOpen = false
        globalConfig.outputDir = System.getProperty("user.dir") + "/src/main/kotlin"
        globalConfig.isFileOverride = true
        globalConfig.idType = IdType.AUTO
        globalConfig.xmlName = "%sMapper"
        globalConfig.mapperName = "%sMapper"
        globalConfig.serviceImplName = "%sServiceImpl"
        globalConfig.controllerName = "%sController"
        globalConfig.isBaseColumnList = true
        globalConfig.isBaseResultMap = true

        mpg.globalConfig = globalConfig

        val dsc = DataSourceConfig()
        dsc.dbType = DbType.MYSQL
        dsc.driverName = "com.mysql.cj.jdbc.Driver"
        dsc.url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8"
        dsc.username = "root"
        dsc.password = "123456"

        mpg.dataSource = dsc


        // 自定义配置
//        val cfg: InjectionConfig = object : InjectionConfig() {
//            override fun initMap() {
//                // to do nothing
//            }
//        }
//        val focList: MutableList<FileOutConfig> = ArrayList()
//        focList.add(object : FileOutConfig("/templates/mapper.xml.ftl") {
//            override fun outputFile(tableInfo: TableInfo): String? {
//                // 自定义输入文件名称
//                return (projectPath.toString() + "/src/main/resources/mapper/"
//                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML)
//            }
//        })

        //　config xml　template and outpath
//        cfg.fileOutConfigList = focList
//        mpg.cfg = cfg

        mpg.template = TemplateConfig().setXml(null)
//                .setController(null)
//                .setService(null)
//                .setServiceImpl(null)
//                .setMapper(null)
//                .setEntity(null)
//                .setEntityKt(null)


        val sc = StrategyConfig()
        sc.columnNaming = NamingStrategy.underline_to_camel
        sc.setTablePrefix("")
        sc.setInclude(tb)
        sc.isRestControllerStyle = true;
        sc.naming = NamingStrategy.underline_to_camel
        sc.isEntityLombokModel = true
        sc.isRestControllerStyle = true
        sc.isControllerMappingHyphenStyle = true;
        mpg.strategy = sc

        val pkConfig = PackageConfig()
        pkConfig.parent = "com"
        pkConfig.controller = "controller"
        pkConfig.entity = "domain"
        pkConfig.service = "service"
        pkConfig.mapper = "mapper"
        mpg.packageInfo = pkConfig

        mpg.templateEngine = FreemarkerTemplateEngine()
        mpg.execute();

    }
}