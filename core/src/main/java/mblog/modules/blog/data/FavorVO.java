package mblog.modules.blog.data;

import mblog.modules.blog.entity.Favor;


/**
 * @author  an
 */
public class FavorVO extends Favor {

    private PostVO post;

    public PostVO getPost() {
        return post;
    }

    public void setPost(PostVO post) {
        this.post = post;
    }
}
