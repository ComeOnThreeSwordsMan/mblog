package mblog.template.directive;

import mblog.modules.blog.service.ChannelService;
import mblog.template.DirectiveHandler;
import mblog.template.TemplateDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author an
 */
@Component
public class ChannelDirective extends TemplateDirective {
    @Autowired
    private ChannelService channelService;

    @Override
    public String getName() {
        return "channel";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        Integer id = handler.getInteger("id", 0);
        handler.put(RESULT, channelService.getById(id)).render();
    }
}