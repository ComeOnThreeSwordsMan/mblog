/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package mblog.base.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author an
 */
public class Data implements Serializable {
    private static final long serialVersionUID = -1491499610244557029L;

    private static int CODE_SUCCESS = 0;
    private static int CODE_FAIL = -1;

    public static String NOOP = "";
    /**
     *  处理状态：0: 成功
     */
    private int code;
    private String message;
    /**
     *     返回数据
     */
    private Object data;
    private ArrayList<Button> links = new ArrayList<>();


    private Data(int code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static  Data success(){
        return success(null);
    }


    public static  Data success(Object data){
        return success("操作成功", data);
    }

    public static  Data success(String message, Object data){
        return new Data(Data.CODE_SUCCESS, message, data);
    }

    public static  Data failure(String message){
        return failure(Data.CODE_FAIL, message);
    }

    public static  Data failure(int code, String message){
        return new Data(code, message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public Data addLink(String link, String text) {
        links.add(new Button(link, text));
        return this;
    }

    public ArrayList<Button> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Button> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "{code:\"" + code + "\", message:\"" + message + "\", data:\"" + (data != null ? data.toString():"") + "\"}";
    }

    public class Button {
        private String text;
        private String link;

        Button(String link, String text) {
            this.link = link;
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
