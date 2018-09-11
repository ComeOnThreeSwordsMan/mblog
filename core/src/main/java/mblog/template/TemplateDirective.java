package mblog.template;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
 * @author an
 */
public abstract class TemplateDirective implements TemplateDirectiveModel {
    protected static String RESULT = "result";
    protected static String RESULTS = "results";

    /**
     * @param env 是环境变量，在这里我们可以拿到 通过  environment.getOut  拿到 Write 。
     * @param parameters 这里我们可以得到到参数，这里的参数是以 键值对的形式存在的。
     * @param loopVars 是所以数据类型的顶级接口，我们  可以通过  templateMole[i]  通过这个i变量来返回我们指定的第几个参数的返回值。
     * @param body 是标签开始和结束的 内容 ，通过这个对象的 render（）方法我可以接着执行 自定义标签里的 其他标签（freemarker内置标签或者我们自定义标签）
     * @throws TemplateException 模板异常
     * @throws IOException IO异常
     */
    @Override
    public void execute(Environment env, Map parameters,
                        TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        try {
            execute(new DirectiveHandler(env, parameters, loopVars, body));
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new TemplateException(e, env);
        }
    }

    abstract public String getName();
    abstract public void execute(DirectiveHandler handler) throws Exception;

}
