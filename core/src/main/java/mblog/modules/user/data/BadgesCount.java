package mblog.modules.user.data;

import java.io.Serializable;

/**
 * @author an
 */
public class BadgesCount implements Serializable {
    private static final long serialVersionUID = 8276459939240769498L;
    /**
     * 通知数量
     */
    private int notifies;
    /**
     * 私信数量
     */
    private int messages;

    public int getNotifies() {
        return notifies;
    }

    public void setNotifies(int notifies) {
        this.notifies = notifies;
    }

    public int getMessages() {
        return messages;
    }

    public void setMessages(int messages) {
        this.messages = messages;
    }
}
