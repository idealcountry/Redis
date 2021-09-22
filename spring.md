##SpringBoot的一些基本知识
IOC容器的两个方式
* JavaBean的装配
> 常见于类之间的装配，标定某个类注入到IOC容器中去，如@Component、@Service、@Repository、@Controller等
* Bean之间的依赖即依赖注入
> @Autowired注解中主要是完成根据属性的类型找到对应的Bean进行注入，表示被修饰的类需要注入对象。Spring会扫描所有被其标注的类，然后根据类型在IOC容器中找到匹配的类进行注入。被其注解后的类不需要在导入文件
* RxxxxxBody
> 主要表示的是返回JSON或者XML类型的数据